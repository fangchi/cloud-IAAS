package com.hicomb.cloud.rest.engine.zsystem;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.ZsystemVirtualMachinePerf;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class ZSystemVMPerfTestCase extends ZSystemCloudTestCase {

	/**
	 * 测试Z虚拟机性能
	 * @throws CloudRestException
	 */
	public final void  testQueryZsystemVMPerf() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		List<ZsystemVirtualMachinePerf> zsystemVirtualMachinePerfs = smartCloudEntryRestEngine.queryZSystemVirtualMachinePerf(ip, port, userName, password);
		printZsystemVirtualMachinePerfs(zsystemVirtualMachinePerfs);
	}
}
