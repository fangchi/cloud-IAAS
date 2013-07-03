package com.hicomb.cloud.rest.engine.zsystem;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.host.ZSystemHostPerf;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class ZSystemHostPerfTestCase extends ZSystemCloudTestCase {

	/**
	 * 测试Z体系主机性能
	 * @throws CloudRestException
	 */
	public final void  testQueryZsystemHostPerf() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		ZSystemHostPerf zSystemHostPerf = smartCloudEntryRestEngine.queryZSystemHostPerf(ip, port, userName, password, "172.16.31.228");
		printZsystemHostPerf(zSystemHostPerf);
	}
}
