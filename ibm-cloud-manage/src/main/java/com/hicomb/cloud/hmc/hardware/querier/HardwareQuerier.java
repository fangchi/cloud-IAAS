package com.hicomb.cloud.hmc.hardware.querier;

import java.util.ArrayList;
import java.util.List;

import com.hicomb.cloud.hmc.hardware.entity.HardWare;
import com.hicomb.cloud.hmc.hardware.entity.LparOption;
import com.hicomb.cloud.hmc.hardware.entity.MemoryOption;
import com.hicomb.cloud.hmc.hardware.entity.ProcOption;
import com.hicomb.cloud.hmc.hardware.entity.SlotOption;
import com.hicomb.cloud.hmc.hardware.entity.SubSlotOption;
import com.hicomb.cloud.hmc.tools.CommondLineTools;

/**
 * 硬件查询器
 */
public class HardwareQuerier {

	/**
	 * 处理HMC返回的消息
	 * @param responseStr
	 * @return
	 */
	private static boolean handleResponseStr(String responseStr ){
		if(responseStr.contains("No results")){//如果没有结果
			return false;
		}
		return true;
	}
	
	/**
	 * 获取硬件列表
	 * @param hostIp ip地址
	 * @param port 端口
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	public static List<HardWare> queryHardWareList(String hostIp,int port,String userName,String password){
		List<HardWare> hardWareList  = new ArrayList<HardWare>();
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, "lssyscfg -r sys -F name,serial_num,type_model,ipaddr,state,power_on_option");
		//获取硬件列表
		if(responseStr!=null){
			String[] hardWareStrs = responseStr.split("\n");
			for (int i = 0; i < hardWareStrs.length; i++) {//解析结果
				HardWare hardWare = new HardWare();
				String[] hardWareAttrs = hardWareStrs[i].split(",");
				String name = hardWareAttrs[0];
				String serialNum = hardWareAttrs[1];
				String typeModel = hardWareAttrs[2];
				String ipaddr = hardWareAttrs[3];
				String state = hardWareAttrs[4];
				String powerOnOption = hardWareAttrs[5];
				hardWare.setName(name);
				hardWare.setSerialNum(serialNum);
				hardWare.setTypeModel(typeModel);
				hardWare.setIpaddr(ipaddr);
				hardWare.setState(state);
				hardWare.setPowerOnOption(powerOnOption);
				if("standby".equals(powerOnOption)||"operating".equals(powerOnOption)||"autostart".equals(powerOnOption)){ //仅能采集运行中的计算机
					//Lpar
					hardWare.setLparOptions(queryHardWareLpar(hostIp, port, userName, password, name));
					//Proc
					hardWare.setProcOption(queryHardWareProcOptions( hostIp, port, userName, password, name));
					//memory
					hardWare.setMemoryOption(queryHardWareMemOptions( hostIp, port, userName, password, name));
					//Slots
					List<SlotOption> listSlotOptions = queryHardWareSlotOptions( hostIp, port, userName, password, name);
					if(listSlotOptions == null){//判断是否支持硬件采集
						hardWare.setSupportDiscorvery(false);
					}else {
						hardWare.setSupportDiscorvery(true);
						hardWare.setSlotOptions(listSlotOptions);
						//SubSlots
						hardWare.setSubSlotOptions(queryHardWareSubSlotOptions( hostIp, port, userName, password, name));
					}
					hardWare.setVirtualIO(queryHardWareVirtualioOptions( hostIp, port, userName, password, name));
				}
				hardWareList.add(hardWare);
			}
		}
		return hardWareList;
	}
	
	/**
	 * 获取硬件处理器信息
	 * @param hostIp 
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 硬件设备名称
	 * @return
	 */
	public static ProcOption queryHardWareProcOptions(String hostIp,int port,String userName,String password,String hardWareName){
		ProcOption procOption = null;
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, "lshwres -r proc -m {id} -F configurable_sys_proc_units,curr_avail_sys_proc_units,installed_sys_proc_units --level sys".replace("{id}", hardWareName));
		if(responseStr!= null){
			String[] hardWareProcAttrs = responseStr.split(",");
			Double configurableSysProcUnits = Double.parseDouble(hardWareProcAttrs[0]);
			Double currAvailSysProcUnits = Double.parseDouble(hardWareProcAttrs[1]);
			Double installedSysProcUnits = Double.parseDouble(hardWareProcAttrs[2]);
			procOption = new ProcOption();
			procOption.setConfigurableSysProcUnits(configurableSysProcUnits);
			procOption.setCurrAvailSysProcUnits(currAvailSysProcUnits);
			procOption.setInstalledSysProcUnits(installedSysProcUnits);
		}
		return procOption;
	}
	
	/**
	 * 获取硬件内存信息
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 硬件设备名称
	 * @return
	 */
	public static MemoryOption queryHardWareMemOptions(String hostIp,int port,String userName,String password,String hardWareName){
		MemoryOption memoryOption = null;
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, "lshwres -r mem -m {id} -F configurable_sys_mem,curr_avail_sys_mem,installed_sys_mem,sys_firmware_mem --level sys".replace("{id}", hardWareName));
		if(responseStr!= null){
			String[] hardWareMemAttrs = responseStr.split(",");
			Double configurableSysMem = Double.parseDouble(hardWareMemAttrs[0]);
			Double currAvailSysMem = Double.parseDouble(hardWareMemAttrs[1]);
			Double installedSysMem = Double.parseDouble(hardWareMemAttrs[2]);
			Double sysFirmwareMem = Double.parseDouble(hardWareMemAttrs[3]);
			memoryOption = new MemoryOption();
			memoryOption.setConfigurableSysMem(configurableSysMem);
			memoryOption.setCurrAvailSysMem(currAvailSysMem);
			memoryOption.setInstalledSysMem(installedSysMem);
			memoryOption.setSysFirmwareMem(sysFirmwareMem);
		}
		return memoryOption;
	}
	
	/**
	 * 获取硬件卡槽信息
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 设备名称
	 * @return
	 */
	public static List<SlotOption> queryHardWareSlotOptions(String hostIp,int port,String userName,String password,String hardWareName){
		List<SlotOption> slotOptions = new ArrayList<SlotOption>();
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, 
				"lshwres -r io --rsubtype slot -m {id} -F unit_phys_loc,phys_loc,drc_name,description".replace("{id}", hardWareName));
		if(responseStr.contains("not support")){
			return null;
		}
		if(handleResponseStr(responseStr)){
			String[] slotsStr = responseStr.split("\n");
			for(String slot:slotsStr){
				String[] hardWareSlotAttrs = slot.split(",");
				slotOptions.add(new SlotOption(hardWareSlotAttrs[0]+"."+hardWareSlotAttrs[1],hardWareSlotAttrs[2], hardWareSlotAttrs[3]));
			}
		}
		return slotOptions;
	}
	
	/**
	 * 获取硬件子卡槽信息
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 设备名称
	 * @return
	 */
	public static List<SubSlotOption> queryHardWareSubSlotOptions(String hostIp,int port,String userName,String password,String hardWareName){
		List<SubSlotOption> subSlotOptions = new ArrayList<SubSlotOption>();
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, 
				"lshwres -r io --rsubtype slotchildren -m {id} -F phys_loc,description,mac_address,wwpn".replace("{id}", hardWareName));
		if(responseStr.contains("not support")){
			return null;
		}
		if(handleResponseStr(responseStr)){
			String[] slotsStr = responseStr.split("\n");
			for(String slot:slotsStr){
				String[] hardWareSlotAttrs = slot.split(",");
				subSlotOptions.add(new SubSlotOption(hardWareSlotAttrs[0], hardWareSlotAttrs[1],hardWareSlotAttrs[2], hardWareSlotAttrs[3]));
			}
		}
		return subSlotOptions;
	}
	
	/**
	 * 获取硬件虚拟IO信息
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 硬件名称
	 * @return
	 */
	public static List<String> queryHardWareVirtualioOptions(String hostIp,int port,String userName,String password,String hardWareName){
		List<String> virtualIOList = new ArrayList<String>();
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, 
					"lshwres -r virtualio --rsubtype eth -m {id} --level lpar -F lpar_name".replace("{id}", hardWareName));
		
		String[] virtualIOs =responseStr.split("\n");
		if(responseStr.contains("not support")){
			return null;
		}
		if(handleResponseStr(responseStr)){
			for(String virtualIO:virtualIOs){
				virtualIOList.add(virtualIO);
			}
		}
		return virtualIOList;
	}
	
	/**
	 * 获取硬件Lpar信息
	 * @param hostIp
	 * @param port
	 * @param userName
	 * @param password
	 * @param hardWareName 设备名称
	 * @return
	 */
	public static List<LparOption> queryHardWareLpar(String hostIp,int port,String userName,String password,String hardWareName){
		List<LparOption> lparOptionList = new ArrayList<LparOption>();
		String responseStr = CommondLineTools.getCommondResponse(hostIp, port, userName,password, 
					"lssyscfg -r lpar -m {id} -F name,rmc_ipaddr".replace("{id}", hardWareName));
		String[] lpars =responseStr.split("\n");
		if(handleResponseStr(responseStr)){
			for(String lpar:lpars){
				if(!"".equals(lpars)){
					if(lpar.split(",").length >= 2){
						lparOptionList.add(new LparOption(lpar.split(",")[0],lpar.split(",")[1]));
					} else if(lpar.length() == 1){
						lparOptionList.add(new LparOption(lpar.split(",")[0],null));
					}
				}
			}
		}
		return lparOptionList;
	}
}
