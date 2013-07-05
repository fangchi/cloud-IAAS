package com.hicomb.rest.handler;

import java.net.HttpURLConnection;

import com.hicomb.rest.exception.RestException;

public interface ConnectionHandler<T> {
	
	/**
	 * handle Http response
	 * @param con
	 * @param clazz
	 * @return
	 * @throws RestException
	 */
	public T handle(HttpURLConnection con,Class<T> clazz) throws RestException;
}
