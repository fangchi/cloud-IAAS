package com.hicomb.cloud.rest.sysdirector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.HashMap;

import org.apache.xerces.impl.dv.util.Base64;

import com.hicomb.cloud.rest.common.CommonConst;

/**
 * Director引擎
 */
public abstract class AbstractSystemDirectorRestEngine implements SystemDirectorRestEngine{

	/**
	 * 构建HTTP请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	protected abstract String buildRequestURL(String hostIp,int port);
	
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
		bodyHashMap.put("Accept-Language", "en");
		bodyHashMap.put("Pragma", "no-cache, no-cache");
		bodyHashMap.put("ISDAPIVersion", CommonConst.SYSDIRECTOR_PRODUCT_VERSION);
		return bodyHashMap;
	}
	
	/**
	 * 获取返回String
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
}
