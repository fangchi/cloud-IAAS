package com.hicomb.cloud.rest.sysdirector;

import java.util.List;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.event.SystemDirectorEvent;
import com.hicomb.cloud.rest.sysdirector.entity.host.PowerHost;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPool;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPoolPerf;
import com.hicomb.cloud.rest.sysdirector.entity.vm.PowerVirtualMachinePerf;


/**
 * SystemDirector rest引擎
 */
public interface SystemDirectorRestEngine {

	/**
	 * 查找系统池
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 */
	public List<SystemPool> querySystemPool(String ip, int port,
			String userName, String password)  throws CloudRestException;
	
	/**
	 * 获取系统池性能
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param oid
	 * @return
	 * @throws CloudRestException
	 */
	public SystemPoolPerf querySystemPoolPerf(String ip, int port,
			String userName, String password,String oid)  throws CloudRestException;
	
	/**
	 * 获取host列表
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param oid
	 * @return
	 * @throws CloudRestException
	 */
	public List<PowerHost> queryHosts(String ip, int port,
			String userName, String password)  throws CloudRestException;
	
	/**
	 * 获取powerVM性能
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param serverId
	 * @return
	 * @throws CloudRestException
	 */
	public PowerVirtualMachinePerf queryPowerVirtualMachinePerf(String ip, int port, String userName,
			String password,String serverId) throws CloudRestException;
	
	
	/**
	 * 获取SystemDirector事件
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param serverId
	 * @return
	 * @throws CloudRestException
	 */
	public List<SystemDirectorEvent> querySystemDirectorEvents(String ip, int port, String userName,
			String password,long beginDate,long endDate,String severity) throws CloudRestException;
}
