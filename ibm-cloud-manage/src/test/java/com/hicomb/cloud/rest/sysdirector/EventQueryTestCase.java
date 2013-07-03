package com.hicomb.cloud.rest.sysdirector;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sysdirector.entity.event.SystemDirectorEvent;
import com.hicomb.cloud.rest.sysdirector.https.HttpsSystemDirectorRestEngine;

public class EventQueryTestCase extends TestCase {

	/**
	 * 测试Director事件
	 * @throws CloudRestException
	 */
	public final void testQuerySystemDirectorEvent() throws CloudRestException {
		long current = System.currentTimeMillis();
		long yesterday = current - 1 * 60 * 60 *1000;
		SystemDirectorRestEngine smartCloudEntryRestEngine =new HttpsSystemDirectorRestEngine();
		List<SystemDirectorEvent> list = smartCloudEntryRestEngine.querySystemDirectorEvents("172.16.13.173", 8422, "administrator", "Passw0rd", yesterday, current, "Critical");
		assertNotNull(list);
		for (Iterator<SystemDirectorEvent> iterator = list.iterator(); iterator.hasNext();) {
			SystemDirectorEvent smartCloudEntryEvent = (SystemDirectorEvent) iterator
					.next();
			System.out.println(smartCloudEntryEvent.getEventId());
			System.out.println(smartCloudEntryEvent.getOccurTime());
			System.out.println(smartCloudEntryEvent.getContent());
			System.out.println(smartCloudEntryEvent.getSeverity());
			System.out.println(smartCloudEntryEvent.getResHostIp());
			System.out.println(smartCloudEntryEvent.getResIp());
		}
	}
}
