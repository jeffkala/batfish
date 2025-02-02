package org.batfish.representation.aws;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkArgument;
import static org.batfish.common.util.isp.IspModelingUtils.installRoutingPolicyAdvertiseStatic;
import static org.batfish.datamodel.Interface.NULL_INTERFACE_NAME;
import static org.batfish.representation.aws.AwsConfiguration.BACKBONE_FACING_INTERFACE_NAME;
import static org.batfish.representation.aws.Utils.addStaticRoute;
import static org.batfish.representation.aws.Utils.connectGatewayToVpc;
import static org.batfish.representation.aws.Utils.toStaticRoute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.batfish.common.Warnings;
import org.batfish.datamodel.AclLine;
import org.batfish.datamodel.Configuration;
import org.batfish.datamodel.DeviceModel;
import org.batfish.datamodel.ExprAclLine;
import org.batfish.datamodel.HeaderSpace;
import org.batfish.datamodel.Interface;
import org.batfish.datamodel.Ip;
import org.batfish.datamodel.IpAccessList;
import org.batfish.datamodel.IpSpace;
import org.batfish.datamodel.IpWildcard;
import org.batfish.datamodel.IpWildcardSetIpSpace;
import org.batfish.datamodel.LineAction;
import org.batfish.datamodel.PrefixSpace;
import org.batfish.datamodel.TraceElement;
import org.batfish.datamodel.acl.AclLineMatchExprs;
import org.batfish.datamodel.acl.MatchHeaderSpace;
import org.batfish.datamodel.acl.TrueExpr;
import org.batfish.datamodel.transformation.Transformation;
import org.batfish.datamodel.transformation.TransformationStep;

