package com.hicomb.cloud.rest.sysdirector.entity.systempool;

/**
 * 系统池性能Bean
 */
public class SystemPoolPerf {

	/*Id*/
	private String OID;
	
	/*总存储*/
	private double totalstorage;
	
	/*未使用的存储*/
	private double freestorage;
	
	/*分配的存储*/
	private double allocatedstorage;

	/*未使用的内存*/
	private double freememory;
	
	/*分配的内存*/
	private double allocatedmemory;
	
	/*总内存*/
	private double totalmemory;
	
	/*可用的处理器*/
	private double freeprocessor;
	
	/*分配的存储器*/
	private double allocatedprocessor;
	
	/*总存储器*/
	private double totalprocessor;
	
	/*平均CPU使用率*/
	private double avgcpuutilization;
	

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	public double getTotalstorage() {
		return totalstorage;
	}

	public void setTotalstorage(double totalStorage) {
		this.totalstorage = totalStorage;
	}

	public double getFreestorage() {
		return freestorage;
	}

	public void setFreestorage(double freeStorage) {
		this.freestorage = freeStorage;
	}

	public double getAllocatedstorage() {
		return allocatedstorage;
	}

	public void setAllocatedstorage(double allocatedstorage) {
		this.allocatedstorage = allocatedstorage;
	}

	public double getFreememory() {
		return freememory;
	}

	public void setFreememory(double freememory) {
		this.freememory = freememory;
	}

	public double getAllocatedmemory() {
		return allocatedmemory;
	}

	public void setAllocatedmemory(double allocatedmemory) {
		this.allocatedmemory = allocatedmemory;
	}

	public double getTotalmemory() {
		return totalmemory;
	}

	public void setTotalmemory(double totalmemory) {
		this.totalmemory = totalmemory;
	}

	public double getFreeprocessor() {
		return freeprocessor;
	}

	public void setFreeprocessor(double freeprocessor) {
		this.freeprocessor = freeprocessor;
	}

	public double getAllocatedprocessor() {
		return allocatedprocessor;
	}

	public void setAllocatedprocessor(double allocatedprocessor) {
		this.allocatedprocessor = allocatedprocessor;
	}

	public double getTotalprocessor() {
		return totalprocessor;
	}

	public void setTotalprocessor(double totalprocessor) {
		this.totalprocessor = totalprocessor;
	}

	public double getAvgcpuutilization() {
		return avgcpuutilization;
	}

	public void setAvgcpuutilization(double avgcpuutilization) {
		this.avgcpuutilization = avgcpuutilization;
	}
	
	
}
