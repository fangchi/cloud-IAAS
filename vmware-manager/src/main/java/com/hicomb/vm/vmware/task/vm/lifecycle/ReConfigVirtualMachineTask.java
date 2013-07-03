package com.hicomb.vm.vmware.task.vm.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;

public class ReConfigVirtualMachineTask extends AbstractTask<Integer> {

	protected final Log logger = LogFactory
			.getLog(ReConfigVirtualMachineTask.class);

	@Override
	public Integer doExecute(VMWareConnection connection)
			throws VMTaskException {
		// TODO Auto-generated method stub
		return null;
	}

//	private VimPortType vimPort = null;
//	private String device;
//	private String operation;
//	private String vmName;
//	private String disksize = null;
//	private String diskmode = null;
//
//	private String value = null;
//
//	private ManagedObjectReference virtualMachine = null;
//	
//	public ReConfigVirtualMachineTask(String device, String operation,
//			String vmName, String disksize, String diskmode, String value,
//			ManagedObjectReference virtualMachine) {
//		super();
//		this.device = device;
//		this.operation = operation;
//		this.vmName = vmName;
//		this.disksize = disksize;
//		this.diskmode = diskmode;
//		this.value = value;
//		this.virtualMachine = virtualMachine;
//	}
//
//	/**
//	 * Gets the controller key and the next available free unit number on the
//	 * SCSI controller
//	 * 
//	 * @param vmMor
//	 * @return
//	 * @throws InvalidPropertyFaultMsg
//	 * @throws RuntimeFaultFaultMsg
//	 */
//	protected List<Integer> getControllerKey(ManagedObjectReference vmMor,
//			VMWareConnection connection) throws InvalidPropertyFaultMsg,
//			RuntimeFaultFaultMsg {
//		List<Integer> retVal = new ArrayList<Integer>();
//
//		List<VirtualDevice> listvd = ((ArrayOfVirtualDevice) getEntityProps(
//				vmMor, new String[] { "config.hardware.device" }, connection)
//				.get("config.hardware.device")).getVirtualDevice();
//
//		Map<Integer, VirtualDevice> deviceMap = new HashMap<Integer, VirtualDevice>();
//		for (VirtualDevice virtualDevice : listvd) {
//			deviceMap.put(virtualDevice.getKey(), virtualDevice);
//		}
//		boolean found = false;
//		for (VirtualDevice virtualDevice : listvd) {
//			if (virtualDevice instanceof VirtualSCSIController) {
//				VirtualSCSIController vscsic = (VirtualSCSIController) virtualDevice;
//				int[] slots = new int[16];
//				slots[7] = 1;
//				List<Integer> devicelist = vscsic.getDevice();
//				for (Integer deviceKey : devicelist) {
//					if (deviceMap.get(deviceKey).getUnitNumber() != null) {
//						slots[deviceMap.get(deviceKey).getUnitNumber()] = 1;
//					}
//				}
//				for (int i = 0; i < slots.length; i++) {
//					if (slots[i] != 1) {
//						retVal.add(vscsic.getKey());
//						retVal.add(i);
//						found = true;
//						break;
//					}
//				}
//				if (found) {
//					break;
//				}
//			}
//		}
//
//		if (!found) {
//			throw new RuntimeException(
//					"The SCSI controller on the vm has maxed out its "
//							+ "capacity. Please add an additional SCSI controller");
//		}
//		return retVal;
//	}
//
//	protected String getDatastoreNameWithFreeSpace(int minFreeSpace,
//			VMWareConnection connection) throws InvalidPropertyFaultMsg,
//			RuntimeFaultFaultMsg {
//		String dsName = null;
//		List<ManagedObjectReference> datastores = ((ArrayOfManagedObjectReference) getEntityProps(
//				virtualMachine, new String[] { "datastore" }, connection).get(
//				"datastore")).getManagedObjectReference();
//		for (ManagedObjectReference datastore : datastores) {
//			DatastoreSummary ds = (DatastoreSummary) getEntityProps(datastore,
//					new String[] { "summary" }, connection).get("summary");
//			if (ds.getFreeSpace() > minFreeSpace) {
//				dsName = ds.getName();
//				break;
//			}
//		}
//		return dsName;
//	}
//
//	protected VirtualDeviceConfigSpec getDiskDeviceConfigSpec(
//			VMWareConnection connection) throws Exception {
//		String ops = operation;
//		VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();
//
//		if (ops.equalsIgnoreCase("Add")) {
//			VirtualDisk disk = new VirtualDisk();
//			VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
//			String dsName = getDatastoreNameWithFreeSpace(
//					Integer.parseInt(disksize), connection);
//
//			int ckey = 0;
//			int unitNumber = 0;
//			List<Integer> getControllerKeyReturnArr = getControllerKey(
//					virtualMachine, connection);
//			if (!getControllerKeyReturnArr.isEmpty()) {
//				ckey = getControllerKeyReturnArr.get(0);
//				unitNumber = getControllerKeyReturnArr.get(1);
//			}
//			String fileName = "[" + dsName + "] " + vmName + "/" + value
//					+ ".vmdk";
//			diskfileBacking.setFileName(fileName);
//			diskfileBacking.setDiskMode(diskmode);
//
//			disk.setControllerKey(ckey);
//			disk.setUnitNumber(unitNumber);
//			disk.setBacking(diskfileBacking);
//			int size = 1024 * (Integer.parseInt(disksize));
//			disk.setCapacityInKB(size);
//			disk.setKey(-1);
//
//			diskSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
//			diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.CREATE);
//			diskSpec.setDevice(disk);
//		} else if (ops.equalsIgnoreCase("Remove")) {
//			VirtualDisk disk = null;
//			List<VirtualDevice> deviceList = ((ArrayOfVirtualDevice) getEntityProps(
//					virtualMachine, new String[] { "config.hardware.device" },
//					connection).get("config.hardware.device"))
//					.getVirtualDevice();
//			for (VirtualDevice device : deviceList) {
//				if (device instanceof VirtualDisk) {
//					if (value.equalsIgnoreCase(device.getDeviceInfo()
//							.getLabel())) {
//						disk = (VirtualDisk) device;
//						break;
//					}
//				}
//			}
//			if (disk != null) {
//				diskSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
//				diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.DESTROY);
//				diskSpec.setDevice(disk);
//			} else {
//				System.out.println("No device found " + value);
//				return null;
//			}
//		}
//		return diskSpec;
//	}
//
//	protected VirtualDeviceConfigSpec getCDDeviceConfigSpec(
//			VMWareConnection connection) throws Exception {
//		String ops = operation;
//		VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();
//		List<VirtualDevice> listvd = ((ArrayOfVirtualDevice) getEntityProps(
//				virtualMachine, new String[] { "config.hardware.device" },
//				connection).get("config.hardware.device")).getVirtualDevice();
//
//		if (ops.equalsIgnoreCase("Add")) {
//			cdSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
//
//			VirtualCdrom cdrom = new VirtualCdrom();
//
//			VirtualCdromRemoteAtapiBackingInfo vcrabi = new VirtualCdromRemoteAtapiBackingInfo();
//			vcrabi.setDeviceName("");
//			vcrabi.setUseAutoDetect(true);
//
//			Map<Integer, VirtualDevice> deviceMap = new HashMap<Integer, VirtualDevice>();
//			for (VirtualDevice virtualDevice : listvd) {
//				deviceMap.put(virtualDevice.getKey(), virtualDevice);
//			}
//			int controllerKey = 0;
//			int unitNumber = 0;
//			boolean found = false;
//			for (VirtualDevice virtualDevice : listvd) {
//				if (virtualDevice instanceof VirtualIDEController) {
//					VirtualIDEController vscsic = (VirtualIDEController) virtualDevice;
//					int[] slots = new int[2];
//					List<Integer> devicelist = vscsic.getDevice();
//					for (Integer deviceKey : devicelist) {
//						if (deviceMap.get(deviceKey).getUnitNumber() != null) {
//							slots[deviceMap.get(deviceKey).getUnitNumber()] = 1;
//						}
//					}
//					for (int i = 0; i < slots.length; i++) {
//						if (slots[i] != 1) {
//							controllerKey = vscsic.getKey();
//							unitNumber = i;
//							found = true;
//							break;
//						}
//					}
//					if (found) {
//						break;
//					}
//				}
//			}
//
//			if (!found) {
//				throw new RuntimeException(
//						"The IDE controller on the vm has maxed out its "
//								+ "capacity. Please add an additional IDE controller");
//			}
//
//			cdrom.setBacking(vcrabi);
//			cdrom.setControllerKey(controllerKey);
//			cdrom.setUnitNumber(unitNumber);
//			cdrom.setKey(-1);
//
//			cdSpec.setDevice(cdrom);
//			return cdSpec;
//		} else {
//			VirtualCdrom cdRemove = null;
//			cdSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
//			for (VirtualDevice device : listvd) {
//				if (device instanceof VirtualCdrom) {
//					if (value.equalsIgnoreCase(device.getDeviceInfo()
//							.getLabel())) {
//						cdRemove = (VirtualCdrom) device;
//						break;
//					}
//				}
//			}
//			if (cdRemove != null) {
//				cdSpec.setDevice(cdRemove);
//			} else {
//				System.out.println("No device available " + value);
//				return null;
//			}
//		}
//		return cdSpec;
//	}
//
//	protected VirtualDeviceConfigSpec getNICDeviceConfigSpec(
//			VMWareConnection connection) throws Exception {
//		String ops = operation;
//		VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
//		if (ops.equalsIgnoreCase("Add")) {
//			nicSpec.setOperation(VirtualDeviceConfigSpecOperation.ADD);
//			VirtualEthernetCard nic = new VirtualPCNet32();
//			VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
//			nicBacking.setDeviceName(value);
//			nic.setAddressType("generated");
//			nic.setBacking(nicBacking);
//			nic.setKey(-1);
//			nicSpec.setDevice(nic);
//		} else if (ops.equalsIgnoreCase("Remove")) {
//			VirtualEthernetCard nic = null;
//			nicSpec.setOperation(VirtualDeviceConfigSpecOperation.REMOVE);
//			List<VirtualDevice> listvd = ((ArrayOfVirtualDevice) getEntityProps(
//					virtualMachine, new String[] { "config.hardware.device" },
//					connection).get("config.hardware.device"))
//					.getVirtualDevice();
//			for (VirtualDevice device : listvd) {
//				if (device instanceof VirtualEthernetCard) {
//					if (value.equalsIgnoreCase(device.getDeviceInfo()
//							.getLabel())) {
//						nic = (VirtualEthernetCard) device;
//						break;
//					}
//				}
//			}
//			if (nic != null) {
//				nicSpec.setDevice(nic);
//			} else {
//				System.out.println("No device available " + value);
//				return null;
//			}
//		}
//		return nicSpec;
//	}
//
//	protected ResourceAllocationInfo getShares() {
//		ResourceAllocationInfo raInfo = new ResourceAllocationInfo();
//		SharesInfo sharesInfo = new SharesInfo();
//		if (value.equalsIgnoreCase(SharesLevel.HIGH.toString())) {
//			sharesInfo.setLevel(SharesLevel.HIGH);
//		} else if (value.equalsIgnoreCase(SharesLevel.NORMAL.toString())) {
//			sharesInfo.setLevel(SharesLevel.NORMAL);
//		} else if (value.equalsIgnoreCase(SharesLevel.LOW.toString())) {
//			sharesInfo.setLevel(SharesLevel.LOW);
//		} else {
//			sharesInfo.setLevel(SharesLevel.CUSTOM);
//			sharesInfo.setShares(Integer.parseInt(value));
//		}
//		raInfo.setShares(sharesInfo);
//		return raInfo;
//	}
//
//	@Override
//	public Integer doExecute(VMWareConnection connection)
//			throws VMTaskException {
//		try {
//			vimPort = connection.getVimPort();
//			String deviceType = device;
//			VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
//			if (deviceType.equalsIgnoreCase("memory")
//					&& operation.equals("update")) {
//				logger.info("Reconfiguring The Virtual Machine For Memory Update "
//						+ vmName);
//				try {
//					vmConfigSpec.setMemoryAllocation(getShares());
//					vmConfigSpec.setMemoryMB(Long.parseLong(value));
//				} catch (java.lang.NumberFormatException nfe) {
//					logger.error("Value of Memory update must "
//							+ "be one of high|low|normal|[numeric value]");
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				}
//			} else if (deviceType.equalsIgnoreCase("cpu")
//					&& operation.equals("update")) {
//				logger.info("Reconfiguring The Virtual Machine For CPU Update "
//								+ vmName);
//				try {
//					vmConfigSpec.setCpuAllocation(getShares());
//					vmConfigSpec.setNumCPUs(Integer.parseInt(value));
//				} catch (SOAPFaultException sfe) {
//					logger.error(sfe);
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				} catch (java.lang.NumberFormatException nfe) {
//					logger.error("Value of CPU update must "
//							+ "be one of high|low|normal|[numeric value]");
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				}
//			} else if (deviceType.equalsIgnoreCase("disk")
//					&& !operation.equals("update")) {
//				logger.info("Reconfiguring The Virtual Machine For Disk Update "
//								+ vmName);
//				VirtualDeviceConfigSpec vdiskSpec = getDiskDeviceConfigSpec(connection);
//				if (vdiskSpec != null) {
//					List<VirtualDeviceConfigSpec> vdiskSpecArray = new ArrayList<VirtualDeviceConfigSpec>();
//					vdiskSpecArray.add(vdiskSpec);
//					vmConfigSpec.getDeviceChange().addAll(vdiskSpecArray);
//				} else {
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				}
//			} else if (deviceType.equalsIgnoreCase("nic")
//					&& !operation.equals("update")) {
//				logger.info("Reconfiguring The Virtual Machine For NIC Update "
//								+ vmName);
//				VirtualDeviceConfigSpec nicSpec = getNICDeviceConfigSpec(connection);
//				if (nicSpec != null) {
//					List<VirtualDeviceConfigSpec> nicSpecArray = new ArrayList<VirtualDeviceConfigSpec>();
//					nicSpecArray.add(nicSpec);
//					vmConfigSpec.getDeviceChange().addAll(nicSpecArray);
//				} else {
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				}
//			} else if (deviceType.equalsIgnoreCase("cd")
//					&& !operation.equals("update")) {
//				logger.info("Reconfiguring The Virtual Machine For CD Update "
//								+ vmName);
//				VirtualDeviceConfigSpec cdSpec = getCDDeviceConfigSpec(connection);
//				if (cdSpec != null) {
//					List<VirtualDeviceConfigSpec> cdSpecArray = new ArrayList<VirtualDeviceConfigSpec>();
//					cdSpecArray.add(cdSpec);
//					vmConfigSpec.getDeviceChange().addAll(cdSpecArray);
//				} else {
//					return VMWareBaseCommon.TASK_EXE_FAIL;
//				}
//			} else {
//				logger.error("Invalid device type [memory|cpu|disk|nic|cd]");
//				return VMWareBaseCommon.TASK_EXE_FAIL;
//			}
//
//			ManagedObjectReference tmor = vimPort.reconfigVMTask(
//					virtualMachine, vmConfigSpec);
//			if (getTaskResultAfterDone(connection, tmor)) {
//				logger.info("Virtual Machine reconfigured successfully");
//				return VMWareBaseCommon.TASK_EXE_SUCCESS;
//			} else {
//				logger.info("Virtual Machine reconfigur failed");
//				return VMWareBaseCommon.TASK_EXE_FAIL;
//			}
//		} catch (Exception e) {
//			logger.error(e);
//			e.printStackTrace();
//			throw new VMTaskException(e.getMessage(), e);
//		}
//
//	}

}
