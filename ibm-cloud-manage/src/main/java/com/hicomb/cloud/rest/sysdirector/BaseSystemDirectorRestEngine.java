package com.hicomb.cloud.rest.sysdirector;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.event.SystemDirectorEvent;
import com.hicomb.cloud.rest.sysdirector.entity.host.PowerHost;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPool;
import com.hicomb.cloud.rest.sysdirector.entity.systempool.SystemPoolPerf;
import com.hicomb.cloud.rest.sysdirector.entity.vm.PowerVirtualMachinePerf;
import com.hicomb.cloud.rest.util.HttpsUtil;
import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;

/**
 * Director引擎
 */
public abstract class BaseSystemDirectorRestEngine extends
		AbstractSystemDirectorRestEngine {

	private static final Log logger = LogFactory
			.getLog(BaseSystemDirectorRestEngine.class);
	
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
	 * 构建查询Power主机的Http连接
	 * @param host 主机对象
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildPowerHostConn(PowerHost host, String hostIp, int port,
			String userName, String password) throws Exception{
		String basePath = buildRequestURL(hostIp, port)
				+ CommonConst.SYSDIRECTOR_QUERY_POWER_HOST_URL.replace(
						"{id}", host.getOID());
		return (HttpsURLConnection)buildConnFromURL(basePath,hostIp, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建Power主机存储连接
	 * @param host 主机对象
	 * @param hostIp 
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildPowerHostStorageConn(PowerHost host, String hostIp, int port,
			String userName, String password) throws Exception{
		String relateStoragePath = buildRequestURL(hostIp, port)
			+ CommonConst.SYSDIRECTOR_QUERY_POWER_HOST_STORAGES_URL
				.replace("{id}", host.getOID());
		return (HttpsURLConnection)buildConnFromURL(relateStoragePath,hostIp, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建系统池连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildSystemPoolsConn(String ip, int port,
			String userName, String password) throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_SYSTEMPOOLS_URL;
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建系统池性能连接
	 * @param oid
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildSystemPoolsPerfConn(String oid,String ip, int port,
			String userName, String password) throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_SYSTEMPOOLPERF_URL.replace(
						"{id}", oid);
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建主机连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildHostConn(String ip, int port, String userName,
			String password) throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_POWER_HOSTS_URL;
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建Power虚拟机性能连接
	 * @param serverId
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildPowervmPerfConn(String serverId ,String hostIp,
			int port, String userName, String password)throws Exception{
		String basePath = buildRequestURL(hostIp, port)
				+ CommonConst.SYSDIRECTOR_QUERY_POWERVMPERF_URL.replace(
						"{id}", serverId);
		return (HttpsURLConnection)buildConnFromURL(basePath,hostIp, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建SystemDirecitor事件列表连接
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param beginDate 开始时间
	 * @param endTime 结束时间
	 * @param severity 安全等级
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildSystemDirectorEventsConn(String ip,
			int port, String userName, String password,long beginDate,long endDate,String severity)throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_EVENTS_URL.replace(
						"{beginDate}", ""+beginDate).replace("{endDate}", ""+endDate)
						.replace("{severity}", severity);
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建SystemDirecitor事件连接
	 * @param eventId 事件编号
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpsURLConnection buildSystemDirectorEventConn(String eventId,String ip,
			int port, String userName, String password)throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_EVENT_URL.replace("{id}", ""+eventId);
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	/**
	 * 构建事件管理资源连接
	 * @param componentType
	 * @param resOId
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HttpURLConnection buildEventRelatedResourceConn(String componentType,String resOId,String ip,
			int port, String userName, String password)throws Exception{
		String basePath = buildRequestURL(ip, port)
				+ CommonConst.SYSDIRECTOR_QUERY_EVENTRELATEDRESOURCE_URL.replace("{componentType}", ""+componentType).replace("{resOId}", resOId);
		return (HttpsURLConnection)buildConnFromURL(basePath,ip, port,userName,password,CommonConst.HTTP_METHOD_GET,null);
	}
	
	
	/**
	 * 构建Power主机性能
	 * @param host power主机
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @throws CloudRestException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void buildHostProperties(PowerHost host, String hostIp, int port,
			String userName, String password) throws CloudRestException {
		try {
			//构建Power主机
			HttpURLConnection conn = buildPowerHostConn( host,  hostIp,  port,userName,  password);
			String response = buildResponseJson(conn);
			HashMap hostPropertiesMaps = RESTUtilities.fromJSON(response,
					HashMap.class);
			//Host属性
			Map propertiesMap = (Map) hostPropertiesMaps.get("properties");
			//获取内存相关信息
			host.setMemoryCapacity(Double.parseDouble(String
					.valueOf(propertiesMap.get("Memory.Capacity"))));
			host.setMemoryMaximumAllocation(Double.parseDouble(String
					.valueOf(propertiesMap.get("Memory.MaximumAllocation"))));
			//获取处理器相关信息
			host.setProcessorCapacity(Double.parseDouble(String
					.valueOf(propertiesMap.get("Processor.Capacity"))));
			host.setProcessorMaximumAllocationInt(Double.parseDouble(String
					.valueOf(propertiesMap.get("Processor.MaximumAllocation"))));
			HttpURLConnection conn2 = buildPowerHostStorageConn( host,hostIp,port,userName,password);
			//构建存储器相关信息
			double totalStorage = 0;
			double totalAvailableStorage = 0;
			List<Map> storageProperties = (List<Map>) RESTUtilities.fromJSON(
					buildResponseJson(conn2), HashMap.class)
					.get("storagePools");
			for (Iterator<Map> iterator = storageProperties.iterator(); iterator
					.hasNext();) {
				Map storagePropertiy = (Map) iterator.next();
				totalStorage = totalStorage
						+ Double.parseDouble(String.valueOf(storagePropertiy
								.get("totalStorage")));
				totalAvailableStorage = totalAvailableStorage
						+ Double.parseDouble(String.valueOf(storagePropertiy
								.get("availableStorage")));
			}
			host.setStorageCapacity(totalStorage);
			host.setStorageAllocation(totalAvailableStorage);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SystemPool> querySystemPool(String ip, int port,
			String userName, String password) throws CloudRestException {
		try {
			List<SystemPool> systemPools = new ArrayList<SystemPool>();
			HttpURLConnection conn = buildSystemPoolsConn( ip,  port,userName,  password);
			HashMap systemPoolMaps = RESTUtilities.fromJSON(
					buildResponseJson(conn), HashMap.class);//构建系统连接池
			List systemPoolMapList = (List) systemPoolMaps.get("resources");
			for (Iterator<Map> iterator = systemPoolMapList.iterator(); iterator
					.hasNext();) {
				Map systemPool = (Map) iterator.next();
				systemPools.add(new SystemPool(String.valueOf(systemPool
						.get("Name")), String.valueOf(systemPool.get("OID"))));
			}
			return systemPools;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SystemPoolPerf querySystemPoolPerf(String ip, int port,
			String userName, String password, String oid)
			throws CloudRestException {
		try {
			SystemPoolPerf systemPoolPerf = new SystemPoolPerf();
			systemPoolPerf.setOID(oid);
			HttpURLConnection conn = buildSystemPoolsPerfConn(oid, ip,  port, userName,  password);
			HashMap systemPoolPerfMaps = RESTUtilities.fromJSON(
					buildResponseJson(conn), HashMap.class);
			List systemPoolPerfMapList = (List) systemPoolPerfMaps
					.get("monitordata");//获取监控数据
			for (Iterator<Map> iterator = systemPoolPerfMapList.iterator(); iterator
					.hasNext();) {
				Map systemPoolPerfMap = (Map) iterator.next();
				if ("Valid".equals(systemPoolPerfMap.get("Status"))) {//如果数据可靠
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("totalstorage")) {//获取存储相关性能
						systemPoolPerf.setTotalstorage(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("freestorage")) {
						systemPoolPerf.setFreestorage(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("allocatedstorage")) {
						systemPoolPerf.setAllocatedstorage(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("freememory")) {//获取内存方面性能
						systemPoolPerf.setFreememory(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("allocatedmemory")) {
						systemPoolPerf.setAllocatedmemory(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("totalmemory")) {
						systemPoolPerf.setTotalmemory(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("freeprocessor")) {//获取处理器相关的性能
						systemPoolPerf.setFreeprocessor(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("allocatedprocessor")) {
						systemPoolPerf.setAllocatedprocessor(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("totalprocessor")) {
						systemPoolPerf.setTotalprocessor(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
					if (String.valueOf(systemPoolPerfMap.get("MonitorDataID"))
							.contains("avgcpuutilization")) {
						systemPoolPerf.setAvgcpuutilization(Double
								.parseDouble((String) systemPoolPerfMap
										.get("Value")));
					}
				}
			}
			return systemPoolPerf;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PowerHost> queryHosts(String ip, int port, String userName,
			String password) throws CloudRestException {
		try {
			List<PowerHost> hosts = new ArrayList<PowerHost>();
			HttpURLConnection conn = buildHostConn(ip,port,userName, password);//获取Hosts
			HashMap hostsMaps = RESTUtilities.fromJSON(buildResponseJson(conn),
					HashMap.class);
			List<Map> hostsMap = (List<Map>) hostsMaps.get("hosts");
			PowerHost host;
			for (Iterator<Map> iterator = hostsMap.iterator(); iterator
					.hasNext();) {
				host = new PowerHost();
				Map hostMap = (Map) iterator.next();
				host.setOID(String.valueOf(hostMap.get("oid")));
				host.setName(String.valueOf(hostMap.get("name")));
				buildHostProperties(host, ip, port, userName, password);
				hosts.add(host);
			}
			return hosts;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PowerVirtualMachinePerf queryPowerVirtualMachinePerf(String ip,
			int port, String userName, String password, String serverId)
			throws CloudRestException {
		try {
			PowerVirtualMachinePerf powerVirtualMachinePerf = new PowerVirtualMachinePerf();
			HttpURLConnection conn = buildPowervmPerfConn(serverId, ip,port,userName,password);
			HashMap monitordataMaps = RESTUtilities.fromJSON(
					buildResponseJson(conn), HashMap.class);
			List<Map> monitordataList = (List<Map>) monitordataMaps
					.get("monitordata");//获取虚拟机相关性能
			for (Iterator<Map> iterator = monitordataList.iterator(); iterator
					.hasNext();) {
				Map monitordata = (Map) iterator.next();
				if (String.valueOf(monitordata.get("DisplayName")).contains(
						"CPU % Utilization")
						&& "Valid".equals(monitordata.get("Status"))) {
					powerVirtualMachinePerf.setCpuUsage(monitordata
							.get("Value") == null ? 0 : Double
							.parseDouble(String.valueOf(monitordata
									.get("Value"))));
				}
				if (String.valueOf(monitordata.get("DisplayName")).contains(
						"Memory Usage")
						&& "Valid".equals(monitordata.get("Status"))) {
					powerVirtualMachinePerf.setMemoryUsage(monitordata
							.get("Value") == null ? 0 : Double
							.parseDouble(String.valueOf(monitordata
									.get("Value"))));
				}
				if (String.valueOf(monitordata.get("DisplayName")).contains(
						"True Memory Size")
						&& "Valid".equals(monitordata.get("Status"))) {
					powerVirtualMachinePerf.setMemoryallocation(monitordata
							.get("Value") == null ? 0 : Double
							.parseDouble(String.valueOf(monitordata
									.get("Value"))));
				}
				// TODO diskSize 采集
				powerVirtualMachinePerf.setUsedDisk(0);
				powerVirtualMachinePerf.setTotalDisk(0);
			}
			return powerVirtualMachinePerf;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SystemDirectorEvent>  querySystemDirectorEvents(String ip, int port, String userName,
			String password,long beginDate,long endDate,String severity)
			throws CloudRestException {
		try {
			List<SystemDirectorEvent> resEventList = new ArrayList<SystemDirectorEvent>();
			HttpURLConnection conn = buildSystemDirectorEventsConn(ip,port,userName,password,beginDate,endDate,severity);
			HashMap eventListMap = RESTUtilities.fromJSON(
					buildResponseJson(conn), HashMap.class);
			List<Map> eventList = (List<Map>)eventListMap.get("events");//获取事件列表
			SystemDirectorEvent systemDirectorEvent = null;
			for (Iterator<Map> iterator = eventList.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				systemDirectorEvent =new SystemDirectorEvent();//构建基本属性
				systemDirectorEvent.setEventId(""+map.get("EventID"));//id
				systemDirectorEvent.setContent(""+map.get("EventText"));//内容
				systemDirectorEvent.setSeverity(""+map.get("Severity"));//安全级别
				systemDirectorEvent.setComponentType(""+map.get("ComponentType"));//组建类型
				HttpURLConnection conn2 = buildSystemDirectorEventConn(systemDirectorEvent.getEventId(),ip,port,userName,password);
				HashMap eventDetailMap = RESTUtilities.fromJSON(
						buildResponseJson(conn2), HashMap.class);
				systemDirectorEvent.setOccurTime(new Date(Long.parseLong(""+((Map)eventDetailMap.get("GeneratedDate")).get("Date"))));//获取发生事件
				systemDirectorEvent.setResId(""+eventDetailMap.get("ResourceOID"));//设置资源
				resEventList.add(systemDirectorEvent);
				if(systemDirectorEvent.getComponentType()!=null && eventDetailMap.get("ResourceOID")!=null){
					HttpURLConnection conn3 = buildEventRelatedResourceConn(systemDirectorEvent.getComponentType(),eventDetailMap.get("ResourceOID").toString(),ip,port,userName,password);
					try {
						HashMap relatedResourceDetailMap = RESTUtilities.fromJSON(
								buildResponseJson(conn3), HashMap.class);//进一步获取对应的主机的信息
						HashMap properties = (HashMap)relatedResourceDetailMap.get("Properties");
						systemDirectorEvent.setResDescription((String)properties.get("Description"));
						systemDirectorEvent.setResDisplayName((String)properties.get("DisplayName"));
						
						List<String> iPv4AddressesList = (List<String>)properties.get("IPv4Address");
						if(iPv4AddressesList != null && iPv4AddressesList.size()>=1){
							systemDirectorEvent.setResIp(iPv4AddressesList.get(0));
						}
						List<String> hostNameList = (List<String>)properties.get("HostName");
						if(hostNameList != null && hostNameList.size()>=1){
							systemDirectorEvent.setResHostIp(hostNameList.get(0));
						}
					} catch (Exception e) {
						systemDirectorEvent.setResDescription("");
						systemDirectorEvent.setResDisplayName("");
						systemDirectorEvent.setResIp("");
						systemDirectorEvent.setResHostIp("");
					}
					
				}
			}
			return resEventList;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}
	}
}
