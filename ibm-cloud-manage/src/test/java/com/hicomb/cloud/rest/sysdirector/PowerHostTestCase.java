package com.hicomb.cloud.rest.sysdirector;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.host.PowerHost;
import com.hicomb.cloud.rest.sysdirector.https.HttpsSystemDirectorRestEngine;

public class PowerHostTestCase extends SysDirectorBaseTestCase {

	/**
	 * 测试Power主机
	 * @throws CloudRestException
	 */
	public final void testQueryHosts() throws CloudRestException {
		SystemDirectorRestEngine systemDirectorRestEngine = new HttpsSystemDirectorRestEngine();
		List<PowerHost> list = systemDirectorRestEngine.queryHosts(hostIp, port, userName, password);
		assertTrue(list.size()>0);
		printHosts(list);
	}
}
