package com.hicomb.cloud.rest.sysdirector.https;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.sysdirector.BaseSystemDirectorRestEngine;

/**
 * Https 协议实现
 * @author Administrator
 *
 */
public class HttpsSystemDirectorRestEngine extends
		BaseSystemDirectorRestEngine {

	/**
	 * 构建请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	@Override
	protected String buildRequestURL(String hostIp,int port){
		return CommonConst.HTTPS_SCHEMA+hostIp+":"+port;
	}
}
