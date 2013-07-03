package com.hicomb.vm.vmware.task.cluster;

import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.cluster.perf.QueryClusterPerfTask;

/**
 * 集群性能测试类
 */
public class ClusterQueryPerfTestCase  extends VMWareBaseTestCase {

	/**
	 * 查询集群
	 */
	public final void testQueryCluster() throws VMTaskException{
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
		QueryClusterPerfTask QueryClusterPerfTask = new QueryClusterPerfTask();
		List<ClusterObj> clusterObjs =  QueryClusterPerfTask.execute(connectionPool);
		for (Iterator<ClusterObj> iterator = clusterObjs.iterator(); iterator.hasNext();) {
			ClusterObj clusterObj = (ClusterObj) iterator.next();
			printCluster(clusterObj);
		}
	}
	
	/**
	 * 打印性能信息
	 * @param clusterObj
	 */
	protected void printCluster(ClusterObj clusterObj){
		System.out.println("======================================================");
		System.out.println("cluster NAME:"+clusterObj.getName());
		System.out.println("cluster TotalCpu:"+clusterObj.getTotalCpu() + " GHZ");//单位：GHZ
		System.out.println("cluster usedCpu:"+clusterObj.getUsedCpu() + " GHZ");//单位：GHZ
		System.out.println("cluster cpuUsage %:"+clusterObj.getCpuHZUsage());//CPU核心使用率
		System.out.println("cluster numCpuCores:"+clusterObj.getNumCpuCores());//CPU核心数
		System.out.println("cluster usedCpuCores:"+clusterObj.getUsedNumCpuCores());//已使用CPU核心数
//		System.out.println("cluster effectiveNumCpuCores:"+clusterObj.getNumEffectiveCpuCores());//可用的CPU核心数
//		System.out.println("cluster cpuUsage %:"+clusterObj.getCpuCoreUsage());//CPU核心使用率
		System.out.println("cluster TotalMemory:"+clusterObj.getTotalMemory() + " GB");//单位：GB
		System.out.println("cluster useMemory:"+clusterObj.getUsedMemory() + " GB");//单位：GB
		System.out.println("cluster memoryUsage %:"+clusterObj.getMemoryUsage());//内存使用率
//		List<HostObj> hostObjs =  clusterObj.getHostObjs();
//		for (Iterator<HostObj> iterator = hostObjs.iterator(); iterator.hasNext();) {
//			HostObj hostObj = (HostObj) iterator.next();
//			System.out.println("Cluster "+clusterObj.getName() +"'s Hosts..................");
//			//printHostObj(hostObj);
//		}
	}
}
