package com.hicomb.cloud.rest.powerperformance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.cloud.rest.common.CommonConst;
import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.virtualmachine.VirtualMachine;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sysdirector.SystemDirectorRestEngine;
import com.hicomb.cloud.rest.sysdirector.entity.vm.PowerVirtualMachinePerf;
import com.hicomb.cloud.rest.sysdirector.https.HttpsSystemDirectorRestEngine;

/**
 * Power主机新能查询器
 */
public class PowerVirtualMachinePerfQuerier {

	private static final Log logger = LogFactory
			.getLog(PowerVirtualMachinePerfQuerier.class);

	/**
	 * 获取Power主机性能
	 * @param sceProtocal sce协议
	 * @param sceIp sce IP
	 * @param scePort sce 端口
	 * @param sceUserName sce用户名
	 * @param scePassword sce密码
	 * @param sysDirectorProtocal  director协议
	 * @param sysDirectorIp director ip
	 * @param sysDirectorPort director 端口
	 * @param sysDirectorUserName director用户名称
	 * @param sysDirectorPassword  director 密码
	 * @return
	 * @throws CloudRestException
	 */
	public List<PowerVirtualMachinePerf> queryPowerVirtualMachinePerformance(
			String sceProtocal, String sceIp, int scePort, String sceUserName,
			String scePassword, String sysDirectorProtocal,
			String sysDirectorIp, int sysDirectorPort,
			String sysDirectorUserName, String sysDirectorPassword)
			throws CloudRestException {
		try {
			List<PowerVirtualMachinePerf> powerVirtualMachinePerfList = new ArrayList<PowerVirtualMachinePerf>();
			SmartCloudEntryRestEngine smartCloudEntryRestEngine = null;
			SystemDirectorRestEngine systemDirectorRestEngine = null;
			if ("HTTP".equalsIgnoreCase(sceProtocal)) {
				smartCloudEntryRestEngine = new HttpSmartCloudEntryRestEngine();
			}
			if ("HTTPS".equalsIgnoreCase(sceProtocal)) {
				throw new CloudRestException("尚未实现SCE https");//TODO 尚未实现HTTPS
			}
			if ("HTTP".equalsIgnoreCase(sysDirectorProtocal)) {
				throw new CloudRestException("尚未实现SysDirector http");//TODO 尚未实现HTTP
			}
			if ("HTTPS".equalsIgnoreCase(sysDirectorProtocal)) {
				systemDirectorRestEngine = new HttpsSystemDirectorRestEngine();
			}
			List<VirtualMachine> virtualMachines = smartCloudEntryRestEngine
					.queryVirtualMachines(sceIp, scePort, sceUserName,
							scePassword);//遍历获取虚拟机列表
			for (Iterator<VirtualMachine> iterator = virtualMachines.iterator(); iterator
					.hasNext();) {
				VirtualMachine virtualMachine = (VirtualMachine) iterator
						.next();
				if (CommonConst.ARCHITECTURE_POWER
						.equalsIgnoreCase(virtualMachine.getArchitecture())) {//构建性能
					PowerVirtualMachinePerf powerVirtualMachinePerf = systemDirectorRestEngine
							.queryPowerVirtualMachinePerf(sysDirectorIp,
									sysDirectorPort, sysDirectorUserName,
									sysDirectorPassword,
									virtualMachine.getSrcId());
					powerVirtualMachinePerf.setOid(virtualMachine.getId());
					powerVirtualMachinePerf.setSrcId(virtualMachine.getSrcId());
					powerVirtualMachinePerfList.add(powerVirtualMachinePerf);
				}
			}
			return powerVirtualMachinePerfList;
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
			throw new CloudRestException(e.getLocalizedMessage());
		}

	}
}
