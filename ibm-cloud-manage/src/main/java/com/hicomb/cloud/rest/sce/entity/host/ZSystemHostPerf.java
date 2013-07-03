package com.hicomb.cloud.rest.sce.entity.host;

/**
 * Z体系主机性能
 */
public class ZSystemHostPerf {

	/*ip*/
	private String hostIP;
	/*total CPU*/
	private double totalCPU;
	/*内存总量*/
	private double totalMemory;
	/*磁盘总量*/
	private double totalDisk;
	/*空闲磁盘*/
	private double freeDisk;
	/*CPU使用率*/
	private double usageCPU;
	/*内存使用率*/
	private double usageMemory;
	/*磁盘使用率*/
	private double usageDisk;

	public String getHostIP() {
		return hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
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

	public double getFreeDisk() {
		return freeDisk;
	}

	public void setFreeDisk(double freeDisk) {
		this.freeDisk = freeDisk;
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
