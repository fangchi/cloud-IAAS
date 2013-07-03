package com.hicomb.cloud.rest.sce;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.cloud.rest.RestResponse;
import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.handler.Handler;
import com.hicomb.cloud.rest.handler.PowerHandler;
import com.hicomb.cloud.rest.handler.VMWareHandler;
import com.hicomb.cloud.rest.handler.ZSystemHandler;
import com.hicomb.cloud.rest.sce.entity.State;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.event.SmartCloudEntryEvent;
import com.hicomb.cloud.rest.sce.entity.host.ZSystemHostPerf;
import com.hicomb.cloud.rest.sce.entity.network.NetworkConfiguration;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.ZsystemVirtualMachinePerf;
import com.hicomb.cloud.rest.util.HttpsUtil;
import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;

public abstract class BaseSmartCloudEntryRestEngine extends
		AbstractSmartCloudEntryRestEngine {

	private static final Log logger = LogFactory.getLog(AbstractSmartCloudEntryRestEngine.class);
	
	public boolean isHttpsSchema(String basePath){
		return basePath.startsWith(CommonConst.HTTPS_SCHEMA);
	}
	
	public HttpURLConnection buildConnFromURL(String basePath,String ip,int port,String userName,String password,String method,HashMap<String, Object> requestBody) throws RestException{
		RestEngine restEngine = new DefaultRestEngine();
		HashMap<String, String> headerToken = buildUserToken(userName,
				password);
		headerToken.put("Content-Type", "application/json; charset=UTF-8");
		HttpURLConnection conn = isHttpsSchema(basePath)? 
				restEngine.processHttpsRequest(basePath,method, null, headerToken, "UTF-8",HttpsUtil.getSSLSocketFactory(
						ip, port, password), HttpsUtil.getHostNameVerifier()): restEngine.processHttpRequest(basePath,
								method, requestBody, headerToken, "UTF-8");//针对不同的协议发送不同的
		return conn;
	}
	
	/**
	 * 构建查询镜像Appliance连接
	 * @param appliance 镜像
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildAppliancesCustomizationConn(Appliance appliance,String ip, int port, String userName, String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
		+ CommonConst.SCE_QUERY_APPLIANCES_CUSTOMIZATION_URL
				.replace("{id}", String.valueOf(appliance.getId()));
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	
	/**
	 * 构建查询虚拟机虚拟服务器的连接
	 * @param virtualMachine 虚拟机
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildWorkloadVirtualserversConn(VirtualMachine virtualMachine,String ip, int port, String userName, String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SCE_QUERY_WORKLOAD_VIRTUALSERVERS_URL
						.replace("{id}",
								String.valueOf(virtualMachine.getId()));
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	
	/**
	 * 构建查询虚拟服务的连接
	 * @param virtualMachine 虚拟机
	 * @param virtaulServerId 虚拟服务器ID
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildWorkloadVirtualserverConn(VirtualMachine virtualMachine,String virtaulServerId,String ip, int port, 
			String userName, String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
		 + CommonConst.SCE_QUERY_WORKLOAD_VIRTUALSERVER_URL.replace(
				"{id}", String.valueOf(virtualMachine.getId()))
				.replace("{serverid}", virtaulServerId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
		
	/**
	 * 获取虚拟服务器存储器连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param virtualServerId
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildVirtualserverStoragesConn(String ip, int port,
			String userName, String password, String virtualServerId) throws RestException{
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_VIRTUALSERVER_STORAGES_URL.replace(
				"{id}", virtualServerId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 获取查询云平台的连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param networkConfiguration
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildCloudConn(String ip, int port, String userName,
			String password, NetworkConfiguration networkConfiguration) throws RestException{
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_CLOUD_URL.replace("{id}",
				networkConfiguration.getCloudId());
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建镜像连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildAppliancesConn(String ip, int port, String userName,
			String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_APPLIANCES_URL;
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建通过镜像构建虚拟机连接
	 * @param applianceId 镜像IP
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildWorkloadsByApplianceIdConn(String applianceId,String ip, int port, String userName,
			String password) throws RestException{
		// 构建POST
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SCE_WORKLOADS_URL;
		HashMap<String, Object> applianceMap = new HashMap<String, Object>();
		applianceMap.put("appliance", applianceId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_POST,applianceMap);
	}
	
	/**
	 * 构建新增虚拟机请求
	 * @param newWorkloadId
	 * @param properties
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildPutWorkloadConn(String newWorkloadId,HashMap<String, Object> properties,String ip, int port, String userName,
			String password) throws RestException{
		// 修改新增的虚拟机
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SCE_WORKLOAD_URL.replace("{id}",
						newWorkloadId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_PUT,properties);
	}
	
	/**
	 * 构建删除虚拟机请求
	 * @param workloadId 虚拟机编号
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildDeleteWorkloadConn(String workloadId,String ip, int port, String userName,
			String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_WORKLOAD_URL.replace("{id}", workloadId)
			+ "?hard=true";
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_DELETE,null);
	}
	
	/**
	 * 获取获取虚拟机列表的连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildWorkloadsConn(String ip, int port, String userName,
			String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SCE_WORKLOADS_URL;
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建单个虚拟机连接
	 * @param workloadId 虚拟机编号
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildWorkloadConn(String workloadId,String ip, int port, String userName,
			String password) throws RestException{
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_WORKLOAD_URL.replace("{id}", workloadId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建虚拟服务器磁盘连接
	 * @param virtualServerId 虚拟服务器ID
	 * @param diskName 磁盘名称
	 * @param diskSize 磁盘大小
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildVirtualserverStorages(String virtualServerId,String diskName,long diskSize,String ip, int port, String userName,
			String password) throws RestException{
		String storagePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_VIRTUALSERVER_STORAGES_URL
				.replace("{id}", virtualServerId);
		HashMap<String, Object> storageProperties = new HashMap<String, Object>();
		storageProperties.put("name", diskName);
		storageProperties.put("size", diskSize);
		return buildConnFromURL(storagePath,ip, port,userName,password,CommonConst.HTTP_METHOD_POST,storageProperties);
	}
	
	
	/**
	 * 获取网络配置列表
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildNetworkconfigurations(String ip, int port, String userName,
			String password) throws RestException {
		String basePath = buildRequestURL(ip, port)+ CommonConst.SCE_NETWORKCONFIGURATIONS_URL;
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建Z虚拟机列表连接
	 * @param virtualServerId
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildZvmVirtualMachineConn(String virtualServerId,String ip, int port, String userName,
			String password) throws RestException {
		String basePath = buildRequestURL(ip, port)
		+ CommonConst.SCE_QUERY_ZVMVMS_URL.replace("{id}",
				virtualServerId);//获取Z体系虚拟机
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 获取z主机连接
	 * @param hostIp
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildZvmHostConn(String hostIp, String ip,
			int port, String userName, String password) throws RestException {
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_ZVMHOST_URL.replace("{ip}", hostIp);//获取Z主机
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	
	/**
	 * 获取Z事件连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param beginTime
	 * @param endTime
	 * @param level
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection buildZSystemEventConn(String ip, int port, String userName,
			String password,long beginTime,long endTime,String severity) throws RestException {
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_QUERY_EVENTS_URL.replace("{beginTime}", ""+beginTime)
				.replace("{endTime}", ""+endTime).replace("{severity}", severity);//构建查询事件的链接
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
   * 构建新增虚拟机相关请求
   * @param newWorkloadId
   * @param properties
   * @param ip
   * @param port
   * @param userName
   * @param password
   * @return
   * @throws RestException
   */
  public HttpURLConnection buildRequestConn(String requestId,HashMap<String, Object> properties,String ip, int port, String userName,
      String password) throws RestException{
    // 修改新增的虚拟机
    String basePath = buildRequestURL(ip, port)
        + CommonConst.SCE_REQUEST_URL.replace("{id}", requestId);
    return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_PUT,properties);
  }
  
  
  /**
   * 构建新增虚拟机相关请求
   * @param newWorkloadId
   * @param properties
   * @param ip
   * @param port
   * @param userName
   * @param password
   * @return
   * @throws RestException
   */
  public HttpURLConnection buildQueryRequestsConn(String newWorkloadId,String ip, int port, String userName,
      String password) throws RestException{
    // 修改新增的虚拟机
    String basePath = buildRequestURL(ip, port)
        + CommonConst.SCE_REQUESTS_URL.replace("{id}",
            newWorkloadId).replace("{user}", userName);
    return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
  }
  
 /**
  * 构建更新镜像部署目标
  * @param workloadId
  * @param cloudId
  * @param targetId
  * @param ip
  * @param port
  * @param userName
  * @param password
  * @return
  * @throws RestException
  */
  public HttpURLConnection buildWorkloadTargetDryConn(String workloadId,String cloudId,String targetId,String ip, int port, String userName,
			String password) throws RestException{
		HashMap<String, Object> targetMap = new HashMap<String, Object>();
		//SCE 2.4 多云环境
		if("".equals(cloudId)||cloudId==null){
			targetMap.put("target", "cloud://default/"+targetId);
		}else{
			targetMap.put("target", "cloud://"+cloudId+"/"+targetId);
		}
		// 构建PUT
		String basePath = buildRequestURL(ip, port)
			+ CommonConst.SCE_TARGETDRY_URL.replace("{id}",workloadId);
		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_PUT,targetMap);
		
	}
	
  
  
  /**
   * 构建更新镜像部署目标
   * @param workloadId
   * @param cloudId
   * @param targetId
   * @param ip
   * @param port
   * @param userName
   * @param password
   * @return
   * @throws RestException
   */
   public HttpURLConnection buildWorkloadTargetChangeConn(String workloadId,String cloudId,String targetId,String ip, int port, String userName,
 			String password) throws RestException{
 		HashMap<String, Object> targetMap = new HashMap<String, Object>();
 		//SCE 2.4 多云环境
 		if("".equals(cloudId)||cloudId==null){
 			targetMap.put("target", "cloud://default/"+targetId);
 		}else{
 			targetMap.put("target", "cloud://"+cloudId+"/"+targetId);
 		}
 		// 构建PUT
 		String basePath = buildRequestURL(ip, port)
		+ CommonConst.SCE_TARGETCHANGE_URL.replace("{id}",workloadId);
 		return buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_PUT,targetMap);
 	}
  
	/**
	 * 构建镜像属性
	 * @param appliance
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws CloudRestException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Appliance queryApplianceCustomization(Appliance appliance,
			String ip, int port, String userName, String password)
			throws CloudRestException {
		try {
			Map<String, Object> applianceSummaryMap = getApplianceSummary(
					String.valueOf(appliance.getId()), ip, port, userName,
					password);
			HttpURLConnection conn = 
				buildAppliancesCustomizationConn(appliance,ip, port,userName, password);//构建查询镜像的连接
			String applianceCustomization = buildResponseJson(conn);
			HashMap map = RESTUtilities.fromJSON(applianceCustomization,
					HashMap.class);
			List<HashMap> properties = (List<HashMap>) map.get("properties");//处理properties
			Handler handler = null;//针对不同平台做不同的句柄处理
			if (CommonConst.ARCHITECTURE_X86.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new VMWareHandler();
			}
			else if (CommonConst.ARCHITECTURE_POWER.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new PowerHandler();
			}
			else if (CommonConst.ARCHITECTURE_ZSYSTEM.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new ZSystemHandler();
			}
			if (handler == null) {
				throw new CloudRestException("未知的体系架构");
			}
			handler.getApplianceFromProperties(appliance, properties);
			return appliance;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机明细失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机明细失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机明细失败,IO错误");
		}
	}

	/**
	 * 构建工作负载属性
	 * @param virtualMachine
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws CloudRestException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private VirtualMachine queryWorkloadVirtualServerProperties(VirtualMachine virtualMachine, String ip, int port,
			String userName, String password) throws CloudRestException {
		try {
			HttpURLConnection conn = buildWorkloadVirtualserversConn( virtualMachine, ip,port,userName,  password);
			String workloadCustomization = buildResponseJson(conn);
			List<HashMap> virtualServersList = ((List<HashMap>) RESTUtilities.fromJSON(
					workloadCustomization, HashMap.class).get("virtualServers"));//获取虚拟机对应的虚拟服务器列表
			if(virtualServersList != null && virtualServersList.size() > 0 ){
				// IBM 日后 一个workload 对应一个 virtaulServer
				String virtaulServerId = virtualServersList.get(0).get("id").toString();//一个虚拟机只对一个虚拟服务器
				virtualMachine.getVirtualServers().add(virtaulServerId);
				HttpURLConnection conn2 = buildWorkloadVirtualserverConn(virtualMachine,virtaulServerId, ip,  port, 
						 userName,  password);//查询对应的server
				String virtualServerStr = buildResponseJson(conn2);
				HashMap virtualServerMap = RESTUtilities.fromJSON(virtualServerStr,
						HashMap.class);
				if(virtualServerMap.get("ip") != null) {
				  virtualMachine.setIpAddress(((String) virtualServerMap.get("ip")).replace(" ", ""));//获取IP地址 
				}
				Handler handler = null;//针对不同的体系架构做不同的句柄
				if (CommonConst.ARCHITECTURE_X86.equals(virtualMachine
						.getArchitecture().toUpperCase())) {
					handler = new VMWareHandler();
				}
				if (CommonConst.ARCHITECTURE_POWER.equals(virtualMachine
						.getArchitecture().toUpperCase())) {
					handler = new PowerHandler();
				}
				if (CommonConst.ARCHITECTURE_ZSYSTEM.equals(virtualMachine
						.getArchitecture().toString().toUpperCase())) {
					handler = new ZSystemHandler();
				}
				if (handler == null) {
					throw new CloudRestException("未知的体系架构");
				}
				if(virtualServerMap.get("properties") != null) {
	        handler.getWorkloadFromProperties(virtualMachine,
	            (List<HashMap>) virtualServerMap.get("properties"));//构建虚拟机的属性
				}
			}
			return virtualMachine;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像明细失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像明细失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像明细失败,IO错误");
		}
	}
	
	/**
	 * 获取虚拟服务器磁盘
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param virtualServerId 虚拟服务器Id
	 * @return
	 * @throws RestException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private long queryVirtualServerDiskSize(String ip, int port,
			String userName, String password, String virtualServerId)
			throws RestException, UnsupportedEncodingException, IOException {
		long totalDiskSize = 0;
		HttpURLConnection conn = buildVirtualserverStoragesConn( ip,  port,userName,  password,  virtualServerId);
		String resultMsg = buildResponseJson(conn);
		HashMap virtualMachinesMap = RESTUtilities.fromJSON(resultMsg,
				HashMap.class);
		List<Map> storages = (List<Map>) virtualMachinesMap.get("storages");//获取对应的存储器
		for (Iterator<Map> iterator = storages.iterator(); iterator.hasNext();) {
			Map storage = (Map) iterator.next();
			totalDiskSize = totalDiskSize
					+ Long.parseLong(String.valueOf(storage.get("size")));
		}
		return totalDiskSize;
	}

	/**
	 * 构建云网络所属的云
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param networkConfiguration
	 * @throws RestException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes" })
	private void buildBeyondCloud(String ip, int port, String userName,
			String password, NetworkConfiguration networkConfiguration)
			throws RestException, UnsupportedEncodingException, IOException {
		HttpURLConnection conn = buildCloudConn( ip,  port,  userName,
				 password,  networkConfiguration);
		String resultMsg = buildResponseJson(conn);
		HashMap cloudMap = RESTUtilities.fromJSON(resultMsg, HashMap.class);
		networkConfiguration.setCloudType((String) cloudMap.get("cloudType"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Appliance> queryAppliances(String ip, int port,
			String userName, String password) throws CloudRestException {
		List<Appliance> resAppliances = new ArrayList<Appliance>();
		try {
			HttpURLConnection conn = buildAppliancesConn( ip,  port,userName,  password);//构建镜像连接
			String allAppliancesSummary = buildResponseJson(conn);
			HashMap map = RESTUtilities.fromJSON(allAppliancesSummary,
					HashMap.class);
			List<Map> appliances = (List<Map>) map.get("appliances");//获取镜像列表
			Appliance appliance = null;
			for (Iterator<Map> iterator = appliances.iterator(); iterator
					.hasNext();) {
				Map applianceMap = (Map) iterator.next();
				appliance = new Appliance();
				buildApplianceFromMap(appliance, applianceMap);
				try {
					appliance = queryApplianceCustomization(appliance, ip,
							port, userName, password);//构建镜像属性
				} catch (Exception e) {
					continue;// 如果获取镜像定制信息报错，跳过该镜像
				}
				resAppliances.add(appliance);
			}
			return resAppliances;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("请求虚拟机镜像失败,IO错误");
		}
	}
	
	public String buildVirtualMachine(String ip, int port, String userName,
      String password, String virtualname, String applianceId,String cloudId,String target,
      String description, long diskSize, long memorySize, long cpuNum,
      String networkConfigureId,String ipAddr,Object... args) throws CloudRestException {
	  try {
		  String newWorkloadId = createVirtualMachine(ip, port, userName, password, virtualname, applianceId,cloudId, target, description, diskSize, memorySize, 
			  cpuNum, networkConfigureId, ipAddr,args);
	 	  //审核请求
	      Thread.sleep(500);
	      approveRequest(newWorkloadId, ip, port, userName, password);
	      return newWorkloadId;
	  }catch (InterruptedException e) {
		  logger.error(e);
		  e.printStackTrace();
	      throw new CloudRestException("睡眠出错");
	  }
	}
	
	public boolean approveRequest(String newWorkloadId, String ip, int port, String userName, String password) throws CloudRestException{
	  try {
			HttpURLConnection queryConn = buildQueryRequestsConn(newWorkloadId, ip, port, userName, password);
		    String requestSummary = buildResponseJson(queryConn);
		    HashMap<String, Object> requestsMap = RESTUtilities.fromJSON(requestSummary, HashMap.class);
		    List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) requestsMap.get("requests");
		    if(list == null || list.isEmpty()) {
		      logger.error("审核请求时，没有获取到请求，workloadId:" + newWorkloadId);
		      return false;
		    }
		    HashMap<String, Object> requestMap = list.get(0);
		    String requestId = (String)requestMap.get("id");
		    HashMap<String, Object> properties = new HashMap<String, Object>();
		    properties.put("id", requestId);
		    properties.put("state", "APPROVED");
		    queryConn = buildRequestConn(requestId, properties, ip, port, userName, password);
		    String result = buildResponseJson(queryConn);
		    logger.info("审核请求返回结果:" + result);
	  	} catch (RestException e) {
		  logger.error(e);
		  e.printStackTrace();
		  throw new CloudRestException("审核请求失败,引擎错误");
	    } catch (UnsupportedEncodingException e) {
	      logger.error(e);
	      e.printStackTrace();
	      throw new CloudRestException("审核请求失败,不支持的编码");
	    } catch (IOException e) {
	      logger.error(e);
	      e.printStackTrace();
	      throw new CloudRestException("审核请求失败,IO错误");
	    }
	  return true;
	}
	

	@SuppressWarnings({ "rawtypes" })
	public String createVirtualMachine(String ip, int port, String userName,
			String password, String virtualname, String applianceId,String cloudId,String target,
			String description, long diskSize, long memorySize, long cpuNum,
			String networkConfigureId,String ipAddr,Object... args) throws CloudRestException {
		try {
			// 获取镜像Project
			HashMap<String, Object> applianceSummaryMap = getApplianceSummary(
					applianceId, ip, port, userName, password);
			String projectId = applianceSummaryMap
					.get("projectUri")
					.toString()
					.replace(
							buildRequestURL(ip, port)
									+ CommonConst.SCE_QUERY_PROJECTS_URL, "")
					.replace("/", "");
			
			// 获取镜像明细信息
			Appliance appliance = new Appliance();
			appliance.setId(applianceId);
			queryApplianceCustomization(appliance, ip, port, userName, password);//查询镜像信息
			//构建镜像处理类
			Handler handler = null;
			if (CommonConst.ARCHITECTURE_X86.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new VMWareHandler();
			}
			else if (CommonConst.ARCHITECTURE_POWER.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new PowerHandler();
			}
			else if (CommonConst.ARCHITECTURE_ZSYSTEM.equals(applianceSummaryMap
					.get("architecture").toString().toUpperCase())) {
				handler = new ZSystemHandler();
			}
			if (handler == null) {
				throw new CloudRestException("未知的体系架构");
			}
			//构建工作负载的Http连接
			HttpURLConnection conn = buildWorkloadsByApplianceIdConn( applianceId, ip,  port,  userName,password);
			//获取虚拟机属性
			String workloadCustomization = buildResponseJson(conn);
			HashMap workloadIdMap = RESTUtilities.fromJSON(
					workloadCustomization, HashMap.class);
			String newWorkloadId = (String) workloadIdMap.get("id");
			logger.info("新增工作负载id:" + newWorkloadId);
			//如果部署目标不为空
			if(!"".equals(target)){//更新部署目标
				buildResponseJson(buildWorkloadTargetDryConn( newWorkloadId,cloudId, target, ip,  port,  userName,password));
				buildResponseJson(buildWorkloadTargetChangeConn( newWorkloadId,cloudId, target, ip,  port,  userName,password));
			}
			// 构建虚机信息
			HashMap<String, Object> properties = null;
			properties = handler.buildVMproperties(virtualname, projectId,
					appliance,target, description, diskSize, memorySize, cpuNum,
					networkConfigureId,ipAddr,args);
			//新建虚拟机  发起的PUT
			HttpURLConnection conn2 = buildPutWorkloadConn( newWorkloadId,properties, ip,  port, userName, password);
			buildResponseJson(conn2);
			logger.info("修改工作负载"+newWorkloadId+"基础信息");
			return newWorkloadId;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("添加虚拟机失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("添加虚拟机失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("添加虚拟机失败,IO错误");
		} 
	}
	public RestResponse removeVirtualMachine(String ip, int port,
      String userName, String password, String workloadId)
      throws CloudRestException {
	  RestResponse result = deleteVirtualMachine(ip, port, userName, password, workloadId);
	  try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      logger.error(e);
      throw new CloudRestException("睡眠出错");
    }
	  approveRequest(workloadId, ip, port, userName, password);
	  return result;
	}
	

	public RestResponse deleteVirtualMachine(String ip, int port,
			String userName, String password, String workloadId)
			throws CloudRestException {
		try {
			//构建删除虚拟机的连接
			HttpURLConnection conn = buildDeleteWorkloadConn(workloadId, ip,  port,userName,  password);
			String resultMsg = buildResponseJson(conn);
			return new RestResponse(conn.getResponseCode(), resultMsg);
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("撤销虚拟机失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("撤销虚拟机失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("撤销虚拟机失败,IO错误");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VirtualMachine> queryVirtualMachines(String ip, int port,
			String userName, String password) throws CloudRestException {
		try {
			List<VirtualMachine> virtualMachines = new ArrayList<VirtualMachine>();
			//构建查询虚拟机列表的连接
			HttpURLConnection conn = buildWorkloadsConn(ip, port,userName,  password);
			String resultMsg = buildResponseJson(conn);
			HashMap virtualMachinesMap = RESTUtilities.fromJSON(resultMsg,
					HashMap.class);
			//获取虚拟机列表
			List<Map> virtualMachineList = (List) virtualMachinesMap
					.get("workloads");
			VirtualMachine virtualMachine = null;
			for (Iterator<Map> iterator = virtualMachineList.iterator(); iterator
					.hasNext();) {
				//构建对应的虚拟机列表对象
				virtualMachine = new VirtualMachine();
				Map vmproperties = (Map) iterator.next();
				virtualMachine.setId((String) vmproperties.get("id"));
				virtualMachine.setName((String) vmproperties.get("name"));
				virtualMachine.setDescription((String) vmproperties
						.get("description"));
				virtualMachine.setHypervisor((String) vmproperties
						.get("hypervisor"));
				virtualMachine.setArchitecture((String) vmproperties
						.get("architecture"));
				virtualMachine.setState(new State((String) ((Map) vmproperties
						.get("state")).get("id"), (String) ((Map) vmproperties
						.get("state")).get("label")));
				if(vmproperties.get("cloudId") != null){
					// 获取所属底层环境oId
					String srcIdString = (String) vmproperties.get("cloudId");
					String cloudIdStr = srcIdString.split("/")[srcIdString
							.split("/").length - 1];
					virtualMachine.setSrcId(cloudIdStr.contains("+") ? cloudIdStr
							.substring(0, cloudIdStr.indexOf("+")) : cloudIdStr);
				}
				if ("FAILED".equals(virtualMachine.getState().getId())||"UNKNOWN".equals(virtualMachine.getState().getId())) {
					//logger.info("不添加到容器中的vm:"+virtualMachine.getId());
					continue;
				}
				// 构建基本CPU 内存
				queryWorkloadVirtualServerProperties(virtualMachine, ip, port,
						userName, password);
				if(virtualMachine.getVirtualServers().size()>0){
					// 构建存储设备
					virtualMachine.setDiskSize(queryVirtualServerDiskSize(ip, port,
							userName, password, virtualMachine.getVirtualServers()
									.get(0)));
				}
				virtualMachines.add(virtualMachine);
			}
			return virtualMachines;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,IO错误");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VirtualMachine> queryVirtualMachinesBasicInfo(String ip, int port,
			String userName, String password) throws CloudRestException{
		try {
			List<VirtualMachine> virtualMachines = new ArrayList<VirtualMachine>();
			HttpURLConnection conn = buildWorkloadsConn(ip, port,userName,  password);
			String resultMsg = buildResponseJson(conn);//获取虚拟机列表
			HashMap virtualMachinesMap = RESTUtilities.fromJSON(resultMsg,
					HashMap.class);
			List<Map> virtualMachineList = (List) virtualMachinesMap
					.get("workloads");
			VirtualMachine virtualMachine = null;
			for (Iterator<Map> iterator = virtualMachineList.iterator(); iterator
					.hasNext();) {//构建虚拟机基本信息
				virtualMachine = new VirtualMachine();
				Map vmproperties = (Map) iterator.next();
				virtualMachine.setId((String) vmproperties.get("id"));
				virtualMachine.setName((String) vmproperties.get("name"));
				virtualMachine.setDescription((String) vmproperties
						.get("description"));
				virtualMachine.setHypervisor((String) vmproperties
						.get("hypervisor"));
				virtualMachine.setArchitecture((String) vmproperties
						.get("architecture"));
				// 获取所属底层环境oId
				String srcId = (String) vmproperties.get("cloudId");
				String cloudIdStr = srcId.split("/")[srcId
						.split("/").length - 1];
				virtualMachine.setSrcId(cloudIdStr.contains("+") ? cloudIdStr
						.substring(0, cloudIdStr.indexOf("+")) : cloudIdStr);
				virtualMachine.setState(new State((String) ((Map) vmproperties
						.get("state")).get("id"), (String) ((Map) vmproperties
						.get("state")).get("label")));
				if ("FAILED".equals(virtualMachine.getState().getId())) {
					continue;
				}
				virtualMachines.add(virtualMachine);
			}
			return virtualMachines;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,IO错误");
		}
	}

	public String getVirtualMachine(String ip, int port, String userName,
			String password, String workloadId) throws CloudRestException {
		try {
			HttpURLConnection conn = buildWorkloadConn(workloadId, ip,  port,  userName,password);
			return buildResponseJson(conn);
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟机失败,IO错误");
		}
	}

	public int reconfigVirtualMachineDevice(String ip, int port,
      String userName, String password, String workloadId,
      String diskName, long diskSize, long memorySize, long cpuNum)
      throws CloudRestException {
	    int result = updateVirtualMachineDevice(ip, port, userName, password, workloadId, diskName, diskSize, memorySize, cpuNum);
	    //审核请求
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          logger.error(e);
          throw new CloudRestException("睡眠出错");
        }
        approveRequest(workloadId, ip, port, userName, password);
        return result;
      }
	
	@SuppressWarnings({ "rawtypes" })
	public int updateVirtualMachineDevice(String ip, int port,
			String userName, String password, String workloadId,
			String diskName, long diskSize, long memorySize, long cpuNum)
			throws CloudRestException {
		try {
			String response = getVirtualMachine(ip, port, userName,
					password, workloadId);
			HashMap vmproperties = RESTUtilities.fromJSON(
					response, HashMap.class);
			Handler handler = null;
			HashMap<String, Object> properties = null;
			if (CommonConst.ARCHITECTURE_X86.equals(vmproperties
					.get("architecture").toString().toUpperCase())) {
				handler = new VMWareHandler();
			}
			if (CommonConst.ARCHITECTURE_POWER.equals(vmproperties
					.get("architecture").toString().toUpperCase())) {
				handler = new PowerHandler();
			}
			if (CommonConst.ARCHITECTURE_ZSYSTEM.equals(vmproperties
					.get("architecture").toString().toUpperCase())) {
				handler = new ZSystemHandler();
			}
			if (handler == null) {
				throw new CloudRestException("未知的体系架构");
			}
			
			boolean isRun = false;
			if(CommonConst.ARCHITECTURE_X86.equals(vmproperties
					.get("architecture").toString().toUpperCase())){//X86
				if("STOPPED".equals(((Map) vmproperties.get("state")).get("id"))){// is stopped
					isRun =  false;
				} else if("OK".equals(((Map) vmproperties.get("state")).get("id"))) {// is ok
					isRun =  true;
				} else {
					throw new CloudRestException("只能在虚拟机状态为'确定'或者'停止'时，才能调整虚拟机");
				}
			}
			if (!"OK".equals(((Map) vmproperties.get("state")).get("id"))
					&& (CommonConst.ARCHITECTURE_POWER.equals(vmproperties
							.get("architecture").toString().toUpperCase()))) {// Power体系必须开机才能重新配置
				throw new RestException("Power虚拟机配置修改必须在开机状态");
			}
			// TODO Z 体系
			properties = handler.buildVMDeviceProperties(diskSize, memorySize,
					cpuNum,isRun);
			HttpURLConnection conn = buildPutWorkloadConn( workloadId, properties, ip,  port,  userName, password);
			buildResponseJson(conn);
			// TODO power 磁盘调整
			boolean needNewDisk = ((null != diskName) && !"".equals(diskName));
			String architecture = vmproperties.get("architecture").toString()
					.toUpperCase();
			if (CommonConst.ARCHITECTURE_POWER.equals(architecture)
					&& needNewDisk) {//构建
				VirtualMachine virtualMachine = new VirtualMachine();
				virtualMachine.setId(workloadId);
				virtualMachine.setArchitecture(architecture);
				queryWorkloadVirtualServerProperties(virtualMachine, ip, port,
						userName, password);
				String virtualServerId = virtualMachine.getVirtualServers()
						.get(0);
				HttpURLConnection conn2 = buildVirtualserverStorages( virtualServerId, diskName, diskSize, ip,  port,  userName,
						 password);//构建磁盘链接
				buildResponseJson(conn2);
				return conn2.getResponseCode();
			}
			return conn.getResponseCode();
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,IO错误");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RestResponse reconfigVirtualMachineBasicInfo(String ip, int port,
			String userName, String password, String workloadId, String name,
			String description) throws CloudRestException {
		try {
			String propertiesString = "{\"name\":\"" + name
					+ "\",\"description\":\"" + description
					+ "\",\"instances\":1}";
			HashMap properties = RESTUtilities.fromJSON(propertiesString,
					HashMap.class);
			HttpURLConnection conn = buildPutWorkloadConn(workloadId, properties, ip, port, userName, password);
			String createSummary = buildResponseJson(conn);//构建修改PUT链接
			return new RestResponse(conn.getResponseCode(), createSummary);
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("修改虚拟机配置失败,IO错误");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NetworkConfiguration> queryNetworkConfigurations(String ip,
			int port, String userName, String password)
			throws CloudRestException {
		List<NetworkConfiguration> networkConfigurations = new ArrayList<NetworkConfiguration>();
		try {
			HttpURLConnection conn =buildNetworkconfigurations( ip, port,userName,password);
			String networkConfigurationsJson = buildResponseJson(conn);
			HashMap<String, List> map = RESTUtilities.fromJSON(
					networkConfigurationsJson, HashMap.class);//构建查询网络配置列表
			NetworkConfiguration networkConfiguration = new NetworkConfiguration();
			for (Iterator<HashMap> iterator = map.get("networkConfigurations")
					.iterator(); iterator.hasNext();) {
				networkConfiguration = new NetworkConfiguration();
				HashMap hashMap = (HashMap) iterator.next();
				buildNetworkConfigurationFromMap(networkConfiguration, hashMap);
				if (networkConfiguration.getCloudId() != null) { // Power /Z 体系
					// 构建所属的云
					buildBeyondCloud(ip, port, userName, password,
							networkConfiguration);
				} else {
					networkConfiguration
							.setCloudType(CommonConst.ARCHITECTURE_X86);
				}
				networkConfigurations.add(networkConfiguration);
			}
			return networkConfigurations;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟网络配置出错,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟网络配置出错,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取虚拟网络配置出错,IO错误");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ZSystemHostPerf queryZSystemHostPerf(String ip, int port,
			String userName, String password, String hostIP)
			throws CloudRestException {
		try {
			ZSystemHostPerf zSystemHostPerf = new ZSystemHostPerf();
			HttpURLConnection conn = buildZvmHostConn(hostIP,ip,port,userName,password);
			HashMap map = RESTUtilities.fromJSON(buildResponseJson(conn),
					HashMap.class);//构建采集Z体系主机的连接
			List<Map> resources = (List<Map>) ((Map) ((List) map.get("stats"))
					.get(0)).get("resources");
			for (Iterator<Map> iterator = resources.iterator(); iterator
					.hasNext();) {
				Map resourceMap = (Map) iterator.next();
				String key = (String) resourceMap.get("id");
				if ("totalCPU".equals(key)) {
					zSystemHostPerf.setTotalCPU(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("totalMemory".equals(key)) {
					zSystemHostPerf.setTotalMemory(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("totalDisk".equals(key)) {
					zSystemHostPerf.setTotalDisk(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("freeDisk".equals(key)) {
					zSystemHostPerf.setFreeDisk(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("usageCPU".equals(key)) {
					zSystemHostPerf.setUsageCPU(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("usageMemory".equals(key)) {
					zSystemHostPerf.setUsageMemory(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
				if ("usageDisk".equals(key)) {
					zSystemHostPerf.setUsageDisk(Double.parseDouble(String
							.valueOf(resourceMap.get("value"))));
				}
			}
			return zSystemHostPerf;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,IO错误");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ZsystemVirtualMachinePerf> queryZSystemVirtualMachinePerf(String ip,
			int port, String userName, String password)
			throws CloudRestException {
		try {
			List<ZsystemVirtualMachinePerf> zsystemVirtualMachinePerfs = new ArrayList<ZsystemVirtualMachinePerf>();
			List<VirtualMachine> virtualMachineList = queryVirtualMachines(ip,
					port, userName, password);
			for (Iterator<VirtualMachine> iterator = virtualMachineList.iterator(); iterator.hasNext();) {
				VirtualMachine virtualMachine = (VirtualMachine) iterator.next();
				if (CommonConst.ARCHITECTURE_ZSYSTEM.equalsIgnoreCase(virtualMachine.getArchitecture())) {
					ZsystemVirtualMachinePerf zsystemVirtualMachinePerf = new ZsystemVirtualMachinePerf();
					zsystemVirtualMachinePerf.setOid(virtualMachine.getId());
					HttpURLConnection conn = buildZvmVirtualMachineConn(virtualMachine.getVirtualServers().get(0),ip,port,userName,password);
					HashMap map = RESTUtilities.fromJSON(buildResponseJson(conn),
							HashMap.class);
					List<Map> resources = (List<Map>) ((Map) ((List) map.get("stats"))
							.get(0)).get("resources");
					for (Iterator<Map> iterator2 = resources.iterator(); iterator2
							.hasNext();) {
						Map resourceMap = (Map) iterator2.next();
						String key = (String) resourceMap.get("id");
						if ("totalCPU".equals(key)) {
							zsystemVirtualMachinePerf.setTotalCPU(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
						if ("totalMemory".equals(key)) {
							zsystemVirtualMachinePerf.setTotalMemory(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
						if ("totalDisk".equals(key)) {
							zsystemVirtualMachinePerf.setTotalDisk(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
						if ("usageCPU".equals(key)) {
							zsystemVirtualMachinePerf.setUsageCPU(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
						if ("usageMemory".equals(key)) {
							zsystemVirtualMachinePerf.setUsageMemory(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
						if ("usageDisk".equals(key)) {
							zsystemVirtualMachinePerf.setUsageDisk(Double.parseDouble(String
									.valueOf(resourceMap.get("value"))));
						}
					}
					zsystemVirtualMachinePerfs.add(zsystemVirtualMachinePerf);
				}
			}
			return zsystemVirtualMachinePerfs;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取ZSystemHost性能失败,IO错误");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String swapVirtualMachineState(String vmId, String ip, int port,
			String userName, String password) throws CloudRestException {
		try {
			HttpURLConnection  conn  = buildWorkloadConn( vmId, ip,
					 port,  userName,  password);
			String workloadJson = buildResponseJson(conn);
			HashMap<String, List> map = RESTUtilities.fromJSON(
					workloadJson, HashMap.class);
			HashMap<String, Object> properties = new HashMap<String, Object>();
			if("STOPPED".equals(((Map)map.get("state")).get("id"))){//如果是关闭状态
				properties.put("state", "OK");
			}else {//如果是非关闭状态
				properties.put("state", "STOPPED");
			}
			HttpURLConnection  conn2 = buildPutWorkloadConn(vmId,properties, ip,  port,  userName, password);
			return  buildResponseJson(conn2);
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("改变虚拟机状态错误,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("改变虚拟机状态错误,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("改变虚拟机状态错误,IO错误");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SmartCloudEntryEvent> querySceEvent(String ip, int port,
			String userName, String password,long beginTime,long endTime,String level) throws CloudRestException {
		try {
			List<SmartCloudEntryEvent> events = new ArrayList<SmartCloudEntryEvent>();
			HttpURLConnection  conn  = buildZSystemEventConn(ip,
					 port,  userName,  password, beginTime, endTime, level);
			HashMap eventListMap = RESTUtilities.fromJSON(buildResponseJson(conn),
					HashMap.class);
			List<Map> eventsList = (List<Map>)eventListMap.get("events");
			SmartCloudEntryEvent event = null;
			for (Iterator<Map> iterator = eventsList.iterator(); iterator.hasNext();) {
				Map eventMap = (Map) iterator.next();
				event = new SmartCloudEntryEvent();
				event.setEventId(""+eventMap.get("id"));
				event.setEventType(""+eventMap.get("originator"));
				event.setSeverity((String)((Map)eventMap.get("severity")).get("id"));
				event.setOccurTime(new Date(Long.parseLong(""+eventMap.get("timestamp"))));
				List<Map> resList = (List)eventMap.get("resources");
				String formatMsg = ""+eventMap.get("message");
				int index = 0;
				for (Iterator iterator2 = resList.iterator(); iterator2
						.hasNext();) {
					Map res = (Map) iterator2.next();
					event.getRelatedResource().add(res);
					formatMsg = formatMsg.replace("${"+index+"}", ""+res.get("name"));
					index++;
				}
				event.setMessage(formatMsg);
				events.add(event);
			}
			return events;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取SCE事件出错,引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取SCE事件出错,不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException("获取SCE事件出错,IO错误");
		}
	}
}
