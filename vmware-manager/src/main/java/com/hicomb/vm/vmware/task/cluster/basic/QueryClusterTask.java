package com.hicomb.vm.vmware.task.cluster.basic;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.hicomb.vm.vmware.task.cluster.ClusterObj;
import com.hicomb.vm.vmware.task.host.HostObj;
import com.hicomb.vm.vmware.util.VMWareUtils;
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询集群基本信息任务
 */
public class QueryClusterTask extends AbstractTask<List<ClusterObj>>{

	private static final Log logger = LogFactory.getLog(QueryClusterTask.class);
	
	@Override
	protected List<ClusterObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		try {
			List<ClusterObj> clusterObjs = new ArrayList<ClusterObj>();
			//构建所有的Cluster
			Map<ManagedObjectReference, Map<String, Object>> clusters =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.CLUSTER_COMPUTE_RESOURCE,
	                     new String[] {"name","summary.effectiveCpu","summary.effectiveMemory",
	            	   "summary.numCpuCores","summary.numEffectiveHosts",
	            	   "summary.numHosts","summary.totalCpu","summary.totalMemory","host","resourcePool"},connection);//根据文件夹获取属性
			for (ManagedObjectReference clusterRef : clusters.keySet()) {//遍历符合的变量
				ClusterObj clusterObj = new ClusterObj(clusterRef);
				clusterObj.setId(clusterRef.toString());
				clusterObj.setName((String)clusters.get(clusterRef).get("name"));
				clusterObj.setvCenterName(clusterRef.toString());
				clusterObj.setEffectiveCpu((Integer)clusters.get(clusterRef).get("summary.effectiveCpu"));
				clusterObj.setEffectiveMemory((Long)clusters.get(clusterRef).get("summary.effectiveMemory"));
				clusterObj.setNumCpuCores((Short)clusters.get(clusterRef).get("summary.numCpuCores"));
				clusterObj.setNumEffectiveHosts((Integer)clusters.get(clusterRef).get("summary.numEffectiveHosts"));
				clusterObj.setNumHosts((Integer)clusters.get(clusterRef).get("summary.numHosts"));
				clusterObj.setTotalCpu((Integer)clusters.get(clusterRef).get("summary.totalCpu"));
				clusterObj.setTotalMemory((Long)clusters.get(clusterRef).get("summary.totalMemory"));
				ManagedObjectReference[]  hosts = ((ArrayOfManagedObjectReference)clusters.get(clusterRef).get("host")).getManagedObjectReference();
				hosts = hosts==null? new ManagedObjectReference[]{}:hosts;
				Map<String, HostObj> hostsMap = new HashMap<String, HostObj>();
				for (int i = 0; i < hosts.length; i++) {
					HostObj  hostObj = VMWareUtils.buildHostId(hosts[i], connection);
					hostsMap.put(hostObj.getUuid(),hostObj);
				}
				String[] hostskey = hostsMap.keySet().toArray(new String[0]);
				Arrays.sort(hostskey);
				for(String key:hostskey){
					clusterObj.addHostObj(hostsMap.get(key));
				}
				clusterObjs.add(clusterObj);
			}
			return clusterObjs;
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态",e);
		} catch (RuntimeFault e) {
			logger.error(e);  
			throw new VMTaskException("运行时异常",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常",e);
		} 
	}
}
