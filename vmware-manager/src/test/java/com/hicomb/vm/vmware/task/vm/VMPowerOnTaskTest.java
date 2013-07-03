package com.hicomb.vm.vmware.task.vm;

import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.basic.QueryVirtualMachinesTask;
import com.hicomb.vm.vmware.task.vm.power.PowerOptVirtualMachineTask;
import com.hicomb.vm.vmware.task.vm.power.PowerOpts;

public class VMPowerOnTaskTest  extends VMWareBaseTestCase {

	ConnectionPool  connectionPool ;
	
	@Override
	public void setUp(){
		connectionPool = ConnectionPoolMgr.getConnectionPool("172.16.13.141", "root", "12345678");
	}
	
	/**Power on	 
	 * @throws VMTaskException
	 */
	public void testPowerOnVMTaskTest() {
		try {
			Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesTask();
			List<VirtualMachineObj> res = task.execute(connectionPool);
			Task<Integer> task2 = new PowerOptVirtualMachineTask(res.get(0).getManagedObjectReference(),PowerOpts.POWERON);
			int resault = task2.execute(connectionPool);
			assertEquals(VMWareBaseCommon.TASK_EXE_SUCCESS,resault);
		} catch (Exception e) {
			assertTrue(false);
		}
 	}
	
}
