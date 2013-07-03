package com.hicomb.cloud.rest.common;

import com.hicomb.cloud.rest.configure.RestPorperties;

/**
 * 常量类
 */
public class CommonConst {
	
	/*HTTP 方法头*/
	public static final String HTTP_METHOD_POST ="POST";
	
	public static final String HTTP_METHOD_PUT ="PUT";
	
	public static final String HTTP_METHOD_GET ="GET";
	
	public static final String HTTP_METHOD_DELETE ="DELETE";
	
	/* 体系 架构*/
	public static final String ARCHITECTURE_POWER = "POWER";
	
	public static final String ARCHITECTURE_X86 = "X86";
	
	public static final String ARCHITECTURE_ZSYSTEM = "Z";
	
	
	/*协议头*/
	public static final String HTTP_SCHEMA ="http://";
	
	public static final String HTTPS_SCHEMA ="https://";
	
	/*SCE*/
	private static final String SCE_PREFIX = RestPorperties.PROPERTY_PREFIX + "sce.";
	
	/*Director*/
	private static final String SYSDIRECTOR_PREFIX = RestPorperties.PROPERTY_PREFIX + "sysdirector.";
	
	private static final String SCE_URL_PREFIX = SCE_PREFIX + "url.";
	
	private static final String SCE_QUERY_APPLIANCES = SCE_URL_PREFIX+"appliance";
	
	private static final String SCE_QUERY_APPLIANCES_DETAIL = SCE_URL_PREFIX+"appliancedetail";
	
	private static final String SCE_QUERY_PROJECTS = SCE_URL_PREFIX+"project";
	
	
	private static final String SCE_WORKLOADS = SCE_URL_PREFIX+"workloads";
	
	private static final String SCE_WORKLOAD = SCE_URL_PREFIX+"workload";
	
	private static final String SCE_REQUESTS = SCE_URL_PREFIX+"requests";
  
	private static final String SCE_REQUEST = SCE_URL_PREFIX+"request";
	
	private static final String SCE_QUERY_APPLIANCES_CUSTOMIZATION = SCE_URL_PREFIX+"appliancecustomization";
	
	private static final String SCE_QUERY_WORKLOADS_CUSTOMIZATION = SCE_URL_PREFIX+"workloadcustomization";
	
	private static final String SCE_QUERY_WORKLOAD_VIRTUALSERVER = SCE_URL_PREFIX+"workloadvirtualserver";
	
	private static final String SCE_QUERY_WORKLOAD_VIRTUALSERVERS = SCE_URL_PREFIX+"workloadvirtualservers";
	
	private static final String SCE_QUERY_VIRTUALSERVER_STORAGES = SCE_URL_PREFIX+"virtualserverstorages";
	
	private static final String SCE_QUERY_NETWORKCONFIGURATIONS = SCE_URL_PREFIX+"networkconfigurations";
	
	private static final String SCE_QUERY_ZVMHOST = SCE_URL_PREFIX+"zvmhost";
	
	private static final String SCE_QUERY_ZVMVMS = SCE_URL_PREFIX+"zvmvms";
	
	private static final String SCE_QUERY_CLOUDS = SCE_URL_PREFIX+"clouds";
	
	private static final String SCE_QUERY_CLOUD = SCE_URL_PREFIX+"cloud";
	
	private static final String SCE_TARGET_DRY = SCE_URL_PREFIX+"targetdry";
	
	private static final String SCE_TARGET_CHANGE = SCE_URL_PREFIX+"targetchange";
	
	private static final String SCE_QUERY_EVENTS = SCE_URL_PREFIX+"events";
	
	public static final String SCE_URL_BASE_PATH = "/cloud/api";
	
