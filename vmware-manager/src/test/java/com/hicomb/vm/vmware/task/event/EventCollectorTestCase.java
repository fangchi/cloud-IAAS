package com.hicomb.vm.vmware.task.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;
import com.hicomb.vm.vmware.task.Task;
import com.hicomb.vm.vmware.task.event.EventObj;
import com.hicomb.vm.vmware.task.event.QueryEventTask;

import junit.framework.TestCase;

/**
 *  事件采集测试用例
 */
public class EventCollectorTestCase extends TestCase {
	
	/**
	 * 执行时间采集 注：保证本机和Vcenter服务器时间一致
	 * @throws InterruptedException
	 * @throws VMTaskException
	 */
	public void testColletor() throws InterruptedException, VMTaskException {
		Calendar startTime = Calendar.getInstance();
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool("192.168.2.115", "root", "broada123");
//		String str = "2012-06-01 00:00:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date date = sdf.parse(str);
//			startTime = Calendar.getInstance();
//			startTime.setTime(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Calendar endTime = null;
		String [] eventType = {"VmPoweredOffEvent",
				"VmPoweredOnEvent", "VmSuspendedEvent", "VmRenamedEvent" };
		String [] alarmCategory = {"error"};
		while(true){
			Thread.sleep(10000);
			endTime = Calendar.getInstance();
//			System.out.println("EventCollectorTestCase.startTime = " + startTime.getTime()+" EventCollectorTestCase.endTime = "+endTime.getTime());
			Task<List<EventObj>> task = new QueryEventTask(startTime, endTime, eventType, alarmCategory);
			List<EventObj> list = task.execute(connectionPool);
			System.out.println("objId = " + list.get(0).getObjId());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					System.out.println("EventId = " + list.get(i).getEventId());
					System.out.println("EventType = " + list.get(i).getEventType());
					System.out.println("ClassName = " + list.get(i).getClassName());
					System.out.println("FullFormattedMessage = " + list.get(i).getFullFormattedMessage());
					System.out.println("Reference = " + list.get(i).getReferenceStr());
					System.out.println("setSrcManagedObjectReference = " + list.get(i).getSrcManagedObjectReference());
					System.out.println("CreateTime = " + list.get(i).getCreateTime());
				}
			}
			startTime = endTime;
		}		
	}
	
	/**
	 * 执行时间采集 注：保证本机和Vcenter服务器时间一致
	 * @throws InterruptedException
	 * @throws VMTaskException
	 */
	public void testColletor2() throws InterruptedException, VMTaskException {
		Calendar startTime = Calendar.getInstance();
		ConnectionPool  connectionPool = ConnectionPoolMgr.getConnectionPool("192.168.2.115", "root", "broada123");
		String str = "2013-01-10 16:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(str);
			startTime = Calendar.getInstance();
			startTime.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar endTime = Calendar.getInstance();
		String [] eventType = {"VmPoweredOffEvent",
				"VmPoweredOnEvent", "VmSuspendedEvent", "VmRenamedEvent" };
		String [] alarmCategory = {};
		
		Task<List<EventObj>> task = new QueryEventTask(startTime, endTime, eventType, alarmCategory);
		List<EventObj> list = task.execute(connectionPool);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("EventId = " + list.get(i).getEventId());
				System.out.println("EventType = " + list.get(i).getEventType());
				System.out.println("ClassName = " + list.get(i).getClassName());
				System.out.println("FullFormattedMessage = " + list.get(i).getFullFormattedMessage());
				System.out.println("Reference = " + list.get(i).getReferenceStr());
				System.out.println("setSrcManagedObjectReference = " + list.get(i).getSrcManagedObjectReference());
				System.out.println("CreateTime = " + list.get(i).getCreateTime());
			}
		}
	}
}
