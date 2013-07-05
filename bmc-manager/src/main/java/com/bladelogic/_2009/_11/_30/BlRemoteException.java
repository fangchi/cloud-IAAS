/**
 * BlRemoteException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

public class BlRemoteException extends java.lang.Exception {

	private static final long serialVersionUID = 1365940670827L;

	private com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException faultMessage;

	public BlRemoteException() {
		super("BlRemoteException");
	}

	public BlRemoteException(java.lang.String s) {
		super(s);
	}

	public BlRemoteException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public BlRemoteException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(
			com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException msg) {
		faultMessage = msg;
	}

	public com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException getFaultMessage() {
		return faultMessage;
	}
}
