package com.hicomb.bmc.bladelogic.rest.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.bmc.bladelogic.rest.common.BladeLogicCommonConst;
import com.hicomb.bmc.bladelogic.rest.entity.Job;
import com.hicomb.bmc.bladelogic.rest.entity.Server;
import com.hicomb.bmc.bladelogic.rest.exception.BladeLogicRestException;
import com.hicomb.bmc.bladelogic.rest.util.HttpsUtil;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;

public class BladeLogicRestManager {

	private static BladeLogicRestManager cachedInstance;
	
	private static final Log logger = LogFactory.getLog(BladeLogicRestManager.class);
	
	private final static String propertySetClassChildrenResponseStr = "PropertySetClassChildrenResponse";
	
	private final static String operationResultResponseStr = "OperationResultResponse";
	
	private final static String operationResultStr = "OperationResult";
	
	private final static String statusResponseStr = "StatusResponse";
	
	
	private final static String propertySetInstanceChildrenResponseStr = "PropertySetInstanceChildrenResponse";
	
	private final static String propertySetInstanceChildrenStr = "PropertySetInstanceChildren";
	
	private final static String propertySetClassChildrenStr = "PropertySetClassChildren";
	
	private final static String propertyValuesStr = "PropertyValues";
	
	/*private final static String propertyValueStr = "PropertyValue";
	
	private final static String propertySetClassesStr = "PropertySetClasses";*/
	
	private final static String propertySetInstanceResponseStr = "PropertySetInstanceResponse";
	
	private final static String propertySetInstancesStr = "PropertySetInstances";
	
	private final static String propertySetInstanceStr = "PropertySetInstance";
	
	private final static String elementsStr = "Elements"; 
	
