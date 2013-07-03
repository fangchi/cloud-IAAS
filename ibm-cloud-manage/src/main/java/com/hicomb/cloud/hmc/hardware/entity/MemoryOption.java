package com.hicomb.cloud.hmc.hardware.entity;

/**
 * 内存 
 */
public class MemoryOption {

	/*配置内存*/
	private double configurableSysMem;
	/*当前可用内存*/
	private double currAvailSysMem;
	/*安装内存*/
	private double installedSysMem;
	/*防火墙内存*/
	private double sysFirmwareMem;

	public double getConfigurableSysMem() {
		return configurableSysMem;
	}

	public void setConfigurableSysMem(double configurableSysMem) {
		this.configurableSysMem = configurableSysMem;
	}

	public double getCurrAvailSysMem() {
		return currAvailSysMem;
	}

	public void setCurrAvailSysMem(double currAvailSysMem) {
		this.currAvailSysMem = currAvailSysMem;
	}

	public double getInstalledSysMem() {
		return installedSysMem;
	}

	public void setInstalledSysMem(double installedSysMem) {
		this.installedSysMem = installedSysMem;
	}

	public double getSysFirmwareMem() {
		return sysFirmwareMem;
	}

	public void setSysFirmwareMem(double sysFirmwareMem) {
		this.sysFirmwareMem = sysFirmwareMem;
	}

}
