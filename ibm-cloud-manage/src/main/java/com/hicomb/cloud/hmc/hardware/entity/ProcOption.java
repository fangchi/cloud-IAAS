package com.hicomb.cloud.hmc.hardware.entity;

/**
 * 处理器
 */
public class ProcOption {

	/*配置处理器*/
	private double configurableSysProcUnits;
	/*当前可用内存*/
	private double currAvailSysProcUnits;
	/*安装的内存*/
	private double installedSysProcUnits;
	
	public double getConfigurableSysProcUnits() {
		return configurableSysProcUnits;
	}
	public void setConfigurableSysProcUnits(double configurableSysProcUnits) {
		this.configurableSysProcUnits = configurableSysProcUnits;
	}
	public double getCurrAvailSysProcUnits() {
		return currAvailSysProcUnits;
	}
	public void setCurrAvailSysProcUnits(double currAvailSysProcUnits) {
		this.currAvailSysProcUnits = currAvailSysProcUnits;
	}
	public double getInstalledSysProcUnits() {
		return installedSysProcUnits;
	}
	public void setInstalledSysProcUnits(double installedSysProcUnits) {
		this.installedSysProcUnits = installedSysProcUnits;
	}
	
	
	
}
