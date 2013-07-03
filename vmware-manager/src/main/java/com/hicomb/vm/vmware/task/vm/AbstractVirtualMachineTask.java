package com.hicomb.vm.vmware.task.vm;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.HostVirtualNic;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.PhysicalNic;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.RuntimeFault;

public abstract class AbstractVirtualMachineTask extends
	AbstractTask<List<VirtualMachineObj>>{

	private static final Log logger = LogFactory
	.getLog(AbstractVirtualMachineTask.class);
	
	public void buildVirtualMachineHostPro(VirtualMachineObj virtualMachineObj,ManagedObjectReference hostReference) throws VMTaskException{
		PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(hostReference,
				VMWareBaseCommon.HOST_SYSTEM, new String[] { "config.network" });
		ObjectContent[] oCont;
		try {
			oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			if (oCont != null) {
				for (ObjectContent oc : oCont) {
					DynamicProperty[] dps = oc.getPropSet();
					if (dps != null) {
						for (DynamicProperty dp : dps) {
							if ("config.network".equals(dp.getName())) {
								HostNetworkInfo hostNetworkInfo = (HostNetworkInfo) dp.getVal();
								String hostIp = "";
								ArrayList<String> hostIps = new ArrayList<String>();
								for(PhysicalNic pnic :hostNetworkInfo.getPnic()){
									if(pnic.getSpec().getIp().getIpAddress().length() > 0){
										hostIps.add(pnic.getSpec().getIp().getIpAddress());
									}
								}
								for( HostVirtualNic  vnic: hostNetworkInfo.getVnic()){
									if(vnic.getSpec().getIp().getIpAddress().length() > 0){
										hostIps.add(vnic.getSpec().getIp().getIpAddress());
									}
								}
								String[] hostIpsArr = hostIps.toArray(new String[0]);
								Arrays.sort(hostIpsArr);
								if(hostIpsArr.length>0){
									for (int i = 0; i < hostIpsArr.length; i++) {
										hostIp = hostIp+hostIpsArr[i]+",";
									}
									hostIp = hostIp.substring(0, hostIp.length()-1);
								}
								virtualMachineObj.setHostIp(hostIp);
							}
						}
					}
				}
			}
		}catch (InvalidState e) {
			logger.error(e);
			e.printStackTrace();
			throw new VMTaskException("异常的状态", e);
		} catch (RuntimeFault e) {
			logger.error(e);
			e.printStackTrace();
			throw new VMTaskException("运行时异常", e);
		} catch (RemoteException e) {
			logger.error(e);
			e.printStackTrace();
			throw new VMTaskException("远程调用异常", e);
		}
	}
}
