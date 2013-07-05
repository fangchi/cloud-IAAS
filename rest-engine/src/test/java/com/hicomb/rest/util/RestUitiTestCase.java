package com.hicomb.rest.util;

import java.util.HashMap;


import com.hicomb.rest.RestBaseTestCase;

public class RestUitiTestCase extends RestBaseTestCase {

	public final void testValueToObject() {
		String a = "{\"a\":1,\"b\":\"asasasa\",\"c\":121.02}";
		assertEquals("asasasa", RESTUtilities.fromJSON(a, HashMap.class).get("b"));
		assertEquals(1, RESTUtilities.fromJSON(a, HashMap.class).get("a"));
		assertEquals(121.02, RESTUtilities.fromJSON(a, HashMap.class).get("c"));
	}
	
	public final void testCreateURIWithSimpleParameters() {
		HashMap<String,Object> parames = new HashMap<String, Object>();
		parames.put("a", "1");
		parames.put("b", "2");
		String url = RESTUtilities.createURIWithSimpleParameters("www.baidu.com", parames);
		assertTrue(url.equals("www.baidu.com?a=1&b=2")|| url.equals("www.baidu.com?b=2&a=1"));
	}
}
