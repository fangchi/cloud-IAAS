package com.hicomb.vm.vmware.connection;

import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.ConnectionPoolMgr;
import com.hicomb.vm.vmware.connection.VMWareConnection;

import junit.framework.TestCase;

/**
 * 连接池测试
 */
public class ConnectionPoolTestCase extends TestCase {
	
	/**
	 *  测试连接池
	 */
	public void testConntectionPool() {
		ConnectionPool connectionPool = ConnectionPoolMgr.getConnectionPool("192.168.2.115", "root", "broada123");
		VMWareConnection onConnection  = connectionPool.getConnection();
		assertEquals(false, onConnection.isClosed());
		connectionPool.freeConnection(onConnection);
	}

}
