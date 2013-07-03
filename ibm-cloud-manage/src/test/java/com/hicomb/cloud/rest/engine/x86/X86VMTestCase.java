package com.hicomb.cloud.rest.engine.x86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.xerces.impl.dv.util.Base64;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;
import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;

public class X86VMTestCase  extends X86CloudTestCase{

//	/**
//	 * 查询虚拟机列表
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
////	
//	/**
//	 * 测试查询虚拟机基本配置
//	 */
//	public final void testQueryVMSBasic() throws CloudRestException{
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		List<VirtualMachine> virtualMachineList = smartCloudEntryRestEngine.queryVirtualMachines(ip, port, userName, password);
//		for (Iterator<VirtualMachine> iterator = virtualMachineList.iterator(); iterator.hasNext();) {
//			VirtualMachine virtualMachine = (VirtualMachine) iterator.next();
//			System.out.println("......");
//			printVMBasic(virtualMachine);
//		}
//		assertEquals(true, true);
//	}
	
//	/**
//	 * 测试创建虚拟机
//	 */
/*	public final void testCreateVM() throws CloudRestException {
		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
		String newId = smartCloudEntryRestEngine.buildVirtualMachine(ip, port, userName, password,
				UUID.randomUUID().toString().substring(0, 8),"5652","","描述",16384,1024,2,
				"5901","172.16.13.150",new HashMap<String, Object>());
		assertNotNull(newId);
		System.out.println(newId);
	}*/
	
//	/**
//	 * 测试删除虚拟机
//	 * @throws CloudRestException
//	 */
//	public void testDeleteVM() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.removeVirtualMachine(ip, port, userName, password,"570");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}	

	

//	//调整磁盘大小
//	public final void testReconfigVMDevice() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		int response = smartCloudEntryRestEngine.reconfigVirtualMachineDevice(ip, port, userName, password, "3213","", 8196, 2048, 4);
//		assertEquals(RESTConstants.HTTP_OK, response);
//	}
	

//	/**
//	 * 测试获取虚拟机
//	 */
//	public final void testGetVM() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.getVirtualMachine(ip, port, userName, password, "576");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}
	
//	/**
//	 * 测试虚拟机基础信息
//	 */
//	public final void testReconfigVMBasicInfo() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		RestResponse response = smartCloudEntryRestEngine.reconfigVirtualMachineBasicInfo(ip, port, userName, password, "564","fc","miaoshu");
//		assertEquals(RESTConstants.HTTP_OK, response.getResponseCode());
//		System.out.println(response.getResponseMsg());
//	}

//	/**
//	 * 测试开关机
//	 */
//	public final void testSwapVMState() throws CloudRestException {
//		SmartCloudEntryRestEngine  smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
//		String response = smartCloudEntryRestEngine.swapVirtualMachineState("3201", ip, port, userName, password);
//		System.out.println(response);
//	}
	
}
