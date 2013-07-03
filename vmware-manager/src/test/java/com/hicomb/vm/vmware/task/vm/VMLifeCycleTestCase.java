package com.hicomb.vm.vmware.task.vm;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import com.hicomb.vm.vmware.base.VMWareBaseTestCase;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.hicomb.vm.vmware.task.vm.basic.QueryVirtualMachinesTask;
import com.vmware.vim25.GuestDiskInfo;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDisk;

//本测试用例以废除
@Deprecated 
public class VMLifeCycleTestCase extends VMWareBaseTestCase {

	// public void testReConfigVMCPU() {
	// try {
	// Task<Map<String, ManagedObjectReference>> task = new
	// QueryVirtualMachinesTask("VirtualMachine");
	// Map<String, ManagedObjectReference> res = task.execute();
	// Task<Integer> task2 = new ReConfigVirtualMachineTask("CPU","update",
	// "", "", "", "1",
	// res.get("TestOS"));
	// int resault = task2.execute();
	// assertEquals(VMWareBaseCommon.TASK_EXE_SUCCESS,resault);
	// } catch (Exception e) {
	// assertTrue(false);
	// }
	// }
	//
	// public void testReConfigVMMemory() {
	// try {
	// Task<Map<String, ManagedObjectReference>> task = new
	// QueryVirtualMachinesTask("VirtualMachine");
	// Map<String, ManagedObjectReference> res = task.execute();
	// Task<Integer> task2 = new ReConfigVirtualMachineTask("memory","update",
	// "", "", "", "1024",
	// res.get("TestOS"));
	// int resault = task2.execute();
	// assertEquals(VMWareBaseCommon.TASK_EXE_SUCCESS,resault);
	// } catch (Exception e) {
	// assertTrue(false);
	// }
	// }
	//
	// public void testReConfigVMDisc() {
	// try {
	// Task<Map<String, ManagedObjectReference>> task = new
	// QueryVirtualMachinesTask("VirtualMachine");
	// Map<String, ManagedObjectReference> res = task.execute();
	// Task<Integer> task2 = new ReConfigVirtualMachineTask("disk","Add",
	// "TestOS", "1024", "persistent", "",
	// res.get("TestOS"));
	// int resault = task2.execute();
	// assertEquals(VMWareBaseCommon.TASK_EXE_SUCCESS,resault);
	// } catch (Exception e) {
	// assertTrue(false);
	// }
	// }

	// public void testReConfigVMDisc() {
	// try {
	// Task<Map<String, ManagedObjectReference>> task = new
	// QueryVirtualMachinesTask("VirtualMachine");
	// Map<String, ManagedObjectReference> res = task.execute();
	// Task<Integer> task2 = new ReConfigVirtualMachineTask("disk","Add",
	// "TestOS", "1024", "persistent", "",
	// res.get("TestOS"));
	// int resault = task2.execute();
	// assertEquals(VMWareBaseCommon.TASK_EXE_SUCCESS,resault);
	// } catch (Exception e) {
	// assertTrue(false);
	// }
	// }

	public void testQueryVirtualMachinesTask() {
		try {
			ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool("172.16.13.141", "root", "12345678");
			Task<List<VirtualMachineObj>> task = new QueryVirtualMachinesTask();
			List<VirtualMachineObj> resDetailObjs = task.execute(connectionPool);
			assertTrue(resDetailObjs.size() > 0);
			for (Iterator<VirtualMachineObj> iterator = resDetailObjs
					.iterator(); iterator.hasNext();) {
				VirtualMachineObj virtualMachineDetailObj = (VirtualMachineObj) iterator
						.next();
				printVMs(virtualMachineDetailObj);
			}
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	private void printVMs(VirtualMachineObj virtualMachineDetailObj) {
		System.out.println("name:"
				+ virtualMachineDetailObj.getVirtualMachineConfigInfo()
						.getName());
		System.out.println("GuestFullName:"
				+ virtualMachineDetailObj.getVirtualMachineConfigInfo()
						.getGuestFullName());
		
		
		System.out.println("IpAddress:"
				+ virtualMachineDetailObj.getGuestIpAddress());
		System.out.println("NumCPU:"
				+ virtualMachineDetailObj.getVirtualMachineConfigInfo()
						.getHardware().getNumCPU());
		
		DecimalFormat decimal = new DecimalFormat("#.##");
		System.out.println("OverallCpuUsage:"
				+ Float.valueOf(decimal.format(Float.valueOf(virtualMachineDetailObj.getVMOverallCpuUsage()).floatValue() / 10000.0D)).floatValue());
		
		System.out.println("MemoryMB:"
				+ virtualMachineDetailObj.getVirtualMachineConfigInfo()
						.getHardware().getMemoryMB());
		System.out.println("GuestMemoryUsag:"
				+ virtualMachineDetailObj.getVMOguestMemoryUsage());
		
//		System.out.println("MemoryOverhead:"
//				+ virtualMachineDetailObj.getVirtualMachineRuntimeInfo()
//						.getMemoryOverhead()/1024/1024+"MB");
		
		System.out.println("TotalStorage:"
				+ virtualMachineDetailObj.getTotalStorage()/1024/1024+"MB");
		
		System.out.println("FreeStorage:"
				+ virtualMachineDetailObj.getFreeStorage()/1024/1024+"MB");
		
		System.out.println("StoreageCommitted:"
				+ virtualMachineDetailObj.getCommittedStorage()/ 1024L / 1024L/1024L+"G");
		
//		System.out.println("StoreageUncommitted():"
//				+ virtualMachineDetailObj.GET/ 1024L / 1024L/1024L+"G");
		
		
//		System.out.println("cleanPowerOff:"
//				+ virtualMachineDetailObj.getVirtualMachineSummary().getRuntime().getPowerState().getValue());
		
		for (VirtualDevice virtualDevice : virtualMachineDetailObj
				.getVirtualMachineConfigInfo().getHardware().getDevice()) {
			if (virtualDevice instanceof VirtualDisk) {
				System.out.println("disk info:");
				VirtualDisk disk = (VirtualDisk) virtualDevice;
				System.out.println(disk.getDeviceInfo().getLabel() + ":"
						+ disk.getCapacityInKB());
			}
		}
		if (virtualMachineDetailObj.getVirtualMachinePowerState()
				.equals("running")) {
			System.out.println("GuestHostName:"
					+ virtualMachineDetailObj.getGuestOSFullName());
			System.out.println("GuestIpAddress:"
					+ virtualMachineDetailObj.getGuestIpAddress());
			System.out.println("guest disk info:");
			for (GuestDiskInfo guestDiskInfo : virtualMachineDetailObj.getGuestDiskInfos()) {
				System.out.println("Capacity" + ":"
						+ ((float)guestDiskInfo.getCapacity())/1024/1024/1024+"GB");
				System.out.println("FreeSpace" + ":"
						+ ((float)guestDiskInfo.getFreeSpace())/1024/1024/1024+"GB");
			}
		}
	}

}
