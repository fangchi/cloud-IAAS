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
import com.vmware.vim25.ArrayOfHostCpuPackage;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询主机CPU性能任务
 */
public class QueryHostCpuTask extends AbstractHostTask {
	
	private static final Log logger = LogFactory.getLog(QueryHostCpuTask.class);

	public static final String PROPERTY_CPU_CORE_HZ = "summary.hardware.cpuMhz";
	public static final String PROPERTY_OVERALL_CPU_USAGE = "summary.quickStats.overallCpuUsage";

	@Override
	public List<HostObj> doExecute(VMWareConnection connection) throws VMTaskException {
		List<HostObj> hostObjList = new ArrayList<HostObj>();
		try {
			//构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> hosts =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.HOST_SYSTEM ,new String[] {"hardware.systemInfo.uuid","hardware.cpuInfo.numCpuCores","hardware.cpuPkg",
						"config.network",PROPERTY_CPU_CORE_HZ,PROPERTY_OVERALL_CPU_USAGE },connection);//按照文件夹获取对应的数据
			for (ManagedObjectReference host : hosts.keySet()) {//设置对应属性
				Map<String, Object> propertiesMap = hosts.get(host);
				HostObj hostObj = new HostObj(host);
				buildHostNetworkInfo(hostObj ,(HostNetworkInfo)propertiesMap.get("config.network"));
				hostObj.setUuid((String)propertiesMap.get("hardware.systemInfo.uuid"));
				hostObj.setHostCpuPackage(((ArrayOfHostCpuPackage)propertiesMap.get("hardware.cpuPkg")).getHostCpuPackage());
				hostObj.setNumCpuCores((Short)propertiesMap.get("hardware.cpuInfo.numCpuCores"));
				hostObj.setCpuMhz(Float.valueOf(String.valueOf(propertiesMap.get(PROPERTY_CPU_CORE_HZ))));
				hostObj.setOverallCpuUsage(Float.valueOf(String.valueOf(propertiesMap.get(PROPERTY_OVERALL_CPU_USAGE)))/(hostObj.getCpuMhz() * hostObj.getNumCpuCores()));
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
