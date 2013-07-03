package com.hicomb.vm.connection;

/**
 * VMware连接接口
 */
public interface VMConnection {

	/**
	 * 打开连接
	 * @throws Exception
	 */
	public void open() throws Exception;
	
	/**
	 * 关闭连接
	 * @throws Exception
	 */
	public void close() throws Exception ;
	
	/**
	 * 是否已经关闭
	 * @return
	 */
	public boolean isClosed() ;
}
