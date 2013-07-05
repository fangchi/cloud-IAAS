/**
 * SessionRejectedException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

public class SessionRejectedException extends java.lang.Exception {

	private static final long serialVersionUID = 1365939611695L;

	private com.bladelogic.webservices.skeleton.assumerole.SessionRejectedException faultMessage;

	public SessionRejectedException() {
		super("SessionRejectedException");
	}

	public SessionRejectedException(java.lang.String s) {
		super(s);
	}

	public SessionRejectedException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public SessionRejectedException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(
			com.bladelogic.webservices.skeleton.assumerole.SessionRejectedException msg) {
		faultMessage = msg;
	}

	public com.bladelogic.webservices.skeleton.assumerole.SessionRejectedException getFaultMessage() {
		return faultMessage;
	}
}
