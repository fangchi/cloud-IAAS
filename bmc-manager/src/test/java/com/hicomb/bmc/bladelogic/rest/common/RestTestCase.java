package com.hicomb.bmc.bladelogic.rest.common;

import junit.framework.TestCase;

public abstract class RestTestCase extends TestCase{
	
	protected String username;
	
	protected String password;
	
	protected String userRole;
	
	protected String serverIp;
	
	protected int port;
	
	protected String sslKey;
	
	@Override
	public void setUp() {
		username="BLAdmin";
		password="sa";
		userRole="BLAdmins";
		serverIp = "192.168.14.160";
		port = 9843;
		sslKey = "123456";
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getServerIp() {
		return serverIp;
	}

	public int getPort() {
		return port;
	}
}
