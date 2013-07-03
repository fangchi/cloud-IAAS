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
import com.vmware.vim25.ArrayOfGuestDiskInfo;
import com.vmware.vim25.ManagedObjectReference;

/**
 * 查找虚拟机磁盘信息任务
 */
public class QueryVirtualMachinesDiskTask extends AbstractTask<List<VirtualMachineObj>> {
	
	private static final Log logger = LogFactory.getLog(QueryVirtualMachinesDiskTask.class);

	@Override
	public List<VirtualMachineObj> doExecute(VMWareConnection connection)
			throws VMTaskException {
		try {
			List<VirtualMachineObj> virtualMachineObjs = new ArrayList<VirtualMachineObj>();
			//构建所有的Host
			Map<ManagedObjectReference, Map<String, Object>> virtualMachines =
	               getMOREFsInContainerByType(connection.getServiceContent().getRootFolder(),
	            		   VMWareBaseCommon.VIRTUAL_MACHINE,
	                     new String[] {"config.uuid","guest.ipAddress","summary.config.numVirtualDisks",
						"guest.disk","storage"},connection);//按照文件夹检索属性
			for(ManagedObjectReference obj:virtualMachines.keySet()){
				VirtualMachineObj virtualMachineObj  = new VirtualMachineObj(obj);
				virtualMachineObj.setObjId((String) virtualMachines.get(obj).get("config.uuid"));
				virtualMachineObj.setGuestIpAddress((String) virtualMachines.get(obj).get("guest.ipAddress"));
				virtualMachineObj.setDiskNum((Integer) virtualMachines.get(obj).get("summary.config.numVirtualDisks"));
				virtualMachineObj.setGuestDiskInfos(((ArrayOfGuestDiskInfo) virtualMachines.get(obj).get("guest.disk")).getGuestDiskInfo());
//				virtualMachineObj.setVirtualMachineStorageInfo((VirtualMachineStorageInfo)virtualMachines.get(obj).get("summary.storage."));
				virtualMachineObjs.add(virtualMachineObj);
			}
			return virtualMachineObjs;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new VMTaskException(e.getMessage(), e);
		}
	}
}