	public static final String SCE_QUERY_APPLIANCES_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_APPLIANCES);
	
	public static final String SCE_QUERY_APPLIANCES_CUSTOMIZATION_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_APPLIANCES_CUSTOMIZATION);
	
	public static final String SCE_QUERY_APPLIANCES_DETAIL_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_APPLIANCES_DETAIL);
	
	public static final String SCE_QUERY_PROJECTS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_PROJECTS);
	
	public static final String SCE_WORKLOADS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_WORKLOADS);
	
	public static final String SCE_WORKLOAD_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_WORKLOAD);

	public static final String SCE_REQUESTS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_REQUESTS);
  
	public static final String SCE_REQUEST_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_REQUEST);

	public static final String SCE_QUERY_WORKLOAD_VIRTUALSERVERS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_WORKLOAD_VIRTUALSERVERS);
	
	public static final String SCE_QUERY_WORKLOAD_VIRTUALSERVER_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_WORKLOAD_VIRTUALSERVER);
	
	public static final String SCE_QUERY_WORKLOADS_CUSTOMIZATION_URL= SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_WORKLOADS_CUSTOMIZATION);
	
	public static final String SCE_NETWORKCONFIGURATIONS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_NETWORKCONFIGURATIONS);

	public static final String SCE_QUERY_VIRTUALSERVER_STORAGES_URL =SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_VIRTUALSERVER_STORAGES);
	
	public static final String SCE_QUERY_CLOUDS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_CLOUDS);
	
	public static final String SCE_QUERY_CLOUD_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_CLOUD);
	
	public static final String SCE_QUERY_ZVMHOST_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_ZVMHOST);
	
	public static final String SCE_QUERY_ZVMVMS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_ZVMVMS);
	
	public static final String SCE_QUERY_EVENTS_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_QUERY_EVENTS);
	
	public static final String SCE_TARGETCHANGE_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_TARGET_CHANGE);
	
	public static final String SCE_TARGETDRY_URL = SCE_URL_BASE_PATH+RestPorperties.getInstance().getConfigProperty(SCE_TARGET_DRY);
	
	
	//SYSDIRECTOR
	public static final String SYSDIRECTOR_SSL_ALGORITHM = RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_PREFIX+"ssl.algorithm");
	
	public static final String SYSDIRECTOR_PRODUCT_VERSION = RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_PREFIX+"product.version");

	public static final String SYSDIRECTOR_URL_BASE_PATH = "/ibm/director/rest";
	
	private static final String SYSDIRECTOR_URL_PREFIX = SYSDIRECTOR_PREFIX + "url.";
	
	private static final String SYSDIRECTOR_QUERY_SYSTEMPOOLS = SYSDIRECTOR_URL_PREFIX+"systempools";
	
	private static final String SYSDIRECTOR_QUERY_SYSTEMPOOLPERF = SYSDIRECTOR_URL_PREFIX+"systempoolsperf";
	
	private static final String SYSDIRECTOR_QUERY_POWER_HOSTS = SYSDIRECTOR_URL_PREFIX+"powerhosts";
	
	private static final String SYSDIRECTOR_QUERY_POWER_HOST = SYSDIRECTOR_URL_PREFIX+"powerhost";
	
	private static final String SYSDIRECTOR_QUERY_POWERVMPERF = SYSDIRECTOR_URL_PREFIX+"virtualserverperf";
	
	private static final String SYSDIRECTOR_QUERY_POWER_HOST_STORAGES = SYSDIRECTOR_URL_PREFIX+"powerhoststorages";
	
	private static final String SYSDIRECTOR_QUERY_EVENTS = SYSDIRECTOR_URL_PREFIX+"events";
	
	private static final String SYSDIRECTOR_QUERY_EVENT = SYSDIRECTOR_URL_PREFIX+"event";
	
	private static final String SYSDIRECTOR_QUERY_EVENTRELATEDRESOURCE = SYSDIRECTOR_URL_PREFIX +"eventrelatedresource";
	
	public static final String SYSDIRECTOR_QUERY_SYSTEMPOOLS_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_SYSTEMPOOLS);
	
	public static final String SYSDIRECTOR_QUERY_SYSTEMPOOLPERF_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_SYSTEMPOOLPERF);
	
	public static final String SYSDIRECTOR_QUERY_POWER_HOSTS_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_POWER_HOSTS);

	public static final String SYSDIRECTOR_QUERY_POWER_HOST_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_POWER_HOST);

	public static final String SYSDIRECTOR_QUERY_POWERVMPERF_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_POWERVMPERF);

	public static final String SYSDIRECTOR_QUERY_POWER_HOST_STORAGES_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_POWER_HOST_STORAGES);

	public static final String SYSDIRECTOR_QUERY_EVENTS_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_EVENTS);
	
	public static final String SYSDIRECTOR_QUERY_EVENT_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_EVENT);

	public static final String SYSDIRECTOR_QUERY_EVENTRELATEDRESOURCE_URL = SYSDIRECTOR_URL_BASE_PATH + RestPorperties.getInstance().getConfigProperty(SYSDIRECTOR_QUERY_EVENTRELATEDRESOURCE);

}
