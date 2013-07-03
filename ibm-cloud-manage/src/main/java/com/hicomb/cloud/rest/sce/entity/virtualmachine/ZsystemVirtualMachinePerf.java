package com.hicomb.cloud.rest.sce.entity.virtualmachine;

/**
 * z体系虚拟机性能
 */
public class ZsystemVirtualMachinePerf {
	
	/*虚拟机ID*/
	private String oid;

	/*CPU总数*/
	private double totalCPU;

	/*总内存*/
	private double totalMemory;
	
	/*总磁盘*/
	private double totalDisk;

	/*CPU使用量*/
	private double usageCPU;

	/*CPU使用量*/
	private double usageMemory;

	/*磁盘使用量*/
	private double usageDisk;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getTotalCPU() {
		return totalCPU;
	}

	public void setTotalCPU(double totalCPU) {
		this.totalCPU = totalCPU;
	}

	public double getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(double totalMemory) {
		this.totalMemory = totalMemory;
	}

	public double getTotalDisk() {
		return totalDisk;
	}

	public void setTotalDisk(double totalDisk) {
		this.totalDisk = totalDisk;
	}

	public double getUsageCPU() {
		return usageCPU;
	}

	public void setUsageCPU(double usageCPU) {
		this.usageCPU = usageCPU;
	}

	public double getUsageMemory() {
		return usageMemory;
	}

	public void setUsageMemory(double usageMemory) {
		this.usageMemory = usageMemory;
	}

	public double getUsageDisk() {
		return usageDisk;
	}

	public void setUsageDisk(double usageDisk) {
		this.usageDisk = usageDisk;
	}
	
	
}
