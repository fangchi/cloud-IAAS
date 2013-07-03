package com.hicomb.cloud.rest.sysdirector;

import java.util.List;


import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPool;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPoolPerf;
import com.hicomb.cloud.rest.sysdirector.https.HttpsSystemDirectorRestEngine;

public class SystemPoolTestCase extends SysDirectorBaseTestCase {

	/**
	 * 测试系统池基本信息
	 * @throws CloudRestException
	 */
	public final void testQuerySystemPool() throws CloudRestException {
		SystemDirectorRestEngine systemDirectorRestEngine = new HttpsSystemDirectorRestEngine();
		List<SystemPool> list = systemDirectorRestEngine.querySystemPool(hostIp, port, userName, password);
		assertTrue(list.size()>0);
		printSystemPools(list);
	}

	/**
	 * 测试查询系统池性能
	 * @throws CloudRestException
	 */
	public final void testQuerySystemPoolPerf() throws CloudRestException {
		SystemDirectorRestEngine systemDirectorRestEngine = new HttpsSystemDirectorRestEngine();
		List<SystemPool> list = systemDirectorRestEngine.querySystemPool(hostIp, port, userName, password);
		SystemPoolPerf systemPoolPerf = systemDirectorRestEngine.querySystemPoolPerf(hostIp, port, userName, password,list.get(0).getOID());
		assertNotNull(systemPoolPerf);
		printSystemPoolPerf(systemPoolPerf);
	}
}
