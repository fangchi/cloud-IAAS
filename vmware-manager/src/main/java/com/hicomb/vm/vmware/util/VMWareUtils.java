package com.hicomb.vm.vmware.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.cluster.perf.QueryClusterPerfTask;
import com.hicomb.vm.vmware.task.host.HostObj;
import com.hicomb.vm.vmware.task.vm.VirtualMachineObj;
import com.vmware.vim25.ArrayOfManagedObjectReference;
import com.vmware.vim25.ArrayOfPerfCounterInfo;
import com.vmware.vim25.DynamicProperty;
import com.vmware.vim25.HostNetworkInfo;
import com.vmware.vim25.HostVirtualNic;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfMetricSeries;
import com.vmware.vim25.PerfQuerySpec;
import com.vmware.vim25.PhysicalNic;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.TraversalSpec;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VirtualMachineConfigInfo;

/**
 * 工具类
 */
public class VMWareUtils {
	
	private static final Log logger = LogFactory.getLog(VMWareUtils.class);

	/**
	 * 获取动态属性，方法逻辑：
	 * 1.创建属性条件数组：PropertySpec[]
	 * 2.创建属性过滤条件数组：PropertyFilterSpec[]
	 * 3.调用sdk的retrieveProperties方法获取数据
	 * 4.以<管理对象引用, <属性名, 属性对象>>组织Map数据，如果属性对象是基本数据类型，那么将其转化为相应包装类。
	 * 
	 * 注意：
	 * 正常情况下返回非空Map，如果参数不合法，则会返回null
	 * 
	 * @param connection    vsphere连接，该连接的状态必须是已连接
	 * @param infoType    属性路径，最佳形式为{{管理对象名称,属性名称1,属性名称2,...}...}，如new String[][] { new String[] { "HostSystem",
	 * "summary" }}，最终返回的是HostSystem管理对象的summary属性
	 * @throws VMTaskException 
	 */
	public static Map<ManagedObjectReference, Map<String, Object>> retrieveProperties(VMWareConnection connection,
			String[][] infoType) throws VMTaskException {
		// 参数验证
		if (connection == null || connection.isClosed()) {
			return null;
		}
		if (infoType == null || infoType.length <= 0) {
			return null;
		}

		ManagedObjectReference usecoll = connection.getPropCol();
		ManagedObjectReference useroot = connection.getRootFolder();
		SelectionSpec[] selectionSpecs = buildFullTraversal();
		PropertySpec[] propspecary = buildPropertySpecArray(infoType);
		PropertyFilterSpec spec = new PropertyFilterSpec(null, null, propspecary, new ObjectSpec[] { new ObjectSpec(null,
				null, useroot, Boolean.FALSE, selectionSpecs) }, null);
		ObjectContent[] retoc = null;
		try {
			retoc = connection.getService().retrieveProperties(usecoll, new PropertyFilterSpec[] { spec });
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取vsphere动态属性失败",e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常：获取vsphere动态属性失败",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取vsphere动态属性失败",e);
		} 
		Map<ManagedObjectReference, Map<String, Object>> returnMap = new HashMap<ManagedObjectReference, Map<String, Object>>();
		if (retoc != null && retoc.length >= 0) {
			for (ObjectContent content : retoc) {
				Map<String, Object> propMap = new HashMap<String, Object>();
				returnMap.put(content.getObj(), propMap);
				for (DynamicProperty prop : content.getPropSet()) {
					propMap.put(prop.getName(), prop.getVal());
				}
			}
		}
		return returnMap;
	}

