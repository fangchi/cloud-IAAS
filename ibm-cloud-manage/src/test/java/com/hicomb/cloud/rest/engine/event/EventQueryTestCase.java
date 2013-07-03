package com.hicomb.cloud.rest.engine.event;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.hicomb.cloud.rest.exception.CloudRestException;
import com.hicomb.cloud.rest.sce.SmartCloudEntryRestEngine;
import com.hicomb.cloud.rest.sce.entity.event.SmartCloudEntryEvent;
import com.hicomb.cloud.rest.sce.http.HttpSmartCloudEntryRestEngine;

public class EventQueryTestCase extends TestCase {

	/**
	 * 测试查询事件列表
	 * @throws CloudRestException
	 */
	public final void testQuerySceEvent() throws CloudRestException {
		long current = System.currentTimeMillis();
		long yesterday = current - 24 * 60 * 60 *1000;
		SmartCloudEntryRestEngine smartCloudEntryRestEngine =new HttpSmartCloudEntryRestEngine();
		List<SmartCloudEntryEvent> list = smartCloudEntryRestEngine.querySceEvent("172.16.13.173", 8080, "admin", "admin", yesterday, current, "INFO");
		assertNotNull(list);
		for (Iterator<SmartCloudEntryEvent> iterator = list.iterator(); iterator.hasNext();) {
			SmartCloudEntryEvent smartCloudEntryEvent = (SmartCloudEntryEvent) iterator
					.next();
			System.out.println(smartCloudEntryEvent.getEventId());
			System.out.println(smartCloudEntryEvent.getRelatedResource().get(0).get("id"));
			System.out.println(smartCloudEntryEvent.getOccurTime());
			System.out.println(smartCloudEntryEvent.getMessage());
		}
	}
}
