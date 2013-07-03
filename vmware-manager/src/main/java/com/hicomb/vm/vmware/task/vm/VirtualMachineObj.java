package com.hicomb.vm.vmware.task.vm;

import java.text.DecimalFormat;
import java.util.List;

import com.vmware.vim25.GuestDiskInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NetworkSummary;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualMachineStorageInfo;

public class VirtualMachineObj {

	private String objId;

	private String VmName;

	private String version;

	private String hostIp;

	private int numCpu;
	
	private int diskNum;

	private int totalMemory;// 单位：MB

	private int cpuCapacity;

	private int VMOverallCpuUsage;// CPU使用量

	private int VMOguestMemoryUsage;// 内存使用量

	private Long committedStorage;

	private VirtualMachineConfigInfo virtualMachineConfigInfo;

	private ManagedObjectReference managedObjectReference;

	private ManagedObjectReference host;

	private VirtualMachinePowerState virtualMachinePowerState;

	private VirtualMachineStorageInfo virtualMachineStorageInfo;

	private GuestDiskInfo[] guestDiskInfos;

	private String guestOSFullName;

	private String guestIpAddress;

	private List<NetworkSummary> networks;
	
	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getNumCpu() {
		return numCpu;
	}

	public void setNumCpu(int numCpu) {
		this.numCpu = numCpu;
	}

	public int getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(int totalMemory) {
		this.totalMemory = totalMemory;
	}

	public int getVMOverallCpuUsage() {
		return VMOverallCpuUsage;
	}

	public void setVMOverallCpuUsage(int vMOverallCpuUsage) {
		VMOverallCpuUsage = vMOverallCpuUsage;
	}

	public int getVMOguestMemoryUsage() {
		return VMOguestMemoryUsage;
	}

	public void setVMOguestMemoryUsage(int vMOguestMemoryUsage) {
		VMOguestMemoryUsage = vMOguestMemoryUsage;
	}

	public Long getCommittedStorage() {
		return committedStorage / 1024 / 1024 / 1024;
	}

	public void setCommittedStorage(Long committedStorage) {
		this.committedStorage = committedStorage;
	}

	public String getVmName() {
		return VmName;
	}

	public void setVmName(String vmName) {
		VmName = vmName;
	}

	public VirtualMachineObj(ManagedObjectReference managedObjectReference) {
		super();
		this.managedObjectReference = managedObjectReference;
	}

	public ManagedObjectReference getManagedObjectReference() {
		return managedObjectReference;
	}

	public void setManagedObjectReference(
			ManagedObjectReference managedObjectReference) {
		this.managedObjectReference = managedObjectReference;
	}

	public VirtualMachineConfigInfo getVirtualMachineConfigInfo() {
		return virtualMachineConfigInfo;
	}

	public void setVirtualMachineConfigInfo(
			VirtualMachineConfigInfo virtualMachineConfigInfo) {
		this.virtualMachineConfigInfo = virtualMachineConfigInfo;
	}

	public ManagedObjectReference getHost() {
		return host;
	}

	public void setHost(ManagedObjectReference host) {
		this.host = host;
	}

	public VirtualMachinePowerState getVirtualMachinePowerState() {
		return virtualMachinePowerState;
	}

	public void setVirtualMachinePowerState(
			VirtualMachinePowerState virtualMachinePowerState) {
		this.virtualMachinePowerState = virtualMachinePowerState;
	}

	public GuestDiskInfo[] getGuestDiskInfos() {
		return guestDiskInfos;
	}

	public void setGuestDiskInfos(GuestDiskInfo[] guestDiskInfos) {
		this.guestDiskInfos = guestDiskInfos;
	}

	public String getGuestOSFullName() {
		return guestOSFullName;
	}

	public void setGuestOSFullName(String guestOSFullName) {
		this.guestOSFullName = guestOSFullName;
	}

	public String getGuestIpAddress() {
		return guestIpAddress;
	}

	public void setGuestIpAddress(String guestIpAddress) {
		this.guestIpAddress = guestIpAddress;
	}

	public List<NetworkSummary> getNetworks() {
		return networks;
	}