/**
 * Represents an AWS Internet Gateway
 * https://docs.aws.amazon.com/cli/latest/reference/ec2/describe-internet-gateways.html
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ParametersAreNonnullByDefault
final class InternetGateway implements AwsVpcEntity, Serializable {

  /** Name of the export policy to backbone */
  static final String IGW_TO_BACKBONE_EXPORT_POLICY_NAME = "~igw~to~backbone~export~policy~";

  /** Name of the filter that drops from private IPs without an associated public IP */
  static final String UNASSOCIATED_PRIVATE_IP_FILTER_NAME = "~DENY~UNASSOCIATED~PRIVATE~IPs~";

  static final TraceElement ALLOWED_ASSOCIATED_PRIVATE_IP_TRACE_ELEMENT =
      TraceElement.of("Allowed private instance IPs associated with a public IP");

  static final TraceElement DENIED_UNASSOCIATED_PRIVATE_IP_TRACE =
      TraceElement.of("Denied private instance IPs NOT associated with a public IP");

  private final @Nonnull List<String> _attachmentVpcIds;

  private @Nonnull String _internetGatewayId;

  private final @Nonnull Map<String, String> _tags;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @ParametersAreNonnullByDefault
  private static class Attachment {

    private final @Nonnull String _vpcId;

    @JsonCreator
    private static Attachment create(@Nullable @JsonProperty(JSON_KEY_VPC_ID) String vpcId) {
      checkArgument(vpcId != null, "Vpc id cannot be null for Internet gateway attachment");
      return new Attachment(vpcId);
    }

    private Attachment(String vpcId) {
      _vpcId = vpcId;
    }

    public @Nonnull String getVpcId() {
      return _vpcId;
    }
  }

  @JsonCreator
  private static InternetGateway create(
      @Nullable @JsonProperty(JSON_KEY_INTERNET_GATEWAY_ID) String internetGatewayId,
      @Nullable @JsonProperty(JSON_KEY_ATTACHMENTS) List<Attachment> attachments,
      @Nullable @JsonProperty(JSON_KEY_TAGS) List<Tag> tags) {
    checkArgument(internetGatewayId != null, "Id cannot be null for Internet gateway");
    checkArgument(attachments != null, "Attachments cannot be null for Internet gateway");

    return new InternetGateway(
        internetGatewayId,
        attachments.stream().map(Attachment::getVpcId).collect(ImmutableList.toImmutableList()),
        firstNonNull(tags, ImmutableList.<Tag>of()).stream()
            .collect(ImmutableMap.toImmutableMap(Tag::getKey, Tag::getValue)));
  }

  public InternetGateway(
      String internetGatewayId, List<String> attachmentVpcIds, Map<String, String> tags) {
    _internetGatewayId = internetGatewayId;
    _attachmentVpcIds = attachmentVpcIds;
    _tags = tags;
  }

  @Override
  public String getId() {
    return _internetGatewayId;
  }

  public @Nonnull List<String> getAttachmentVpcIds() {
    return _attachmentVpcIds;
  }

  Configuration toConfigurationNode(
      ConvertedConfiguration awsConfiguration, Region region, Warnings warnings) {
    Configuration cfgNode =
        Utils.newAwsConfiguration(
            _internetGatewayId, "aws", _tags, DeviceModel.AWS_INTERNET_GATEWAY);
    cfgNode.getVendorFamily().getAws().setRegion(region.getName());

    // Map from private to public IPs that will be used for the NAT
    Map<Ip, Ip> privatePublicMap =
        region.getNetworkInterfaces().values().stream()
            .filter(ni -> _attachmentVpcIds.contains(ni.getVpcId()))
            .flatMap(ni -> ni.getPrivateIpAddresses().stream())
            .filter(pvtIp -> pvtIp.getPublicIp() != null)
            .collect(
                ImmutableMap.toImmutableMap(
                    PrivateIpAddress::getPrivateIp, PrivateIpAddress::getPublicIp));

    // Install a filter that will drop all incoming packets from subnets that have invalid private
    // IPs (i.e., there is no associated public IP).
    // This filter is installed on subnet-facing interfaces when they are created in Subnet.java.
    IpAccessList unassociatedIpFilter =
        computeUnassociatedPrivateIpFilter(privatePublicMap.keySet());
    cfgNode.getIpAccessLists().put(unassociatedIpFilter.getName(), unassociatedIpFilter);

    _attachmentVpcIds.forEach(
        vpcId -> {
          Interface iface =
              connectGatewayToVpc(
                  _internetGatewayId, cfgNode, vpcId, awsConfiguration, region, warnings);
          if (iface != null) {
            iface.setIncomingFilter(unassociatedIpFilter);
          }
        });

    // In order for the backbone to know that this IGW has these public IPs, we create
    // static null routes that will be advertised into BGP. These are non-forwarding routes so that
    // traffic from the subnet to the public IPs of the subnet will get delivered, by leaving the
    // IGW and then coming back in.
    PrefixSpace publicPrefixSpace = new PrefixSpace();
    privatePublicMap
        .values()
        .forEach(
            publicIp -> {
              publicPrefixSpace.addPrefix(publicIp.toPrefix());
              addStaticRoute(
                  cfgNode, toStaticRoute(publicIp.toPrefix(), NULL_INTERFACE_NAME, true));
            });

    installRoutingPolicyAdvertiseStatic(
        IGW_TO_BACKBONE_EXPORT_POLICY_NAME, cfgNode, publicPrefixSpace);
    Utils.createBackboneConnection(
        cfgNode, cfgNode.getDefaultVrf(), IGW_TO_BACKBONE_EXPORT_POLICY_NAME);

    configureNat(cfgNode.getAllInterfaces().get(BACKBONE_FACING_INTERFACE_NAME), privatePublicMap);

    return cfgNode;
  }

  @VisibleForTesting
  static IpAccessList computeUnassociatedPrivateIpFilter(Collection<Ip> validPrivateIps) {
    ImmutableList.Builder<AclLine> aclLines = ImmutableList.builder();
    if (!validPrivateIps.isEmpty()) {
      IpSpace validPrivateIpSpace =
          IpWildcardSetIpSpace.builder()
              .including(
                  validPrivateIps.stream().map(IpWildcard::create).collect(Collectors.toList()))
              .build();
      aclLines.add(
          ExprAclLine.builder()
              .setTraceElement(ALLOWED_ASSOCIATED_PRIVATE_IP_TRACE_ELEMENT)
              .setMatchCondition(
                  new MatchHeaderSpace(
                      HeaderSpace.builder().setSrcIps(validPrivateIpSpace).build()))
              .setAction(LineAction.PERMIT)
              .build());
    }
    aclLines.add(
        ExprAclLine.builder()
            .setTraceElement(DENIED_UNASSOCIATED_PRIVATE_IP_TRACE)
            .setMatchCondition(TrueExpr.INSTANCE)
            .setAction(LineAction.DENY)
            .build());
    return IpAccessList.builder()
        .setName(UNASSOCIATED_PRIVATE_IP_FILTER_NAME)
        .setLines(aclLines.build())
        .build();
  }

  @VisibleForTesting
  static void configureNat(Interface bbInterface, Map<Ip, Ip> privatePublicMap) {
    ImmutableList.Builder<Transformation.Builder> outgoingNatRules = ImmutableList.builder();
    ImmutableList.Builder<Transformation.Builder> incomingNatRules = ImmutableList.builder();

    privatePublicMap.forEach(
        (pvtIp, pubIp) -> {
          outgoingNatRules.add(
              Transformation.when(AclLineMatchExprs.matchSrc(pvtIp))
                  .apply(TransformationStep.shiftSourceIp(pubIp.toPrefix())));
          incomingNatRules.add(
              Transformation.when(AclLineMatchExprs.matchDst(pubIp))
                  .apply(TransformationStep.shiftDestinationIp(pvtIp.toPrefix())));
        });

    bbInterface.setOutgoingTransformation(chain(outgoingNatRules.build()));
    bbInterface.setIncomingTransformation(chain(incomingNatRules.build()));
  }

  private static @Nullable Transformation chain(List<Transformation.Builder> rules) {
    Transformation tail = null;
    for (Transformation.Builder t : rules) {
      tail = t.setOrElse(tail).build();
    }
    return tail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InternetGateway)) {
      return false;
    }
    InternetGateway that = (InternetGateway) o;
    return Objects.equals(_attachmentVpcIds, that._attachmentVpcIds)
        && Objects.equals(_tags, that._tags)
        && Objects.equals(_internetGatewayId, that._internetGatewayId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_attachmentVpcIds, _internetGatewayId, _tags);
  }
}
