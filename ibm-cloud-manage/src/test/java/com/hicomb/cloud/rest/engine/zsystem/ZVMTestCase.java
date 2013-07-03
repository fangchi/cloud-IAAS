package com.hicomb.cloud.rest.engine.zsystem;

import com.hicomb.cloud.rest.exception.CloudRestException;

public class ZVMTestCase  extends ZSystemCloudTestCase{
	
//	/**
//	 * 测试查询ZVM虚拟机
//	 * @throws CloudRestException
//	 */
//	public final void testQueryVMS() throws CloudRestException{
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		List<VirtualMachine> virtualMachineList = smartCloudEntryRestEngine.queryVirtualMachines(ip, port, userName, password);
//		for (Iterator<VirtualMachine> iterator = virtualMachineList.iterator(); iterator.hasNext();) {
//			VirtualMachine virtualMachine = (VirtualMachine) iterator.next();
//			System.out.println("......");
//			printVM(virtualMachine);
//		}
//		assertEquals(true, true);
//	}
	
	public final void testCreateVM() throws CloudRestException {}
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		String response = smartCloudEntryRestEngine.buildVirtualMachine("", port, userName, password, 
//				UUID.randomUUID().toString().substring(0, 5), "253", "描述", 8192,1024 , 2, "34002","ip");
//		System.out.println(response);
//		
//	}
//	
	
//	public void testDeleteVM() throws CloudRestException {
//	SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//	RestResponse response = smartCloudEntryRestEngine.removeVirtualMachine(hostIp, port, userName, password,"570");
//	assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//	System.out.println(response.getResponseMsg());
//}	

	
//	//调整磁盘大小
//	public final void testReconfigVMDevice() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		int response = smartCloudEntryRestEngine.reconfigVirtualMachineDevice(ip, port, userName, password, "29592","F", 10001, 2048, 4);
//		assertEquals(RESTConstants.HTTP_OK, response);
//	}
	
//	public final void testGetVM() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.getVirtualMachine(hostIp, port, userName, password, "576");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}
	
//	public final void testReconfigVMBasikInfo() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.reconfigVirtualMachineBasicInfo(hostIp, port, userName, password, "564","fc","miaoshu");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}

}
