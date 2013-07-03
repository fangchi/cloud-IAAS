package com.hicomb.cloud.rest.https;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import junit.framework.TestCase;

import org.apache.xerces.impl.dv.util.Base64;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.util.HttpsUtil;
import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;

public class IBMHttpsConnctionTestCase extends TestCase {

	/**
	 * 测试IBM HTTPS
	 * @throws Exception
	 */
	public final void testHttpsConnction() throws Exception {
		SSLSocketFactory sslsocketFactory = HttpsUtil.getSSLSocketFactory("172.16.13.173", 8422, "Passw0rd");
		
		RestEngine restEngine = new DefaultRestEngine();
		HashMap<String, String> headHashMap  = new HashMap<String, String>();
		// create authorization token string for later
        String userInfo  = "administrator" + ":" + new String("Passw0rd");
        headHashMap.put("Authorization", "Basic " + Base64.encode(userInfo.getBytes()));
        headHashMap.put("Accept-Language", "en");
        headHashMap.put("Pragma", "no-cache, no-cache");
        headHashMap.put("ISDAPIVersion", CommonConst.SYSDIRECTOR_PRODUCT_VERSION);
        HttpsURLConnection conn = restEngine.processHttpsRequest(
				"https://172.16.13.173:8422/ibm/director/rest/VMControl/workloads", "GET", null,
				headHashMap,"UTF-8",sslsocketFactory,HttpsUtil.getHostNameVerifier());
        System.out.println(conn.getResponseMessage());
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));// 
		//assertEquals(RESTConstants.HTTP_OK, conn.getResponseCode());
		//assertEquals(true, conn.getContentType().contains("text/html"));
		
		StringBuffer lineBuffer = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			lineBuffer.append(line);
			lineBuffer.append(System.getProperty("line.separator"));
		}
		System.out.println(lineBuffer.toString());
		assertTrue(lineBuffer.toString().length()>0);
	}
}
