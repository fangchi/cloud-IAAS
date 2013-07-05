package com.hicomb.bmc.bladelogic.rest.entity;

import java.util.HashMap;
import java.util.Map;

public class Server {

	private String objectId;
	private String name;
	private String description;
	private String ipAddr;
	private String agentStatus;
	private String osVendor;
	private String osPlatform;
	private String os;
	private String osVersion;
	private boolean isOnline;
	
	private Map<String,Object> properties = new HashMap<String,Object>();
	
	
	private String host;

	public Server(String objectId) {
		super();
		this.objectId = objectId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getAgentStatus() {
		return agentStatus;
	}
	
	public String getOsVendor() {
		return osVendor;
	}

	public void setOsVendor(String osVendor) {
		this.osVendor = osVendor;
	}

	public void setAgentStatus(String agentStatus) {
		if("agent is alive".equals(agentStatus)){
			this.agentStatus = "alive";
		}else {
			this.agentStatus = "notalive";
		}
	}

	public String getOsPlatform() {
		return osPlatform;
	}

	public void setOsPlatform(String osPlatform) {
		this.osPlatform = osPlatform;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public Map<String,Object> getProperties() {
		return properties;
	}

	public void addProperty(String name,Object value) {
		properties.put(name, value);
	}
	
	
}
