package org.batfish.representation.cisco;

import org.batfish.vendor.StructureUsage;

public enum CiscoStructureUsage implements StructureUsage {
  AAA_ACCOUNTING_CONNECTION_DEFAULT("aaa accounting connection default"),
  AAA_ACCOUNTING_GROUP("aaa accounting group"),
  AAA_AUTHENTICATION_GROUP("aaa authentication group"),
  AAA_AUTHORIZATION_GROUP("aaa authorization group"),
  AAA_GROUP_SERVER_TACACS_SERVER("aaa group server tacacs+ server"),
  ACCESS_GROUP_GLOBAL_FILTER("access-group global filter"),
  BGP_ADVERTISE_MAP_EXIST_MAP("bgp neighbor advertise-map exist-map"),
  BGP_AGGREGATE_ATTRIBUTE_MAP("bgp vrf aggregate-address attribute-map"),
  BGP_AGGREGATE_ADVERTISE_MAP("bgp vrf aggregate-address advertise-map"),
  BGP_AGGREGATE_SUPPRESS_MAP("bgp vrf aggregate-address suppress-map"),
  BGP_DEFAULT_ORIGINATE_ROUTE_MAP("bgp default-originate route-map"),
  BGP_INBOUND_PREFIX_LIST("bgp inbound prefix-list"),
  BGP_INBOUND_PREFIX6_LIST("bgp inbound ipv6 prefix-list"),
  BGP_INBOUND_ROUTE_MAP("bgp inbound route-map"),
  BGP_INBOUND_ROUTE6_MAP("bgp inbound ipv6 route-map"),
  BGP_INHERITED_PEER_POLICY("inherited BGP peer-policy"),
  BGP_INHERITED_SESSION("inherited BGP peer-session"),
  BGP_LISTEN_RANGE_PEER_GROUP("bgp listen range peer-group"),
  BGP_LISTEN_RANGE_SELF_REF("bgp listen range self ref"),
  BGP_NEIGHBOR_DISTRIBUTE_LIST_ACCESS_LIST_IN("bgp neighbor distribute-list access-list in"),
  BGP_NEIGHBOR_DISTRIBUTE_LIST_ACCESS_LIST_OUT("bgp neighbor distribute-list access-list out"),
  BGP_NEIGHBOR_DISTRIBUTE_LIST_ACCESS6_LIST_IN("bgp neighbor distribute-list ipv6 access-list in"),
  BGP_NEIGHBOR_DISTRIBUTE_LIST_ACCESS6_LIST_OUT(
      "bgp neighbor distribute-list ipv6 access-list out"),
  BGP_NEIGHBOR_FILTER_AS_PATH_ACCESS_LIST("bgp neighbor filter-list access-list"),
  BGP_NEIGHBOR_PEER_GROUP("bgp neighbor peer-group"),
  BGP_NEIGHBOR_SELF_REF("bgp neighbor self ref"),
  BGP_NEIGHBOR_STATEMENT("bgp neighbor statement"),
  BGP_NEIGHBOR_WITHOUT_REMOTE_AS("bgp neighbor without remote-as"),
  BGP_NETWORK_ORIGINATION_ROUTE_MAP("bgp ipv4 network statement route-map"),
  BGP_NETWORK6_ORIGINATION_ROUTE_MAP("bgp ipv6 network statement route-map"),
  BGP_OUTBOUND_PREFIX_LIST("bgp outbound prefix-list"),
  BGP_OUTBOUND_PREFIX6_LIST("bgp outbound ipv6 prefix-list"),
  BGP_OUTBOUND_ROUTE_MAP("bgp outbound route-map"),
  BGP_OUTBOUND_ROUTE6_MAP("bgp outbound ipv6 route-map"),
  BGP_PEER_GROUP_REFERENCED_BEFORE_DEFINED("bgp peer-group referenced before defined"),
  BGP_REDISTRIBUTE_CONNECTED_MAP("bgp redistribute connected route-map"),
  BGP_REDISTRIBUTE_EIGRP_MAP("bgp redistribute eigrp route-map"),
  BGP_REDISTRIBUTE_OSPF_MAP("bgp redistribute ospf route-map"),
  BGP_REDISTRIBUTE_OSPFV3_MAP("bgp redistribute ospfv3 route-map"),
  BGP_REDISTRIBUTE_RIP_MAP("bgp redistribute rip route-map"),
  BGP_REDISTRIBUTE_STATIC_MAP("bgp redistribute static route-map"),
  BGP_ROUTE_MAP_ADVERTISE("bgp address-family aggregate-address advertise-map"),
  BGP_ROUTE_MAP_UNSUPPRESS("bgp unsuppress-map"),
  BGP_UPDATE_SOURCE_INTERFACE("update-source interface"),
  BGP_USE_AF_GROUP("bgp use af-group"),
  BGP_USE_NEIGHBOR_GROUP("bgp use neighbor-group"),
  BGP_USE_SESSION_GROUP("bgp use session-group"),
  CLASS_MAP_ACCESS_GROUP("class-map access-group"),
  CLASS_MAP_ACCESS_LIST("class-map access-list"),
  CLASS_MAP_ACTIVATED_SERVICE_TEMPLATE("class-map activate-service-template"),
  CLASS_MAP_SERVICE_TEMPLATE("class-map service-template"),
  CONTROL_PLANE_ACCESS_GROUP("control-plane ip access-group"),
  CONTROL_PLANE_SERVICE_POLICY_INPUT("control-plane service-policy input"),
  CONTROL_PLANE_SERVICE_POLICY_OUTPUT("control-plane service-policy output"),
  CONTROLLER_DEPI_TUNNEL("controller rf-channel depi-tunnel"),
  COPS_LISTENER_ACCESS_LIST("cops listener access-list"),
  CRYPTO_DYNAMIC_MAP_ACL("crypto dynamic-map acl"),
  CRYPTO_DYNAMIC_MAP_ISAKMP_PROFILE("crypto dynamic-map isakmp-profile"),
  CRYPTO_DYNAMIC_MAP_TRANSFORM_SET("crypto dynamic-map transform-set"),
  CRYPTO_MAP_IPSEC_ISAKMP_ACL("crypto map ipsec-isakmp acl"),
  CRYPTO_MAP_IPSEC_ISAKMP_CRYPTO_DYNAMIC_MAP_SET("crypto map ipsec-isakmp crypto-dynamic-map-set"),
  CRYPTO_MAP_IPSEC_ISAKMP_ISAKMP_PROFILE("crypto map ipsec-isakmp isakmp-profile"),
  CRYPTO_MAP_IPSEC_ISAKMP_TRANSFORM_SET("crypto map ipsec-isakmp transform-set"),
  CRYPTO_MAP_MATCH_ADDRESS("crypto map match address"),
  DEPI_TUNNEL_DEPI_CLASS("depi-tunnel depi-class"),
  DEPI_TUNNEL_L2TP_CLASS("depi-tunnel l2tp-class"),
  DEPI_TUNNEL_PROTECT_TUNNEL("depi-tunnel protect-tunnel"),
  DOMAIN_LOOKUP_SOURCE_INTERFACE("domain lookup source-interface"),
  DOCSIS_GROUP_DOCSIS_POLICY("cable load-balance docsis-group docsis-policy"),
  DOCSIS_POLICY_DOCSIS_POLICY_RULE("cable load-balance docsis-policy rule"),
  EIGRP_AF_INTERFACE("eigrp address-family af-interface"),
  EIGRP_DISTRIBUTE_LIST_ACCESS_LIST_IN("router eigrp distribute-list in"),
  EIGRP_DISTRIBUTE_LIST_ACCESS_LIST_OUT("router eigrp distribute-list out"),
  EIGRP_DISTRIBUTE_LIST_GATEWAY_IN("router eigrp distribute-list gateway in"),
  EIGRP_DISTRIBUTE_LIST_GATEWAY_OUT("router eigrp distribute-list gateway out"),
  EIGRP_DISTRIBUTE_LIST_PREFIX_LIST_IN("router eigrp distribute-list prefix in"),
  EIGRP_DISTRIBUTE_LIST_PREFIX_LIST_OUT("router eigrp distribute-list prefix out"),
  EIGRP_DISTRIBUTE_LIST_ROUTE_MAP_IN("router eigrp distribute-list route-map in"),
  EIGRP_DISTRIBUTE_LIST_ROUTE_MAP_OUT("router eigrp distribute-list route-map out"),
  EIGRP_PASSIVE_INTERFACE("eigrp passive-interface"),
  EIGRP_REDISTRIBUTE_BGP_MAP("eigrp redistribute bgp route-map"),
  EIGRP_REDISTRIBUTE_CONNECTED_MAP("eigrp redistribute connected route-map"),
  EIGRP_REDISTRIBUTE_EIGRP_MAP("eigrp redistribute eigrp route-map"),
  EIGRP_REDISTRIBUTE_ISIS_MAP("eigrp redistribute isis route-map"),
  EIGRP_REDISTRIBUTE_OSPF_MAP("eigrp redistribute ospf route-map"),
  EIGRP_REDISTRIBUTE_RIP_MAP("eigrp redistribute rip route-map"),
  EIGRP_REDISTRIBUTE_STATIC_MAP("eigrp redistribute static route-map"),
  EIGRP_STUB_LEAK_MAP("eigrp stub leak-map"),
  EXTENDED_ACCESS_LIST_ICMP_TYPE_OBJECT_GROUP("extended access-list icmp-type object-group"),
  EXTENDED_ACCESS_LIST_NETWORK_OBJECT("extended access-list network object"),
  EXTENDED_ACCESS_LIST_NETWORK_OBJECT_GROUP("extended access-list network object-group"),
  EXTENDED_ACCESS_LIST_PORTGROUP("extended access-list portgroup"),
  EXTENDED_ACCESS_LIST_PROTOCOL_OBJECT_GROUP("extended access-list protocol object-group"),
  EXTENDED_ACCESS_LIST_PROTOCOL_OR_SERVICE_OBJECT_GROUP(
      "extended access-list protocol or service object-group"),
  EXTENDED_ACCESS_LIST_SERVICE_OBJECT("extended access-list service object"),
  EXTENDED_ACCESS_LIST_SERVICE_OBJECT_GROUP("extended access-list service object-group"),
  ICMP_TYPE_OBJECT_GROUP_GROUP_OBJECT("object-group icmp-type group-object"),
  ICMP_TYPE_OBJECT_GROUP_ICMP_OBJECT("object-group icmp-type icmp-object object"),
  INSPECT_CLASS_MAP_MATCH_ACCESS_GROUP("class-map type inspect match access-group"),
  INSPECT_POLICY_MAP_INSPECT_CLASS("policy-map type inspect class type inspect"),
  INTERFACE_BFD_TEMPLATE("interface bfd template"),
  INTERFACE_IGMP_ACCESS_GROUP_ACL("interface igmp access-group acl"),
  INTERFACE_IGMP_HOST_PROXY_ACCESS_LIST("interface igmp host-proxy access-list"),
  INTERFACE_IGMP_STATIC_GROUP_ACL("interface igmp static-group acl"),
  INTERFACE_INCOMING_FILTER("interface incoming ip access-list"),
  INTERFACE_IP_INBAND_ACCESS_GROUP("interface ip inband access-group"),
  INTERFACE_IP_VERIFY_ACCESS_LIST("interface ip verify access-list"),
  INTERFACE_IP_VRF_SITEMAP("interface ip vrf sitemap"),
  INTERFACE_IPV6_TRAFFIC_FILTER_IN("interface ipv6 traffic-filter in"),
  INTERFACE_IPV6_TRAFFIC_FILTER_OUT("interface ipv6 traffic-filter out"),
  INTERFACE_MEMBER_INTERFACE("interface member-interface"),
  INTERFACE_OUTGOING_FILTER("interface outgoing ip access-list"),
  INTERFACE_PIM_NEIGHBOR_FILTER("interface ip pim neighbor-filter"),
  INTERFACE_POLICY_ROUTING_MAP("interface policy-routing route-map"),
  INTERFACE_SELF_REF("interface"),
  INTERFACE_SERVICE_INSTANCE_SERVICE_POLICY("interface service-instance service-policy"),
  INTERFACE_SERVICE_POLICY("interface service-policy"),
  INTERFACE_STANDBY_TRACK("interface standby track"),
  INTERFACE_SUMMARY_ADDRESS_EIGRP_LEAK_MAP("interface summary-address eigrp leak-map"),
  INTERFACE_TRAFFIC_ZONE_MEMBER("interface zone-member"),
  INTERFACE_ZONE_MEMBER("interface zone-member security"),
  IP_DOMAIN_LOOKUP_INTERFACE("ip domain lookup interface"),
  IP_ROUTE_NHINT("ip route next-hop interface"),
  IP_NAT_DESTINATION_ACCESS_LIST("ip nat destination acl"),
  IP_NAT_DESTINATION_POOL("ip nat destination pool"),
  IP_NAT_INSIDE_SOURCE("ip nat inside source"),
  IP_NAT_INSIDE_SOURCE_STATIC("ip nat inside source static"),
  IP_NAT_OUTSIDE_SOURCE("ip nat outside source"),
  IP_NAT_SOURCE_ACCESS_LIST("ip nat source dynamic access-list"),
  IP_NAT_SOURCE_POOL("ip nat source pool"),
  IP_LOCAL_POLICY_ROUTE_MAP("ip local policy route-map"),
  IP_SLA_SOURCE_INTERFACE("ip sla source-interface"),
  IPV4_ACCESS_LIST_EXTENDED_LINE_SELF_REF("extended ipv4 access-list line"),
  IPV4_ACCESS_LIST_STANDARD_LINE_SELF_REF("standard ipv4 access-list line"),
  IPV6_LOCAL_POLICY_ROUTE_MAP("ipv6 local policy route-map"),
  IP_TACACS_SOURCE_INTERFACE("ip tacacs source-interface"),
  IPSEC_PROFILE_ISAKMP_PROFILE("ipsec profile set isakmp-profile"),
  IPSEC_PROFILE_TRANSFORM_SET("ipsec profile set transform-set"),
  ISAKMP_POLICY_SELF_REF("isakmp policy"),
  ISAKMP_PROFILE_KEYRING("isakmp profile keyring"),
  ISAKMP_PROFILE_SELF_REF("isakmp profile"),
  ISIS_REDISTRIBUTE_CONNECTED_MAP("isis redistribute connected route-map"),
  ISIS_REDISTRIBUTE_STATIC_MAP("isis redistribute static route-map"),
  LINE_ACCESS_CLASS_LIST("line access-class list"),
  LINE_ACCESS_CLASS_LIST6("line access-class ipv6 list"),
  MANAGEMENT_SSH_ACCESS_GROUP("management ssh ip access-group"),
  MANAGEMENT_TELNET_ACCESS_GROUP("management telnet ip access-group"),
  MPLS_LDP_PASSWORD_REQUIRED_FOR("mpls ldp password required for"),
  MSDP_PEER_SA_LIST("msdp peer sa-list"),
  NAMED_RSA_PUB_KEY_SELF_REF("named rsa pubkey"),
  NETWORK_OBJECT_GROUP_GROUP_OBJECT("object-group network group-object"),
  NETWORK_OBJECT_GROUP_NETWORK_OBJECT("object-group network network-object object"),
  NTP_ACCESS_GROUP("ntp access-group"),
  NTP_SOURCE_INTERFACE("ntp source-interface"),
  OBJECT_NAT_MAPPED_INTERFACE("object nat mapped interface"),
  OBJECT_NAT_MAPPED_SOURCE_NETWORK_OBJECT("object nat mapped source network object"),
  OBJECT_NAT_MAPPED_SOURCE_NETWORK_OBJECT_GROUP("object nat mapped source network object group"),
  OBJECT_NAT_REAL_INTERFACE("object nat real interface"),
  OBJECT_NAT_REAL_SOURCE_NETWORK_OBJECT("object nat real source network object"),
  OSPF_AREA_FILTER_LIST("ospf area filter-list"),
  OSPF_AREA_INTERFACE("router ospf area interface"),
  OSPF_DEFAULT_ORIGINATE_ROUTE_MAP("ospf default-originate route-map"),
  OSPF_DISTRIBUTE_LIST_ACCESS_LIST_IN("router ospf distribute-list in"),
  OSPF_DISTRIBUTE_LIST_ACCESS_LIST_OUT("router ospf distribute-list out"),
  OSPF_DISTRIBUTE_LIST_PREFIX_LIST_IN("router ospf distribute-list prefix in"),
  OSPF_DISTRIBUTE_LIST_PREFIX_LIST_OUT("router ospf distribute-list prefix out"),
  OSPF_DISTRIBUTE_LIST_ROUTE_MAP_IN("router ospf distribute-list route-map in"),
  OSPF_DISTRIBUTE_LIST_ROUTE_MAP_OUT("router ospf distribute-list route-map out"),
  OSPF_PREFIX_PRIORITY_MAP("ospf prefix-priority route-map"),
  OSPF_REDISTRIBUTE_BGP_MAP("ospf redistribute bgp route-map"),
  OSPF_REDISTRIBUTE_CONNECTED_MAP("ospf redistribute connected route-map"),
  OSPF_REDISTRIBUTE_EIGRP_MAP("ospf redistribute eigrp route-map"),
  OSPF_REDISTRIBUTE_STATIC_MAP("ospf redistribute static route-map"),
  OSPF6_DISTRIBUTE_LIST_PREFIX_LIST_IN("ipv6 router ospf distribute-list prefix-list in"),
  OSPF6_DISTRIBUTE_LIST_PREFIX_LIST_OUT("ipv6 router ospf distribute-list prefix-list out"),
  PIM_ACCEPT_REGISTER_ACL("pim accept-register acl"),
  PIM_ACCEPT_REGISTER_ROUTE_MAP("pim accept-register route-map"),
  PIM_ACCEPT_RP_ACL("pim accept-rp acl"),
  PIM_RP_ADDRESS_ACL("pim rp-address"),
  PIM_RP_ANNOUNCE_FILTER("pim rp announce filter"),
  PIM_RP_CANDIDATE_ACL("pim rp candidate acl"),
  PIM_SEND_RP_ANNOUNCE_ACL("pim send rp announce acl"),
  PIM_SPT_THRESHOLD_ACL("pim spt threshold acl"),
  PIM_SSM_RANGE("ip pim ssm range"),
  POLICY_MAP_CLASS("policy-map class"),
  POLICY_MAP_CLASS_SERVICE_POLICY("policy-map class service-policy"),
  POLICY_MAP_EVENT_CLASS("policy-map event class"),
  POLICY_MAP_EVENT_CLASS_ACTIVATE("policy-map event class activate"),
  PROTOCOL_OBJECT_GROUP_GROUP_OBJECT("object-group protocol group-object"),
  PROTOCOL_OBJECT_GROUP_PROTOCOL_OBJECT("object-group protocol protocol-object object"),
  QOS_ENFORCE_RULE_SERVICE_CLASS("cable qos enforce-rule service-class"),
  RIP_DISTRIBUTE_LIST("router rip distribute-list"),
  ROUTE_MAP_ADD_COMMUNITY("route-map set community additive"),
  ROUTE_MAP_CLAUSE_PREV_REF("route-map clause"),
  ROUTE_MAP_CONTINUE("route-map continue target clause"),
  ROUTE_MAP_DELETE_COMMUNITY("route-map delete community"),
  ROUTE_MAP_MATCH_AS_PATH_ACCESS_LIST("route-map match as-path access-list"),
  ROUTE_MAP_MATCH_COMMUNITY_LIST("route-map match community-list"),
  ROUTE_MAP_MATCH_EXTCOMMUNITY("route-map match extcommunity"),
  ROUTE_MAP_MATCH_INTERFACE("route-map match interface"),
  ROUTE_MAP_MATCH_IPV4_ACCESS_LIST("route-map match ipv4 access-list"),
  ROUTE_MAP_MATCH_IPV4_PREFIX_LIST("route-map match ipv4 prefix-list"),
  ROUTE_MAP_MATCH_IPV6_ACCESS_LIST("route-map match ipv6 access-list"),
  ROUTE_MAP_MATCH_IPV6_PREFIX_LIST("route-map match ipv6 prefix-list"),
  ROUTE_MAP_SET_COMMUNITY("route-map set community list"),
  ROUTER_ISIS_DISTRIBUTE_LIST_ACL("router isis distribute-list acl"),
  ROUTER_STATIC_ROUTE("router static route"),
  SECURITY_ZONE_PAIR_SELF_REF("zone-pair security self-reference"),
  SERVICE_OBJECT_GROUP_GROUP_OBJECT("object-group service group-object"),
  SERVICE_OBJECT_GROUP_SERVICE_OBJECT("object-group service service-object object"),
  SERVICE_POLICY_GLOBAL("service-policy global"),
  SERVICE_POLICY_INTERFACE("service-policy interface"),
  SNMP_SERVER_COMMUNITY_ACL("snmp server community acl"),
  SNMP_SERVER_COMMUNITY_ACL4("snmp server community ipv4 acl"),
  SNMP_SERVER_COMMUNITY_ACL6("snmp server community ipv6 acl"),
  SNMP_SERVER_FILE_TRANSFER_ACL("snmp server file transfer acl"),
  SNMP_SERVER_GROUP_V3_ACCESS("snmp-server group v3 access"),
  SNMP_SERVER_GROUP_V3_ACCESS_IPV6("snmp-server group v3 access ipv6"),
  SNMP_SERVER_SOURCE_INTERFACE("snmp-server source-interface"),
  SNMP_SERVER_TFTP_SERVER_LIST("snmp server tftp-server list"),
  SNMP_SERVER_TRAP_SOURCE("snmp-server trap-source"),
  SYSTEM_SERVICE_POLICY("system service-policy"),
  SSH_ACL("ssh acl"),
  SSH_IPV4_ACL("ssh ipv4 access-list"),
  SSH_IPV6_ACL("ssh ipv6 access-list"),
  STATIC_ROUTE_TRACK("ip route track"),
  TACACS_SERVER_SELF_REF("tacacs-server"),
  TACACS_SOURCE_INTERFACE("tacacs source-interface"),
  TRACK_INTERFACE("track interface"),
  TRACK_IP_SLA("track ip sla"),
  TRACK_LIST_BOOLEAN("track list boolean"),
  TRACK_LIST_THRESHOLD_PERCENTAGE("track list threshold percentage"),
  TRACK_LIST_THRESHOLD_WEIGHT("track list threshold weight"),
  TUNNEL_PROTECTION_IPSEC_PROFILE("interface TunnelX tunnel protection ipsec profile"),
  TUNNEL_SOURCE("tunnel source"),
  TWICE_NAT_MAPPED_INTERFACE("twice nat mapped interface"),
  TWICE_NAT_MAPPED_DESTINATION_NETWORK_OBJECT("twice nat mapped destination network object"),
  TWICE_NAT_MAPPED_DESTINATION_NETWORK_OBJECT_GROUP(
      "twice nat mapped destination network object group"),
  TWICE_NAT_MAPPED_SOURCE_NETWORK_OBJECT("twice nat mapped source network object"),
  TWICE_NAT_MAPPED_SOURCE_NETWORK_OBJECT_GROUP("twice nat mapped source network object group"),
  TWICE_NAT_REAL_INTERFACE("twice nat real interface"),
  TWICE_NAT_REAL_DESTINATION_NETWORK_OBJECT("twice nat real destination network object"),
  TWICE_NAT_REAL_DESTINATION_NETWORK_OBJECT_GROUP(
      "twice nat real destination network object group"),
  TWICE_NAT_REAL_SOURCE_NETWORK_OBJECT("twice nat real source network object"),
  TWICE_NAT_REAL_SOURCE_NETWORK_OBJECT_GROUP("twice nat real source network object group"),
  WCCP_GROUP_LIST("ip wccp group-list"),
  WCCP_REDIRECT_LIST("ip wccp redirect-list"),
  WCCP_SERVICE_LIST("ip wccp service-list"),
  VRF_DEFINITION_ADDRESS_FAMILY_EXPORT_MAP("vrf definition address-family export map"),
  VRF_DEFINITION_ADDRESS_FAMILY_IMPORT_MAP("vrf definition address-family import map"),
  VXLAN_SOURCE_INTERFACE("vxlan source-interface"),
  VXLAN_SELF_REF("vxlan"),
  ZONE_PAIR_DESTINATION_ZONE("zone-pair security destination"),
  ZONE_PAIR_INSPECT_SERVICE_POLICY("zone-pair service-policy type inspect"),
  ZONE_PAIR_SOURCE_ZONE("zone-pair security source");

  private final String _description;

  CiscoStructureUsage(String description) {
    _description = description;
  }

  @Override
  public String getDescription() {
    return _description;
  }
}
