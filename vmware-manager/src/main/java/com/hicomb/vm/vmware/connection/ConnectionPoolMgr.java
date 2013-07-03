package com.hicomb.vm.vmware.connection;

import java.util.HashMap;
import java.util.Map;

/**
 * 连接池管理器
 */
public class ConnectionPoolMgr {

	/*缓存的连接池*/
	private static Map <String,ConnectionPool> cachedConnectionPoolMap = new HashMap<String, ConnectionPool>();
	
	/**
	 * 获取连接池
	 * @param ip
	 * @param userName
	 * @param password
	 * @return
	 */
	public static ConnectionPool getConnectionPool(String ip,String userName ,String password) {
		if(cachedConnectionPoolMap.get(ip)!=null){//根据IP地址缓存
			return cachedConnectionPoolMap.get(ip);
		}else{
			ConnectionPool connectionPool = new ConnectionPool(ip,userName,password);
			cachedConnectionPoolMap.put(ip, connectionPool
					);
			return connectionPool;
		}
	}
	
	public static int getPoolSize() {
		return cachedConnectionPoolMap.size();
	}
}
