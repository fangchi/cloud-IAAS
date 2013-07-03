package com.hicomb.vm.vmware.task.host;

import java.util.ArrayList;
import java.util.List;

import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.vmware.vim25.HostCpuInfo;
import com.vmware.vim25.HostCpuPackage;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.HostSystemInfo;
import com.vmware.vim25.ManagedObjectReference;

/**
 * 主机对象
 */
public class HostObj {

	/* UUID */
	private String uuid;

	private String vCenterName;

	private String ipAddress;

	private String macAddress;

	private String model;// 类型

	/* 硬件厂商 */
	private String HardwareVendor;

	/* 核心数 */
	private Short numCpuCores;

	/* CPU描述 */
	private String cpuDescription;

	/* CPU信息对象 */
	private HostCpuInfo hostCpuInfo;

	/* CPU详细信息 */
	private HostCpuPackage[] hostCpuPackage;

	/* 虚拟机列表 */
	private List<VirtualMachineObj> list = new ArrayList<VirtualMachineObj>();

	private float memorySize;

	private float memoryUsage;

	/* 网络 */
	private HostNetworkInfo networkInfo;

	/* reference */
	private ManagedObjectReference hostreference;

	private short diskNumber;

	private float totalDiskSize;

	private float freeDiskSize;

	private String diskType;

	private float cpuMhz;// CPU频率(单位：MHZ)

	private float cpuUsage;

	private float diskUsage;

	private float overallCpuUsage;

	public HostObj(ManagedObjectReference hostreference) {
		super();
		this.hostreference = hostreference;
	}

	public HostObj(HostCpuInfo hostCpuInfo, Long memorySize,
			HostSystemInfo systeminfo, ManagedObjectReference hostreference,
			HostNetworkInfo networkInfo) {
		super();
		this.memorySize = memorySize;
		this.hostreference = hostreference;
		this.networkInfo = networkInfo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getvCenterName() {
		return vCenterName;
	}

	public void setvCenterName(String vCenterName) {
		this.vCenterName = vCenterName;
	}

	/**
	 * 获取磁盘信息（MB）
	 * 
	 * @return
	 */
	public float getMemorySize() {
		return (float) memorySize / (1024 * 1024);
	}

	public void setMemorySize(Long memorySize) {
		this.memorySize = memorySize;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public ManagedObjectReference getHostreference() {
		return hostreference;
	}

	public void setHostreference(ManagedObjectReference hostreference) {
		this.hostreference = hostreference;
	}

	public float getTotalDiskSize() {
		return totalDiskSize;
	}

	public void setTotalDiskSize(float totalDiskSize) {
		this.totalDiskSize = totalDiskSize;
	}

	public short getDiskNumber() {
		return diskNumber;
	}

	public void setDiskNumber(short diskNumber) {
		this.diskNumber = diskNumber;
	}

	public float getFreeDiskSize() {
		return freeDiskSize;
	}

	public void setFreeDiskSize(float freeDiskSize) {
		this.freeDiskSize = freeDiskSize;
	}

	public float getDiskUsage() {
		return diskUsage;
	}

	public void setDiskUsage(float diskUsage) {
		this.diskUsage = diskUsage;
	}

	public float getCpuMhz() {
		return cpuMhz;
	}

	public void setCpuMhz(float cpuMhz) {
		this.cpuMhz = cpuMhz;
	}

	public HostCpuInfo getHostCpuInfo() {
		return hostCpuInfo;
	}

	public void setHostCpuInfo(HostCpuInfo hostCpuInfo) {
		this.hostCpuInfo = hostCpuInfo;
	}

	public float getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(float memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public float getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(float cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public String getDiskType() {
		return diskType;
	}

	public void setDiskType(String diskType) {
		this.diskType = diskType;
	}

	public HostCpuPackage[] getHostCpuPackage() {
		return hostCpuPackage;
	}

	public void setHostCpuPackage(HostCpuPackage[] hostCpuPackage) {
		this.hostCpuPackage = hostCpuPackage;
	}

	public HostNetworkInfo getNetworkInfo() {
		return networkInfo;
	}

	public void setNetworkInfo(HostNetworkInfo networkInfo) {
		this.networkInfo = networkInfo;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public List<VirtualMachineObj> getList() {
		return list;
	}

	public void setList(List<VirtualMachineObj> list) {
		this.list = list;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getHardwareVendor() {
		return HardwareVendor;
	}

	public void setHardwareVendor(String hardwareVendor) {
		HardwareVendor = hardwareVendor;
	}

	public int getNumCpuCores() {
		return numCpuCores;
	}

	public void setNumCpuCores(Short numCpuCores) {
		this.numCpuCores = numCpuCores;
	}

	public String getCpuDescription() {
		return cpuDescription;
	}

	public void setCpuDescription(String cpuDescription) {
		this.cpuDescription = cpuDescription;
	}

	public float getOverallCpuUsage() {
		return overallCpuUsage;
	}

	public void setOverallCpuUsage(float overallCpuUsage) {
		this.overallCpuUsage = overallCpuUsage;
	}
}
