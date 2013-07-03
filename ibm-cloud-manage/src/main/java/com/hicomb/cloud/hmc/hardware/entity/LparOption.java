package com.hicomb.cloud.hmc.hardware.entity;

/**
 * Lpar 
 */
public class LparOption {

	/*名称*/
	private String lparName;
	
	/*IP地址*/
	private String lparIpAddr;

	public LparOption(String lparName, String lparIpAddr) {
		super();
		this.lparName = lparName;
		this.lparIpAddr = lparIpAddr;
	}

	public String getLparName() {
		return lparName;
	}

	public void setLparName(String lparName) {
		this.lparName = lparName;
	}

	public String getLparIpAddr() {
		return lparIpAddr;
	}

	public void setLparIpAddr(String lparIpAddr) {
		this.lparIpAddr = lparIpAddr;
	}
	
}
