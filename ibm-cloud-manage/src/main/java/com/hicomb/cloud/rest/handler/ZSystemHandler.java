package com.hicomb.cloud.rest.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hicomb.rest.util.RESTUtilities;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;

/**
 *  Z体系句柄
 */
public class ZSystemHandler implements Handler {

	/**
	 *for Z system  arg[0] = gateway ;arg[1]= netmask ;arg[2]=hostname; arg[3]=domain ;arg[4]=pri_dns; arg[5] =vmpassword;  arg[6] = mdiskpassword 
	 */
	@SuppressWarnings({ "unchecked"})
	public HashMap<String, Object> buildVMproperties(String virtualname,
			String project, Appliance appliance,String targetId, String description,
			long diskSize, long memorySize, long cpuNum,String netWorkConfigure,String ipAddr,Object... args) {
		String gateway ="";
		String netMask ="";
		String hostname ="";
		String domain ="";
		String pri_dns ="";
		if(!"".equals(netWorkConfigure)&&null!=netWorkConfigure){//如果存在网络配置ID
			gateway = "{"+netWorkConfigure+"}";
			netMask = "{"+netWorkConfigure+"}";
			hostname = "{"+netWorkConfigure+"}";
			domain = "{"+netWorkConfigure+"}";
			pri_dns = "{"+netWorkConfigure+"}";
		}
		String password = "";
		String mdiskpassword = "";
		if(ipAddr!=null&&"".equals(ipAddr)){
			ipAddr = "{"+netWorkConfigure+"}";
		} if(args.length > 0 && (!"null".equals(String.valueOf(args[0]))&&!"".equals(String.valueOf(args[0])))){ //如果存在网关
			gateway = (String)args[0];
		} if(args.length > 1 && (!"null".equals(String.valueOf(args[1]))&&!"".equals(String.valueOf(args[1])))){ //如果存在子网掩码
			netMask = (String)args[1];
		} if(args.length > 2 && (!"null".equals(String.valueOf(args[2]))&&!"".equals(String.valueOf(args[2])))){ //如果存在主机名
			hostname = (String)args[2];
		} if(args.length > 3 && (!"null".equals(String.valueOf(args[3]))&&!"".equals(String.valueOf(args[3])))){ //如果存在域名
			domain = (String)args[3];
		} if(args.length > 4 && (!"null".equals(String.valueOf(args[4]))&&!"".equals(String.valueOf(args[4])))){ //如果首选dns
			pri_dns = (String)args[4];
		} if(args.length > 5 && (!"null".equals(String.valueOf(args[5]))&&!"".equals(String.valueOf(args[5])))){ //虚拟机密码
			password = (String)args[5];
		} if(args.length > 6 && (!"null".equals(String.valueOf(args[6]))&&!"".equals(String.valueOf(args[6])))){ //mdisk
			mdiskpassword = (String)args[6];
		} 
		String propertiesString = 
			"{\"name\":\""+virtualname+"\"," +
			"\"description\":\""+description+"\"," +
			"\"instances\":1," +
			"\"project\":\""+project+"\"," +
			"\"properties\":[" +
				"{\"name\":\"hostname\",\"basic\":true,\"value\":\""+hostname+"\"}," +
				"{\"name\":\"domain\",\"basic\":true,\"value\":\""+domain+"\"}," +
				"{\"name\":\"pri_dns\",\"basic\":false,\"value\":\""+pri_dns+"\"}," +
				"{\"name\":\"cpu\",\"basic\":true,\"value\":"+cpuNum+"}," +
				"{\"name\":\"memsize\",\"basic\":true,\"value\":"+memorySize+"},"+
				"{\"name\":\"ipaddr\",\"basic\":false,\"value\":\""+ipAddr+"\"},"+
				"{\"name\":\"netmask\",\"basic\":false,\"value\":\""+netMask+"\"}," +
				"{\"name\":\"password\",\"basic\":false,\"value\":\""+password+"\"}," +
				"{\"name\":\"mdiskpassword\",\"basic\":false,\"value\":\""+mdiskpassword+"\"}," +
				"{\"name\":\"gateway\",\"basic\":false,\"value\":\""+gateway+"\"}]"+
				",\"state\":\"EXECUTING\"}";
		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	@SuppressWarnings({ "unchecked"})
	public HashMap<String, Object> buildVMDeviceProperties(long diskSize,
			long memorySize, long cpuNum,boolean isRun) {
		String propertiesString = "";
		if(isRun){//运行时可以动态改变cpu
			propertiesString="{\"properties\":" +
			"[" +
			"{\"name\":\"cpu\",\"basic\":true,\"value\":"+cpuNum+"}]," +
			"\"state\":\"RESIZING\"}";
		}else {//停止时可以动态改变cpu和内存
			propertiesString="{\"properties\":" +
			"[" +
			"{\"name\":\"cpu\",\"basic\":true,\"value\":"+cpuNum+"}," +
			"{\"name\":\"memsize\",\"basic\":true,\"value\":"+memorySize+"}]," +
			"\"state\":\"RESIZING\"}";
		
		}
		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	@SuppressWarnings({"rawtypes" })
	public Appliance getApplianceFromProperties(Appliance appliance,List<HashMap> properties) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		for (
		Iterator<HashMap> iterator = properties.iterator(); iterator
				.hasNext();) {
			HashMap property = (HashMap) iterator.next();
			if ("MEMSIZE".equals(property.get("name").toString().toUpperCase())&&property.get("rules")!=null) {
				resMap.put("memorySize", ((List) property.get("values")).get(0));
			}
			if ("CPU".equals(property.get("name").toString().toUpperCase())&&property.get("rules")!=null) {
				resMap.put("cpuNum", ((List) property.get("values")).get(0));
			}
		}
		appliance.setCustomProperties(resMap);
		return appliance;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public VirtualMachine getWorkloadFromProperties(VirtualMachine virtualMachine,List<HashMap> properties){
		Map<String, Object> resMap = new HashMap<String, Object>();
		for (
			Iterator<HashMap> iterator = properties.iterator(); iterator
				.hasNext();) {
			HashMap property = (HashMap) iterator.next();
			if ( "General Information".equals(property.get("category"))&&"Memory (MB)".equals(property.get("description"))) {
				virtualMachine.setMemorySize(Long.parseLong(String.valueOf(property.get("value"))));
			}if ( "General Information".equals(property.get("category"))&&"CPUs".equals(property.get("description"))) {
				virtualMachine.setCpuNum(Long.parseLong(String.valueOf(property.get("value"))));
			}if ( "供应商信息".equals(property.get("category"))&&"主机类型：".equals(property.get("description"))) {
				resMap.put("vender", property.get("value"));
			}if ("Guest Hostname".equals(property.get("description"))) {
				resMap.put("hostname", String.valueOf(property.get("value")));
			}if ("Guest HostVendor".equals(property.get("description"))) {
				resMap.put("vender", String.valueOf(property.get("value")));
			}
		}
		virtualMachine.setCustomProperties(resMap);
		return virtualMachine;
	}
}
