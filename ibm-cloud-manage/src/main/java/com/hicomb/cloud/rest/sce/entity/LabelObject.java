package com.hicomb.cloud.rest.sce.entity;

/**
 * SCELabel组件
 */
public class LabelObject {

	private String id;
	private String label;
	
	public LabelObject() {
		super();
	}

	public LabelObject(String id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
