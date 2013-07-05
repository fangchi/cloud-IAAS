/**
 * CommandNotFoundException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

public class CommandNotFoundException extends java.lang.Exception {

	private static final long serialVersionUID = 1365940670864L;

	private com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException faultMessage;

	public CommandNotFoundException() {
		super("CommandNotFoundException");
	}

	public CommandNotFoundException(java.lang.String s) {
		super(s);
	}

	public CommandNotFoundException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public CommandNotFoundException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(
			com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException msg) {
		faultMessage = msg;
	}

	public com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException getFaultMessage() {
		return faultMessage;
	}
}
