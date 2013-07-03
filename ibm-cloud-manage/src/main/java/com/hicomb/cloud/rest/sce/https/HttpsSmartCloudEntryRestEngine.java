package com.hicomb.cloud.rest.sce.https;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.sce.BaseSmartCloudEntryRestEngine;

/**
 * SCE https 引擎
 * @author Administrator
 *
 */
public class HttpsSmartCloudEntryRestEngine extends BaseSmartCloudEntryRestEngine {

	/**
	 * 构建HTTPS请求头
	 * @param hostIp
	 * @param port
	 * @return
	 */
	@Override
	protected String buildRequestURL(String hostIp,int port){
		return CommonConst.HTTPS_SCHEMA+hostIp+":"+port;
	}
	
}
