package com.hicomb.bmc.bladelogic.webservice.exception;

public class BladeLogicCommondException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BladeLogicCommondException(String msg){
		super(msg);
	}

	public BladeLogicCommondException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BladeLogicCommondException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BladeLogicCommondException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
