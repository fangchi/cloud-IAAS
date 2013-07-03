package com.hicomb.cloud.hmc.exception;

/**
 * HMC 异常
 */
public class HMCException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Exception oriException;
	
	private String msg ;
	
	public HMCException(Exception e,String msg){
		this.oriException = e;
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "HMC 错误: "+msg+",原始错误："+oriException.getLocalizedMessage();
	}
}
