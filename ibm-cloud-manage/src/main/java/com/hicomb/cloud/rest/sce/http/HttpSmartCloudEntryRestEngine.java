package com.hicomb.cloud.rest.sce.http;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.sce.BaseSmartCloudEntryRestEngine;

/**
 * SCE http 引擎
 * @author Administrator
 *
 */
public class HttpSmartCloudEntryRestEngine extends BaseSmartCloudEntryRestEngine {

	/**
	 * 构建HTTP请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	@Override
	protected String buildRequestURL(String hostIp,int port){
		return CommonConst.HTTP_SCHEMA+hostIp+":"+port;
	}
	
}
