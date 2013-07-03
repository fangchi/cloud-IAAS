package com.hicomb.vm.vmware.task.host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hicomb.vm.vmware.task.AbstractTask;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.HostVirtualNic;
import com.vmware.vim25.PhysicalNic;

/**
 * 抽象任务类
 */
public abstract class AbstractHostTask extends AbstractTask<List<HostObj>>{

	/**
	 * 构建主机网络配置
	 * @param hostObj
	 * @param hostNetworkInfo
	 */
	public void  buildHostNetworkInfo(HostObj hostObj,HostNetworkInfo hostNetworkInfo) {
		hostObj.setNetworkInfo(hostNetworkInfo);
		ArrayList<String> hostIps = new ArrayList<String>();
		String hostIp = "";
		String mac="";
		for(PhysicalNic pnic :hostObj.getNetworkInfo().getPnic()){
			if(pnic.getSpec().getIp().getIpAddress().length() > 0){
				hostIps.add(pnic.getSpec().getIp().getIpAddress());
			}
			mac = mac +pnic.getMac()+",";//根据物理网卡获取Mac
		}
		for( HostVirtualNic  vnic: hostObj.getNetworkInfo().getVnic()){
			if(vnic.getSpec().getIp().getIpAddress().length() > 0){
				hostIps.add(vnic.getSpec().getIp().getIpAddress());//根据物理网卡获取IP
			}
		}
		String[] hostIpsArr = hostIps.toArray(new String[0]);
		Arrays.sort(hostIpsArr);//对IP地址进行排序
		if(hostIpsArr.length>0){
			for (int i = 0; i < hostIpsArr.length; i++) {
				hostIp = hostIp+hostIpsArr[i]+",";
			}
			hostIp = hostIp.substring(0, hostIp.length()-1);
		}
		if(mac.length()>0){
			mac = mac.substring(0, mac.length()-1);
		}
		hostObj.setMacAddress(mac);
		hostObj.setIpAddress(hostIp);
	}
}
