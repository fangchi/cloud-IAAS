package com.hicomb.vm.vmware.common;

import com.hicomb.vm.common.VMSystemProperies;

/**
 * 常量类
 */
public class VMWareBaseCommon {

	public static final String SVC_INST_NAME = "ServiceInstance";
	
	/*集群*/
	public static final String CLUSTER_COMPUTE_RESOURCE = "ClusterComputeResource";
	
	/*主机*/
	public static final String HOST_SYSTEM = "HostSystem";
	
	/*资源池*/
	public static final String RESOURCEPOOL = "ResourcePool";
	
	/*虚拟机*/
	public static final String VIRTUAL_MACHINE ="VirtualMachine";
	
	/*执行成功*/
	public static final int TASK_EXE_SUCCESS = 0;
	
	/*执行失败*/
	public static final int TASK_EXE_FAIL = -1;
	
	public static final String VMWARE_PREFIX = VMSystemProperies.PROPERTY_PREFIX + "vmware.";
	
	//private static final String VMWARE_USERNAME_PROKEY = VMWARE_PREFIX + "auth.username";
	
	///private static final String VMWARE_PASSWORD_PROKEY = VMWARE_PREFIX + "auth.password";
	
	///private static final String VMWARE_WS_URL_PROKEY = VMWARE_PREFIX + "ws.url";
	
	
	private static final String VMWARE_CONN_MAXSIZE_PROKEY = VMWARE_PREFIX + "conn.max";
	
	private static final String VMWARE_CONN_NORMALSIZE_PROKEY = VMWARE_PREFIX + "conn.normal";
	
	///public static final String VMWARE_USERNAME = VMSystemProperies.getProperty(VMWARE_USERNAME_PROKEY);
	
	///public static final String VMWARE_PASSWORD = VMSystemProperies.getProperty(VMWARE_PASSWORD_PROKEY);
	
	//public static final String VMWARE_EVENT_MONITOR_PROKEY = VMWARE_PREFIX+"event.monitortype";
	/*连接池最大数量*/
	public static final int VMWARE_CONN_MAXSIZE = VMSystemProperies.getIntegerProperty(VMWARE_CONN_MAXSIZE_PROKEY);
	public static final int VMWARE_CONN_NORMALSIZE = VMSystemProperies.getIntegerProperty(VMWARE_CONN_NORMALSIZE_PROKEY);
	
	//public static final String VMWARE_EVENT_MONITOR_TYPES = VMSystemProperies.getProperty(VMWARE_EVENT_MONITOR_PROKEY);
	
}
