package com.hicomb.vm.vmware.task.event;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.AbstractTask;
import com.vmware.vim25.ArrayOfEvent;
import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.EventFilterSpecByEntity;
import com.vmware.vim25.EventFilterSpecByTime;
import com.vmware.vim25.EventFilterSpecRecursionOption;
import com.vmware.vim25.HostEvent;
import com.vmware.vim25.InvalidCollectorVersion;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VmEvent;

/**
 * 查询VM event事件信息
 * @author chenliang
 */
public class QueryEventTask extends AbstractTask<List<EventObj>> {
	
	private static final Log logger = LogFactory.getLog(QueryEventTask.class);
	
	private VimPortType _service; // 
	private ServiceContent _sic;
	private ManagedObjectReference _rootFolder;

	// EventManager and EventHistoryCollector References
	private ManagedObjectReference _eventManager;
	private ManagedObjectReference _eventHistoryCollector;
	private ManagedObjectReference propFilter;
	private ManagedObjectReference propColl;
	private Calendar startTime;
	private Calendar endTime;
	private String [] eventType;
	private String [] alarmCategory;
	public static final String HOST_EVENT = "hostEvent";
	public static final String VM_EVENT = "VMEvent";
	
	public QueryEventTask(Calendar startTime, Calendar endTime, String [] eventType, String [] alarmCategory){
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventType = eventType;
		this.alarmCategory = alarmCategory;
	}
	
	
	/**
	 * Initialize the necessary Managed Object References needed here
	 */
	private void initialize() {
		_sic = connection.getServiceContent();
		_service = connection.getService();

		// The PropertyCollector and EventManager References are present
		// in the ServiceInstanceContent
		_eventManager = _sic.getEventManager();
		_rootFolder = _sic.getRootFolder();
	}
	
	/**
	 * 转化原始事件为Vmevent
	 * @param eventObj 目标输出事件
	 * @param anEvent  Vcenter事件
	 */
	private void handleEvent(EventObj eventObj,Event anEvent){
		if (anEvent instanceof VmEvent) {//如果是虚拟机事件
			eventObj.setEventType(VM_EVENT);
			eventObj.setSrcManagedObjectReference(anEvent.getVm().getVm());
			eventObj.setReferenceStr(anEvent.getVm().getVm().get_value());
		} else if (anEvent instanceof HostEvent) {//如果是主机事件
			eventObj.setEventType(HOST_EVENT);
			eventObj.setSrcManagedObjectReference(anEvent.getHost().getHost());
			eventObj.setReferenceStr(anEvent.getHost().getHost().get_value());
		} else {
			eventObj.setEventType("其它");
		}
		eventObj.setEventId(anEvent.getKey());
		eventObj.setClassName(anEvent.getClass().getName());
		eventObj.setFullFormattedMessage(anEvent.getFullFormattedMessage());
		eventObj.setCreateTime(anEvent.getCreatedTime().getTime());
	}

