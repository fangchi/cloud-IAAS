package com.hicomb.vm.vmware.task.cluster;

import java.util.ArrayList;
import java.util.List;

import com.hicomb.vm.vmware.task.host.HostObj;
import com.vmware.vim25.ManagedObjectReference;

/**
 * 集群队形
 */
public class ClusterObj {

	/* id */
	private String id;
	/* 名称 */
	private String name;
	/** vCenter名称 */
	private String vCenterName;
	/* reference */
	private ManagedObjectReference managedObjectReference;
	/* 主机列表 */
	private List<HostObj> hostObjs = new ArrayList<HostObj>();
	/* 可用CPU */
	private int effectiveCpu;
	/* 使用的CPU */
	private float usedCpu;
	/* 使用的内存 */
	private float usedMemory;
	/* 可用内存 */
	private long effectiveMemory;
	/* 可用的主机 */
	private long numEffectiveHosts;
	/* 主机数量 */
	private int numHosts;
	/* CPU核心 */
	private short numCpuCores;
	/* 使用的CPU核心 */
	private int usedNumCpuCores;
	/* CPU总量 */
	private int totalCpu;
	/* 内存总量 */
	private long totalMemory;

	public ClusterObj(ManagedObjectReference managedObjectReference) {
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

	public String getvCenterName() {
		return vCenterName;
	}

	public void setvCenterName(String vCenterName) {
		this.vCenterName = vCenterName;
	}

	public short getNumCpuCores() {
		return numCpuCores;
	}

	public void setNumCpuCores(short numCpuCores) {
		this.numCpuCores = numCpuCores;
	}

	public int getUsedNumCpuCores() {
		return usedNumCpuCores;
	}

	public void setUsedNumCpuCores(int usedNumCpuCores) {
		this.usedNumCpuCores = usedNumCpuCores;
	}

	public List<HostObj> getHostObjs() {
		return hostObjs;
	}

	public void setEffectiveCpu(int effectiveCpu) {
		this.effectiveCpu = effectiveCpu;
	}

	public long getEffectiveCpu() {
		return this.effectiveCpu / 1024;
	}

	public void setTotalCpu(int totalCpu) {
		this.totalCpu = totalCpu;
	}

	public float getTotalCpu() {
		return (float) this.totalCpu / 1024;
	}

	/**
	 * 总的内存量（单位：GB）
	 * 
	 * @return
	 */
	public float getTotalMemory() {
		return (float) totalMemory / (1024 * 1024 * 1024);
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	/**
	 * 获取CPU频率使用率(%)
	 * 
	 * @return
	 */
	public double getCpuHZUsage() {
		if (getTotalCpu() == 0) {
			return 0;
		} else {
			return (((double) (getUsedCpu() * 100)) / getTotalCpu());
		}
	}

	/**
	 * 获取CPU核心使用率(%)
	 * 
	 * @return
	 */
	public double getCpuCoreUsage() {
		if (getNumCpuCores() == 0 || getUsedNumCpuCores() == 0) {
			return 0;
		} else {
			return ((double) getUsedNumCpuCores() * 100) / getNumCpuCores();
		}
	}

	/**
	 * 获取可用CPU核心数
	 * 
	 * @return
	 */
	public int getNumEffectiveCpuCores() {
		return getNumCpuCores() - getUsedNumCpuCores();
	}

	/**
	 * 可用内存量（单位：GB）
	 * 
	 * @return
	 */
	public long getEffectiveMemory() {
		return effectiveMemory / 1024;
	}

	public void setEffectiveMemory(long effectiveMemory) {
		this.effectiveMemory = effectiveMemory;
	}

	public long getNumEffectiveHosts() {
		return numEffectiveHosts;
	}

	public void setNumEffectiveHosts(long numEffectiveHosts) {
		this.numEffectiveHosts = numEffectiveHosts;
	}

	public float getUsedCpu() {
		return (float) usedCpu / 1024;
	}

	public void setUsedCpu(float usedCpu) {
		this.usedCpu = usedCpu;
	}

	public float getUsedMemory() {
		return (float) usedMemory / 1024;
	}

	public void setUsedMemory(float usedMemory) {
		this.usedMemory = usedMemory;
	}

	public Integer getNumHosts() {
		return numHosts;
	}

	public void setNumHosts(Integer numHosts) {
		this.numHosts = numHosts;
	}

	/**
	 * 获取内存使用率
	 * 
	 * @return
	 */
	public double getMemoryUsage() {
		if (getTotalMemory() == 0) {
			return 0;
		} else {
			return (double) ((getUsedMemory() * 100) / getTotalMemory());
		}
	}

	public void setHostObjs(List<HostObj> hostObjs) {
		this.hostObjs = hostObjs;
	}

	public void addHostObj(HostObj hostObj) {
		this.hostObjs.add(hostObj);
	}
}
