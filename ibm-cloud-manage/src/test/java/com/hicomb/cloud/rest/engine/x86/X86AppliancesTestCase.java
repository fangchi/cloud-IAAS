package com.hicomb.cloud.rest.engine.x86;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class X86AppliancesTestCase extends X86CloudTestCase{

	/**
	 * 测试查询X86镜像
	 * @throws CloudRestException
	 */
	public final void testQueryAppliance() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		List<Appliance> appliances = smartCloudEntryRestEngine.queryAppliances(ip, port, userName, password);
		assertNotNull(appliances);
		printAppliances(appliances);
	}
	
	
}
