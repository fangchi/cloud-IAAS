package com.hicomb.vm.vmware.task.vm;

import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.perf.QueryVirtualMachinesMemoryTask;

/**
 * 虚拟机内存测试用例 
 */
public class VMQueryMemoryInfoTaskTest extends VMWareBaseTestCase {
	
	/**
	 * 查询VM的MEMORY信息task
	 * @throws VMTaskException
	 */
	public void testQueryVMMemoryTaskTest() throws VMTaskException {
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
		Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesMemoryTask();
		List<VirtualMachineObj> res = task.execute(connectionPool);
		if(res.size() > 0 && res != null){
			for(int i = 0; i < res.size(); i++){
				System.out.println("======================================================================");
				//在开机状态下查询CPU、内存等才有值，否则值为0
				System.out.println("memoryUsage(MB) : " + res.get(i).getGuestMemoryUsage());//已使用内存量
				System.out.println("TotalMemory(MB) : " + res.get(i).getTotalMemory());//内存总量
				System.out.println("memoryUsePercent % : " + res.get(i).getMemoryUsePercent());//内存使用率
				System.out.println("VM IP :" + res.get(i).getGuestIpAddress());//VM IP
			}
		}
		assertEquals(true, res.size() > 0);
 	}

}
