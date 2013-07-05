package com.hicomb.rest.handler;

import java.net.HttpURLConnection;
import java.util.HashMap;

import com.hicomb.rest.RestBaseTestCase;
import com.hicomb.rest.engine.RestEngine;
import com.hicomb.rest.engine.impl.DefaultRestEngine;
import com.hicomb.rest.exception.RestException;
import com.hicomb.rest.handler.impl.JsonTypeHandler;

public class JsonHandlerTestCase extends RestBaseTestCase {

	public void testHandlerJson() throws RestException {
		RestEngine restEngine = new DefaultRestEngine();
		HttpURLConnection conn = restEngine.processHttpRequest(
				"http://dojotoolkit.org/api/lib/tree.php?v=1.6", "GET", null,
				new HashMap<String, String>(),"UTF-8");
		
		ConnectionHandler<HashMap>  connectionHandler = new JsonTypeHandler<HashMap>();
		HashMap map = connectionHandler.handle(conn, HashMap.class);
		assertTrue(map != null);
	}
}
