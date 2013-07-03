package com.hicomb.cloud.hmc.hardware.entity;

/**
 * 子卡槽
 */
public class SubSlotOption {

	/*id*/
	private String id;
	
	/*描述*/
	private String description;
	
	/*Mac地址*/
	private String macAddress;
	
	/*wwpn*/
	private String wwpn;
	
	public SubSlotOption() {
		super();
	}

	public SubSlotOption(String name, String description,String macAddress,String wwpn) {
		super();
		this.id = name;
		this.description = description;
		this.macAddress = macAddress;
		this.wwpn = wwpn;
	}

	public String getId() {
		return id;
	}

	public void setId(String name) {
		this.id = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getWwpn() {
		return wwpn;
	}

	public void setWwpn(String wwpn) {
		this.wwpn = wwpn;
	}
	
	
}
