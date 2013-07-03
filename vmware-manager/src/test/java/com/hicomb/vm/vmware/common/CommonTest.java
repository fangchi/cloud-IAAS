package com.hicomb.vm.vmware.common;

import junit.framework.TestCase;

/**
 * 常量测试
 */
public class CommonTest extends TestCase {

	public void testConfigure() {
		assertEquals(5, VMWareBaseCommon.VMWARE_CONN_MAXSIZE);

		/**assertEquals(
				"NotEnoughResourcesToStartVmEvent,VmConfigMissingEvent,VmDasUpdateErrorEvent,VmDeployFailedEvent,VmDiskFailedEvent,VmFailedToPowerOffEvent,VmFailedToPowerOnEvent,VmFailedToRebootGuestEvent,VmFailedToResetEvent,VmFailedToShutdownGuestEvent,VmFailedToStandbyGuestEvent,VmFailedToSuspendEvent,VmUpgradeFailedEvent",
				VMWareBaseCommon.VMWARE_EVENT_MONITOR_TYPES);**/
	}
}
