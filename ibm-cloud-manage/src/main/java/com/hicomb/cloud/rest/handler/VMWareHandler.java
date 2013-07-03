package com.hicomb.cloud.rest.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hicomb.rest.util.RESTUtilities;
import com.hicomb.cloud.rest.sce.entity.appliance.Appliance;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;

/**
 *  vmware句柄
 */
public class VMWareHandler implements Handler {

	/**
	 * arg[0] = gateway ;arg[1]= netmask ;arg[2]=hostname ;arg[3]=domain ;arg[4]=pri_dns; arg[5] =vmpassword
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected String buildVMAddtionalProperties(Appliance appliance ,String networkconfId,String ipAddr,
			long diskSize, long memorySize, long cpuNum,Object... args){
		List<Map> totalList = new ArrayList<Map>();
		Map<String,Object> networkPros =  appliance.getNetworkProperties();
		HashMap networkPro = new HashMap();
		String gateway = "";
		String netMask = "";
		String hostname = "";
		String domain = "";
		String pri_dns = "";
		String vmIpAddr = "";
		if(!"".equals(networkconfId)&&null!=networkconfId){//如果有默认的网络配置
			//构建基础属性
			for (Iterator<String> iterator = networkPros.keySet().iterator(); iterator.hasNext();) {
				networkPro = new HashMap();
				String key = (String) iterator.next();
				networkPro.put("name", key);
				networkPro.put("basic", false);
				networkPro.put("value", "{"+networkconfId+"}");
				totalList.add(networkPro);
			}
			gateway = "{"+networkconfId+"}";
			netMask = "{"+networkconfId+"}";
			hostname = "{"+networkconfId+"}";
			domain = "{"+networkconfId+"}";
			pri_dns = "{"+networkconfId+"}";
			vmIpAddr= "{"+networkconfId+"}";
		}
		if(ipAddr!=null&&!"".equals(ipAddr)){
			vmIpAddr = ipAddr; //如果存在IP地址
		} if(args.length>=1 && (!"null".equals(String.valueOf(args[0]))&&!"".equals(String.valueOf(args[0])))){ //如果存在网关
			gateway = (String)args[0];
		} if(args.length>=2 && (!"null".equals(String.valueOf(args[1]))||!"".equals(String.valueOf(args[1])))){ //如果自子网掩码
			netMask = (String)args[1];
		} if(args.length>=3 && (!"null".equals(String.valueOf(args[2]))||!"".equals(String.valueOf(args[2])))){ //如果存在主机名
			hostname = (String)args[2];
		} if(args.length>=4 && (!"null".equals(String.valueOf(args[3]))||!"".equals(String.valueOf(args[3])))){ //如果存在域
			domain = (String)args[3];
		} if(args.length>=5 && (!"null".equals(String.valueOf(args[4]))||!"".equals(String.valueOf(args[4])))){ //如果存在首选dns
			pri_dns = (String)args[4];
		}
		
		HashMap usedhcp = new HashMap();
		usedhcp.put("name", "networkdevice.网络适配器 1.usedhcp");
		usedhcp.put("basic", false);
		usedhcp.put("value", "");
		totalList.add(usedhcp);
		
		
		HashMap ipaddress = new HashMap();
		ipaddress.put("name", "networkdevice.网络适配器 1.ipaddress");
		ipaddress.put("basic", false);
		ipaddress.put("value", vmIpAddr);
		totalList.add(ipaddress);
		
		
		HashMap netmask = new HashMap();
		netmask.put("name", "networkdevice.网络适配器 1.netmask");
		netmask.put("basic", false);
		netmask.put("value", netMask);
		totalList.add(netmask);
		
		HashMap gateway1 = new HashMap();
		gateway1.put("name", "networkdevice.网络适配器 1.gateway1");
		gateway1.put("basic", false);
		gateway1.put("value", gateway);
		totalList.add(gateway1);
		
		HashMap gateway2 = new HashMap();
		gateway2.put("name", "networkdevice.网络适配器 1.gateway2");
		gateway2.put("basic", false);
		gateway2.put("value", "");
		totalList.add(gateway2);
		
		HashMap dns1 = new HashMap();
		dns1.put("name", "networkdevice.网络适配器 1.dns1");
		dns1.put("basic", false);
		dns1.put("value", pri_dns);
		totalList.add(dns1);
		
		HashMap dns2 = new HashMap();
		dns2.put("name", "networkdevice.网络适配器 1.dns2");
		dns2.put("basic", false);
		dns2.put("value", "");
		totalList.add(dns2);
		
		/**HashMap obtainFromDNS = new HashMap();
		obtainFromDNS.put("name", "obtainFromDNS.network1");
		obtainFromDNS.put("basic", false);
		obtainFromDNS.put("value", "");
		totalList.add(obtainFromDNS);**/
		
		HashMap hostNameMap = new HashMap();
		hostNameMap.put("name", "networkdevice.网络适配器 1.hostname");
		hostNameMap.put("basic", false);
		hostNameMap.put("value", hostname);
		totalList.add(hostNameMap);
		
		HashMap domainMap = new HashMap();
		domainMap.put("name", "networkdevice.网络适配器 1.domain");
		domainMap.put("basic", false);
		domainMap.put("value", domain);
		totalList.add(domainMap);
		
		//CPU
		HashMap cpuModeMap  = new HashMap(); 
		cpuModeMap.put("name", "vmware.cpu");
		cpuModeMap.put("basic", true);
		cpuModeMap.put("value", cpuNum);
		totalList.add(cpuModeMap);
		
