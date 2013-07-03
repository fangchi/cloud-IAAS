package com.hicomb.vm.vmware.task.host.basic;

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
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询主机基本信息任务
 */
public class QueryHostTask extends AbstractHostTask {

	private static final Log logger = LogFactory.getLog(QueryHostTask.class);

	@Override
	public List<HostObj> doExecute(VMWareConnection connection) throws VMTaskException {
		List<HostObj> hostObjList = new ArrayList<HostObj>();
		try {
			//构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> hosts =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		 VMWareBaseCommon.HOST_SYSTEM,
	                     new String[] {"hardware.systemInfo.uuid","hardware.memorySize","hardware.cpuInfo.numCpuCores","summary.hardware.cpuMhz",
	   				"hardware.systemInfo.model",
					"hardware.systemInfo.vendor",
					"config.network","datastore"},connection);//根据文件夹获取对应属性
			for (ManagedObjectReference host : hosts.keySet()) {//针对结果做对应的处理
				Map<String, Object> propertiesMap = hosts.get(host);
				HostObj hostObj = new HostObj(host);
				hostObj.setvCenterName(host.toString());
				buildHostNetworkInfo(hostObj ,(HostNetworkInfo)propertiesMap.get("config.network"));
				hostObj.setUuid(String.valueOf(propertiesMap.get("hardware.systemInfo.uuid")));
				hostObj.setMemorySize((Long)propertiesMap.get("hardware.memorySize"));
				hostObj.setNumCpuCores((Short)propertiesMap.get("hardware.cpuInfo.numCpuCores"));
				hostObj.setCpuMhz(Float.valueOf(String.valueOf(propertiesMap.get("summary.hardware.cpuMhz"))));
				hostObj.setModel(String.valueOf(propertiesMap.get("hardware.systemInfo.model")));
				hostObj.setHardwareVendor(String.valueOf(propertiesMap.get("hardware.systemInfo.vendor")));
				ManagedObjectReference[] relatedDataStores = ((ArrayOfManagedObjectReference)propertiesMap.get("datastore")).getManagedObjectReference();
				buildHostDiskInfo(hostObj,host,relatedDataStores);//构建磁盘信息
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
	
	/**
	 * 构建对应主机的磁盘信息
	 * @param hostObj
	 * @param hostObjRef
	 * @param relatedDataStores
	 * @return
	 * @throws VMTaskException
	 */
	public HostObj buildHostDiskInfo(HostObj hostObj,ManagedObjectReference hostObjRef,ManagedObjectReference[] relatedDataStores) throws VMTaskException{
		hostObj.setDiskNumber((short)relatedDataStores.length);
		float totalDiskSize = 0;
		float freeDiskSize = 0;
		for (int i = 0; i < relatedDataStores.length; i++) {
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(
					relatedDataStores[i], "Datastore",
					new String[] { "summary.capacity","summary.freeSpace"});
			try {
				ObjectContent[] oCont = connection.getService().retrieveProperties(
						connection.getPropCol(), pfSpecList);
				oCont = (oCont != null ?oCont:new ObjectContent[0]);
				for (ObjectContent oc : oCont) {
					DynamicProperty[] dps = oc.getPropSet();
					dps = (dps!=null?dps:new DynamicProperty[0]);
					for (DynamicProperty dp : dps) {
						if("summary.capacity".equals(dp.getName())){
							totalDiskSize = totalDiskSize + Long.parseLong(String.valueOf(dp.getVal()))/ 1024 / 1024 / 1024;//获取所有的磁盘大小
						} else if ("summary.freeSpace".equals(dp.getName())){
							freeDiskSize = freeDiskSize + Long.parseLong(String.valueOf(dp.getVal()))/ 1024 / 1024 / 1024;//获取可用的磁盘大小
						} 
					}
				}
				hostObj.setTotalDiskSize(totalDiskSize);
				hostObj.setFreeDiskSize(freeDiskSize);
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
		return hostObj;
	}
}
