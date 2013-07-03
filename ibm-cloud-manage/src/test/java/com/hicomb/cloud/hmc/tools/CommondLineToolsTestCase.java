package com.hicomb.cloud.hmc.tools;

import com.hicomb.cloud.hmc.base.BaseTestCase;

public class CommondLineToolsTestCase extends BaseTestCase {

	/**
	 * 测试命令行执行器
	 */
	public final void testCommond(){
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName, password, "lshwres -r io --rsubtype slotchildren -m SVRP7740-04-SN0681FAP -F phys_loc,description,mac_address,wwpn");
		System.out.println(responseStr);
		assertNotNull(responseStr);
	}
}
