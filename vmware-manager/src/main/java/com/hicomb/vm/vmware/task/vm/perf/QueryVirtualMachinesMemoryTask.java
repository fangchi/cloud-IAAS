package com.hicomb.vm.vmware.task.vm.perf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.VirtualMachinePowerState;

/**
 * 查找虚拟机内存任务
 */
public class QueryVirtualMachinesMemoryTask  extends AbstractTask<List<VirtualMachineObj>> {
	
	private static final Log logger = LogFactory.getLog(QueryVirtualMachinesMemoryTask.class);

	@Override
	public List<VirtualMachineObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		try {
			List<VirtualMachineObj> virtualMachineObjs = new ArrayList<VirtualMachineObj>();
			//构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> virtualMachines =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.VIRTUAL_MACHINE,
	                     new String[] {"config.uuid","guest.ipAddress","runtime.powerState","summary.config.memorySizeMB",
						"summary.quickStats.guestMemoryUsage"},connection);//按照文件夹检索属性
			for(ManagedObjectReference obj:virtualMachines.keySet()){
				VirtualMachineObj virtualMachineObj  = new VirtualMachineObj(obj);
				virtualMachineObj.setObjId((String) virtualMachines.get(obj).get("config.uuid"));
				virtualMachineObj.setGuestIpAddress((String) virtualMachines.get(obj).get("guest.ipAddress"));
				virtualMachineObj.setVirtualMachinePowerState((VirtualMachinePowerState)virtualMachines.get(obj).get("runtime.powerState"));
				virtualMachineObj.setTotalMemory((Integer) virtualMachines.get(obj).get("summary.config.memorySizeMB"));
				virtualMachineObj.setVMOguestMemoryUsage((Integer) virtualMachines.get(obj).get("summary.quickStats.guestMemoryUsage"));
				virtualMachineObjs.add(virtualMachineObj);
			}
			return virtualMachineObjs;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new VMTaskException(e.getMessage(), e);
		}
	}
}
