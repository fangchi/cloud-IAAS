package com.hicomb.bmc.bladelogic.rest.common;

import com.hicomb.bmc.bladelogic.rest.configure.RestPorperties;


public class BladeLogicCommonConst {
	
	/*HTTP 方法头*/
	public static final String HTTP_METHOD_POST ="POST";
	
	public static final String HTTP_METHOD_GET ="GET";
	
	public static final String HTTPS_SCHEMA ="https://";
	
	private static final String BLADELOGIC_PREFIX = RestPorperties.PROPERTY_PREFIX + "bladelogic.";
	
	private static final String BLADELOGIC_URL_PREFIX = BLADELOGIC_PREFIX + "url.";
	
	private static final String BLADELOGIC_QUERY_SYSTEMOBJECT = BLADELOGIC_URL_PREFIX+"systemobjects";
	
	private static final String BLADELOGIC_QUERY_SERVER = BLADELOGIC_URL_PREFIX+ "server";
	
	private static final String BLADELOGIC_JOB_EXEUTEON_SERVER = BLADELOGIC_URL_PREFIX+ "jobexecuteonserver";
	
	public static final String BLADELOGIC_QUERY_SYSTEMOBJECTS_URL = RestPorperties.getInstance().getConfigProperty(BLADELOGIC_QUERY_SYSTEMOBJECT);
	
	public static final String BLADELOGIC_QUERY_SERVER_URL = RestPorperties.getInstance().getConfigProperty(BLADELOGIC_QUERY_SERVER);
	
	public static final String BLADELOGIC_JOB_EXEUTEON_SERVER_URL = RestPorperties.getInstance().getConfigProperty(BLADELOGIC_JOB_EXEUTEON_SERVER);
}
