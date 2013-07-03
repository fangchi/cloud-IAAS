package com.hicomb.cloud.rest.sce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.xerces.impl.dv.util.Base64;

import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;
import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.sce.entity.LabelObject;
import com.hicomb.cloud.rest.sce.entity.State;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.network.NetworkConfiguration;

/**
 * SCE Rest引擎抽象类
 */
public abstract class AbstractSmartCloudEntryRestEngine implements
		SmartCloudEntryRestEngine {

	/**
	 * 构建HTTP请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	protected abstract String buildRequestURL(String hostIp,int port);
	
	/**
	 * 从Map构建镜像
	 * @param appliance
	 * @param map
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	protected void buildApplianceFromMap(Appliance appliance,Map map){
		appliance.setId((String)map.get("id"));
		appliance.setChangedDate(new Date((Long)map.get("changedDate")));
		appliance.setArchitecture((String)map.get("architecture"));
		appliance.setDescription((String)map.get("description"));
		appliance.setHypervisor((String)map.get("hypervisor"));
		appliance.setName((String)map.get("name"));
		appliance.setState(new State(((Map<String,String>)map.get("state")).get("id"), ((Map<String,String>)map.get("state")).get("label")));
	}
	
	/**
	 * 从Map构建网络配置
	 * @param networkConfiguration
	 * @param map
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	protected void buildNetworkConfigurationFromMap(NetworkConfiguration networkConfiguration,Map map){
		networkConfiguration.setId((String)map.get("id"));
		networkConfiguration.setName((String)map.get("name"));
		networkConfiguration.setDescription((String)map.get("description"));
		networkConfiguration.setCloudId((String)map.get("cloudId"));
		if(map.get("dns1")!=null){
			networkConfiguration.setDns1(new LabelObject(((Map<String,String>)map.get("dns1")).get("id"), ((Map<String,String>)map.get("dns1")).get("label")));
		}if(map.get("dns2")!=null){
			networkConfiguration.setDns2(new LabelObject(((Map<String,String>)map.get("dns2")).get("id"), ((Map<String,String>)map.get("dns2")).get("label")));
		}if(map.get("domain")!=null){
			networkConfiguration.setDomain(new LabelObject(((Map<String,String>)map.get("domain")).get("id"), ((Map<String,String>)map.get("domain")).get("label")));
		}if(map.get("gateway1")!=null){
			networkConfiguration.setGateway1(new LabelObject(((Map<String,String>)map.get("gateway1")).get("id"), ((Map<String,String>)map.get("gateway1")).get("label")));
		}if(map.get("gateway2")!=null){
			networkConfiguration.setGateway2(new LabelObject(((Map<String,String>)map.get("gateway2")).get("id"), ((Map<String,String>)map.get("gateway2")).get("label")));
		}if(map.get("subnet")!=null){
			networkConfiguration.setSubnet(new LabelObject(((Map<String,String>)map.get("subnet")).get("id"), ((Map<String,String>)map.get("subnet")).get("label")));
		}if(map.get("usedCount")!=null){
			networkConfiguration.setUsedCount((Integer)map.get("usedCount"));
		}if(map.get("usedCount")!=null){
			networkConfiguration.setUseDHCP(new LabelObject(((Map<String,String>)map.get("useDHCP")).get("id"), ((Map<String,String>)map.get("useDHCP")).get("label")));
		}if(map.get("wins1")!=null){
			networkConfiguration.setWins1(new LabelObject(((Map<String,String>)map.get("wins1")).get("id"), ((Map<String,String>)map.get("wins1")).get("label")));
		}if(map.get("wins2")!=null){
			networkConfiguration.setWins2(new LabelObject(((Map<String,String>)map.get("wins2")).get("id"), ((Map<String,String>)map.get("wins2")).get("label")));
		}
	}
	
	/**
	 * 构建用户token
	 * @param userName
	 * @param password
	 * @return
	 */
	protected HashMap<String, String> buildUserToken(String userName,String password){
		HashMap<String, String> bodyHashMap  = new HashMap<String, String>();
		String userInfo  =userName+ ":" + new String(password);
		bodyHashMap.put("Authorization", "Basic " + Base64.encode(userInfo.getBytes()).replaceAll("\n", ""));
		return bodyHashMap;
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
				conn.getInputStream(), "utf-8"));// 
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
			lineBuffer.append(System.getProperty("line.separator"));
		}
		return lineBuffer.toString();
	}
	
	/**
	 * 获取镜像的详细信息
	 * @param applianceId
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 * @throws RestException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected HashMap<String, Object> getApplianceSummary(String applianceId,
			String hostIp, int port, String userName, String password) throws RestException, UnsupportedEncodingException, IOException{
		HashMap<String, String> headerToken = buildUserToken(userName,
				password);
		//获取镜像明细
		String applianceDetailPath = buildRequestURL(hostIp, port)
		+ CommonConst.SCE_QUERY_APPLIANCES_DETAIL_URL.replace("{id}", applianceId);
		RestEngine queryApplianceEngine = new DefaultRestEngine();
		//获取镜像属性
		HttpURLConnection queryConn = queryApplianceEngine.processHttpRequest(applianceDetailPath,
				"GET", null, headerToken,"UTF-8");
		String applianceSummary = buildResponseJson(queryConn);
		return  RESTUtilities.fromJSON(applianceSummary, HashMap.class);
	}
}
