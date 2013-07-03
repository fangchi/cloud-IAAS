package com.hicomb.cloud.rest.sce.entity.appliance;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hicomb.cloud.rest.sce.entity.State;

/**
 * 镜像
 */
public class Appliance {
	/*id*/
	private String id;
	/*名称*/
	private String name;
	/*变更日期*/
	private Date changedDate;
	/*状态*/
	private State state;
	/*hypervisor*/
	private String hypervisor;
	/*描述*/
	private String description;
	/*体系架构*/
	private String architecture;
	/*个性化定制属性*/
	private Map customProperties;
	/*网络配置属性*/
	private Map networkProperties;
	/*存储属性*/
	private Map storageProperties;
	
	public Appliance() {
		super();
		customProperties = new HashMap();
		networkProperties =  new HashMap();
	}
	
	public Appliance(String id, String name, Date changedDate, State state,
			String hypervisor, String description, String architecture) {
		super();
		this.id = id;
		this.name = name;
		this.changedDate = changedDate;
		this.state = state;
		this.hypervisor = hypervisor;
		this.description = description;
		this.architecture = architecture;
		customProperties = new HashMap();
		networkProperties =  new HashMap();
		storageProperties = new HashMap();
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

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public Map getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(Map customProperties) {
		this.customProperties = customProperties;
	}
	

	public Map getNetworkProperties() {
		return networkProperties;
	}

	public void setNetworkProperties(Map networkProperties) {
		this.networkProperties = networkProperties;
	}

	public Map getStorageProperties() {
		return storageProperties;
	}

	public void setStorageProperties(Map storageProperties) {
		this.storageProperties = storageProperties;
	}
	
	
}
