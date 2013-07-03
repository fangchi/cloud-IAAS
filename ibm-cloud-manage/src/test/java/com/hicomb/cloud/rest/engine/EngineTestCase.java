package com.hicomb.cloud.rest.engine;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.network.NetworkConfiguration;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;

public class EngineTestCase extends TestCase {

	protected String userName;
	
	protected String password;
	
	protected String ip;
	
	protected int port;
	
	protected void printVM(VirtualMachine virtualMachine){
		System.out.println("id:"+virtualMachine.getId());
		System.out.println("name:"+virtualMachine.getName());
		System.out.println("description:"+virtualMachine.getDescription());
		System.out.println("state:"+virtualMachine.getState().getLabel());
		System.out.println("architecture:"+virtualMachine.getArchitecture());
		System.out.println("hypervisor:"+virtualMachine.getHypervisor());
		System.out.println("cpuNum:"+virtualMachine.getCpuNum());
		System.out.println("memorysize:"+virtualMachine.getMemorySize());
		System.out.println("DiskSize:"+virtualMachine.getDiskSize());
		System.out.println("ipAddress:"+virtualMachine.getIpAddress());
		System.out.println("srcId:"+virtualMachine.getSrcId());
		for (Iterator<String> iterator = virtualMachine.getCustomProperties().keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			System.out.println(key+":"+virtualMachine.getCustomProperties().get(key));
			
		}
	}
	
	
	protected void printVMBasic(VirtualMachine virtualMachine){
		System.out.println("id:"+virtualMachine.getId());
		System.out.println("name:"+virtualMachine.getName());
		System.out.println("description:"+virtualMachine.getDescription());
		System.out.println("state:"+virtualMachine.getState().getLabel());
		System.out.println("architecture:"+virtualMachine.getArchitecture());
		System.out.println("hypervisor:"+virtualMachine.getHypervisor());
		System.out.println("cpuNum:"+virtualMachine.getCpuNum());
		System.out.println("memorysize:"+virtualMachine.getMemorySize());
		System.out.println("DiskSize:"+virtualMachine.getDiskSize());
		System.out.println("ipAddress:"+virtualMachine.getIpAddress());
		System.out.println("srcId:"+virtualMachine.getSrcId());
	}
	
	protected void printAppliances(List<Appliance> appliances){
		for (Iterator<Appliance> iterator = appliances.iterator(); iterator.hasNext();) {
			Appliance appliance = (Appliance) iterator.next();
			System.out.println("Id:"+appliance.getId());
			System.out.println("Name:"+appliance.getName());
			System.out.println("Description:"+appliance.getDescription());
			System.out.println("Architecture:"+appliance.getArchitecture());
			System.out.println("Hypervisor:"+appliance.getHypervisor());
			System.out.println("ChangedDate:"+appliance.getChangedDate());
			System.out.println("State:"+appliance.getState().getLabel());
			for(Object key:appliance.getCustomProperties().keySet()){
				System.out.println(key+":"+appliance.getCustomProperties().get(key));
			}
			System.out.println("-----------------------------------------");
		}
	}
	
	protected void printNetworkConfigurations(List<NetworkConfiguration> networkConfigurations){
		for (Iterator<NetworkConfiguration> iterator = networkConfigurations.iterator(); iterator.hasNext();) {
			NetworkConfiguration networkConfiguration = (NetworkConfiguration) iterator.next();
			System.out.println("Id:"+networkConfiguration.getId());
			System.out.println("Name:"+networkConfiguration.getName());
			System.out.println("Description:"+networkConfiguration.getDescription());
			System.out.println("Domain:"+networkConfiguration.getDomain());
			System.out.println("cloudType:"+networkConfiguration.getCloudType());
			System.out.println("-----------------------------------------");
		}
	}
}
