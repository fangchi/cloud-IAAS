package com.hicomb.cloud.hmc.base;

import junit.framework.TestCase;

/**
 * HMC基础测试用例
 */
public class BaseTestCase extends TestCase {

	protected String hostIp;
	protected int port;
	protected String userName;
	protected String password;

	
	
	@Override
	public void setUp(){
		hostIp = "172.16.13.107";
		port =22;
		userName ="fujianpsa";
		password ="fujianpsa";
	}
	
	@Override
	public void tearDown(){
		
	}
}
