package com.hicomb.cloud.rest.sce;

import java.util.List;

import com.hicomb.cloud.rest.RestResponse;
import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.event.SmartCloudEntryEvent;
import com.hicomb.cloud.rest.sce.entity.host.ZSystemHostPerf;
import com.hicomb.cloud.rest.sce.entity.network.NetworkConfiguration;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.ZsystemVirtualMachinePerf;

/**
 * IBM 云平台引擎接口
 */
public interface SmartCloudEntryRestEngine {

	/**
	 * 获取虚拟机镜像
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws CloudRestException
	 */
	public List<Appliance> queryAppliances(String ip, int port,
			String userName, String password) throws CloudRestException;

	/**
	 * 构建虚拟机
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param virtualname
	 * @param applianceId
	 * @param cloudId
	 * @param target
	 * @param description
	 * @param diskSize
	 * @param memorySize
	 * @param cpuNum
	 * @param networkConfigureId
	 * @param ipAddr
	 * @param args  
	 * 	for Z    arg[0] = gateway arg[1]= netmask arg[2]=hostname arg[3]=domain arg[4]=pri_dns arg[5] =vmpassword  arg[6] = mdiskpassword 
	 *  for X86  arg[0] = gateway arg[1]= netmask arg[2]=hostname arg[3]=domain arg[4]=pri_dns arg[5] =vmpassword
	 * @return
	 * @throws CloudRestException
	 */
	public String buildVirtualMachine(String ip, int port,
			String userName, String password, String virtualname,
			String applianceId,String cloudId,String target, String description, long diskSize,
			long memorySize, long cpuNum,String networkConfigureId,String ipAddr,Object... args) throws CloudRestException ;

	/**
	 * 撤销虚拟机
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @return
	 * @throws CloudRestException
	 */
	public RestResponse removeVirtualMachine(String ip, int port,
			String userName, String password, String workloadId) throws CloudRestException;
	
	/**
	 * 获取虚拟机列表信息
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @return
	 * @throws CloudRestException
	 */
	public List<VirtualMachine> queryVirtualMachines(String ip, int port,
			String userName, String password) throws CloudRestException;
	
	/**
	 * 获取虚拟机列表基本信息
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @return
	 * @throws CloudRestException
	 */
	public List<VirtualMachine> queryVirtualMachinesBasicInfo(String ip, int port,
			String userName, String password) throws CloudRestException;
	
	/**
	 * 获取虚拟机信息
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @return
	 * @throws CloudRestException
	 */
	public String getVirtualMachine(String ip, int port,
			String userName, String password, String workloadId) throws CloudRestException;
	
	/**
	 * 重新配置虚拟机基本信息
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @param diskName
	 * @param diskSize
	 * @param memorySize
	 * @param cpuNum
	 * @return
	 * @throws CloudRestException
	 */
	public int reconfigVirtualMachineDevice(String ip, int port,
			String userName, String password, String workloadId, String diskName,
			long diskSize,long memorySize, long cpuNum) throws CloudRestException ;
	
	/**
	 * 重新配置虚拟机
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param workloadId
	 * @param name
	 * @param descption
	 * @return
	 * @throws CloudRestException
	 */
	public RestResponse reconfigVirtualMachineBasicInfo(String ip, int port,
			String userName, String password, String workloadId,
			String name,String descption) throws CloudRestException ;
	
	/**
	 * 查询网络配置
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @throws CloudRestException
	 */
	public List<NetworkConfiguration> queryNetworkConfigurations(String ip, int port,
			String userName, String password)throws CloudRestException;

	/**
	 * 获取ZsystemHost性能指标
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param hostIP
	 * @return
	 */
	public ZSystemHostPerf queryZSystemHostPerf(String ip, int port,
			String userName, String password,String hostIP) throws CloudRestException ;

	/**
	 * 获取ZSystem虚拟机指标
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws CloudRestException
	 */
	public  List<ZsystemVirtualMachinePerf> queryZSystemVirtualMachinePerf(String ip, int port,
			String userName, String password) throws CloudRestException ;
	
	/**
	 * 调整虚拟机电源状态
	 * @param vmId
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 */
	public String swapVirtualMachineState(String vmId,String ip, int port,
			String userName, String password) throws CloudRestException ;
	
	
	/**
	 * 获取z的事件
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 */
	public List<SmartCloudEntryEvent> querySceEvent(String ip, int port,
			String userName, String password,long beginTime,long endTime,String level) throws CloudRestException ;
}
