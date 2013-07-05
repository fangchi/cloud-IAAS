package com.hicomb.rest.handler.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.handler.ConnectionHandler;
import com.hicomb.rest.util.RESTUtilities;

/**
 * JSON Handler
 * @param <T>
 */
public class JsonTypeHandler<T> implements ConnectionHandler<T> {

	// logger
	private static final Log logger = LogFactory.getLog(JsonTypeHandler.class);
	
	public T handle(HttpURLConnection conn, Class<T> clazz) throws RestException{
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			StringBuffer lineBuffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				lineBuffer.append(line);
				lineBuffer.append(System.getProperty("line.separator"));
			}
			return RESTUtilities.fromJSON(lineBuffer.toString(),clazz);
		} catch (IOException e) {
			logger.error(e);
			throw new RestException(e);
		}
		
	}
}
