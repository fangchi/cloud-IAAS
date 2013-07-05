/**
 * LoginService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

/*
 *  LoginService java interface
 */

public interface LoginService {

	/**
	 * Auto generated method signature
	 * 
	 * @param loginUsingUserCredential1
	 * 
	 * @param transactionId2
	 * 
	 * @throws com.bladelogic._2009._11._30.SessionRejectedException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.login.LoginUsingUserCredentialResponse loginUsingUserCredential(

			com.bladelogic.webservices.skeleton.login.LoginUsingUserCredential loginUsingUserCredential1,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId2)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.SessionRejectedException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param loginUsingUserCredential1
	 * 
	 * @param transactionId2
	 */
	public void startloginUsingUserCredential(

			com.bladelogic.webservices.skeleton.login.LoginUsingUserCredential loginUsingUserCredential1,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId2,

			final com.bladelogic._2009._11._30.LoginServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature
	 * 
	 * @param loginUsingSessionCredential4
	 * 
	 * @param transactionId5
	 * 
	 * @throws com.bladelogic._2009._11._30.SessionRejectedException
	 *             :
	 * @throws com.bladelogic._2009._11._30.SessionCredentialExpiredException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.login.LoginUsingSessionCredentialResponse loginUsingSessionCredential(

			com.bladelogic.webservices.skeleton.login.LoginUsingSessionCredential loginUsingSessionCredential4,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId5)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.SessionRejectedException,
			com.bladelogic._2009._11._30.SessionCredentialExpiredException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param loginUsingSessionCredential4
	 * 
	 * @param transactionId5
	 */
	public void startloginUsingSessionCredential(

			com.bladelogic.webservices.skeleton.login.LoginUsingSessionCredential loginUsingSessionCredential4,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId5,

			final com.bladelogic._2009._11._30.LoginServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
