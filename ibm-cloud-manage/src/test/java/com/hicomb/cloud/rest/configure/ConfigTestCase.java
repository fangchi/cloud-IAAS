package com.hicomb.cloud.rest.configure;

import com.hicomb.cloud.rest.common.CommonConst;

import junit.framework.TestCase;

public class ConfigTestCase extends TestCase {

	/**
	 * 测试配置
	 */
	public void testConfig(){
		//assertEquals("com.broda.cloud.rest.http.HttpSmartCloudEntryRestEngine", RestPorperties.getInstance().getConfigProperty("com.hicomb.rest.sce.defaultengine"));
		assertEquals("/cloud/api/appliances", CommonConst.SCE_QUERY_APPLIANCES_URL);
		assertEquals("/cloud/api/appliances/{id}/customization", CommonConst.SCE_QUERY_APPLIANCES_CUSTOMIZATION_URL);
		assertEquals("/cloud/api/networkConfigurations", CommonConst.SCE_NETWORKCONFIGURATIONS_URL);
		assertEquals("/ibm/director/rest/resources/SystemPool", CommonConst.SYSDIRECTOR_QUERY_SYSTEMPOOLS_URL);
		
	}

}
