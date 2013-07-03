package com.hicomb.vm.vmware.task.host;

import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.host.perf.QueryHostMemoryTask;

/**
 * 主机内存性能测试用例 
 */
public class HostMemoryQueryTestCase  extends VMWareBaseTestCase{

	/**
	 * 查询主机内存
	 */
	public void testQueryHostMemory() {
		try {
			ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
			Task<List<HostObj>> task = new QueryHostMemoryTask();
			List<HostObj> hostObjList =  task.execute(connectionPool);
			for (Iterator<HostObj> iterator = hostObjList.iterator(); iterator.hasNext();) {
				HostObj hostObj = (HostObj) iterator.next();
				assertNotNull(hostObj);
				System.out.println("............................................");
				System.out.println("MemorySize = " + hostObj.getMemorySize());
				System.out.println("MemoryUsage = " + hostObj.getMemoryUsage() * 100 + "%");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
