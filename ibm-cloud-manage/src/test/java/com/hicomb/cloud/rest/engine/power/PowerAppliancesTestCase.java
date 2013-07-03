package com.hicomb.cloud.rest.engine.power;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class PowerAppliancesTestCase extends PowerCloudTestCase{

	/**
	 * 测试查询镜像
	 * @throws CloudRestException
	 */
	public final void testQueryAppliance() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		List<Appliance> appliances = smartCloudEntryRestEngine.queryAppliances(ip, port, userName, password);
		assertNotNull(appliances);
		printAppliances(appliances);
	}
	
}