	/**
	 * 获取指定指标的管理对象性能数据，方法逻辑：
	 * 1.创建性能查询条件数组：PerfQuerySpec[]
	 * 2.手动创建性能标识数组：PerfMetricId[]
	 * 3.使用ServiceInstance的queryPerf方法查询性能指标数据
	 * 4.以<管理对象引用, <指标定义标识, 指标性能值>>方式组织Map数据并返回
	 * 
	 * 注意：
	 * 正常情况下返回非空Map，如果参数不合法，则会返回null
	 * 
	 * @param connection    vsphere连接，该连接的状态必须是已连接
	 * @param mors    管理对象引用列表
	 * @param counterIds    性能指标标识
	 */
	public static Map<ManagedObjectReference, Map<Integer, Long>> getIntPerfValues(VMWareConnection connection,
			ManagedObjectReference[] mors, int[] counterIds) throws VMTaskException {
		// 参数验证
		if (connection == null || connection.isClosed()) {
			return null;
		}
		if (mors == null || mors.length <= 0) {
			return null;
		}
		if (counterIds == null || counterIds.length <= 0) {
			return null;
		}

		ManagedObjectReference perfMgr = connection.getServiceContent().getPerfManager();
		VimPortType service = connection.getService();

		// 性能数据的查询开始时间
		Calendar endTime = Calendar.getInstance();
		Calendar startTime = (Calendar) endTime.clone();
		startTime.add(Calendar.SECOND, -20);
		// start.add(Calendar.SECOND, 0); //目前只查询实时数据，所以不需要这一项

		// 查询的性能指标标识
		PerfMetricId[] metricIds = new PerfMetricId[counterIds.length];
		for (int i = 0; i < counterIds.length; i++) {
			metricIds[i] = new PerfMetricId(null, null, counterIds[i], "");
		}

		// 查询条件
		PerfQuerySpec[] qSpecs = new PerfQuerySpec[mors.length];
		for (int i = 0; i < qSpecs.length; i++) {
			qSpecs[i] = new PerfQuerySpec();
			qSpecs[i].setMetricId(metricIds);
			qSpecs[i].setEntity(mors[i]);
			qSpecs[i].setStartTime(startTime);
			qSpecs[i].setEndTime(endTime);
			// 查询vsphere性能更新周期为20s的性能数据
			qSpecs[i].setIntervalId(Integer.valueOf(20));
		}

		PerfEntityMetricBase[] samples = null;
		try {
			samples = service.queryPerf(perfMgr, qSpecs);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常：获取指定指标的管理对象性能数据失败",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取指定指标的管理对象性能数据失败",e);
		} 
		Map<ManagedObjectReference, Map<Integer, Long>> resultMap = new HashMap<ManagedObjectReference, Map<Integer, Long>>();
		if (samples != null) {
			for (PerfEntityMetricBase obj : samples) {
				PerfEntityMetric sample = (PerfEntityMetric) obj;
				Map<Integer, Long> valueMap = new HashMap<Integer, Long>();
				resultMap.put(sample.getEntity(), valueMap);

				// 每个指标都会对应一组性能数据，我们只获取最近一次的性能数据
				int latestIndex = sample.getSampleInfo().length - 1;
				if (latestIndex >= 0) {
					for (PerfMetricSeries series : sample.getValue()) {
						valueMap.put(Integer.valueOf(series.getId().getCounterId()),
								Long.valueOf(((PerfMetricIntSeries) series).getValue(latestIndex)));
					}
				}
			}
		}
		return resultMap;
	}

	/**
	 * 获取指定管理对象的属性，方法逻辑：
	 * 获取动态属性，方法逻辑：
	 * 1.创建属性过滤条件数组：PropertyFilterSpec[]
	 * 2.调用sdk的retrieveProperties方法获取数据
	 * 3.以<属性名, 属性对象>组织Map数据，如果属性对象是基本数据类型，那么将其转化为相应包装类。
	 * 
	 * 注意：
	 * 正常情况下返回非空Map，如果参数不合法，则会返回null
	 * 
	 * @param connection    vsphere连接，该连接的状态必须是已连接
	 * @param mor    管理对象引用
	 * @param properties    属性名，如new String[] {"perfCounter"}，最终查询管理对象的perfCounter属性
	 */
	public static Map<String, Object> retrieveProperties(VMWareConnection connection, ManagedObjectReference mor,
			String[] properties) throws VMTaskException {
		//参数验证
		if (connection == null || connection.isClosed()) {
			return null;
		}
		if (mor == null) {
			return null;
		}
		if (properties == null || properties.length <= 0) {
			return null;
		}

		ManagedObjectReference usecoll = connection.getPropCol();
		PropertyFilterSpec spec = new PropertyFilterSpec();
		spec.setPropSet(new PropertySpec[] { new PropertySpec() });
		spec.getPropSet(0).setAll(new Boolean(properties == null || properties.length == 0));
		spec.getPropSet(0).setType(mor.getType());
		spec.getPropSet(0).setPathSet(properties);
		spec.setObjectSet(new ObjectSpec[] { new ObjectSpec() });
		spec.getObjectSet(0).setObj(mor);
		spec.getObjectSet(0).setSkip(Boolean.FALSE);

		ObjectContent[] retoc = null;
		try {
			retoc = connection.getService().retrieveProperties(usecoll, new PropertyFilterSpec[] { spec });
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取指定管理对象的属性",e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常：获取指定管理对象的属性",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取指定管理对象的属性",e);
		} 
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (retoc != null && retoc.length >= 0)
			for (DynamicProperty prop : retoc[0].getPropSet()) {
				returnMap.put(prop.getName(), prop.getVal());
			}
		return returnMap;
	}
	
	private static SelectionSpec[] buildFullTraversal() {
		// Recurse through all ResourcePools
		TraversalSpec rpToRp = new TraversalSpec(null, null, null, "ResourcePool", "resourcePool", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "rpToRp"), new SelectionSpec(null, null, "rpToVm") });
		rpToRp.setName("rpToRp");
		// Recurse through all ResourcePools
		TraversalSpec rpToVm = new TraversalSpec(null, null, null, "ResourcePool", "vm", Boolean.FALSE,
				new SelectionSpec[] {});
		rpToVm.setName("rpToVm");
		// Traversal through ResourcePool branch
		TraversalSpec crToRp = new TraversalSpec(null, null, null, "ComputeResource", "resourcePool", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "rpToRp"), new SelectionSpec(null, null, "rpToVm") });
		crToRp.setName("crToRp");
		// Traversal through host branch
		TraversalSpec crToH = new TraversalSpec(null, null, null, "ComputeResource", "host", Boolean.FALSE,
				new SelectionSpec[] {});
		crToH.setName("crToH");
		// Traversal through hostFolder branch
		TraversalSpec dcToHf = new TraversalSpec(null, null, null, "Datacenter", "hostFolder", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "visitFolders") });
		dcToHf.setName("dcToHf");
		// Traversal through vmFolder branch
		TraversalSpec dcToVmf = new TraversalSpec(null, null, null, "Datacenter", "vmFolder", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "visitFolders") });
		dcToVmf.setName("dcToVmf");
		// Recurse through all Hosts
		TraversalSpec HToVm = new TraversalSpec(null, null, null, "HostSystem", "vm", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "visitFolders") });
		HToVm.setName("HToVm");
		// Recurse thriugh the folders
		TraversalSpec visitFolders = new TraversalSpec(null, null, null, "Folder", "childEntity", Boolean.FALSE,
				new SelectionSpec[] { new SelectionSpec(null, null, "visitFolders"), new SelectionSpec(null, null, "dcToHf"),
						new SelectionSpec(null, null, "dcToVmf"), new SelectionSpec(null, null, "crToH"),
						new SelectionSpec(null, null, "crToRp"), new SelectionSpec(null, null, "HToVm"),
						new SelectionSpec(null, null, "rpToVm"), });
		visitFolders.setName("visitFolders");
		return new SelectionSpec[] { visitFolders, dcToVmf, dcToHf, crToH, crToRp, rpToRp, HToVm, rpToVm };
	}
	
	/**
	参加属性条件数组
	1.整理参数，最终形式为Map<管理对象名称,Set<属性名称1.属性名称2,...>...>
	2.创建属性条件数组
	 */
	private static PropertySpec[] buildPropertySpecArray(String[][] typeinfo) {
		// Eliminate duplicates
		HashMap<String, Set<String>> tInfo = new HashMap<String, Set<String>>();
		for (int ti = 0; ti < typeinfo.length; ++ti) {
			Set<String> props = tInfo.get(typeinfo[ti][0]);
			if (props == null) {
				props = new HashSet<String>();
				tInfo.put(typeinfo[ti][0], props);
			}
			for (int pi = 1; pi < typeinfo[ti].length; ++pi) {
				props.add(typeinfo[ti][pi]);
			}
		}

		// Create PropertySpecs
		PropertySpec[] pSpecs = new PropertySpec[tInfo.keySet().size()];
		int index = 0;
		for (String type : tInfo.keySet()) {
			PropertySpec pSpec = new PropertySpec();
			Set<String> props = tInfo.get(type);
			pSpec.setType(type);
			pSpec.setAll(props.isEmpty() ? Boolean.TRUE : Boolean.FALSE);
			pSpec.setPathSet(props.toArray(new String[0]));
			pSpecs[index++] = pSpec;
		}
		return pSpecs;
	}
	
	/**
	 * 获取所有性能指标定义信息
	 * 
	 * vsphere尚未提供获取指标定义的遍历操作（如直接根据指标组或名称查询指标）
	 * @param connection
	 * @return 以<指标标识、指标对象>的方式来组织数据并返回
	 * @throws VMTaskException
	 */
	public static Map<Integer, PerfCounterInfo> queryAllPerfCounterInfo(VMWareConnection connection) throws VMTaskException {
		//获取性能指标定义信息
		String[] properties = new String[] { "perfCounter" };
		Map<String, Object> perfInfos = null;
		try {
			perfInfos = retrieveProperties(connection, connection.getServiceContent().getPerfManager(),
					properties);
		} catch (VMTaskException e) {
			throw new VMTaskException("获取性能指标定义失败", e);
		}
		Map<Integer, PerfCounterInfo> returnMap = new HashMap<Integer, PerfCounterInfo>();
		if (perfInfos != null && perfInfos.values() != null) {
			for (Object obj : perfInfos.values()) {
				for (PerfCounterInfo info : ((ArrayOfPerfCounterInfo) obj).getPerfCounterInfo())
					returnMap.put(Integer.valueOf(info.getKey()), info);
			}
		}
		return returnMap;
	}
	
	/**
	 * 根据性能类型（如cpu.usage 1对应平均值，等等）获取性能指标定义信息
	 * @param connection
	 * @param level
	 * @return
	 * @throws VMTaskException
	 */
	public static Map<Integer, PerfCounterInfo> queryPerfCounterInfosByLevel(VMWareConnection connection, int level)
			throws VMTaskException {
		// 获取性能指标定义
		PerfCounterInfo[] perfInfos = null;
		try {
			perfInfos = connection.getService().queryPerfCounterByLevel(connection.getServiceContent().getPerfManager(),
					level);
		} 
//		catch (Exception e) {
//			throw new VMTaskException("按级别[" + level + "]获取性能指标定义失败", e);
//		}
		catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常:按级别[" + level + "]获取性能指标定义失败",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常:按级别[" + level + "]获取性能指标定义失败",e);
		} 
		Map<Integer, PerfCounterInfo> returnMap = new HashMap<Integer, PerfCounterInfo>();
		if (perfInfos != null) {
			for (PerfCounterInfo info : perfInfos) {
				returnMap.put(Integer.valueOf(info.getKey()), info);
			}
		}
		return returnMap;
	}
	
	/**
	 * 通过VM的信息获取VM UUID号
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 */
	public static String getUUIDByVMInfo(ManagedObjectReference vm, ConnectionPool connectionPool) throws VMTaskException {
		String uuid = null;
		VirtualMachineObj obj = new VirtualMachineObj(vm);
		PropertyFilterSpec[] pfSpecListVM = getPropertyFilterSpec(vm, "VirtualMachine", new String[] { "config" });
		ObjectContent[] oContVM;
		VMWareConnection connection = connectionPool.getConnection();
		try {
			oContVM = connection.getService().retrieveProperties(connection.getPropCol(), pfSpecListVM);
			if (oContVM != null) {
				for (ObjectContent ocVM : oContVM) {
					DynamicProperty[] dpsVM = ocVM.getPropSet();
					if (dpsVM != null) {
						for (DynamicProperty dpVM : dpsVM) {
							if ("config".equals(dpVM.getName())) {
								obj.setVirtualMachineConfigInfo((VirtualMachineConfigInfo) dpVM.getVal());
							}
						}
					}
				}
			}
			uuid = obj.getVirtualMachineConfigInfo().getUuid();
			if(uuid != null){
				return uuid;
			} else {
				return "";
			}
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：通过VM的信息获取VM UUID号失败",e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常：通过VM的信息获取VM UUID号失败",e);
		} catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：通过VM的信息获取VM UUID号失败",e);
		} finally {
			connectionPool.freeConnection(connection);
		}
	}
	
	protected static PropertyFilterSpec[] getPropertyFilterSpec(
			ManagedObjectReference moref, String type, String[] properties) {
		// Create Property Spec
		PropertySpec propertySpec = new PropertySpec();
		propertySpec.setAll(Boolean.FALSE);
		propertySpec.setPathSet(properties);
		propertySpec.setType(type);
		PropertySpec[] propertySpecs = new PropertySpec[] { propertySpec };

		// Now create Object Spec
		ObjectSpec objectSpec = new ObjectSpec();
		objectSpec.setObj(moref);
		objectSpec.setSkip(Boolean.FALSE);
		// objectSpec.setSelectSet(new SelectionSpec[]{tSpec});
		ObjectSpec[] objectSpecs = new ObjectSpec[] { objectSpec };

		// Create PropertyFilterSpec using the PropertySpec and ObjectPec
		// created above.
		PropertyFilterSpec propertyFilterSpec = new PropertyFilterSpec();
		propertyFilterSpec.setPropSet(propertySpecs);
		propertyFilterSpec.setObjectSet(objectSpecs);

		PropertyFilterSpec[] pfSpecList = new PropertyFilterSpec[] { propertyFilterSpec };

		return pfSpecList;
	}
	
	/**获取VM的CPU频率
	 * @param connection
	 * @return
	 * @throws VMTaskException
	 */
	public static float getVmCpuMHZ(ManagedObjectReference host,VMWareConnection connection) throws VMTaskException {
		HostObj hostObj = null;
		try {
			hostObj = new HostObj(host);
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(host,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "summary.hardware.cpuMhz"});
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			if (oCont != null) {
				for (ObjectContent oc : oCont) {
					DynamicProperty[] dps = oc.getPropSet();
					if (dps != null) {
						for (DynamicProperty dp : dps) {
							if ("summary.hardware.cpuMhz".equals(dp.getName())) {
								hostObj.setCpuMhz((Integer) dp.getVal());
							}
						}
					}
				}
			}
			return (float)hostObj.getCpuMhz();
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取VM的CPU频率失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时的异常：获取VM的CPU频率失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取VM的CPU频率失败",e);
		}
	}
	


	
	/**获取hostIp地址
	 * 
	 * @param host
	 * @param connection
	 * @return
	 * @throws VMTaskException
	 */
	public static String getHostIpByVMInfo(ManagedObjectReference host,VMWareConnection connection) throws VMTaskException {
		String hostIp = "";
		HostObj hostObj = null;
		try {
			hostObj = new HostObj(host);
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(host,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "config.network"});
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			if (oCont != null) {
				for (ObjectContent oc : oCont) {
					DynamicProperty[] dps = oc.getPropSet();
					if (dps != null) {
						for (DynamicProperty dp : dps) {
							if ("config.network".equals(dp.getName())) {
								hostObj.setNetworkInfo((HostNetworkInfo) dp.getVal());
							}
						}
					}
				}
			}
			for(PhysicalNic pnic :hostObj.getNetworkInfo().getPnic()){
				if(pnic.getSpec().getIp().getIpAddress().length() > 0){
					hostIp = hostIp +pnic.getSpec().getIp().getIpAddress() + ",";
				} 
			}
			for( HostVirtualNic  vnic: hostObj.getNetworkInfo().getVnic()){
				if(vnic.getSpec().getIp().getIpAddress().length() > 0){
					hostIp = hostIp + vnic.getSpec().getIp().getIpAddress()+ "," ;
				}
			}
			if(hostIp.length()>0){
				hostIp = hostIp.substring(0, hostIp.length()-1);
			}
			return hostIp;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取hostIP失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时的异常：获取hostIP失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取hostIP失败",e);
		}
	}
	
	/**获取每个主机下总的cpu核心数
	 * 
	 * @param host
	 * @param connection
	 * @return
	 * @throws VMTaskException
	 */
	public static int getEveryHostNumCpuCore(ManagedObjectReference host,VMWareConnection connection)throws VMTaskException {
		int count = 0;
		List<ManagedObjectReference> list = getVMInfoByHost(host,connection);
		try {
			for(ManagedObjectReference vm : list){
				PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(vm,
						 VMWareBaseCommon.VIRTUAL_MACHINE, new String[] { "summary.config.numCpu"});
				ObjectContent[] oCont = connection.getService().retrieveProperties(
						connection.getPropCol(), pfSpecList);
				if (oCont != null) {
					for (ObjectContent oc : oCont) {
						DynamicProperty[] dps = oc.getPropSet();
						if (dps != null) {
							for (DynamicProperty dp : dps) {
								if ("summary.config.numCpu".equals(dp.getName())) {
									count += (Integer) dp.getVal();
								}
							}
						}
					}
				}
			}
			return count;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取虚拟机cpu核心数失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时的异常：获取虚拟机cpu核心数失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取虚拟机cpu核心数失败",e);
		}
	}
	
	/**
	 * 根据主机获取对应虚拟机reference
	 * @param host
	 * @param connection
	 * @return
	 * @throws VMTaskException
	 */
	public static List<ManagedObjectReference> getVMInfoByHost(ManagedObjectReference host, VMWareConnection connection) throws VMTaskException{
		List<ManagedObjectReference> list = new ArrayList<ManagedObjectReference>();
		try {
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(host,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "vm"});
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			oCont = (oCont != null? oCont:new ObjectContent[0]);
			for (ObjectContent oc : oCont) {
				DynamicProperty[] dps = oc.getPropSet();
				dps = (dps!=null?dps:new DynamicProperty[0]);
				for (DynamicProperty dp : dps) {
					if ("vm".equals(dp.getName())) {
						for(ManagedObjectReference vm :((ArrayOfManagedObjectReference)dp.getVal()).getManagedObjectReference()){
							list.add(vm);
						}
					}
				}
			}
			return list;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取虚拟机信息失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时的异常：获取虚拟机信息失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取虚拟机信息失败",e);
		}
	}
	
	/**
	 * 获取host的CPU(单位：MHZ)、MEMORY（单位：MB）使用量
	 * @param host
	 * @param connection
	 * @return
	 * @throws VMTaskException
	 */
	public static Map<String, Integer> getHostPerfUse(ManagedObjectReference host,VMWareConnection connection) throws VMTaskException {
		int countCpuUse = 0;
		int countMemoryUse = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(host,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "summary.quickStats.overallCpuUsage", "summary.quickStats.overallMemoryUsage"});
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			oCont = (oCont != null? oCont:new ObjectContent[0]);
			for (ObjectContent oc : oCont) {
				DynamicProperty[] dps = oc.getPropSet();
				dps = (dps!=null?dps:new DynamicProperty[0]);
				for (DynamicProperty dp : dps) {
					if ("summary.quickStats.overallCpuUsage".equals(dp.getName())) {
						countCpuUse += ((Integer) dp.getVal());
					}if ("summary.quickStats.overallMemoryUsage".equals(dp.getName())) {
						countMemoryUse += ((Integer) dp.getVal());
					}
				}
			}
			map.put(QueryClusterPerfTask.HOST_CPU_USE, countCpuUse);
			map.put(QueryClusterPerfTask.HOST_MEMORY_USE, countMemoryUse);
			return map;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("异常的状态：获取hostIP失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时的异常：获取hostIP失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取hostIP失败",e);
		}
	}
	
	/**
	 * 获取host uuid
	 * @param hostReference
	 * @return
	 * @throws VMTaskException
	 */
	public static HostObj buildHostId(ManagedObjectReference hostReference, VMWareConnection connection) throws VMTaskException{
		HostObj hostObj = null;
		try {
			hostObj = new HostObj(hostReference);
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(hostReference,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "hardware.systemInfo.uuid" });
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			oCont = (oCont != null? oCont:new ObjectContent[0]);
			for (ObjectContent oc : oCont) {
				DynamicProperty[] dps = oc.getPropSet();
				dps = (dps!=null?dps:new DynamicProperty[0]);
				for (DynamicProperty dp : dps) {
					if ("hardware.systemInfo.uuid".equals(dp.getName())) {
						hostObj.setUuid((String) dp.getVal());
					}
				}
			}
			return hostObj;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("不合理的属性：获取Host的uuid频率失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时错误：获取Host的uuid频率失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取Host的uuid频率失败",e);
		}
	}
	
	/**
	 * 获取host uuid,ip地址
	 * @param hostReference
	 * @return
	 * @throws VMTaskException
	 */
	public static HostObj buildHostIdAndIp(ManagedObjectReference hostReference, ConnectionPool connectionPool) throws VMTaskException{
		HostObj hostObj = null;
		VMWareConnection connection = connectionPool.getConnection();
		try {
			hostObj = new HostObj(hostReference);
			PropertyFilterSpec[] pfSpecList = getPropertyFilterSpec(hostReference,
					 VMWareBaseCommon.HOST_SYSTEM, new String[] { "hardware.systemInfo.uuid", "config.network"});
			ObjectContent[] oCont = connection.getService().retrieveProperties(
					connection.getPropCol(), pfSpecList);
			oCont = (oCont != null? oCont:new ObjectContent[0]);
			for (ObjectContent oc : oCont) {
				DynamicProperty[] dps = oc.getPropSet();
				dps = (dps!=null?dps:new DynamicProperty[0]);
				for (DynamicProperty dp : dps) {
					if ("hardware.systemInfo.uuid".equals(dp.getName())) {
						hostObj.setUuid((String) dp.getVal());
					}if ("config.network".equals(dp.getName())) {
						getHostIp(hostObj,(HostNetworkInfo) dp.getVal());
					}
				}
			}
			return hostObj;
		}catch (InvalidProperty e) {
			logger.error(e);
			throw new VMTaskException("不合理的属性：获取Host的uuid频率失败", e);
		}catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时错误：获取Host的uuid频率失败", e);
		}catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常：获取Host的uuid频率失败",e);
		}finally {
			connectionPool.freeConnection(connection);
		}
	}
	
	/**
	 * 对hostIP地址进行处理
	 */
	public static void getHostIp(HostObj hostObj,HostNetworkInfo hostNetworkInfo){
		hostObj.setNetworkInfo(hostNetworkInfo);
		ArrayList<String> hostIps = new ArrayList<String>();
		String hostIp = "";
		for( HostVirtualNic  vnic: hostObj.getNetworkInfo().getVnic()){
			if(vnic.getSpec().getIp().getIpAddress().length() > 0){
				hostIps.add(vnic.getSpec().getIp().getIpAddress());
			}
		}
		String[] hostIpsArr = hostIps.toArray(new String[0]);
		Arrays.sort(hostIpsArr);
		if(hostIpsArr.length>0){
			for (int i = 0; i < hostIpsArr.length; i++) {
				hostIp = hostIp+hostIpsArr[i]+",";
			}
			hostIp = hostIp.substring(0, hostIp.length()-1);
		}
		hostObj.setIpAddress(hostIp);
	}
}
