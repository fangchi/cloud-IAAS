package com.hicomb.vm.vmware.task.vm;

import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.perf.QueryVirtualMachinesDiskTask;

/**
 * 虚拟机磁盘测试用例
 */
public class VMQueryDiskInfoTaskTest  extends VMWareBaseTestCase {
	
	
	/**
	 * 查询VM的DISK信息task
	 * @throws VMTaskException
	 */
	public void testQueryVMDiskTaskTest() throws VMTaskException {
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
		Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesDiskTask();
		List<VirtualMachineObj> res = task.execute(connectionPool);
		if(res.size() > 0 && res != null){
			for(int i = 0; i < res.size(); i++){
				System.out.println("======================================================================");
				System.out.println("freeStorage(GB) : " + res.get(i).getFreeStorage());//空闲磁盘容量
				System.out.println("totalStorage(GB) : " + res.get(i).getTotalStorage());//总的磁盘容量
				System.out.println("diskNum : " + res.get(i).getDiskNum());//磁盘个数
				System.out.println("VM IP :" + res.get(i).getGuestIpAddress());//VM IP
			}
		}
		assertEquals(true, res.size() > 0);
 	}

}
