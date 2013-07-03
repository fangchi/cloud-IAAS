package com.hicomb.cloud.rest.sysdirector.http;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.sysdirector.BaseSystemDirectorRestEngine;

/**
 * Http 协议实现
 * @author Administrator
 *
 */
public class HttpSystemDirectorRestEngine extends
		BaseSystemDirectorRestEngine {

	/**
	 * 构建请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	@Override
	protected String buildRequestURL(String hostIp,int port){
		return CommonConst.HTTP_SCHEMA+hostIp+":"+port;
	}
}
