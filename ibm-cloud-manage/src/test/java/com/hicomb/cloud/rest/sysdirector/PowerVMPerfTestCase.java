package com.hicomb.cloud.rest.sysdirector;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.vm.PowerVirtualMachinePerf;
import com.hicomb.cloud.rest.sysdirector.https.HttpsSystemDirectorRestEngine;

public class PowerVMPerfTestCase  extends SysDirectorBaseTestCase {

	/**
	 * 测试Power虚拟机
	 * @throws CloudRestException
	 */
	public final void testQueryPowerVirtualMachinePerf() throws CloudRestException {
		SystemDirectorRestEngine systemDirectorRestEngine = new HttpsSystemDirectorRestEngine();
		PowerVirtualMachinePerf powerVirtualMachinePerf = systemDirectorRestEngine.queryPowerVirtualMachinePerf(hostIp, port, userName, password,"18855");
	}
}
