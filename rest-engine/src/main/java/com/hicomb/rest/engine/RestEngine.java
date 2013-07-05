package com.hicomb.rest.engine;

import java.net.HttpURLConnection;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import com.hicomb.rest.exception.RestException;

public interface RestEngine {

	/**
	 * build HTTP request
	 * @param resourceUri
	 * @param method
	 * @param requestBody
	 * @param headers
	 * @return
	 * @throws RestException
	 */
	public HttpURLConnection processHttpRequest(String resourceUri,
			String method, HashMap<String, Object> requestBody, HashMap<String, String> properties,String requestEncoding)
			throws RestException;

	/**
	 * build HTTPS request
	 * @param resourceUri
	 * @param method
	 * @param requestBody
	 * @param properties
	 * @param sslSocketFactory
	 * @return
	 */
	public HttpsURLConnection processHttpsRequest(String resourceUri,
			String method, HashMap<String, Object> requestBody, HashMap<String, String> properties,String requestEncoding,
			SSLSocketFactory sslSocketFactory, HostnameVerifier hostVerifier)
			throws RestException;

}
