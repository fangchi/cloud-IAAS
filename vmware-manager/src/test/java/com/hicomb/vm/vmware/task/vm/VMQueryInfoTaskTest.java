package com.hicomb.vm.vmware.task.vm;

import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.basic.QueryVirtualMachinesTask;

/**
 * 虚拟机基本信息测试用例
 */
public class VMQueryInfoTaskTest extends VMWareBaseTestCase {
	
	/**
	 * 查询VM信息task
	 * @throws VMTaskException
	 */
	public void testQueryVMTaskTest() throws VMTaskException {
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
		Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesTask();
		List<VirtualMachineObj> res = task.execute(connectionPool);
		if(res.size() > 0 && res != null){
			for(int i = 0; i < res.size(); i++){
				System.out.println("======================================================================");
				System.out.println("name : " + res.get(i).getVmName());
				System.out.println("uuid : " + res.get(i).getObjId());
				System.out.println("powerState : " + res.get(i).getVirtualMachinePowerState());//电源状态
				System.out.println("version : " + res.get(i).getVersion()); //虚拟机版本
				System.out.println("os : " + res.get(i).getGuestOSFullName());//操作系统
				System.out.println("ip : " + res.get(i).getGuestIpAddress());//ip地址
				System.out.println("hostIp : " + res.get(i).getHostIp());
				System.out.println("TotalMemory(MB) : " + res.get(i).getTotalMemory());//内存总量
				System.out.println("TotalCpuCoreNum : " + res.get(i).getNumCpu());//CPU核心数
				System.out.println("diskNum : " + res.get(i).getDiskNum());//磁盘个数
				System.out.println("storage(GB) : " + res.get(i).getTotalStorage());
			}
		}
		assertEquals(true, res.size() > 0);
 	}
}
