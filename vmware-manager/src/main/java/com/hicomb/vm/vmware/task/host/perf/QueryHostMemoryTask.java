package com.hicomb.vm.vmware.task.host.perf;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.host.AbstractHostTask;
import com.hicomb.vm.vmware.task.host.HostObj;
import com.hicomb.vm.vmware.task.host.basic.QueryHostTask;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询主机内存性能任务
 */
public class QueryHostMemoryTask  extends AbstractHostTask {

	private static final Log logger = LogFactory.getLog(QueryHostTask.class);

	public static final String PROPERTY_OVERALL_MEMORY_USAGE = "summary.quickStats.overallMemoryUsage";

	@Override
	public List<HostObj> doExecute(VMWareConnection connection) throws VMTaskException {
		List<HostObj> hostObjList = new ArrayList<HostObj>();
		try {
			//构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> hosts =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.HOST_SYSTEM,
	                     new String[] {"hardware.systemInfo.uuid","config.network","hardware.memorySize",PROPERTY_OVERALL_MEMORY_USAGE},connection);//按照文件夹获取对应的数据
			for (ManagedObjectReference host : hosts.keySet()) {
				Map<String, Object> propertiesMap = hosts.get(host);
				HostObj hostObj = new HostObj(host);
				//buildHostNetworkInfo(hostObj ,(HostNetworkInfo)propertiesMap.get("config.network"));
				hostObj.setUuid((String)propertiesMap.get("hardware.systemInfo.uuid"));
				hostObj.setMemorySize(Long.valueOf(String.valueOf(propertiesMap.get("hardware.memorySize"))));
				hostObj.setMemoryUsage((float) ((Integer)propertiesMap.get(PROPERTY_OVERALL_MEMORY_USAGE)/(hostObj.getMemorySize()*1024)));
				hostObjList.add(hostObj);
			}
			return hostObjList;
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
