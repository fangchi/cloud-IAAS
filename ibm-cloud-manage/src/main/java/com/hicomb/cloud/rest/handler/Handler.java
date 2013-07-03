package com.hicomb.cloud.rest.handler;

import java.util.HashMap;
import java.util.List;

import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;

/**
 * 处理句柄
 */
public interface Handler {
	
	/**
	 * 构建虚拟机基本属性
	 * @param virtualname 虚拟机名称
	 * @param project 项目
	 * @param applianceId 镜像
	 * @param target 部署目标
	 * @param description 描述
	 * @param diskSize 磁盘名称
	 * @param memorySize 内存名称
	 * @param cpuNum CPU个数
	 * @param networkConfigurationId 网络配置名称
	 * @param ipAddr ip地址
	 * @param args  for Z  mdiskpassword,vmpassword
	 * @return
	 */
	public HashMap<String, Object> buildVMproperties(String virtualname,
			String project,Appliance appliance,String target, String description, long diskSize,
			long memorySize, long cpuNum,String networkConfigurationId,String ipAddr,Object... args);
	
	/**
	 * 构建虚拟机Properties
	 * @param diskSize
	 * @param memorySize
	 * @param cpuNum
	 * @param isRun
	 * @return
	 */
	public HashMap<String, Object> buildVMDeviceProperties(
			long diskSize, long memorySize, long cpuNum,boolean isRun) ;
	
	/**
	 * 构建镜像
	 * @param appliance
	 * @param properties
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public Appliance getApplianceFromProperties(Appliance appliance,List<HashMap> properties) ;
	
	/**
	 * 构建工作负载
	 * @param virtualMachine
	 * @param properties
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public VirtualMachine getWorkloadFromProperties(VirtualMachine virtualMachine,List<HashMap> properties);
}
