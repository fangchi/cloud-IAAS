package com.hicomb.vm.vmware.task.host;

import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.host.perf.QueryHostDiskTask;

/**
 * 主机磁盘性能测试用例
 */
public class HostDiskQueryTestCase extends VMWareBaseTestCase{

	/**
	 * 主机磁盘性能
	 */
	public void testQueryHostDisk() {
		try {
			ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
			Task<List<HostObj>> task = new QueryHostDiskTask();
			List<HostObj> hostObjList =  task.execute(connectionPool);
			for (Iterator<HostObj> iterator = hostObjList.iterator(); iterator.hasNext();) {
				HostObj hostObj = (HostObj) iterator.next();
				assertNotNull(hostObj);
				System.out.println("............................................");
				System.out.println("DiskSize = " + hostObj.getTotalDiskSize());
				System.out.println("FreeDiskSize = " + hostObj.getFreeDiskSize());
				System.out.println("DiskType = " + hostObj.getDiskType());
				System.out.println("DiskUsage = " + hostObj.getDiskUsage() * 100 + "%");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