	public synchronized static BladeLogicRestManager getInstance() {
		if (cachedInstance == null) {
			cachedInstance = new BladeLogicRestManager();
		}
		return cachedInstance;
	}
	
	
	/**
	 * 在对应服务器执行作业
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @param jobId 作业Id
	 * @param serverIds  需要执行作业的服务器Id列表
	 * @param needWaitResault 是否需要获取执行结果
	 */
	@SuppressWarnings({"rawtypes"})
	public HashMap executeJobOnServer(String ip, int port, String sslKey,
			String username, String password, String userRole,String jobId,String[] serverIds,boolean needWaitResault) throws BladeLogicRestException {
		try {
			// 构建操作参数
			List<HashMap<String, Object>> operationArgumentsMaps = new ArrayList<HashMap<String,Object>>();
	        HashMap<String, Object> operationArgumentMap = new HashMap<String, Object>();
	        operationArgumentMap.put("name", "servers");
	        operationArgumentMap.put("type", "/type/PropertySetClasses/SystemObject/Server");
	        ArrayList<String> uris = new ArrayList<String>();
	        for (int i = 0; i < serverIds.length; i++) {//指定对应的Server
	        	 uris.add("/id/SystemObject/Server/"+serverIds[i]);
			}
	        operationArgumentMap.put("uris",uris);
	        
	        HashMap<String, Object> operationArgumentMap1 = new HashMap<String, Object>();
	        operationArgumentMap1.put("name", "servicename");
	        operationArgumentMap1.put("type", "String");
	        operationArgumentMap1.put("value","Appinfo");
	        
	        operationArgumentsMaps.add(operationArgumentMap);
	        operationArgumentsMaps.add(operationArgumentMap1);
	        
	        HashMap<String, Object> paramHashMap  = new HashMap<String, Object>();
	        paramHashMap.put("OperationArguments", operationArgumentsMaps);
	        // 执行Rest引擎
	        HttpsURLConnection conn = new DefaultRestEngine()
				.processHttpsRequest(
					generateUrlWithCredentialsMap(
							BladeLogicCommonConst.BLADELOGIC_JOB_EXEUTEON_SERVER_URL
									.replace("{id}",jobId), ip, port, username,
							password, userRole), BladeLogicCommonConst.HTTP_METHOD_POST, paramHashMap,
					generateCommmonHeader(), "UTF-8",
					generateSSLFactory(ip, port, sslKey), HttpsUtil
							.getHostNameVerifier());
	        HashMap responseMap = RESTUtilities.fromJSON(buildResponseJson(conn), HashMap.class);
	        String resultStr = "{}";
	        String statusStr = "RUNNING";
	        HashMap  responseMsg = null;
	        //如果需要等待执行结果
	        if(needWaitResault){
	        	while("{}".equals(resultStr)||(!"COMPLETE".equals(statusStr))){//如果任务没有完成
	        		Thread.sleep(1000);
	        		String[] pathStrings = {operationResultResponseStr,operationResultStr};
		        	Map result = (Map)getPropertiesFromMap(responseMap,pathStrings);
		        	String statusValue = (String) result.get("value");
		        	conn = new DefaultRestEngine().processHttpsRequest(
						generateUrlWithCredentialsMap(
								statusValue.replaceAll(" ", "%20"), ip, port, username,
								password, userRole), BladeLogicCommonConst.HTTP_METHOD_GET, null,
						generateCommmonHeader(), "UTF-8",
						generateSSLFactory(ip, port, sslKey), HttpsUtil
								.getHostNameVerifier());
		        	HashMap resultsMap = RESTUtilities.fromJSON(buildResponseJson(conn), HashMap.class);
		        	responseMsg =  (HashMap)resultsMap.get(statusResponseStr);
		        	resultStr = responseMsg.toString().replaceAll(" ", "");
		        	if(((HashMap)responseMsg.get("Status")!=null)){
		        		statusStr = (String)((HashMap)responseMsg.get("Status")).get("status");
		        	}
	        	}
	        	return responseMsg;
	        }
	        return responseMap;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("Rest引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("IO异常");
		} catch (InterruptedException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("线程异常");
		}
	}
	
	/**
	 * 获取服务器明细
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @param server 服务器实体
	 * @throws BladeLogicRestException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getServerDetail(String ip, int port, String sslKey,
			String username, String password, String userRole,Server server) throws BladeLogicRestException{
		try {
			HttpsURLConnection conn = new DefaultRestEngine()
			.processHttpsRequest(
					generateUrlWithCredentialsMap(
							BladeLogicCommonConst.BLADELOGIC_QUERY_SERVER_URL
									.replace("{id}", server.getObjectId()), ip, port, username,
							password, userRole), BladeLogicCommonConst.HTTP_METHOD_GET, null,
					generateCommmonHeader(), "UTF-8",
					generateSSLFactory(ip, port, sslKey), HttpsUtil
							.getHostNameVerifier());
			HashMap responseMap = RESTUtilities.fromJSON(buildResponseJson(conn), HashMap.class);
			String[] pathStrings = {propertySetInstanceChildrenResponseStr,propertySetInstanceChildrenStr,propertyValuesStr,elementsStr};
			List elements = (List)getPropertiesFromMap(responseMap,pathStrings);
			for (Iterator<Map> iterator = elements.iterator(); iterator.hasNext();) {
				Map propertyValue = (Map) iterator.next();
				if("HOST".equals(propertyValue.get("name"))){
					server.setHost((String)propertyValue.get("value"));
				} else if("IP_ADDRESS".equals(propertyValue.get("name"))){
					server.setIpAddr((String)propertyValue.get("value"));
				} else if("AGENT_STATUS".equals(propertyValue.get("name"))){
					server.setAgentStatus((String)propertyValue.get("value"));
				} else if("OS_VENDOR".equals(propertyValue.get("name"))){
					server.setOsVendor((String)propertyValue.get("value"));
				} else if("OS_PLATFORM".equals(propertyValue.get("name"))){
					server.setOsPlatform((String)propertyValue.get("value"));
				} else if("OS".equals(propertyValue.get("name"))){
					server.setOs((String)propertyValue.get("value"));
				} else if("OS_VERSION".equals(propertyValue.get("name"))){
					server.setOsVersion((String)propertyValue.get("value"));
				} else if("IS_ONLINE".equals(propertyValue.get("name"))){
					server.setOnline(Boolean.parseBoolean((String)propertyValue.get("value")));
				} else {
					server.addProperty((String)propertyValue.get("name"), propertyValue.get("value"));
				}
			}
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("Rest引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("IO异常");
		}
	}
	
	/**
	 * 获取服务器列表
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @return 
	 * @throws BladeLogicRestException
	 */
	@SuppressWarnings({"rawtypes" })
	public List<Server> getServers(String ip, int port, String sslKey,
			String username, String password, String userRole)throws BladeLogicRestException{
		List<Server> servers = new ArrayList<Server>();
		List<Map> serverMaps = getSystemObjectList( ip,  port,  sslKey,
			 username,  password,  userRole, "Server");
		for (Iterator<Map> iterator = serverMaps.iterator(); iterator.hasNext();) {
			Map object = (Map) iterator.next();
			Server server = new Server((String)object.get("objectId"));
			server.setName((String)object.get("name"));
			server.setDescription((String)object.get("description"));
			getServerDetail( ip,port,sslKey,username,password,userRole,server);//获取明细
			servers.add(server);
		}
		return servers;
	}
	
	/**
	 * 获取作业明细
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @param job 服务器实体
	 * @throws BladeLogicRestException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getJobDetail(String ip, int port, String sslKey,
			String username, String password, String userRole,Job job) throws BladeLogicRestException{
		try {
			HttpsURLConnection conn = new DefaultRestEngine()
			.processHttpsRequest(
					generateUrlWithCredentialsMap(
							job.getUrl(), ip, port, username,
							password, userRole).replaceAll(" ", "%20"), BladeLogicCommonConst.HTTP_METHOD_GET, null,
					generateCommmonHeader(), "UTF-8",
					generateSSLFactory(ip, port, sslKey), HttpsUtil
							.getHostNameVerifier());
			HashMap responseMap = RESTUtilities.fromJSON(buildResponseJson(conn), HashMap.class);
			String[] pathStrings = {propertySetInstanceResponseStr,propertySetInstanceStr,propertyValuesStr,elementsStr};
			List elements = (List)getPropertiesFromMap(responseMap,pathStrings);
			for (Iterator<Map> iterator = elements.iterator(); iterator.hasNext();) {
				Map propertyValue = (Map) iterator.next();
				if("DATE_CREATED".equals(propertyValue.get("name"))){
					job.setDateCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)propertyValue.get("value")));
				} else if("USER_CREATED".equals(propertyValue.get("name"))){
					job.setUserCreated((String)propertyValue.get("value"));
				} else if("PRIORITY*".equals(propertyValue.get("name"))){
					job.setPriority((String)propertyValue.get("value"));
				} else {
					job.addProperty((String)propertyValue.get("name"), propertyValue.get("value"));
				}
			}
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("Rest引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("IO异常");
		} catch (ParseException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("解析日期异常");
		}
	}
	
	/**
	 * 获取作业列表
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @return 
	 * @throws BladeLogicRestException
	 */
	@SuppressWarnings({"rawtypes" })
	public List<Job> getJobs(String ip, int port, String sslKey,
			String username, String password, String userRole)throws BladeLogicRestException{
		List<Job> jobs = new ArrayList<Job>();
		List<Map> jobMaps = getSystemObjectList( ip,  port,  sslKey,
			 username,  password,  userRole, "Job");
		for (Iterator<Map> iterator = jobMaps.iterator(); iterator.hasNext();) {
			Map object = (Map) iterator.next();
			Job job = new Job((String)object.get("objectId"));
			job.setName((String)object.get("name"));
			job.setDbkey((String)object.get("dbKey"));
			job.setDescription((String)object.get("description"));
			job.setUrl((String)object.get("uri"));
			job.setModelType((String)object.get("modelType"));
			getJobDetail( ip,port,sslKey,username,password,userRole,job);//获取明细
			jobs.add(job);
		}
		return jobs;
	}
	
	
	/**
	 * 获取系统对象
	 * @param ip 服务器IP
	 * @param port 服务器端口
	 * @param sslKey sslKey
	 * @param username 用户名
	 * @param password 密码
	 * @param userRole 用户角色
	 * @param type 对象类别
	 * @return 
	 * @throws BladeLogicRestException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<Map> getSystemObjectList(String ip, int port, String sslKey,
			String username, String password, String userRole, String type) throws BladeLogicRestException{
		try {
			HttpsURLConnection conn = new DefaultRestEngine()
					.processHttpsRequest(
							generateUrlWithCredentialsMap(
									BladeLogicCommonConst.BLADELOGIC_QUERY_SYSTEMOBJECTS_URL
											.replace("{type}", type), ip, port, username,
									password, userRole), BladeLogicCommonConst.HTTP_METHOD_GET, null,
							generateCommmonHeader(), "UTF-8",
							generateSSLFactory(ip, port, sslKey), HttpsUtil
									.getHostNameVerifier());
			HashMap responseMap = RESTUtilities.fromJSON(
					buildResponseJson(conn), HashMap.class);
			String[] pathStrings = {propertySetClassChildrenResponseStr,propertySetClassChildrenStr,propertySetInstancesStr,elementsStr};
			//获取列表
			List<Map> elements = (List<Map>)getPropertiesFromMap(responseMap,pathStrings);
			return elements;
		} catch (RestException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("Rest引擎错误");
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("不支持的编码");
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
			throw new BladeLogicRestException("IO异常");
		}
	}
	
	private BladeLogicRestManager() {
		super();
	}

	/**
	 * 获取响应的字符串（JSON）
	 * @param conn
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	protected String buildResponseJson(HttpURLConnection conn) throws UnsupportedEncodingException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "gbk"));// 
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
			lineBuffer.append(System.getProperty("line.separator"));
		}
		return lineBuffer.toString();
	}
	
	/**
	 * 构建SSLSocket工厂
	 * 
	 * @param ip
	 * @param port
	 * @param sslKey
	 * @return
	 * @throws RestException
	 */
	protected SSLSocketFactory generateSSLFactory(String ip, int port,
			String sslKey) throws RestException {
		SSLSocketFactory sslsocketFactory = HttpsUtil.getSSLSocketFactory(ip,
				port, sslKey);
		return sslsocketFactory;
	}

	/**
	 * 构建请求头
	 */
	protected HashMap<String, String> generateCommmonHeader()
			throws RestException {
		HashMap<String, String> headHashMap = new HashMap<String, String>();
		headHashMap.put("Accept", "application/json");// 请求BladeLogic返回Json
		headHashMap.put("Pragma", "no-cache, no-cache");
		headHashMap.put("Content-Type","application/json");
		return headHashMap;
	}

	/**
	 * 生成URL
	 * @param url
	 * @param ip
	 * @param port
	 * @param userId
	 * @param password
	 * @param userRole
	 * @return
	 * @throws RestException
	 */
	protected String generateUrlWithCredentialsMap(String url, String ip,
			int port, String userId, String password, String userRole)
			throws RestException {
		HashMap<String, Object> credentialsMap = new HashMap<String, Object>();
		credentialsMap.put("username", userId);
		credentialsMap.put("password", password);
		credentialsMap.put("role", userRole);
		String wholeUrl = BladeLogicCommonConst.HTTPS_SCHEMA
				+ ip + ":" + port + RESTUtilities.createURIWithSimpleParameters(url,
						credentialsMap);
		return wholeUrl;
	}
	
	/**
	 * 获取属性
	 * @param oriMap
	 * @param path 路径列表
	 * @return
	 */
	@SuppressWarnings({"rawtypes"})
	protected Object getPropertiesFromMap(HashMap oriMap,String[] path){
		HashMap currentPropertiesMap = oriMap;
		for (int i = 0; i < path.length -1; i++) {
			currentPropertiesMap = (HashMap)currentPropertiesMap.get(path[i]);
		}
		return currentPropertiesMap.get(path[path.length-1]);
	}
}
