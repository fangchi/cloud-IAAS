package com.hicomb.vm.vmware.exception.vm.task;

/**
 * VMware 任务异常
 */
public class VMTaskException extends Exception {

	private static final long serialVersionUID = -7349416970636435929L;
	
	private Exception originalException;
	
	public VMTaskException(String exceptionDescription){
		super(exceptionDescription);
	}
	
	public VMTaskException(String exceptionDescription, Exception throwable){
		super(exceptionDescription);
		originalException = throwable;
	}
	
	@Override
	public String toString(){
		originalException.printStackTrace();
		return "VMware任务异常:"+originalException.getLocalizedMessage();
	}
}
