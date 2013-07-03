package com.hicomb.cloud.rest.engine.power;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.powerperformance.PowerVirtualMachinePerfQuerier;
import com.hicomb.cloud.rest.sysdirector.entity.vm.PowerVirtualMachinePerf;

public class PowerperformanceTestCase extends TestCase {

	public final void testQueryPowerVmPerformance() throws CloudRestException {
		PowerVirtualMachinePerfQuerier powerPermanceQuerier = new PowerVirtualMachinePerfQuerier();
		List<PowerVirtualMachinePerf> powerVirtualMachinePerfList = powerPermanceQuerier
				.queryPowerVirtualMachinePerformance("HTTP", "172.16.13.173", 8080, "admin",
						"admin", "HTTPS", "172.16.13.173", 8422,
						"administrator", "Passw0rd");
		for (Iterator<PowerVirtualMachinePerf> iterator = powerVirtualMachinePerfList
				.iterator(); iterator.hasNext();) {
			PowerVirtualMachinePerf powerVirtualMachinePerf = (PowerVirtualMachinePerf) iterator
					.next();
			System.out.println("oid:" + powerVirtualMachinePerf.getOid());
			System.out.println("src:" + powerVirtualMachinePerf.getSrcId());
			System.out.println("cpuUsage%:"
					+ powerVirtualMachinePerf.getCpuUsage());
			System.out.println("Memoryallocation(MB):"
					+ powerVirtualMachinePerf.getMemoryallocation());
			System.out.println("MemoryUsage(MB):"
					+ powerVirtualMachinePerf.getMemoryUsage());
			System.out.println("totalDisk(MB):"
					+ powerVirtualMachinePerf.getTotalDisk());
			System.out.println("usedDisk(MB):"
					+ powerVirtualMachinePerf.getUsedDisk());
			
		}
	}
}
