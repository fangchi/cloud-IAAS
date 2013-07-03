package com.hicomb.cloud.rest.sysdirector.entity.vm;

public class PowerVirtualMachinePerf {

	/*oid*/
	private String oid;
	
	/*原始SCE Id*/
	private String srcId;
	
	/*CPU性能*/
	private double cpuUsage;
	
	/*内存使用率*/
	private double memoryUsage;
	
	/*已分配内存*/
	private double memoryallocation;
	
	/*总磁盘*/
	private double totalDisk;
	
	/*使用的磁盘*/
	private double usedDisk;
	
	public double getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public double getMemoryallocation() {
		return memoryallocation;
	}

	public void setMemoryallocation(double memoryallocation) {
		this.memoryallocation = memoryallocation;
	}

	public double getTotalDisk() {
		return totalDisk;
	}

	public void setTotalDisk(double totalDisk) {
		this.totalDisk = totalDisk;
	}

	public double getUsedDisk() {
		return usedDisk;
	}

	public void setUsedDisk(double usedDisk) {
		this.usedDisk = usedDisk;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getSrcId() {
		return srcId;
	}

	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}

	public double getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(double memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
}


