/**
 * CommandLoadException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

public class CommandLoadException extends java.lang.Exception {

	private static final long serialVersionUID = 1365940670902L;

	private com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException faultMessage;

	public CommandLoadException() {
		super("CommandLoadException");
	}

	public CommandLoadException(java.lang.String s) {
		super(s);
	}

	public CommandLoadException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public CommandLoadException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(
			com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException msg) {
		faultMessage = msg;
	}

	public com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException getFaultMessage() {
		return faultMessage;
	}
}
