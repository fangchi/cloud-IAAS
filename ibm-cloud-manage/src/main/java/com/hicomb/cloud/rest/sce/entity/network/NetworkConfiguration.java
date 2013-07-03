package com.hicomb.cloud.rest.sce.entity.network;

import com.hicomb.cloud.rest.sce.entity.LabelObject;
/**
 * 网络配置
 */
public class NetworkConfiguration {
	
	private String id;
	private String name;
	private LabelObject useDHCP;
	private LabelObject wins1;
	private LabelObject wins2;
	private LabelObject dns1;
	private LabelObject dns2;
	private String description;
	private LabelObject domain;
	private LabelObject gateway1;
	private LabelObject gateway2;
	private LabelObject subnet;
	private int usedCount;
	private String cloudId;
	private String cloudType;

	public NetworkConfiguration() {
		super();
	}

	public NetworkConfiguration(String id,String name,LabelObject useDHCP, LabelObject wins1,
			LabelObject wins2, LabelObject dns1, LabelObject dns2,
			String description, LabelObject domain, LabelObject gateway1,
			LabelObject gateway2, LabelObject subnet, int usedCount) {
		super();
		this.id = id;
		this.name = name;
		this.useDHCP = useDHCP;
		this.wins1 = wins1;
		this.wins2 = wins2;
		this.dns1 = dns1;
		this.dns2 = dns2;
		this.description = description;
		this.domain = domain;
		this.gateway1 = gateway1;
		this.gateway2 = gateway2;
		this.subnet = subnet;
		this.usedCount = usedCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LabelObject getUseDHCP() {
		return useDHCP;
	}

	public void setUseDHCP(LabelObject useDHCP) {
		this.useDHCP = useDHCP;
	}

	public LabelObject getWins1() {
		return wins1;
	}

	public void setWins1(LabelObject wins1) {
		this.wins1 = wins1;
	}

	public LabelObject getWins2() {
		return wins2;
	}

	public void setWins2(LabelObject wins2) {
		this.wins2 = wins2;
	}

	public LabelObject getDns1() {
		return dns1;
	}

	public void setDns1(LabelObject dns1) {
		this.dns1 = dns1;
	}

	public LabelObject getDns2() {
		return dns2;
	}

	public void setDns2(LabelObject dns2) {
		this.dns2 = dns2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LabelObject getDomain() {
		return domain;
	}

	public void setDomain(LabelObject domain) {
		this.domain = domain;
	}

	public LabelObject getGateway1() {
		return gateway1;
	}

	public void setGateway1(LabelObject gateway1) {
		this.gateway1 = gateway1;
	}

	public LabelObject getGateway2() {
		return gateway2;
	}

	public void setGateway2(LabelObject gateway2) {
		this.gateway2 = gateway2;
	}

	public LabelObject getSubnet() {
		return subnet;
	}

	public void setSubnet(LabelObject subnet) {
		this.subnet = subnet;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public String getCloudId() {
		return cloudId;
	}

	public void setCloudId(String cloudId) {
		this.cloudId = cloudId;
	}

	public String getCloudType() {
		return cloudType;
	}

	public void setCloudType(String cloudType) {
		this.cloudType = cloudType;
	}
}
