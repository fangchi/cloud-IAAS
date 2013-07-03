package com.hicomb.vm.vmware.task.host;


import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.host.basic.QueryHostTask;

/**
 * 主机基本信息测试用例 
 */
public class HostInfoQueryTestCase extends VMWareBaseTestCase{
	
	/**
	 * 查询主机基本信息
	 */
	public void testQueryHost() {
		try {
			ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool(hostIp, hostUserName, hostPasword);
			Task<List<HostObj>> task = new QueryHostTask();
			List<HostObj> hostObjList =  task.execute(connectionPool);
			for (Iterator<HostObj> iterator = hostObjList.iterator(); iterator.hasNext();) {
				HostObj hostObj = (HostObj) iterator.next();
				assertNotNull(hostObj);
				printHostObj(hostObj);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	protected void printHostObj(HostObj hostObj){
		System.out.println("............................................");
		System.out.println("Uuid:"+hostObj.getUuid());
		System.out.println("vender:"+hostObj.getHardwareVendor());
		System.out.println("Model:"+hostObj.getModel());
//		System.out.println("powerState:"+hostObj.getHostRuntimeInfo().getPowerState());
		System.out.println("DefaultGateway:"+hostObj.getNetworkInfo().getIpRouteConfig().getDefaultGateway());
		System.out.println("host IpAddress:"+hostObj.getIpAddress());
		System.out.println("host MAC:"+hostObj.getMacAddress());
		System.out.println("host CpuMhz:"+hostObj.getCpuMhz());
		System.out.println("host CpuCores:"+hostObj.getNumCpuCores());
		System.out.println("host memory:"+hostObj.getMemorySize());
		System.out.println("host DiskSize:"+hostObj.getTotalDiskSize());
//		for(HostCpuPackage hostCpuPackage : hostObj.getHostCpuPackage()) { //CPU描述
//			System.out.println("description:" + hostCpuPackage.getDescription());
//		}
//		System.out.println("BusAdapter:");
//		for(HostHostBusAdapter hostHostBusAdapter : hostObj.getHostConfigInfo().getStorageDevice().getHostBusAdapter()){
//			if(hostHostBusAdapter instanceof HostFibreChannelHba){
//				System.out.println("HostFibreChannelHba:"+hostHostBusAdapter.getModel());
//			}
//		}
//		for(HostCpuIdInfo hostCpuIdInfo :hostObj.getHostCpuIdInfo()){
//			System.out.println("hostCpuIdInfo.vendor:"+hostCpuIdInfo.getVendor());
//		}
//		for(HostPciDevice pciDevice:hostObj.getHostPciDevices()){
//			System.out.println("slot:" + pciDevice.getSlot());  //插槽口
//			System.out.println("function:" + pciDevice.getFunction());
//			System.out.println("pciDeviceDeviceName:"+pciDevice.getDeviceName());
//			System.out.println("pciDeviceVendorName:"+pciDevice.getVendorName());
//		}
	}
}
