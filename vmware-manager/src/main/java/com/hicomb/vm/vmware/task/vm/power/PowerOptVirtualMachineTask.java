package com.hicomb.vm.vmware.task.vm.power;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.VimPortType;

/**
 * 改变虚拟机状态任务
 */
@Deprecated
public class PowerOptVirtualMachineTask extends AbstractTask<Integer> {

	private static final Log logger = LogFactory
			.getLog(PowerOptVirtualMachineTask.class);

	private ManagedObjectReference vm;

	private VimPortType vimPort = null;
	private PowerOpts powerOpts;

	public PowerOptVirtualMachineTask(ManagedObjectReference vm,
			PowerOpts powerOpts) {
		this.vm = vm;
		this.powerOpts = powerOpts;
	}

	@Override
	public Integer doExecute(VMWareConnection connection)
			throws VMTaskException {
		this.vimPort = connection.getService();
		try {
			ManagedObjectReference vmMor = vm;
			ManagedObjectReference taskmor = null;
			switch (powerOpts) {
			case POWERON:
				taskmor = vimPort.powerOnVM_Task(vmMor, null);
				break;
			case POWEROFF:
				taskmor = vimPort.powerOffVM_Task(vmMor);
				break;
			case RESET:
				taskmor = vimPort.resetVM_Task(vmMor);
				break;
			case SUSPEND:
				taskmor = vimPort.suspendVM_Task(vmMor);
				break;
			case REBOOT:
				vimPort.rebootGuest(vm);
				break;
			case SHUTDOWN:
				vimPort.shutdownGuest(vm);
				break;
			case STANDBY:
				vimPort.standbyGuest(vm);
				break;
			}
			Object[] result = waitForValues(taskmor, new String[] {
					"info.state", "info.error", "info.progress" },
					new String[] { "state" }, // info has a property - state for
												// state of the task
					new Object[][] { new Object[] { TaskInfoState.success,
							TaskInfoState.error } });
			if (result[0].equals(TaskInfoState.success)) {
				return VMWareBaseCommon.TASK_EXE_SUCCESS;
			} else {
				return VMWareBaseCommon.TASK_EXE_FAIL;
			}

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			throw new VMTaskException(e.getLocalizedMessage(), e);
		}
	}

}
