package com.hicomb.rest.engine.impl;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.util.RESTUtilities;

/**
 * DefaultRestEngine
 */
public class DefaultRestEngine implements RestEngine {

	/**
	 * build HTTP request
	 */
	public HttpURLConnection processHttpRequest(String resourceUri,
			String method, HashMap<String, Object> requestBody, HashMap<String, String> properties,String requestEncoding)
			throws RestException {
		try {
			URL url = new URL(resourceUri);
			// attempt connection and data retrieval
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			
			httpConnection.setRequestMethod(method);
			
			// set head properties
			Set<String> keys = properties.keySet();
			for (String key : keys) {
				httpConnection.setRequestProperty(key, properties.get(key));
			}
			
			
			// check if the requestBody is present, if so, we have something to
			// write
			if (requestBody != null) {
				httpConnection.setDoOutput(true);
				OutputStreamWriter out = new OutputStreamWriter(httpConnection.getOutputStream(),requestEncoding);
				if(properties.get("Content-Type")!=null&&properties.get("Content-Type").toUpperCase().contains("JSON")){//根据Content-type设置请求体
					out.write(RESTUtilities.objectToJSONString(requestBody));
				}else{
					out.write(RESTUtilities.createQueryparameter(requestBody));
				}
				out.close();
			}
			return httpConnection;
		} catch (MalformedURLException e) {
			throw new RestException(e);
		}  catch (IOException e) {
			throw new RestException(e);
		}
	}

	/**
	 * build HTTPS request
	 */
	public HttpsURLConnection processHttpsRequest(String resourceUri,
			String method, HashMap<String, Object> requestBody,
			HashMap<String, String> properties,String requestEncoding,
			SSLSocketFactory sslSocketFactory, HostnameVerifier hostNameVerifier)
			throws RestException {
		try {
			URL url = new URL(resourceUri);
			// attempt connection and data retrieval
			HttpsURLConnection secureConnection = (HttpsURLConnection) url.openConnection();

			// set the version and the authorization information
			secureConnection.setRequestMethod(method);

			// set head properties
			Set<String> keys = properties.keySet();
			for (String key : keys) {
				secureConnection.setRequestProperty(key, properties.get(key));
			}

			secureConnection.setHostnameVerifier(hostNameVerifier);
			if (sslSocketFactory != null) {
				secureConnection.setSSLSocketFactory(sslSocketFactory);
			}

			// check if the requestBody is present, if so, we have something to
			// write
			if (requestBody != null) {
				secureConnection.setDoOutput(true);
				OutputStreamWriter out = new OutputStreamWriter(secureConnection.getOutputStream(),requestEncoding);
				if(properties.get("Content-Type")!=null&&properties.get("Content-Type").toUpperCase().contains("JSON")){//根据Content-type设置请求体
					out.write(RESTUtilities.objectToJSONString(requestBody));
				}else{
					out.write(RESTUtilities.createQueryparameter(requestBody));
				}
				out.close();
			}
			// return the connection
			return secureConnection;
		} catch (MalformedURLException e) {
			throw new RestException(e);
		} catch (ProtocolException e) {
			throw new RestException(e);
		} catch (IOException e) {
			throw new RestException(e);
		}
	}

}
