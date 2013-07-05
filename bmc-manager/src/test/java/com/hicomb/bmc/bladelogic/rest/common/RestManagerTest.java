package com.hicomb.bmc.bladelogic.rest.common;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import com.hicomb.bmc.bladelogic.rest.entity.Job;
import com.hicomb.bmc.bladelogic.rest.entity.Server;
import com.hicomb.bmc.bladelogic.rest.exception.BladeLogicRestException;
import com.hicomb.bmc.bladelogic.rest.manager.BladeLogicRestManager;

public class RestManagerTest extends RestTestCase {

	private void printServer(Server server){
		System.out.println("");
		System.out.println("name: "+server.getName());
		System.out.println("description: "+server.getDescription());
		System.out.println("agentStatus: "+server.getAgentStatus());
		System.out.println("IpAddr: "+server.getIpAddr());
		System.out.println("os: "+server.getOs());
		System.out.println("OsPlatform: "+server.getOsPlatform());
		System.out.println("OsVendor: "+server.getOsVendor());
		System.out.println("OsVersion: "+server.getOsVersion());
		for (String key:server.getProperties().keySet()) {
			System.out.println(key+": "+server.getProperties().get(key));
		}
	}
	
	private void printJob(Job job) throws UnsupportedEncodingException{
		
		System.out.println(job.getDescription());
		System.out.println("Priority: "+job.getPriority());
		System.out.println("Dbkey: "+job.getDbkey());
		System.out.println("UserCreated: "+job.getUserCreated());
		System.out.println("DateCreated: "+job.getDateCreated());
		for (String key:job.getProperties().keySet()) {
			System.out.println(key+": "+job.getProperties().get(key));
		}
	}
	
	
	
	/**
	 * 测试获取服务器
	 * @throws BladeLogicRestException
	 */
	/**public final void testGetServers() throws BladeLogicRestException {
		List<Server> servers  = BladeLogicRestManager.getInstance().getServers(serverIp, port, sslKey, username, password, userRole);
		for (Iterator<Server> iterator = servers.iterator(); iterator.hasNext();) {
			Server server = (Server) iterator.next();
			printServer(server);
		}
		assertTrue(servers.size()>0);
	}**/
	
	/**
	 * 测试获取作业
	 * @throws BladeLogicRestException
	 * @throws UnsupportedEncodingException 
	 */
	public final void testGetJobs() throws BladeLogicRestException, UnsupportedEncodingException {
		List<Job> jobs  = BladeLogicRestManager.getInstance().getJobs(serverIp, port, sslKey, username, password, userRole);
		for (Iterator<Job> iterator = jobs.iterator(); iterator.hasNext();) {
			Job job = (Job) iterator.next();
			printJob(job);
		}
		assertTrue(jobs.size()>0);
	}
	
	/**
	 * 测试执行作业
	 * @throws BladeLogicRestException
	 */
	/**public final void testExecuteJobs() throws BladeLogicRestException {
		String jobId = "1ffdb4cc-c251-4c48-a4c5-fff62c3a7a29";
		String[] serverId = {"6e0ac6c8-5d16-49f0-80f8-6846972d9e49"};
		HashMap hashMap =BladeLogicRestManager.getInstance().executeJobOnServer(serverIp, port, sslKey, username, password, userRole,jobId,serverId,true);
		assertEquals("false", ((HashMap)hashMap.get("Status")).get("hadErrors"));
	}**/
}
