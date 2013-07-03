package com.hicomb.vm.vmware.task.vm.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.vm.AbstractVirtualMachineTask;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.vmware.vim25.ArrayOfGuestDiskInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.VirtualMachineStorageInfo;

/**
 * 查询虚拟机基本信息任务
 */
public class QueryVirtualMachinesTask extends AbstractVirtualMachineTask {

	private static final Log logger = LogFactory
			.getLog(QueryVirtualMachinesTask.class);

	@Override
	public List<VirtualMachineObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		try {
			List<VirtualMachineObj> virtualMachineObjs = new ArrayList<VirtualMachineObj>();
			// 构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> virtualMachines = getMOREFsInContainerByType(
					connection.getServiceContent().getRootFolder(),
					VMWareBaseCommon.VIRTUAL_MACHINE, new String[] {
							"runtime.host","config.name", "config.uuid", "config.version",
							"summary.config.numCpu",
							"summary.config.memorySizeMB",
							"summary.config.numVirtualDisks",
							"storage",
							"guest.guestFullName", "guest.ipAddress","guest.disk"},//注：这里Guest数据需要在虚拟机中安装VMwaretools工具才能获取数据
					connection);//根据字典获取对应数据
			for (ManagedObjectReference obj : virtualMachines.keySet()) {//设置对应的属性
				VirtualMachineObj virtualMachineObj  = new VirtualMachineObj(obj);
				if((ManagedObjectReference)virtualMachines.get(obj).get("runtime.host") == null){
					List<String> content = new ArrayList<String>();
					content.add(obj.toString());
					continue;
				} else {
					buildVirtualMachineHostPro(virtualMachineObj,(ManagedObjectReference)virtualMachines.get(obj).get("runtime.host"));
					virtualMachineObj.setVmName((String)virtualMachines.get(obj).get("config.name"));
					virtualMachineObj.setObjId((String)virtualMachines.get(obj).get("config.uuid"));
					virtualMachineObj.setVersion((String)virtualMachines.get(obj).get("config.version"));
					virtualMachineObj.setNumCpu((Integer)virtualMachines.get(obj).get("summary.config.numCpu"));
					virtualMachineObj.setDiskNum((Integer)virtualMachines.get(obj).get("summary.config.numVirtualDisks"));
					virtualMachineObj.setTotalMemory(Integer.parseInt(String.valueOf(virtualMachines.get(obj).get("summary.config.memorySizeMB"))));
					virtualMachineObj.setVirtualMachineStorageInfo((VirtualMachineStorageInfo)virtualMachines.get(obj).get("storage"));
					virtualMachineObj.setGuestOSFullName((String)virtualMachines.get(obj).get("guest.guestFullName"));
					virtualMachineObj.setGuestIpAddress((String)virtualMachines.get(obj).get("guest.ipAddress"));
					virtualMachineObj.setGuestDiskInfos(((ArrayOfGuestDiskInfo)virtualMachines.get(obj).get("guest.disk")).getGuestDiskInfo());
					virtualMachineObjs.add(virtualMachineObj);
				}
			}
			return virtualMachineObjs;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new VMTaskException(e.getMessage(), e);
		}
	}
}
