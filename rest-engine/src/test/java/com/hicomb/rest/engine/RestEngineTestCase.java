package com.hicomb.rest.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.apache.xerces.impl.dv.util.Base64;

import com.hicomb.rest.RestBaseTestCase;
import com.hicomb.rest.common.RESTConstants;
import com.hicomb.rest.engine.impl.DefaultRestEngine;

public class RestEngineTestCase extends RestBaseTestCase {

	   private static HostnameVerifier hostNameVerifier = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

	
	/**
	 * @throws Exception
	 */
	public final void testEngineDoGet() throws Exception {
		RestEngine restEngine = new DefaultRestEngine();
		HttpURLConnection conn = restEngine.processHttpRequest(
				"http://www.baidu.com", "GET", null,
				new HashMap<String, String>(),"UTF-8");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));// 
		assertEquals(RESTConstants.HTTP_OK, conn.getResponseCode());
		assertEquals(true, conn.getContentType().contains("text/html"));
		
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
			lineBuffer.append(System.getProperty("line.separator"));
		}
		assertTrue(lineBuffer.toString().length()>0);
	}
	
	/**
	 * @throws Exception
	 */
	public final void testEngineDoPost() throws Exception {
		RestEngine restEngine = new DefaultRestEngine();
		HashMap<String, String> proHashMap  = new HashMap<String, String>();
		proHashMap.put("Content-Type","application/x-www-form-urlencoded");
		
		HashMap<String, Object> bodyHashMap  = new HashMap<String, Object>();
		bodyHashMap.put("f", "a");
		HttpURLConnection conn = restEngine.processHttpRequest(
				"http://post.news.tom.com/s/34000AB31538.html", "POST", bodyHashMap,
				proHashMap,"UTF-8");
		assertEquals(RESTConstants.HTTP_OK, conn.getResponseCode());
		assertEquals(true, conn.getContentType().contains("text/html"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));// 
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
		}
		assertTrue(lineBuffer.toString().length()>0);
		
	}
	
	
	/**
	 * @throws Exception
	 */
	/*public final void testIBM() throws Exception {
		RestEngine restEngine = new DefaultRestEngine();
		HashMap<String, String> headHashMap  = new HashMap<String, String>();
		// create authorization token string for later
        String userInfo  = "admin" + ":" + new String("admin");
        headHashMap.put("Authorization", "Basic " + Base64.encode(userInfo.getBytes()));
		
		HttpURLConnection conn = restEngine.processHttpRequest(
				"http://172.16.13.171:8080/cloud/api/workloads", "GET", null,
				headHashMap,"UTF-8");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));// 
		assertEquals(RESTConstants.HTTP_OK, conn.getResponseCode());
		assertEquals(true, conn.getContentType().contains("json"));
		
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
			lineBuffer.append(System.getProperty("line.separator"));
		}
		assertTrue(lineBuffer.toString().length()>0);
		
	}*/
}
