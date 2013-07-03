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
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.RuntimeFault;

/**
 * 查询主机Disk性能任务
 */
public class QueryHostDiskTask extends AbstractHostTask {

	private static final Log logger = LogFactory
			.getLog(QueryHostDiskTask.class);

	@Override
	public List<HostObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		List<HostObj> hostObjList = new ArrayList<HostObj>();
		try {
			// 构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> hosts = getMOREFsInContainerByType(
					connection.getServiceContent().getRootFolder(),
					VMWareBaseCommon.HOST_SYSTEM, new String[] {
							"hardware.systemInfo.uuid", "config.network",
							"datastore" }, connection);// 按照文件夹获取对应的数据
			for (ManagedObjectReference host : hosts.keySet()) {
				Map<String, Object> propertiesMap = hosts.get(host);
				HostObj hostObj = new HostObj(host);
				// buildHostNetworkInfo(hostObj
				// ,(HostNetworkInfo)propertiesMap.get("config.network"));
				hostObj.setUuid((String) propertiesMap
						.get("hardware.systemInfo.uuid"));
				ManagedObjectReference[] relatedDataStores = ((ArrayOfManagedObjectReference) propertiesMap
						.get("datastore")).getManagedObjectReference();
				buildHostDiskObj(hostObj, host, relatedDataStores);
				hostObjList.add(hostObj);
			}
			return hostObjList;
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态", e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常", e);
		} catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常", e);
		}
	}

	/**
	 * 构建磁盘性能信息
	 * 
	 * @param hostObj
	 * @param hostObjRef
	 * @param relatedDataStores
	 * @return
	 * @throws VMTaskException
	 */
	public HostObj buildHostDiskObj(HostObj hostObj,
			ManagedObjectReference hostObjRef,
			ManagedObjectReference[] relatedDataStores) throws VMTaskException {
		hostObj.setDiskNumber((short) relatedDataStores.length);
		float totalDiskSize = 0;
		float freeDiskSize = 0;
		for (int i = 0; i < relatedDataStores.length; i++) {
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(
					relatedDataStores[i], "Datastore", new String[] {
							"summary.capacity", "summary.freeSpace" });// 容量和Free容量
			ObjectContent[] oCont;
			try {
				oCont = connection.getService().retrieveProperties(
						connection.getPropCol(), pfSpecList);
				if (oCont != null) {
					for (ObjectContent oc : oCont) {
						DynamicProperty[] dps = oc.getPropSet();
						if (dps != null) {
							for (DynamicProperty dp : dps) {
								if ("summary.capacity".equals(dp.getName())) {
									totalDiskSize = totalDiskSize
											+ Long.parseLong(String.valueOf(dp
													.getVal())) / 1024 / 1024
											/ 1024;
								}
								if ("summary.freeSpace".equals(dp.getName())) {
									freeDiskSize = freeDiskSize
											+ Long.parseLong(String.valueOf(dp
													.getVal())) / 1024 / 1024
											/ 1024;
								}
							}
						}
					}
				}
				hostObj.setTotalDiskSize(totalDiskSize);
				hostObj.setFreeDiskSize(freeDiskSize);
				hostObj.setDiskUsage((totalDiskSize - freeDiskSize)
						/ totalDiskSize);// 磁盘使用率
			} catch (InvalidState e) {
				logger.error(e);
				throw new VMTaskException("异常的状态", e);
			} catch (RuntimeFault e) {
				logger.error(e);
				throw new VMTaskException("运行时异常", e);
			} catch (RemoteException e) {
				logger.error(e);
				throw new VMTaskException("远程调用异常", e);
			}
		}
		return hostObj;
	}
}
