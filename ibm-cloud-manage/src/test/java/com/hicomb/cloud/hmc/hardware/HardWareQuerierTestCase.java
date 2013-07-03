package com.hicomb.cloud.hmc.hardware;

import java.util.Iterator;
import java.util.List;

import com.hicomb.cloud.hmc.base.BaseTestCase;
import com.hicomb.cloud.hmc.hardware.entity.HardWare;
import com.hicomb.cloud.hmc.hardware.entity.MemoryOption;
import com.hicomb.cloud.hmc.hardware.entity.ProcOption;
import com.hicomb.cloud.hmc.hardware.entity.SlotOption;
import com.hicomb.cloud.hmc.hardware.entity.SubSlotOption;
import com.hicomb.cloud.hmc.hardware.querier.HardwareQuerier;

/**
 * 硬件查询测试用例
 */
public class HardWareQuerierTestCase extends BaseTestCase {

	/**
	 * 测试查询硬件
	 */
	public final void testQueryHardWaresCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		printHareWares(hardWareList);
	}
	
	/**
	 * 打印硬件信息
	 */
	public final void testQueryHardWaresProcCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			ProcOption procOption = HardwareQuerier.queryHardWareProcOptions(hostIp, port, userName, password, hardWare.getName());
			System.out.println(hardWare.getName());
			System.out.println(procOption.getInstalledSysProcUnits());
			System.out.println(procOption.getConfigurableSysProcUnits());
			System.out.println(procOption.getCurrAvailSysProcUnits());
		}
	}
	
	public final void testQueryHardWaresMemoryCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			MemoryOption memoryOption = HardwareQuerier.queryHardWareMemOptions(hostIp, port, userName, password, hardWare.getName());
			System.out.println(hardWare.getName());
			System.out.println(memoryOption.getConfigurableSysMem());
			System.out.println(memoryOption.getCurrAvailSysMem());
			System.out.println(memoryOption.getInstalledSysMem());
			System.out.println(memoryOption.getSysFirmwareMem());
		}
	}
	
	public final void testQueryHardWaresSlotCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			List<SlotOption> slotOptionList = HardwareQuerier.queryHardWareSlotOptions(hostIp, port, userName, password, hardWare.getName());
			System.out.println(hardWare.getName());
			for (Iterator<SlotOption> iterator2 = slotOptionList.iterator(); iterator2
					.hasNext();) {
				SlotOption slotOption = (SlotOption) iterator2.next();
				System.out.println(slotOption.getDescription());
			}
		}
	}
	
	public final void testQueryHardWaresVitualizaedCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			System.out.println(hardWare.getName()+"isVirtualized:"+hardWare.isVirtualized());
		}
	}
	
	
	public final void testQueryHardWaresSubSlotCommond(){
		List<HardWare> hardWareList = HardwareQuerier.queryHardWareList(hostIp, port, userName, password);
		assertNotNull(hardWareList);
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			List<SubSlotOption> subSlotOptionList = HardwareQuerier.queryHardWareSubSlotOptions(hostIp, port, userName, password, hardWare.getName());
			System.out.println("#########################"+hardWare.getName());
			for (Iterator<SubSlotOption> iterator2 = subSlotOptionList.iterator(); iterator2
					.hasNext();) {
				SubSlotOption subSlotOption = (SubSlotOption) iterator2.next();
				System.out.println(".....................");
				System.out.println("id:"+subSlotOption.getId());
				System.out.println("Description:"+subSlotOption.getDescription());
				System.out.println("MacAddress:"+subSlotOption.getMacAddress());
				System.out.println("Wwpn:"+subSlotOption.getWwpn());
			}
		}
	}
	
	
	protected void printHareWares(List<HardWare> hardWareList){
		for (Iterator<HardWare> iterator = hardWareList.iterator(); iterator.hasNext();) {
			HardWare hardWare = (HardWare) iterator.next();
			System.out.println(".........");
			System.out.println("name:"+hardWare.getName());
			System.out.println("SerialNum:"+hardWare.getSerialNum());
			System.out.println("TypeModel:"+hardWare.getTypeModel());
			System.out.println("Ipaddr:"+hardWare.getIpaddr());
			System.out.println("State:"+hardWare.getState());
			System.out.println("PowerOnOption:"+hardWare.getPowerOnOption());
			System.out.println("EthernetSlotTotalSlot:"+hardWare.getEthernetSlotTotalSlot());
			System.out.println("EmptySlot:"+hardWare.getEmptySlot());
			System.out.println("TotalSlot:"+hardWare.getTotalSlot());
			System.out.println("DiskSlotTotalSlot:"+hardWare.getDiskSlotTotalSlot());
			System.out.println("FiberChanelTotalSlot:"+hardWare.getFiberChanelTotalSlot());
			System.out.println("isVitual:"+hardWare.isVirtualized());
//			System.out.println("InstalledSysProcUnits:"+hardWare.getProcOption().getInstalledSysProcUnits());
//			System.out.println("ConfigurableSysProcUnits:"+hardWare.getProcOption().getConfigurableSysProcUnits());
//			System.out.println("CurrAvailSysProcUnits:"+hardWare.getProcOption().getCurrAvailSysProcUnits());
//			System.out.println("ConfigurableSysMem:"+hardWare.getMemoryOption().getConfigurableSysMem());
//			System.out.println("CurrAvailSysMem:"+hardWare.getMemoryOption().getCurrAvailSysMem());
//			System.out.println("InstalledSysMem:"+hardWare.getMemoryOption().getInstalledSysMem());
//			System.out.println("SysFirmwareMem:"+hardWare.getMemoryOption().getSysFirmwareMem());
		}
	}
	
}
