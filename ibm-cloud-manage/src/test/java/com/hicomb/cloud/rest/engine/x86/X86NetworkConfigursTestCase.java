package com.hicomb.cloud.rest.engine.x86;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.network.NetworkConfiguration;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class X86NetworkConfigursTestCase extends X86CloudTestCase{

	/**
	 * 测试查询X86网络配置
	 * @throws CloudRestException
	 */
	public final void testQueryNetworkConfiguration() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		List<NetworkConfiguration> networkConfigurations = smartCloudEntryRestEngine.queryNetworkConfigurations(ip, port, userName, password);
		printNetworkConfigurations(networkConfigurations);
	}
	
	
}
