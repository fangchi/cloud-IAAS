package com.hicomb.vm.vmware.task.cluster;

import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.cluster.basic.QueryClusterTask;

/**
 * 集群基本信息查询
 */
public class ClusterQueryTestCase extends VMWareBaseTestCase{

	/**
	 * 查询基本信息
	 * @throws VMTaskException
	 */
	public final void testQueryCluster() throws VMTaskException{
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
		QueryClusterTask queryClusterTask = new QueryClusterTask();
		List<ClusterObj> clusterObjs =  queryClusterTask.execute(connectionPool);
		for (Iterator<ClusterObj> iterator = clusterObjs.iterator(); iterator.hasNext();) {
			ClusterObj clusterObj = (ClusterObj) iterator.next();
			printCluster(clusterObj);
		}
	}
	
	/**
	 * 打印集群
	 * @param clusterObj
	 */
	protected void printCluster(ClusterObj clusterObj){
		System.out.println("======================================================");
		System.out.println("cluster id:"+clusterObj.getId());
		System.out.println("cluster NAME:"+clusterObj.getName());
		System.out.println("cluster NumHosts:"+clusterObj.getNumHosts());
		System.out.println("cluster NumEffectiveHosts:"+clusterObj.getNumEffectiveHosts());
		System.out.println("cluster TotalCpu:"+clusterObj.getTotalCpu());//单位：MHZ
		System.out.println("cluster EffectiveCpu:"+clusterObj.getEffectiveCpu());//单位：MHZ
//		System.out.println("cluster cpuUsage %:"+clusterObj.getCpuUsage());//cpu使用率
		System.out.println("cluster TotalNumCpuCores:"+clusterObj.getNumCpuCores());//cpu总数
		System.out.println("cluster TotalMemory:"+clusterObj.getTotalMemory());//单位：GB
		System.out.println("cluster EffectiveMemory:"+clusterObj.getEffectiveMemory());//单位：GB
//		System.out.println("cluster memoryUsage %:"+clusterObj.getMemoryUsage());//内存使用率
//		List<HostObj> hostObjs =  clusterObj.getHostObjs();
//		for (Iterator<HostObj> iterator = hostObjs.iterator(); iterator.hasNext();) {
//			HostObj hostObj = (HostObj) iterator.next();
//			System.out.println("Cluster "+clusterObj.getName() +"'s Hosts..................");
//			//printHostObj(hostObj);
//		}
	}
}
