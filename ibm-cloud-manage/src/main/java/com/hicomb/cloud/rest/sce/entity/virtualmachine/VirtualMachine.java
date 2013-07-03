package com.hicomb.cloud.rest.sce.entity.virtualmachine;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hicomb.cloud.rest.sce.entity.State;

public class VirtualMachine {

	private String id;
	private String name;
	/*hypervisor*/
	private String hypervisor;
	
	private String description;
	private State state;
	private String ipAddress;
	private String architecture;
	/*原始ID  对于X86为UUID 对应Power/Z 为对应的RestID*/
	private String srcId;
	/*虚拟服务器 日后虚拟机和虚拟服务器为1对1关系*/
	private List<String> virtualServers = new ArrayList<String>();
	
	private long cpuNum;
	
	private long memorySize;
	
	private long diskSize;
	
	private Map customProperties;
	
	public VirtualMachine() {
		super();
		customProperties = new HashMap();
	}
	
	public VirtualMachine(String id, String name, Date changedDate, State state,
			String hypervisor, String description, String architecture,String srcId) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.hypervisor = hypervisor;
		this.description = description;
		this.srcId = srcId;
		customProperties = new HashMap();
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Map getCustomProperties() {
		return customProperties;
	}

	public void setCustomProperties(Map customProperties) {
		this.customProperties = customProperties;
	}

	public long getCpuNum() {
		return cpuNum;
	}

	public void setCpuNum(long cpuNum) {
		this.cpuNum = cpuNum;
	}

	public long getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(long memorySize) {
		this.memorySize = memorySize;
	}

	public long getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(long diskSize) {
		this.diskSize = diskSize;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public List<String> getVirtualServers() {
		return virtualServers;
	}

	public void setVirtualServers(List<String> virtualServers) {
		this.virtualServers = virtualServers;
	}

	public String getSrcId() {
		return srcId;
	}

	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}
}
