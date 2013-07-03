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
 * Power句柄 
 */
public class PowerHandler implements Handler {

	/**
	 * 根据镜像构建虚拟机属性
	 * @param appliance
	 * @param networkconfId
	 * @param diskSize
	 * @param memorySize
	 * @param cpuNum
	 * @param ipAddr
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected String buildVMAddtionalProperties(Appliance appliance ,String networkconfId,long diskSize, long memorySize, long cpuNum,String ipAddr){
		List<Map> totalList = new ArrayList<Map>();
		Map<String,Object> networkPros =  appliance.getNetworkProperties();
		HashMap networkPro = new HashMap();
		//构建基础属性
		for (Iterator<String> iterator = networkPros.keySet().iterator(); iterator.hasNext();) {
			networkPro = new HashMap();
			String key = (String) iterator.next();
			networkPro.put("name", key);
			networkPro.put("basic", false);
			networkPro.put("value", "{"+networkconfId+"}");
			if("".equals(ipAddr)&&ipAddr!=null&&key.contains("ipaddress")){
				networkPro.put("value", ipAddr);
			}
			totalList.add(networkPro);
		}
		//构建CPU Mode
		HashMap cpuModeMap  = new HashMap(); 
		cpuModeMap.put("name", "cpumode");
		cpuModeMap.put("basic", true);
		cpuModeMap.put("value", "SHARED");
		totalList.add(cpuModeMap);
		
		//构建内存
		HashMap memsizeMap  = new HashMap();
		memsizeMap.put("name", "memsize");
		memsizeMap.put("basic", false);
		memsizeMap.put("value", memorySize);
		totalList.add(memsizeMap);
		
		//构建CPU共享
		HashMap cpushuMap  = new HashMap();
		cpushuMap.put("name", "cpushared");
		cpushuMap.put("basic", false);
		cpushuMap.put("value", cpuNum);
		totalList.add(cpushuMap);
		
		//构建磁盘
		HashMap cskRAMMap  = new HashMap();
		cskRAMMap.put("name", "cskRAM");
		cskRAMMap.put("basic", true);
		cskRAMMap.put("value", memorySize);
		totalList.add(cskRAMMap);
		
		//构建CPU
		HashMap cskCpuMap  = new HashMap();
		cskCpuMap.put("name", "cskCPU");
		cskCpuMap.put("basic", true);
		cskCpuMap.put("value", cpuNum);
		totalList.add(cskCpuMap);
		//转化为Json
		return RESTUtilities.listToJSONString(totalList);
	}
	

	@SuppressWarnings({ "unchecked"})  
	public HashMap<String, Object> buildVMproperties(String virtualname,
			String project, Appliance appliance,String targetId, String description,
			long diskSize, long memorySize, long cpuNum,String netWorkConfigure,String ipAddr,Object... args ){
		String prosStr =  buildVMAddtionalProperties(appliance,netWorkConfigure,diskSize,memorySize,cpuNum,ipAddr);
		String propertiesString = 
			"{\"name\":\""+virtualname+"\"," +
			"\"description\":\""+description+"\"," +
			"\"instances\":1," +
			"\"project\":\""+project+"\"," +
			"\"properties\":"+ prosStr+
				",\"state\":\"EXECUTING\"}";
		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	@SuppressWarnings({ "unchecked"})
	public HashMap<String, Object> buildVMDeviceProperties(long diskSize,
			long memorySize, long cpuNum,boolean isRun) {
		String propertiesString = 
			"{\"properties\":[" +
			"{\"name\":\"cpu\",\"basic\":false,\"value\":"+cpuNum+"}," +
			"{\"name\":\"memsize\",\"basic\":false,\"value\":"+memorySize+"}]," +
			"\"state\":\"RESIZING\"}";
		return RESTUtilities.fromJSON(propertiesString, HashMap.class);
	}

	
	@SuppressWarnings({ "rawtypes" })
	public Appliance getApplianceFromProperties(Appliance appliance,List<HashMap> properties) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> networkMap = new HashMap<String, Object>();
		for (
		Iterator<HashMap> iterator = properties.iterator(); iterator
				.hasNext();) {
			HashMap property = (HashMap) iterator.next();
			//TODO STORAGE 根据属性构建镜像对象
			if ("MEMSIZE".equals(property.get("name").toString().toUpperCase())) {
				resMap.put("memorySize", ((List) property.get("values")).get(0));
			}if ("CPUSHARED".equals(property.get("name").toString().toUpperCase())) {
				resMap.put("cpuNum", ((List) property.get("values")).get(0));
			}if ("CPUDEDICATED".equals(property.get("name").toString().toUpperCase())) {
				resMap.put("cpudedicated", ((List) property.get("values")).get(0));
			}if(property.get("classification")!=null&&"NETWORK".equals(((HashMap)property.get("classification")).get("id"))
					&&(property.get("valueFrom")!=null)){//获取镜像网络配置属性
				if("IPV4_ADDRESS".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("IPV4_SUBNET_MASK".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("DOMAIN_NAME".equals(property.get("subtype"))){
					networkMap.put(String.valueOf(property.get("name")), "");
				}if("HOST_NAME".equals(property.get("subtype"))){
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
			if ( "内存".equals(property.get("category"))&&"分配的内存大小 (MB)：".equals(property.get("description"))) {
				virtualMachine.setMemorySize(Long.parseLong(String.valueOf(property.get("value"))));
			}if ( "处理器".equals(property.get("category"))&&"分配的处理器数：".equals(property.get("description"))) {
				virtualMachine.setCpuNum(Long.parseLong(String.valueOf(property.get("value"))));
			}if ( "供应商信息".equals(property.get("category"))&&"主机类型：".equals(property.get("description"))) {
				resMap.put("vender", property.get("value"));
			}if ("!product.AIX1.com.ibm.ovf.vim.1.system.hostname!".equals(property.get("description"))) {
				resMap.put("hostname", String.valueOf(property.get("value")));
			}
		}
		virtualMachine.setCustomProperties(resMap);
		return virtualMachine;
	}


}
