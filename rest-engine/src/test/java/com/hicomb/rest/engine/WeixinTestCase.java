package com.hicomb.rest.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import com.hicomb.rest.common.RESTConstants;
import com.hicomb.rest.engine.impl.DefaultRestEngine;

public class WeixinTestCase extends RestEngineTestCase {

	private static String Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return plainText;
	}

	/**
	 * @throws Exception
	 */
	public final void testWeixinEngineDoPost() throws Exception {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("username", "himeiba8@gmail.com");
		properties.put("pwd", "babd55179191a87f408af19bd70dce12");
		properties.put("imgcode", "");
		properties.put("f", "json");
		
		HashMap<String, String> headerHashMap = new HashMap<String, String>();
		headerHashMap.put("Cache-Control", "no-cache, must-revalidate");
		headerHashMap.put("Connection", "keep-alive");
		headerHashMap.put("Content-Type", "application/json; charset=UTF-8");
		headerHashMap.put("Referer", "https://mp.weixin.qq.com/");
		headerHashMap.put("Host", "mp.weixin.qq.com");
		headerHashMap.put("Cookie", "pgv_pvid=103040634; pt2gguin=o0416770681; ptcz=2b57b5f47848aca8cabfba224ca628a1531ae614f8ada9c94b4505fc57539278; o_cookie=416770681; ptui_loginuin=416770681; remember_acct=himeiba8@gmail.com; ts_refer=www.baidu.com/s; ts_uid=9124507351; ptisp=ctc; cert=K2SdZE97itgKgOsHhLadKQnpyvFFJ8Aq; qm_sid=392adf690310c5b4da9b858c0c49bf5e,cxwiTGTRZa1w.; qm_username=416770681; uin=o0416770681; skey=@0K5J32IMP; pgv_info=ssid=s6627206307; RK=oiYiYhd7GN");

		RestEngine restEngine = new DefaultRestEngine();
		HttpsURLConnection conn = restEngine.processHttpsRequest(
				"https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN", "POST",
				properties, headerHashMap, "UTF-8", null, hostNameVerifier);

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
		System.out.println(lineBuffer.toString());
		assertTrue(lineBuffer.toString().length() > 0);
	}
}
