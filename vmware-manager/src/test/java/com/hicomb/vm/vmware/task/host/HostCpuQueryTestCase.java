package com.hicomb.vm.vmware.task.host;

import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.host.perf.QueryHostCpuTask;

/**
 * 主机CPU测试用例
 */
public class HostCpuQueryTestCase extends VMWareBaseTestCase{

	/**
	 * 查询主机CPU性能
	 */
	public void testQueryHostCpu() {
		try {
			ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
			Task<List<HostObj>> task = new QueryHostCpuTask();
			List<HostObj> hostObjList =  task.execute(connectionPool);
			for (Iterator<HostObj> iterator = hostObjList.iterator(); iterator.hasNext();) {
				HostObj hostObj = (HostObj) iterator.next();
				assertNotNull(hostObj);
				System.out.println("............................................");
				System.out.println("CpuMhz(MHZ) = " + hostObj.getCpuMhz());
				System.out.println("CpuUsage = " + hostObj.getOverallCpuUsage() * 100 + "%");
				System.out.println("cpuCoreTotalNum = " + hostObj.getNumCpuCores());
//				for(HostCpuPackage hostCpuPackage : hostObj.getHostCpuPackage()) { //CPU描述
//					System.out.println("description:" + hostCpuPackage.getDescription());
//				}
				System.out.println("host IpAddress:"+hostObj.getIpAddress());
				System.out.println("host MAC:"+hostObj.getMacAddress());
			} 
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
