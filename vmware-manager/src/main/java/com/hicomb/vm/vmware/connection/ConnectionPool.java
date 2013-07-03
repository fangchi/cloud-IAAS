package com.hicomb.vm.vmware.connection;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.vmware.common.VMWareBaseCommon;
import com.hicomb.vm.vmware.exception.connection.VMWareConnctionException;

/**
 * 连接池
 */
public class ConnectionPool {

	private static final Log logger = LogFactory.getLog(ConnectionPool.class);
	
	private int checkedOut;

    private Vector<VMWareConnection> freeConnections = new Vector<VMWareConnection>();

    /*最大连接*/
    private int maxConn = VMWareBaseCommon.VMWARE_CONN_MAXSIZE;

    private int num = 0;
    
    /*当前活动连接*/
    private int numActive = 10;
    
    /*IP*/
    private String ipAddress;
    
    /*用户名*/
    private String userName;
    
    /*密码*/
    private String password;

    
    public ConnectionPool(String ipAddress,String userName,String password) {
    	//trustAllHttpsCertificates();
    	this.ipAddress = ipAddress;
    	this.userName = userName;
    	this.password = password;
    	for (int i = 0; i < VMWareBaseCommon.VMWARE_CONN_NORMALSIZE; i++) { //初始化连接 
        	VMWareConnection c = newConnection();
            if (c != null) {
                freeConnections.addElement(c);
                num++;
            }
        }
    }

    /**
     * 新建连接
     * @return
     */
    private VMWareConnection newConnection()  {
    	try {
    		VMWareConnection connection =  new VMWareConnection(this.ipAddress,this.userName,this.password);
        	connection.open();
        	return connection;
		} catch (VMWareConnctionException e) {
			logger.error("初始化连接出错",e);
			e.printStackTrace();
		}
    	return null;
    }
    
    
    /**
     * 释放连接
     * @param con
     */
    public synchronized void freeConnection(VMWareConnection con) {
        freeConnections.addElement(con);
        num++;
        checkedOut--;
        numActive--;
        notifyAll();
    }

    /**
     * 获取连接
     * @return
     * @throws VMWareConnctionException 
     */
    public synchronized VMWareConnection getConnection(){
    	VMWareConnection con = null;
        if (freeConnections.size() > 0) { 
            num--;
            con = (VMWareConnection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);
            if (con.isClosed()) {
                  con = getConnection();
            }
        } else if (maxConn == 0 || checkedOut < maxConn) {
            con = newConnection();
        }
        if (con != null) { 
            checkedOut++;
        }
        numActive++;
        return con;
    }

    /**
     * 获取连接
     * @param timeout
     * @return
     * @throws VMWareConnctionException 
     */
    public synchronized VMWareConnection getConnection(long timeout) {
        long startTime = new Date().getTime();
        VMWareConnection con;
        while ((con = getConnection()) == null) {
            try {
                wait(timeout);
            } catch (InterruptedException e) {
            }
            if ((new Date().getTime() - startTime) >= timeout) {
                return null; // 
            }
        }
        return con;
    }

    /**
     * 析构函数，释放所有连接资源
     */
    @Override
    public void finalize(){
    	Enumeration<VMWareConnection> allConnections = freeConnections.elements();
		while (allConnections.hasMoreElements()) {
			VMWareConnection con = (VMWareConnection) allConnections.nextElement();
			try {
				con.close();
				num--;
			} catch (VMWareConnctionException e) {
				logger.error("释放连接池失败", e);
				e.printStackTrace();
			}
		}
        freeConnections.removeAllElements();
        numActive = 0;
    }
}