	public void setNetworkSummaries(List<NetworkSummary> networks) {
		this.networks = networks;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public VirtualMachineStorageInfo getVirtualMachineStorageInfo() {
		return virtualMachineStorageInfo;
	}

	public void setDiskNum(int diskNum){
		this.diskNum = diskNum;
	}
	
	public int getDiskNum() {
		return this.diskNum;
	}

	/**
	 * 获取VM磁盘大小（G）
	 * 
	 * @return
	 */
	public float getTotalStorage() {
		float storageSize = 0;
		if (getGuestDiskInfos() != null) {
			for (GuestDiskInfo guestDiskInfo : this.getGuestDiskInfos()) {
				storageSize = storageSize + (float) guestDiskInfo.getCapacity()
						/ 1024 / 1024 / 1024;
			}
			return storageSize;
		} else{
			return 0;
		}
//		if (virtualMachineStorageInfo != null) {
//			for (VirtualMachineUsageOnDatastore virtualMachineUsageOnDatastore : virtualMachineStorageInfo
//					.getPerDatastoreUsage()) {
//				storageSize = storageSize
//						+ virtualMachineUsageOnDatastore.getCommitted();
//			}
//			return storageSize / 1024 / 1024 / 1024;
//		} else {
//			return 0;
//		}
	}

	/**
	 * 获取可使用的磁盘大小（G）
	 * 
	 * @return
	 */
	public float getFreeStorage() {
		float freeStorageSize = 0;
		if (getGuestDiskInfos() != null) {
			for (GuestDiskInfo guestDiskInfo : this.getGuestDiskInfos()) {
				freeStorageSize = freeStorageSize
						+ (float) guestDiskInfo.getFreeSpace() / 1024 / 1024
						/ 1024;
			}
			return freeStorageSize;
		} else {
			return 0;
		}
//		if (virtualMachineStorageInfo != null) {
//			for (VirtualMachineUsageOnDatastore virtualMachineUsageOnDatastore : virtualMachineStorageInfo
//					.getPerDatastoreUsage()) {
//				freeStorageSize = freeStorageSize
//						+ virtualMachineUsageOnDatastore.getUncommitted();
//			}
//			return freeStorageSize / 1024 / 1024 / 1024;
//		} else {
//			return 0;
//		}
	}
	
	/**
	 * VM磁盘使用率
	 * @param
	 */
	public float getDiskUsage(){
		float diskUsage = 0;
		if (getGuestDiskInfos() != null) {
			return getFreeStorage()/getTotalStorage();
		} else {
			return diskUsage;
		}
	}

	public void setVirtualMachineStorageInfo(
			VirtualMachineStorageInfo virtualMachineStorageInfo) {
		this.virtualMachineStorageInfo = virtualMachineStorageInfo;
	}

	public String getName() {
		return getVirtualMachineConfigInfo() != null ? getVirtualMachineConfigInfo()
				.getName() : "";
	}

	public String getGuestFullName() {
		return getVirtualMachineConfigInfo() != null ? getVirtualMachineConfigInfo()
				.getGuestFullName() : "";
	}

	public int getCpuCapacity() {
		return cpuCapacity;
	}

	public void setCpuCapacity(int cpuCapacity) {
		this.cpuCapacity = cpuCapacity;
	}

	/**
	 * 获取CPU使用率(%)
	 * 标准获取方法,但是基于Vcenter平台的不同可能会导致getCpuCapacity为0情况，
	 * 实际使用中如果该方法获取的值不合理可使用反取host主机主频*虚拟机核心数的模式
	 * @return
	 */
	public double getCpuPercent() {
		DecimalFormat decimal = new DecimalFormat("#.##");
		return Double.valueOf(decimal.format(Double.valueOf(
				getCpuCapacity() == 0 ? 0 : getVMOverallCpuUsage() * 100
						/ getCpuCapacity()).doubleValue()));
	}

	/**
	 * CPU使用量(MHZ)
	 * 
	 * @return
	 */
	public float getOverallCpuUsage() {
		if ("poweredOff".equalsIgnoreCase(getVirtualMachinePowerState()
				.toString())) {
			return 0;
		} else {
			DecimalFormat decimal = new DecimalFormat("#.##");
			return Float.valueOf(
					decimal.format(Float.valueOf(getVMOverallCpuUsage())
							.floatValue())).floatValue();
		}
	}

	/**
	 * 获取内存使用量(MB)
	 * 
	 * @return
	 */
	public float getGuestMemoryUsage() {
		if ("poweredOff".equalsIgnoreCase(getVirtualMachinePowerState()
				.toString())) {
			return 0;
		} else {
			DecimalFormat decimal = new DecimalFormat("#.##");
			return Float.valueOf(
					decimal.format(Float.valueOf(getVMOguestMemoryUsage())
							.floatValue())).floatValue();
		}
	}

	/**
	 * 获取内存使用率(%)
	 * 
	 * @return
	 */
	public float getMemoryUsePercent() {
		return getGuestMemoryUsage() * 100 / getTotalMemory();
	}
}
