package com.hicomb.vm.vmware.exception.connection;

/**
 * VMMware 连接异常
 */
public class VMWareConnctionException extends Exception{

	private static final long serialVersionUID = -5599683225415660287L;

	private Exception originalException;
	
	public VMWareConnctionException(String exceptionDescription){
		super(exceptionDescription);
	}
	
	public VMWareConnctionException( Exception throwable){
		originalException = throwable;
	}
	
	public VMWareConnctionException(String exceptionDescription, Exception throwable){
		super(exceptionDescription);
		originalException = throwable;
	}
	
	
	@Override
	public String toString(){
		originalException.printStackTrace();
		return "VMware连接异常:"+originalException.getLocalizedMessage();
	}
}
