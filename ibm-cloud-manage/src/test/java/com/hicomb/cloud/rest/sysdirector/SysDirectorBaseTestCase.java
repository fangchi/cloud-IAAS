package com.hicomb.cloud.rest.sysdirector;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.hicomb.cloud.rest.sysdirector.entity.host.PowerHost;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPool;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPoolPerf;

public abstract class SysDirectorBaseTestCase extends TestCase {

	protected String userName;
	
	protected String password;
	
	protected int port;
	
	protected String hostIp;
	
	@Override
	public void setUp(){
		userName = "administrator";
		password = "Passw0rd";
		port = 8422;
		hostIp = "172.16.13.173";
	}
	
	protected void printSystemPools(List<SystemPool> list){
		for (Iterator<SystemPool> iterator = list.iterator(); iterator.hasNext();) {
			SystemPool systemPool = (SystemPool) iterator.next();
			System.out.println("OID:"+systemPool.getOID());
			System.out.println("name:"+systemPool.getName());
		}
	}
	
	protected void printSystemPoolPerf(SystemPoolPerf systemPoolPerf){
		System.out.println("oid:"+systemPoolPerf.getOID());
		System.out.println("Allocatedmemory:"+systemPoolPerf.getAllocatedmemory());
		System.out.println("Allocatedprocessor:"+systemPoolPerf.getAllocatedprocessor());
		System.out.println("Allocatedstorage:"+systemPoolPerf.getAllocatedstorage());
		System.out.println("Avgcpuutilization:"+systemPoolPerf.getAvgcpuutilization());
		System.out.println("Freememory:"+systemPoolPerf.getFreememory());
		System.out.println("Freeprocessor:"+systemPoolPerf.getFreeprocessor());
		System.out.println("Freestorage:"+systemPoolPerf.getFreestorage());
		System.out.println("Totalmemory:"+systemPoolPerf.getTotalmemory());
		System.out.println("Totalprocessor:"+systemPoolPerf.getTotalprocessor());
		System.out.println("Totalstorage:"+systemPoolPerf.getTotalstorage());
	}
	
	protected void printHosts(List<PowerHost> hosts){
		for (Iterator<PowerHost> iterator = hosts.iterator(); iterator.hasNext();) {
			System.out.println(".......");
			PowerHost host = (PowerHost) iterator.next();
			System.out.println("OID:"+host.getOID());
			System.out.println("name:"+host.getName());
			System.out.println("ProcessorCapacity:"+host.getProcessorCapacity());
			System.out.println("ProcessorUsage:"+host.getProcessorUsage());
			System.out.println("MemoryCapacity:"+host.getMemoryCapacity()/1024+"(GB)");
			System.out.println("MemoryUsage:"+host.getMemoryUsage());
			System.out.println("StorageCapacity:"+host.getStorageCapacity()/1024+"(GB)");
			System.out.println("StorageUsage:"+host.getStorageUsage());
		}
	}
}
