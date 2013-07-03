package com.hicomb.cloud.rest.engine.power;

import java.util.Iterator;
import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class PowerVMTestCase  extends PowerCloudTestCase{

	/**
	 * 测试查询VM
	 */
	public final void testQueryVMS() throws CloudRestException{
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		List<VirtualMachine> virtualMachineList = smartCloudEntryRestEngine.queryVirtualMachines(ip, port, userName, password);
		for (Iterator<VirtualMachine> iterator = virtualMachineList.iterator(); iterator.hasNext();) {
			VirtualMachine virtualMachine = (VirtualMachine) iterator.next();
			System.out.println("......");
			printVM(virtualMachine);
		}
		assertEquals(true, true);
	}
	
//	public final void testCreateVM() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		String newId = smartCloudEntryRestEngine.buildVirtualMachine(hostIp, port, userName, password,UUID.randomUUID().toString().substring(0, 8),"257","描述",8192,1024,2,"1");
//		assertNotNull(newId);
//		System.out.println(newId);
//	}
	
	
//	public void testDeleteVM() throws CloudRestException {
//	SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//	RestResponse response = smartCloudEntryRestEngine.removeVirtualMachine(hostIp, port, userName, password,"570");
//	assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//	System.out.println(response.getResponseMsg());
//}	

	
	//
//	public final void testReconfigVMDevice() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		int  responseCode = smartCloudEntryRestEngine.reconfigVirtualMachineDevice(hostIp, port, userName, password, "29570", "F" ,2048, 1024, 3);
//		assertEquals(RESTConstants.HTTP_CREATED, responseCode);
//	}
//	
//	public final void testGetVM() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.getVirtualMachine(hostIp, port, userName, password, "576");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}
	
//	public final void testReconfigVMBasikInfo() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.reconfigVirtualMachineBasicInfo(hostIp, port, userName, password, "344","fc","miaoshu");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}

}