	/**
	 * 根据条件查询添加event事件信息采集器
	 * @throws VMTaskException
	 */
	private void createEventHistoryCollector() throws VMTaskException{
		// Create an Entity Event Filter Spec to
		// specify the MoRef of the VM to be get events filtered for
		EventFilterSpecByEntity entitySpec = new EventFilterSpecByEntity();
		entitySpec.setEntity(_rootFolder);
		entitySpec.setRecursion(EventFilterSpecRecursionOption.children);

		// set the entity spec in the EventFilter
		EventFilterSpec eventFilter = new EventFilterSpec();
		eventFilter.setEntity(entitySpec);

		// we are only interested in getting events for the VM.
		// Add as many events you want to track relating to vm.
		// Refer to API Data Object vmEvent and see the extends class list for
		// elaborate list of vmEvents
		eventFilter.setType(eventType);//指定event类型
		eventFilter.setCategory(alarmCategory);//指定event级别
		
		EventFilterSpecByTime tfilter = new EventFilterSpecByTime();
		tfilter.setBeginTime(startTime);
		tfilter.setEndTime(endTime);
		eventFilter.setTime(tfilter);//指定查询event的时间范围
		// create the EventHistoryCollector to monitor events for a VM
		// and get the ManagedObjectReference of the EventHistoryCollector
		// returned
		try {
			 _eventHistoryCollector = _service.createCollectorForEvents(
					_eventManager, eventFilter);
			 connection.getService().setCollectorPageSize(_eventHistoryCollector, 100);//默认采集100条数据
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态",e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常",e);
		} 
	}

	/**
	 * event事件信息过滤器
	 * @return
	 */
	private PropertyFilterSpec createEventFilterSpec() {
		// Set up a PropertySpec to use the latestPage attribute
		// of the EventHistoryCollector
		PropertySpec propSpec = new PropertySpec();
		propSpec.setAll(new Boolean(false));//true时忽视pathSet属性
		propSpec.setPathSet(new String[] { "latestPage" });//指定查询最近一页
		propSpec.setType(_eventHistoryCollector.getType());
		
		// PropertySpecs are wrapped in a PropertySpec array
		PropertySpec[] propSpecAry = new PropertySpec[] { propSpec };

		// Set up an ObjectSpec with the above PropertySpec for the
		// EventHistoryCollector we just created
		// as the Root or Starting Object to get Attributes for.
		ObjectSpec objSpec = new ObjectSpec();
		objSpec.setObj(_eventHistoryCollector);
		objSpec.setSkip(new Boolean(false));

		// Get Event objects in "latestPage" from "EventHistoryCollector"
		// and no "traversl" further, so, no SelectionSpec is specified
		objSpec.setSelectSet(new SelectionSpec[] {});

		// ObjectSpecs are wrapped in an ObjectSpec array
		ObjectSpec[] objSpecAry = new ObjectSpec[] { objSpec };

		PropertyFilterSpec spec = new PropertyFilterSpec();
		spec.setPropSet(propSpecAry);
		spec.setObjectSet(objSpecAry);
		return spec;
	}

	/**
	 * 对采集的数据进行处理
	 * @param update
	 * @return
	 */
	private List<EventObj> handleUpdate(UpdateSet update) {
		List<EventObj> list = new ArrayList<EventObj>();
		ArrayList<ObjectUpdate> vmUpdates = new ArrayList<ObjectUpdate>();
		PropertyFilterUpdate[] pfus = update.getFilterSet();
		for (int pfui = 0; pfui < pfus.length; ++pfui) {
			ObjectUpdate[] ous = pfus[pfui].getObjectSet();
			for (int oui = 0; oui < ous.length; ++oui) {
				if (ous[oui].getObj().getType().equals("EventHistoryCollector")) {
					vmUpdates.add(ous[oui]);
				}
			}
		}
		if (vmUpdates.size() > 0) {
			for (Iterator<ObjectUpdate> vmi = vmUpdates.iterator(); vmi.hasNext();) {
				list.addAll(handleObjectUpdate((ObjectUpdate) vmi.next()));
			}
		}
		return list;
	}

	/**
	 * 根据条件判断对数据的操作
	 * @param oUpdate
	 * @return
	 */
	private List<EventObj> handleObjectUpdate(ObjectUpdate oUpdate) {
		List<EventObj> list = null;
		PropertyChange[] pc = oUpdate.getChangeSet();
		try {//根据对象更新的类型做对应的额处理
			if (oUpdate.getKind() == ObjectUpdateKind.enter) {
				list = handleChanges(pc);
			} else if (oUpdate.getKind() == ObjectUpdateKind.leave) {
				list = handleChanges(pc);
			} else if (oUpdate.getKind() == ObjectUpdateKind.modify) {
				list = handleChanges(pc);
			}
		} catch (VMTaskException e) {
			logger.error(e);
		} 
		return list;
	}

	/**
	 * 对获取到的数据进行封装并返回一个list
	 * @param changes
	 * @return
	 * @throws VMTaskException
	 */
	private List<EventObj> handleChanges(PropertyChange[] changes)
			throws VMTaskException {
		List<EventObj> list = new ArrayList<EventObj>();
		EventObj eventObj = null;
		for (int pci = 0; pci < changes.length; ++pci) {
			Object value = changes[pci].getVal();
			PropertyChangeOp op = changes[pci].getOp();
			if (value != null && !op.getValue().equalsIgnoreCase("remove")) {//根据不同的事件组合来做不同的处理
				if (value instanceof ArrayOfEvent) {//如果是事件数组
					ArrayOfEvent aoe = (ArrayOfEvent) value;
					Event[] evts = aoe.getEvent();
					if (evts != null && evts.length > 0) {
						for (int evtID = 0; evtID < evts.length; ++evtID) {
							Event anEvent = evts[evtID];
							eventObj = new EventObj();
							handleEvent(eventObj,anEvent);//处理原始事件
							list.add(eventObj);
						}
					}
				} else if (value instanceof Event) {//如果是事件
					eventObj = new EventObj();
					handleEvent(eventObj,(Event)value);//处理原始事件
					list.add(eventObj);
				}
			}
		}
		return list;
	}

	@Override
	public List<EventObj> doExecute(VMWareConnection connection) throws VMTaskException{
		List<EventObj> list = null;
		try {
			initialize();//初始化
			createEventHistoryCollector();//构建事件采集器
			PropertyFilterSpec eventFilterSpec = createEventFilterSpec();//构建过滤器属性
			propColl = connection.getPropCol();
			propFilter = connection.getService().createFilter(propColl, eventFilterSpec, true);//构建过滤器
			list = collectorData();//采集事件数据
			connection.getService().cancelWaitForUpdates(propColl);//销毁采集器
			connection.getService().destroyPropertyFilter(propFilter);
			connection.getService().destroyCollector(_eventHistoryCollector);//销毁Collector
			return list;
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态",e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常",e);
		}  catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常",e);
		} 
	}

	/**
	 * 采集事件数据
	 * @return
	 * @throws VMTaskException
	 */
	public List<EventObj> collectorData() throws VMTaskException {
		List<EventObj> list = null;
		try {
			UpdateSet update = connection.getService().waitForUpdates(propColl, "");
			if (update != null && update.getFilterSet() != null) {
				list = this.handleUpdate(update);
			}
		} catch (InvalidCollectorVersion e) {
			logger.error(e);
			throw new VMTaskException("收集版本异常", e);
		} catch (InvalidState e) {
			logger.error(e);
			throw new VMTaskException("异常的状态", e);
		} catch (RuntimeFault e) {
			logger.error(e);
			throw new VMTaskException("运行时异常", e);
		} catch (RemoteException e) {
			logger.error(e);
			throw new VMTaskException("远程调用异常",e);
		}
		return list;
	}
}