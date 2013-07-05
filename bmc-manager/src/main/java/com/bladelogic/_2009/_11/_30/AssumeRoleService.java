
/**
 * AssumeRoleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

/*
 *  AssumeRoleService java interface
 */

public interface AssumeRoleService {

	/**
	 * Auto generated method signature
	 * 
	 * @param assumeRole0
	 * 
	 * @param sessionId1
	 * 
	 * @param transactionId2
	 * 
	 * @throws com.bladelogic._2009._11._30.SessionRejectedException
	 *             :
	 * @throws com.bladelogic._2009._11._30.SessionCredentialExpiredException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.assumerole.AssumeRoleResponse assumeRole(

			com.bladelogic.webservices.skeleton.assumerole.AssumeRole assumeRole0,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId1,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId2)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.SessionRejectedException,
			com.bladelogic._2009._11._30.SessionCredentialExpiredException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param assumeRole0
	 * 
	 * @param sessionId1
	 * 
	 * @param transactionId2
	 */
	public void startassumeRole(

			com.bladelogic.webservices.skeleton.assumerole.AssumeRole assumeRole0,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId1,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId2,

			final com.bladelogic._2009._11._30.AssumeRoleServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
