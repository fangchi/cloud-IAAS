package com.hicomb.cloud.rest.engine.zsystem;

import java.util.Iterator;
import java.util.List;

import com.hicomb.cloud.rest.engine.EngineTestCase;
import com.hicomb.cloud.rest.sce.entity.host.ZSystemHostPerf;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.ZsystemVirtualMachinePerf;

public class ZSystemCloudTestCase extends EngineTestCase {

	@Override
	public void setUp() {
		userName = "admin";
		password = "admin";
		ip = "172.16.13.173";
		port =8080;
	}
	
	protected void printZsystemHostPerf(ZSystemHostPerf zSystemHostPerf){
		System.out.println("FreeDisk:"+zSystemHostPerf.getFreeDisk());
		System.out.println("TotalCPU:"+zSystemHostPerf.getTotalCPU());
		System.out.println("TotalDisk:"+zSystemHostPerf.getTotalDisk());
		System.out.println("TotalMemory:"+zSystemHostPerf.getTotalMemory());
		System.out.println("UsageCPU:"+zSystemHostPerf.getUsageCPU());
		System.out.println("UsageDisk:"+zSystemHostPerf.getUsageDisk());
		System.out.println("UsageMemory:"+zSystemHostPerf.getUsageMemory());
	}
	
	protected void printZsystemVirtualMachinePerfs(List<ZsystemVirtualMachinePerf> zsystemVirtualMachinePerfs){
		for (Iterator<ZsystemVirtualMachinePerf> iterator = zsystemVirtualMachinePerfs.iterator(); iterator
				.hasNext();) {
			ZsystemVirtualMachinePerf zsystemVirtualMachinePerf = (ZsystemVirtualMachinePerf) iterator
					.next();
			System.out.println("......");
			System.out.println("Oid:"+zsystemVirtualMachinePerf.getOid());
			System.out.println("TotalCPU:"+zsystemVirtualMachinePerf.getTotalCPU());
			System.out.println("TotalDisk:"+zsystemVirtualMachinePerf.getTotalDisk());
			System.out.println("TotalMemory:"+zsystemVirtualMachinePerf.getTotalMemory());
			System.out.println("UsageCPU:"+zsystemVirtualMachinePerf.getUsageCPU());
			System.out.println("UsageDisk:"+zsystemVirtualMachinePerf.getUsageDisk());
			System.out.println("UsageMemory:"+zsystemVirtualMachinePerf.getUsageMemory());
		}
	}
	
}
