/**
 * SessionCredentialExpiredException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

public class SessionCredentialExpiredException extends java.lang.Exception {

	private static final long serialVersionUID = 1365939611749L;

	private com.bladelogic.webservices.skeleton.assumerole.SessionCredentialExpiredException faultMessage;

	public SessionCredentialExpiredException() {
		super("SessionCredentialExpiredException");
	}

	public SessionCredentialExpiredException(java.lang.String s) {
		super(s);
	}

	public SessionCredentialExpiredException(java.lang.String s,
			java.lang.Throwable ex) {
		super(s, ex);
	}

	public SessionCredentialExpiredException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(
			com.bladelogic.webservices.skeleton.assumerole.SessionCredentialExpiredException msg) {
		faultMessage = msg;
	}

	public com.bladelogic.webservices.skeleton.assumerole.SessionCredentialExpiredException getFaultMessage() {
		return faultMessage;
	}
}
