package com.hicomb.vm.vmware.task.cluster.perf;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.hicomb.vm.vmware.task.cluster.ClusterObj;
import com.hicomb.vm.vmware.util.VMWareUtils;
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询集群性能信息任务
 */
public class QueryClusterPerfTask  extends AbstractTask<List<ClusterObj>>{

private static final Log logger = LogFactory.getLog(QueryClusterPerfTask.class);

	public static final String HOST_CPU_USE = "host.cpu.use";
	public static final String HOST_MEMORY_USE = "host.memory.use";
	
	
	@Override
	protected List<ClusterObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		try {
			int usedCpuCoresNum = 0;
			List<ClusterObj> clusterObjs = new ArrayList<ClusterObj>();
			Map<ManagedObjectReference, Map<String, Object>> clusters =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.CLUSTER_COMPUTE_RESOURCE,
	                     new String[] {"name", "summary.totalCpu", "summary.totalMemory", "summary.numCpuCores", "host", "resourcePool"},connection);//遍历字典查询任务
			for (ManagedObjectReference clusterPerf : clusters.keySet()) {
				ClusterObj clusterObj = new ClusterObj(clusterPerf);
				clusterObj.setName((String)clusters.get(clusterPerf).get("name"));
				clusterObj.setTotalCpu((Integer)clusters.get(clusterPerf).get("summary.totalCpu"));//CPU主频
				clusterObj.setTotalMemory((Long)clusters.get(clusterPerf).get("summary.totalMemory"));//cpu内存
				clusterObj.setNumCpuCores((Short)clusters.get(clusterPerf).get("summary.numCpuCores"));//cpu核心
				long usedCpu = 0;
				long usedMemory = 0;
				ManagedObjectReference[] hosts = ((ArrayOfManagedObjectReference)clusters.get(clusterPerf).get("host")).getManagedObjectReference();
				if(hosts != null){//查询对应的主机
					for(ManagedObjectReference host : hosts){
						usedCpuCoresNum += VMWareUtils.getEveryHostNumCpuCore(host, connection);
						usedCpu += VMWareUtils.getHostPerfUse(host, connection).get(HOST_CPU_USE);
						usedMemory += VMWareUtils.getHostPerfUse(host, connection).get(HOST_MEMORY_USE);
					}
				}
				clusterObj.setUsedNumCpuCores(usedCpuCoresNum);//cluster已使用的CPU核心总数 （根据主机求得）
				buildResourcePool((ManagedObjectReference)clusters.get(clusterPerf).get("resourcePool"), clusterObj, usedCpu, usedMemory);//构建实时数据
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

	/**
	 * 构建资源池的数据
	 * @param resourcePoolReference
	 * @param clusterObj
	 * @param usedCpu
	 * @param usedMemory
	 * @return
	 * @throws VMTaskException
	 */
	private ClusterObj buildResourcePool(ManagedObjectReference resourcePoolReference, ClusterObj clusterObj, long usedCpu, long usedMemory) throws VMTaskException{
		try {
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(resourcePoolReference,
					 VMWareBaseCommon.RESOURCEPOOL, new String[] { "runtime.cpu.overallUsage", "runtime.memory.overallUsage"});//遍历查询CPU内存实时数据
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			oCont = (oCont != null?oCont:new ObjectContent[0]);
			for (ObjectContent oc : oCont) {
				DynamicProperty[] dps = oc.getPropSet();
				dps = (dps != null? dps:new DynamicProperty[0]);
				for (DynamicProperty dp : dps) {
					if ("runtime.cpu.overallUsage".equals(dp.getName())) {
						usedCpu += (Long) dp.getVal();
					}
					if ("runtime.memory.overallUsage".equals(dp.getName())) {
						usedMemory += ((Long) dp.getVal())/(1024*1024);//将获取到的内存使用量的单位转了MB
					}
				}
			}
			clusterObj.setUsedCpu(usedCpu);
			clusterObj.setUsedMemory(usedMemory);
			return clusterObj;
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态",e);
		} catch (RuntimeFault e) {
			logger.error(e);  
			throw new VMTaskException("运行时异常",e);
		} catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常",e);
		} 
	}
}
