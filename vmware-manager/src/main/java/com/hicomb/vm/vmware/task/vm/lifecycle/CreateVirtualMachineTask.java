package com.hicomb.vm.vmware.task.vm.lifecycle;

import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;

public class CreateVirtualMachineTask extends AbstractTask<Void> {

	public Void doExecute(VMWareConnection connection) throws VMTaskException {
		// TODO Auto-generated method stub
		return null;
	}
//	private static final Log logger = LogFactory
//			.getLog(CreateVirtualMachineTask.class);
//
//
//	private VimPortType vimPort = null;
//	private ServiceContent serviceContent = null;
//
//	private String dataCenterName;
//	private String hostname;
//	private String virtualMachineName;
//	private String dataStore;
//	private int diskSize;
//	private String vmMemory;
//	private int numCpus;
//	private String guestOsId;
//
//	public CreateVirtualMachineTask(String dataCenterName, String hostname,
//			String virtualMachineName, String dataStore, int diskSize,
//			String vmMemory, int numCpus, String guestOsId) {
//		super();
//		this.dataCenterName = dataCenterName;
//		this.hostname = hostname;
//		this.virtualMachineName = virtualMachineName;
//		this.dataStore = dataStore;
//		this.diskSize = diskSize;
//		this.vmMemory = vmMemory;
//		this.numCpus = numCpus;
//		this.guestOsId = guestOsId;
//	}
//
//	/**
//	 * Creates the virtual disk.
//	 * 
//	 * @param volName
//	 *            the vol name
//	 * @param diskCtlrKey
//	 *            the disk ctlr key
//	 * @param datastoreRef
//	 *            the datastore ref
//	 * @param diskSizeMB
//	 *            the disk size in mb
//	 * @return the virtual device config spec object
//	 */
//	private static VirtualDeviceConfigSpec createVirtualDisk(String volName,
//			int diskCtlrKey, ManagedObjectReference datastoreRef, int diskSizeMB) {
//		String volumeName = getVolumeName(volName);
//		VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();
//
//		diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);
//		diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
//
//		VirtualDisk disk = new VirtualDisk();
//		VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
//
//		diskfileBacking.setFileName(volumeName);
//		diskfileBacking.setDiskMode("persistent");
//
//		disk.setKey(new Integer(0));
//		disk.setControllerKey(new Integer(diskCtlrKey));
//		disk.setUnitNumber(new Integer(0));
//		disk.setBacking(diskfileBacking);
//		disk.setCapacityInKB(1024);
//
//		diskSpec.setDevice(disk);
//
//		return diskSpec;
//	}
//
//	/**
//	 * This method returns the ConfigTarget for a HostSystem.
//	 * 
//	 * @param computeResMor
//	 *            A MoRef to the ComputeResource used by the HostSystem
//	 * @param hostMor
//	 *            A MoRef to the HostSystem
//	 * @return Instance of ConfigTarget for the supplied
//	 *         HostSystem/ComputeResource
//	 * @throws Exception
//	 *             When no ConfigTarget can be found
//	 */
//	protected ConfigTarget getConfigTargetForHost(
//			ManagedObjectReference computeResMor,
//			ManagedObjectReference hostMor, VMWareConnection connection)
//			throws Exception {
//		ManagedObjectReference envBrowseMor = (ManagedObjectReference) getEntityProps(
//				computeResMor, new String[] { "environmentBrowser" },
//				connection).get("environmentBrowser");
//		ConfigTarget configTarget = vimPort.queryConfigTarget(envBrowseMor,
//				hostMor);
//		if (configTarget == null) {
//			throw new RuntimeException(
//					"No ConfigTarget found in ComputeResource");
//		}
//		return configTarget;
//	}
//
//	/**
//	 * The method returns the default devices from the HostSystem.
//	 * 
//	 * @param computeResMor
//	 *            A MoRef to the ComputeResource used by the HostSystem
//	 * @param hostMor
//	 *            A MoRef to the HostSystem
//	 * @return Array of VirtualDevice containing the default devices for the
//	 *         HostSystem
//	 * @throws Exception
//	 */
//	protected List<VirtualDevice> getDefaultDevices(
//			ManagedObjectReference computeResMor,
//			ManagedObjectReference hostMor, VMWareConnection connection)
//			throws Exception {
//		ManagedObjectReference envBrowseMor = (ManagedObjectReference) getEntityProps(
//				computeResMor, new String[] { "environmentBrowser" },
//				connection).get("environmentBrowser");
//		VirtualMachineConfigOption cfgOpt = vimPort.queryConfigOption(
//				envBrowseMor, null, hostMor);
//		List<VirtualDevice> defaultDevs = null;
//		if (cfgOpt == null) {
//			throw new RuntimeException(
//					"No VirtualHardwareInfo found in ComputeResource");
//		} else {
//			VirtualDevice[] lvds = cfgOpt.getDefaultDevice();
//			if (lvds == null) {
//				throw new RuntimeException(
//						"No Datastore found in ComputeResource");
//			} else {
//				defaultDevs = lvds;
//			}
//		}
//		return defaultDevs;
//	}
//
//	private static String getVolumeName(String volName) {
//		String volumeName = null;
//		if (volName != null && volName.length() > 0) {
//			volumeName = "[" + volName + "]";
//		} else {
//			volumeName = "[Local]";
//		}
//
//		return volumeName;
//	}
//
//	/**
//	 * Creates the vm config spec object.
//	 * 
//	 * @param vmName
//	 *            the vm name
//	 * @param datastoreName
//	 *            the datastore name
//	 * @param diskSizeMB
//	 *            the disk size in mb
//	 * @param computeResMor
//	 *            the compute res moref
//	 * @param hostMor
//	 *            the host mor
//	 * @return the virtual machine config spec object
//	 * @throws Exception
//	 *             the exception
//	 */
//	protected VirtualMachineConfigSpec createVmConfigSpec(
//			VMWareConnection connection, String vmName, String datastoreName,
//			int diskSizeMB, ManagedObjectReference computeResMor,
//			ManagedObjectReference hostMor) throws Exception {
//
//		ConfigTarget configTarget = getConfigTargetForHost(computeResMor,
//				hostMor, connection);
//		List<VirtualDevice> defaultDevices = getDefaultDevices(computeResMor,
//				hostMor, connection);
//		VirtualMachineConfigSpec configSpec = new VirtualMachineConfigSpec();
//		String networkName = null;
//		if (configTarget.getNetwork() != null) {
//			for (int i = 0; i < configTarget.getNetwork().length; i++) {
//				VirtualMachineNetworkInfo netInfo = configTarget.getNetwork().get(i);
//				NetworkSummary netSummary = netInfo.getNetwork();
//				if (netSummary.isAccessible()) {
//					networkName = netSummary.getName();
//					break;
//				}
//			}
//		}
//		ManagedObjectReference datastoreRef = null;
//		if (datastoreName != null) {
//			boolean flag = false;
//			for (int i = 0; i < configTarget.getDatastore().length; i++) {
//				VirtualMachineDatastoreInfo vdsInfo = configTarget.getDatastore().get(i);
//				DatastoreSummary dsSummary = vdsInfo.getDatastore();
//				if (dsSummary.getName().equals(datastoreName)) {
//					flag = true;
//					if (dsSummary.isAccessible()) {
//						datastoreRef = dsSummary.getDatastore();
//					} else {
//						throw new RuntimeException(
//								"Specified Datastore is not accessible");
//					}
//					break;
//				}
//			}
//			if (!flag) {
//				throw new RuntimeException("Specified Datastore is not Found");
//			}
//		} else {
//			boolean flag = false;
//			for (int i = 0; i < configTarget.getDatastore().length; i++) {
//				VirtualMachineDatastoreInfo vdsInfo = configTarget.getDatastore().get(i);
//				DatastoreSummary dsSummary = vdsInfo.getDatastore();
//				if (dsSummary.isAccessible()) {
//					datastoreName = dsSummary.getName();
//					datastoreRef = dsSummary.getDatastore();
//					flag = true;
//					break;
//				}
//			}
//			if (!flag) {
//				throw new RuntimeException("No Datastore found on host");
//			}
//		}
//		String datastoreVolume = getVolumeName(datastoreName);
//		VirtualMachineFileInfo vmfi = new VirtualMachineFileInfo();
//		vmfi.setVmPathName(datastoreVolume);
//		configSpec.setFiles(vmfi);
//		// Add a scsi controller
//		int diskCtlrKey = 1;
//		VirtualDeviceConfigSpec scsiCtrlSpec = new VirtualDeviceConfigSpec();
//		scsiCtrlSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
//		VirtualLsiLogicController scsiCtrl = new VirtualLsiLogicController();
//		scsiCtrl.setBusNumber(0);
//		scsiCtrlSpec.setDevice(scsiCtrl);
//		scsiCtrl.setKey(diskCtlrKey);
//		scsiCtrl.setSharedBus(VirtualSCSISharing.NO_SHARING);
//		String ctlrType = scsiCtrl.getClass().getName();
//		ctlrType = ctlrType.substring(ctlrType.lastIndexOf(".") + 1);
//
//		// Find the IDE controller
//		VirtualDevice ideCtlr = null;
//		for (int di = 0; di < defaultDevices.size(); di++) {
//			if (defaultDevices.get(di) instanceof VirtualIDEController) {
//				ideCtlr = defaultDevices.get(di);
//				break;
//			}
//		}
//
//		// Add a floppy
//		VirtualDeviceConfigSpec floppySpec = new VirtualDeviceConfigSpec();
//		floppySpec.setOperation(VirtualDeviceConfigSpecOperation.add);
//		VirtualFloppy floppy = new VirtualFloppy();
//		VirtualFloppyDeviceBackingInfo flpBacking = new VirtualFloppyDeviceBackingInfo();
//		flpBacking.setDeviceName("/dev/fd0");
//		floppy.setBacking(flpBacking);
//		floppy.setKey(3);
//		floppySpec.setDevice(floppy);
//
//		// Add a cdrom based on a physical device
//		VirtualDeviceConfigSpec cdSpec = null;
//
//		if (ideCtlr != null) {
//			cdSpec = new VirtualDeviceConfigSpec();
//			cdSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
//			VirtualCdrom cdrom = new VirtualCdrom();
//			VirtualCdromIsoBackingInfo cdDeviceBacking = new VirtualCdromIsoBackingInfo();
//			cdDeviceBacking.setDatastore(datastoreRef);
//			cdDeviceBacking.setFileName(datastoreVolume + "testcd.iso");
//			cdrom.setBacking(cdDeviceBacking);
//			cdrom.setKey(20);
//			cdrom.setControllerKey(new Integer(ideCtlr.getKey()));
//			cdrom.setUnitNumber(new Integer(0));
//			cdSpec.setDevice(cdrom);
//		}
//
//		// Create a new disk - file based - for the vm
//		VirtualDeviceConfigSpec diskSpec = null;
//		diskSpec = createVirtualDisk(datastoreName, diskCtlrKey, datastoreRef,
//				diskSizeMB);
//
//		// Add a NIC. the network Name must be set as the device name to create
//		// the NIC.
//		VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();
//		if (networkName != null) {
//			nicSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
//			VirtualEthernetCard nic = new VirtualPCNet32();
//			VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
//			nicBacking.setDeviceName(networkName);
//			nic.setAddressType("generated");
//			nic.setBacking(nicBacking);
//			nic.setKey(4);
//			nicSpec.setDevice(nic);
//		}
//
//		List<VirtualDeviceConfigSpec> deviceConfigSpec = new ArrayList<VirtualDeviceConfigSpec>();
//		deviceConfigSpec.add(scsiCtrlSpec);
//		deviceConfigSpec.add(floppySpec);
//		deviceConfigSpec.add(diskSpec);
//		if (ideCtlr != null) {
//			deviceConfigSpec.add(cdSpec);
//			deviceConfigSpec.add(nicSpec);
//		} else {
//			deviceConfigSpec = new ArrayList<VirtualDeviceConfigSpec>();
//			deviceConfigSpec.add(nicSpec);
//		}
//		configSpec.getDeviceChange().addAll(deviceConfigSpec);
//		return configSpec;
//	}
//
//	@Override
//	public Void doExecute(VMWareConnection connection) throws VMTaskException {
//		try {
//			vimPort = connection.getVimPort();
//			serviceContent = connection.getServiceContent();
//			ManagedObjectReference dcmor = getMOREFsInContainerByType(
//					serviceContent.getRootFolder(), "Datacenter", connection)
//					.get(dataCenterName);
//			if (dcmor == null) {
//				logger.error("Datacenter " + dataCenterName + " not found.");
//				return null;
//			}
//			ManagedObjectReference hostmor = getMOREFsInContainerByType(dcmor,
//					"HostSystem", connection).get(hostname);
//			if (hostmor == null) {
//				logger.error("Host " + hostname + " not found");
//				return null;
//			}
//
//			ManagedObjectReference crmor = (ManagedObjectReference) getEntityProps(
//					hostmor, new String[] { "parent" }, connection).get(
//					"parent");
//			if (crmor == null) {
//				logger.error("No Compute Resource Found On Specified Host");
//				return null;
//			}
//
//			ManagedObjectReference resourcepoolmor = (ManagedObjectReference) getEntityProps(
//					crmor, new String[] { "resourcePool" }, connection).get(
//					"resourcePool");
//			ManagedObjectReference vmFolderMor = (ManagedObjectReference) getEntityProps(
//					dcmor, new String[] { "vmFolder" }, connection).get(
//					"vmFolder");
//
//			VirtualMachineConfigSpec vmConfigSpec = createVmConfigSpec(
//					connection, virtualMachineName, dataStore, diskSize, crmor,
//					hostmor);
//
//			vmConfigSpec.setName(virtualMachineName);
//			vmConfigSpec.setAnnotation("VirtualMachine Annotation");
//			vmConfigSpec.setMemoryMB(new Long(vmMemory));
//			vmConfigSpec.setNumCPUs(numCpus);
//			vmConfigSpec.setGuestId(guestOsId);
//
//			ManagedObjectReference taskmor = vimPort.createVMTask(vmFolderMor,
//					vmConfigSpec, resourcepoolmor, hostmor);
//			if (getTaskResultAfterDone(connection, taskmor)) {
//				logger.info("Success: Creating VM  - " + virtualMachineName);
//			} else {
//				String msg = "Failure: Creating [ " + virtualMachineName
//						+ "] VM";
//				throw new RuntimeException(msg);
//			}
//			ManagedObjectReference vmMor = (ManagedObjectReference) getEntityProps(
//					taskmor, new String[] { "info.result" }, connection).get(
//					"info.result");
//			logger.info("Powering on the newly created VM "
//					+ virtualMachineName);
//			// Start the Newly Created VM.
//			// powerOnVM(vmMor);
//			return null;
//		} catch (Exception e) {
//			logger.error(e);
//			throw new VMTaskException(e.getMessage(), e);
//		}
//
//	}

}
