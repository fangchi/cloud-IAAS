package com.hicomb.rest.exception;

/**
 * Rest引擎异常
 * @author Administrator
 */
public class RestException extends Exception {
	
	private static final long serialVersionUID = 6158248958600318103L;
	
	private Throwable throwable;
	
	public RestException( String msg) {
		super(msg);
	}

	public RestException( Throwable throwable) {
		this.throwable = throwable;
	}
	
	@Override
	public String toString(){
		return "Rest引擎异常:"+throwable.toString();
	}
}
