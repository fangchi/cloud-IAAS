package com.hicomb.vm.vmware.task.vm;

import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.perf.QueryVirtualMachinesCpuTask;

/**
 * 虚拟机CPU性能测试用例
 */
public class VMQueryCpuInfoTaskTest extends VMWareBaseTestCase {
	
	/**
	 * 查询VM的CPU信息task
	 * @throws VMTaskException
	 */
	public void testQueryVMCpuTaskTest() throws VMTaskException {
		ConnectionPool connectionPool = ConnectionPoolMgr.getConnectionPool(
				hostIp, hostUserName, hostPasword);
		Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesCpuTask();
		List<VirtualMachineObj> res = task.execute(connectionPool);
		if (res.size() > 0 && res != null) {
			for (int i = 0; i < res.size(); i++) {
				System.out
						.println("======================================================================");
				// 在开机状态下查询CPU、内存等才有值，否则值为0
				System.out.println("power state:"
						+ res.get(i).getVirtualMachinePowerState().getValue());
				System.out.println("cpuUsage(Mhz) : "
						+ res.get(i).getOverallCpuUsage());// 已使用CPU
				System.out.println("cpuCapacity(Mhz) : "
						+ res.get(i).getCpuCapacity());// CPU频率
				System.out.println("TotalCpuCoreNum : "
						+ res.get(i).getNumCpu());// CPU核心数
				System.out.println("cpuUsePercent % : "
						+ res.get(i).getCpuPercent());// CPU使用率
				System.out.println("VM IP :" + res.get(i).getGuestIpAddress());// VM
																				// IP
			}
		}
		assertEquals(true, res.size() > 0);
	}
}
