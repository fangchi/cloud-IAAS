package com.hicomb.vm.vmware.task;

import com.hicomb.vm.vmware.connection.ConnectionPool;
import com.hicomb.vm.vmware.connection.VMWareConnection;
import com.hicomb.vm.vmware.exception.vm.task.VMTaskException;

/**
 * VMware 任务接口，所有的VMware任务必须直接或者间接实现此接口 
 * @param <T>
 */
public abstract class Task<T> {

	/*此任务的连接*/
	protected VMWareConnection connection;
	
	/**
	 * 执行任务
	 * @param connectionPool 执行任务所需要的连接池
	 * @return
	 * @throws VMTaskException
	 */
	public T execute(ConnectionPool connectionPool) throws VMTaskException{
		VMWareConnection connection = null;
		try {
			connection = connectionPool
					.getConnection();
			this.connection = connection;//从连接池中获取连接
			return doExecute(connection);//执行任务
		}catch (VMTaskException e) {
			e.fillInStackTrace();
			throw e;
		}finally{
			if(connection!=null){
				connectionPool.freeConnection(connection);//释放连接
			}
		}
	}
	
	protected abstract T doExecute(VMWareConnection connection) throws VMTaskException;
	
	/**
	 * 获取此任务的连接
	 * @return
	 */
	public VMWareConnection getConnection(){
		return connection;
	}
}
