package com.hicomb.cloud.rest.sysdirector.entity.host;

/**
 * Power主机
 */
public class PowerHost {

	/*Power主机*/
	private String OID;
	/*Power名称*/
	private String name;
	/*处理器能力*/
	private double processorCapacity;
	/*处理器最大分配*/
	private double processorMaximumAllocationInt;
	/*Memory容量*/
	private double memoryCapacity;
	/*Momory最大分配*/
	private double memoryMaximumAllocation;
	/*存储容量*/
	private double storageCapacity;
	/*已经分配的存储*/
	private double storageAllocation;

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProcessorCapacity() {
		return processorCapacity;
	}

	public void setProcessorCapacity(double processorCapacity) {
		this.processorCapacity = processorCapacity;
	}

	public double getProcessorMaximumAllocationInt() {
		return processorMaximumAllocationInt;
	}

	public void setProcessorMaximumAllocationInt(
			double processorMaximumAllocationInt) {
		this.processorMaximumAllocationInt = processorMaximumAllocationInt;
	}

	/**
	 * 获取Processor使用率
	 * @return
	 */
	public double getProcessorUsage() {
		return (processorCapacity - processorMaximumAllocationInt)
				/ (processorCapacity == 0 ? 1 : processorCapacity);
	}

	public double getMemoryCapacity() {
		return memoryCapacity;
	}

	public void setMemoryCapacity(double memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}

	public double getMemoryMaximumAllocation() {
		return memoryMaximumAllocation;
	}

	public void setMemoryMaximumAllocation(double memoryMaximumAllocation) {
		this.memoryMaximumAllocation = memoryMaximumAllocation;
	}

	/**
	 * 内存使用率
	 * @return
	 */
	public double getMemoryUsage() {
		return (memoryCapacity - memoryMaximumAllocation) / (memoryCapacity == 0 ? 1
				: memoryCapacity);
	}

	public double getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(double storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public double getStorageAllocation() {
		return storageAllocation;
	}

	public void setStorageAllocation(double storageAllocation) {
		this.storageAllocation = storageAllocation;
	}

	/**
	 * 获取存储使用率
	 * @return
	 */
	public double getStorageUsage() {
		return (storageCapacity - storageAllocation) / (storageCapacity == 0 ? 1
				: storageCapacity);
	}

}
