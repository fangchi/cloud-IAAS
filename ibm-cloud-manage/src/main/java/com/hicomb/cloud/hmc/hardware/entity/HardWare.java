package com.hicomb.cloud.hmc.hardware.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 硬件对象
 */
public class HardWare {
	public final static int NUMBER_UNKNOWN = -1;
	/*名称*/
	private String name;
	/*序列号*/
	private String serialNum;
	/*型号*/
	private String typeModel;
	/*ip*/
	private String ipaddr;
	/*状态*/
	private String state;
	/*是否注电*/
	private String powerOnOption;
	/*是否支持硬件发现*/
	private boolean supportDiscorvery;
	/*Lpar*/
	private List<LparOption> lparOptions =  new ArrayList<LparOption>();
	/*处理器*/
	private ProcOption procOption;
	/*内存*/
	private MemoryOption memoryOption;
	/*卡槽*/
	private List<SlotOption> slotOptions =  new ArrayList<SlotOption>();
	/*子卡槽*/
	private List<SubSlotOption> subSlotOptions =  new ArrayList<SubSlotOption>();
	/*虚拟IO*/
	private List<String> virtualIO =  new ArrayList<String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getTypeModel() {
		return typeModel;
	}

	public void setTypeModel(String typeModel) {
		this.typeModel = typeModel;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPowerOnOption() {
		return powerOnOption;
	}

	public void setPowerOnOption(String powerOnOption) {
		this.powerOnOption = powerOnOption;
	}
	
	public List<LparOption> getLparOptions() {
		return lparOptions;
	}

	public void setLparOptions(List<LparOption> lparOptions) {
		this.lparOptions = lparOptions;
	}

	public ProcOption getProcOption() {
		return procOption;
	}

	public void setProcOption(ProcOption procOption) {
		this.procOption = procOption;
	}

	public MemoryOption getMemoryOption() {
		return memoryOption;
	}

	public void setMemoryOption(MemoryOption memoryOption) {
		this.memoryOption = memoryOption;
	}

	public List<SlotOption> getSlotOptions() {
		return slotOptions;
	}

	public void setSlotOptions(List<SlotOption> slotOptions) {
		this.slotOptions = slotOptions;
	}

	public List<SubSlotOption> getSubSlotOptions() {
		return subSlotOptions;
	}

	public void setSubSlotOptions(List<SubSlotOption> subSlotOptions) {
		this.subSlotOptions = subSlotOptions;
	}

	public List<String> getVirtualIO() {
		return virtualIO;
	}

	public void setVirtualIO(List<String> virtualIO) {
		this.virtualIO = virtualIO;
	}

	public boolean isSupportDiscorvery() {
		return supportDiscorvery;
	}

	public void setSupportDiscorvery(boolean supportDiscorvery) {
		this.supportDiscorvery = supportDiscorvery;
	}

	/**
	 * 是否虚拟化(安装VIOS)
	 * @return
	 */
	public boolean isVirtualized(){
		for(LparOption lparOption:lparOptions){
			if(lparOption.getLparName().toLowerCase().matches(".*vios.*")){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取目前没有使用的Slot
	 * @return
	 */
	public int getEmptySlot(){
		int result = 0;
		for(SlotOption  slotOption : slotOptions){
			if("empty slot".equals(slotOption.getName().toLowerCase())){
				result = result+1;
			}
		}
		return result;
	}
	
	/**
	 * 获取所有Slot
	 * @return
	 */
	public int getTotalSlot(){
		return slotOptions.size();
	}
	
	/**
	 * 获取光纤通道
	 * @return
	 */
	public int getFiberChanelTotalSlot(){
		Set<String> allFiberChanelStrings =new HashSet<String>();
		//IBM 算法  根据wwpn有多少就有多少 
		if(subSlotOptions!=null){
			for(SubSlotOption  subSlotOption : subSlotOptions){//
				if(!"null".equals(subSlotOption.getWwpn())){//description 8 Gigabit PCI-E Dual Port Fibre Channel Adapter
					allFiberChanelStrings.add(subSlotOption.getWwpn());
				}
			}
		}
		return allFiberChanelStrings.size()==0?NUMBER_UNKNOWN:allFiberChanelStrings.size();
	}
	
	
	/**
	 * 获取以太网卡
	 * @return
	 */
	public int getEthernetSlotTotalSlot(){
		Set<String> allEthernetStrings =new HashSet<String>();
		//IBM 算法  根据Mac有多少就有多少
		if(subSlotOptions!=null){
			for(SubSlotOption  subSlotOption : subSlotOptions){
				if(!"null".equals(subSlotOption.getMacAddress())){//description 8 Gigabit PCI-E Dual Port Fibre Channel Adapter
					allEthernetStrings.add(subSlotOption.getMacAddress());
				}
			}
		}
		return allEthernetStrings.size()==0?NUMBER_UNKNOWN:allEthernetStrings.size();
	}
	
	/**
	 * 获取磁盘
	 * @return
	 */
	public int getDiskSlotTotalSlot(){
		List<String> allDiskStrings =new ArrayList<String>();
		if(subSlotOptions!=null){
			for(SubSlotOption  subSlotOption : subSlotOptions){
				if(subSlotOption.getDescription().toLowerCase().matches(".*disk.*")){//DISK
					allDiskStrings.add(subSlotOption.getDescription());
				}
			}
		}
		return allDiskStrings.size()==0?NUMBER_UNKNOWN:allDiskStrings.size();
	}
}
