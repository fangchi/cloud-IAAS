package com.hicomb.cloud.rest.sysdirector.entity.systempool;

/**
 * 系统池
 */
public class SystemPool {

	private String name;
	private String OID;

	public SystemPool() {
		super();
	}

	public SystemPool(String name, String oID) {
		super();
		this.name = name;
		OID = oID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

}