		//内存
		HashMap memsizeMap  = new HashMap();
		memsizeMap.put("name", "vmware.memory");
		memsizeMap.put("basic", false);
		memsizeMap.put("value", memorySize);
		totalList.add(memsizeMap);
		
		for (Iterator<String> iterator = appliance.getStorageProperties().keySet().iterator(); iterator.hasNext();) {
			networkPro = new HashMap();
			String key = (String) iterator.next();
			networkPro.put("name", key);
			networkPro.put("basic", false);
			networkPro.put("value", diskSize);
			totalList.add(networkPro);
		}
		String jsonString = RESTUtilities.listToJSONString(totalList);
		
		System.out.println(jsonString);
		return jsonString;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> buildVMproperties(String virtualname,
			String project, Appliance appliance,String targetId, String description,
			long diskSize, long memorySize, long cpuNum,String netWorkConfigure,String ipAddr,Object... args) {
		String prosStr =  buildVMAddtionalProperties(appliance,netWorkConfigure,ipAddr,diskSize,memorySize,cpuNum,args);
		String propertiesString = "{\"name\":\""
				+ virtualname
				+ "\",\"description\":\""
				+ description
				+ "\",\"instances\":1,\"project\":\""
				+ project
				+ "\","
				+ "\"properties\":"+prosStr+","
				+ "\"state\":\"EXECUTING\"}";

		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> buildVMDeviceProperties(long diskSize,
			long memorySize, long cpuNum,boolean isRun) {
		String propertiesString = "";
		if(!isRun){ //停止状态时， 能够调整 CPU 内存  磁盘
			propertiesString= "{" + "\"properties\":["
			+ "{\"name\":\"DiskSize.硬盘 1\",\"basic\":false,\"value\":"
			+ diskSize + "},"
			+ "{\"name\":\"vmware.memory\",\"basic\":true,\"value\":"
			+ memorySize + "},"
			+ "{\"name\":\"vmware.cpu\",\"basic\":true,\"value\":" + cpuNum
			+ "}]," + "\"state\":\"RESIZING\"}";
		} else {//运行状态时，只能够调整磁盘大小
			propertiesString= "{" + "\"properties\":["
			+ "{\"name\":\"DiskSize.硬盘 1\",\"basic\":false,\"value\":"
			+ diskSize + "}]," + "\"state\":\"RESIZING\"}";
		}
		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	@SuppressWarnings({ "rawtypes" })
	public Appliance getApplianceFromProperties(Appliance appliance,List<HashMap> properties) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> networkMap = new HashMap<String, Object>();
		Map<String, Object> storageProperties = new HashMap<String, Object>();
		//TODO 所有属性标准化 需要重构
		for (
		Iterator<HashMap> iterator = properties.iterator(); iterator
				.hasNext();) {
			HashMap property = (HashMap) iterator.next();
			if (property.get("classification") != null
					&& "STORAGE".equals(((Map) property.get("classification"))
							.get("id").toString())
					&& property.get("rules") != null) {
				resMap.put("diskSize", ((List) property.get("values")).get(0));
				storageProperties.put(String.valueOf(property.get("name")), "");
				appliance.setStorageProperties(storageProperties);
			} if (property.get("classification") != null
					&& "HARDWARE".equals(((Map) property.get("classification"))
							.get("id").toString())&&"VMWARE.MEMORY".equals(property.get("name").toString().toUpperCase())) {
				resMap.put("memorySize", ((List) property.get("values")).get(0));
			} if (property.get("classification") != null
					&& "HARDWARE".equals(((Map) property.get("classification"))
							.get("id").toString())&&"VMWARE.CPU".equals(property.get("name").toString().toUpperCase())) {
				resMap.put("cpuNum", ((List) property.get("values")).get(0));
			} if(property.get("classification")!=null&&"NETWORK".equals(((HashMap)property.get("classification")).get("id"))
					&&(property.get("valueFrom")!=null)){//获取镜像网络配置属性
				if("IPV4_ADDRESS".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("IPV4_SUBNET_MASK".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("DOMAIN_NAME".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("HOST_NAME".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("DNS_FLAG".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("DHCP_FLAG".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("domainSuffixes".equals(property.get("valueFrom"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("networkId".equals(property.get("valueFrom"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}
			}
		}
		appliance.setCustomProperties(resMap);
		appliance.setNetworkProperties(networkMap);
		return appliance;
	}
	
	@SuppressWarnings({"rawtypes" })
	public VirtualMachine getWorkloadFromProperties(VirtualMachine virtualMachine,List<HashMap> properties){
		Map<String, Object> resMap = new HashMap<String, Object>();
		for (
			Iterator<HashMap> iterator = properties.iterator(); iterator
				.hasNext();) {
			HashMap property = (HashMap) iterator.next();
			if ( "内存 (MB)".equals(property.get("description"))) {
				virtualMachine.setMemorySize(Long.parseLong(String.valueOf(property.get("value"))));
			}if ("CPU 数".equals(property.get("description"))) {
				virtualMachine.setCpuNum(Long.parseLong(String.valueOf(property.get("value"))));
			}if ("访客操作系统".equals(property.get("description"))) {
				resMap.put("guestOS", String.valueOf(property.get("value")));
			}if ("访客主机名".equals(property.get("description"))) {
				resMap.put("hostname", String.valueOf(property.get("value")));
			}if ("以太网卡数".equals(property.get("description"))) {
				resMap.put("ethernetPortNum", Integer.parseInt(String.valueOf(property.get("value"))));
			}
		}
		virtualMachine.setCustomProperties(resMap);
		return virtualMachine;
	}
}
