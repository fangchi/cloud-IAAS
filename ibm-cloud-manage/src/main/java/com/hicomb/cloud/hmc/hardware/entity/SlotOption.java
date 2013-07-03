package com.hicomb.cloud.hmc.hardware.entity;

/**
 * 卡槽
 */
public class SlotOption {

	/*id*/
	private String id;
	
	/*名称*/
	private String name;
	
	/*描述*/
	private String description;
	
	public SlotOption() {
		super();
	}

	public SlotOption(String id,String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
