package com.hicomb.vm.vmware.connection;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hicomb.vm.connection.VMConnection;
import com.hicomb.vm.vmware.exception.connection.VMWareConnctionException;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimServiceLocator;

/**
 * Vmware 连接
 */
public class VMWareConnection implements VMConnection {

	private static final Log logger = LogFactory.getLog(VMWareConnection.class);

	private String ipAddress;
	
	private String userName;
	
	private String password;
	
	/**
	 * 直接连接
	 */
	private boolean isConnected;
	/**
	 * 定位器
	 */
	private VimServiceLocator locator;
	/**
	 * 服务Content
	 */
	private ServiceContent serviceContent;
	/**
	 *
	 */
	private  ManagedObjectReference mor;
	/**
	 * 服务
	 */
	private VimPortType service;

	/**
	 *忽略校验
	 */
	private void ignoreCert() {
		System.setProperty(
				"org.apache.axis.components.net.SecureSocketFactory",
				"org.apache.axis.components.net.SunFakeTrustSocketFactory");
	}
	

	public VMWareConnection(String ipAddress, String userName, String password) {
		super();
		this.ipAddress = ipAddress;
		this.userName = userName;
		this.password = password;
	}



	/**
	 * 打开连接
	 * @param ignoreCerts
	 * @param password
	 * @param userName
	 * @param urlStr
	 * @throws VSphereException
	 */
	public void open() throws VMWareConnctionException {
		ignoreCert();
		mor = new ManagedObjectReference();
		mor.setType("ServiceInstance");
		mor.set_value("ServiceInstance");
		locator = new VimServiceLocator();
		locator.setMaintainSession(true);
		try {
			service = locator.getVimPort(new URL(
					getVSphereSDKUrl(this.ipAddress)));
			serviceContent = service.retrieveServiceContent(mor);
			if (serviceContent.getSessionManager() != null) {
				service.login(serviceContent.getSessionManager(),
						this.userName,
						this.password, null);
			}
			isConnected = true;
			logger.info("connection established");
		} catch (Exception e) {
			e.printStackTrace();
			throw new VMWareConnctionException(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * SDK url
	 * @param ipAddr
	 */
	public static String getVSphereSDKUrl(String ipAddr) {
		return "https://" + ipAddr + "/sdk";
	}

	/**
	 * 关闭连接
	 * @throws VSphereException
	 */
	public void close() throws VMWareConnctionException {
		if (service != null) {
			try {
				service.logout(serviceContent.getSessionManager());
			} catch (Exception e) {
				throw new VMWareConnctionException(e.getLocalizedMessage(), e);
			}
			service = null;
			serviceContent = null;
			isConnected = false;
			logger.info("connection close");
		}
	}

	/**
	 * 是否关闭
	 */
	public boolean isClosed() {
		return !isConnected;
	}

	/**
	 * 获取服务
	 */
	public VimPortType getService() {
		return service;
	}

	public ServiceContent getServiceContent() {
		return serviceContent;
	}

	
	public ManagedObjectReference getRootFolder() {
		return serviceContent.getRootFolder();
	}

	public ManagedObjectReference getPropCol() {
		return serviceContent.getPropertyCollector();
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}

	
}