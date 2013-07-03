package com.hicomb.vm.vmware.exception.properies;

/**
 * VMwareProperties属性异常
 *
 */
public class VMWarePropertiesException extends Exception {
	
	private static final long serialVersionUID = -1322860428909734158L;

	private Exception originalException;
	
	public VMWarePropertiesException(String exceptionDescription){
		super(exceptionDescription);
	}
	
	public VMWarePropertiesException(String exceptionDescription, Exception throwable){
		super(exceptionDescription);
		originalException = throwable;
	}
	
	
	@Override
	public String toString(){
		originalException.printStackTrace();
		return "VMware获取属性异常:"+originalException.getLocalizedMessage();
	}
}
