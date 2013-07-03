package com.hicomb.vm.vmware.base;

import junit.framework.TestCase;

/**
 * 测试基础类
 */
public class VMWareBaseTestCase extends TestCase{
    
	/*VcenterIP*/
	protected String hostIp;
	
	/*Vcenter用户名*/
	protected String hostUserName;
	
	/*Vcenter密码*/
	protected String hostPasword;

	@Override
	public void setUp(){
		hostIp = "192.168.2.115";
		hostUserName = "root";
		hostPasword ="broada123";
	}
	
	@Override
	public void tearDown(){
		
	}
}
