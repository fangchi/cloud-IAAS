
/**
 * CLITunnelService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

/*
 *  CLITunnelService java interface
 */

public interface CLITunnelService {

	/**
	 * Auto generated method signature
	 * 
	 * @param executeCommandByParamString6
	 * 
	 * @param sessionId7
	 * 
	 * @param transactionId8
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse executeCommandByParamString(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString executeCommandByParamString6,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId7,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId8)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param executeCommandByParamString6
	 * 
	 * @param sessionId7
	 * 
	 * @param transactionId8
	 */
	public void startexecuteCommandByParamString(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString executeCommandByParamString6,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId7,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId8,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature
	 * 
	 * @param executeCommandByParamListAndAttachment10
	 * 
	 * @param sessionId11
	 * 
	 * @param transactionId12
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse executeCommandByParamListAndAttachment(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment executeCommandByParamListAndAttachment10,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId11,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId12)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param executeCommandByParamListAndAttachment10
	 * 
	 * @param sessionId11
	 * 
	 * @param transactionId12
	 */
	public void startexecuteCommandByParamListAndAttachment(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment executeCommandByParamListAndAttachment10,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId11,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId12,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature
	 * 
	 * @param executeCommandUsingAttachments14
	 * 
	 * @param sessionId15
	 * 
	 * @param transactionId16
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse executeCommandUsingAttachments(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments executeCommandUsingAttachments14,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId15,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId16)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param executeCommandUsingAttachments14
	 * 
	 * @param sessionId15
	 * 
	 * @param transactionId16
	 */
	public void startexecuteCommandUsingAttachments(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments executeCommandUsingAttachments14,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId15,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId16,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature
	 * 
	 * @param executeCommandByParamList18
	 * 
	 * @param sessionId19
	 * 
	 * @param transactionId20
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse executeCommandByParamList(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList executeCommandByParamList18,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId19,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId20)
			throws java.rmi.RemoteException

			, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param executeCommandByParamList18
	 * 
	 * @param sessionId19
	 * 
	 * @param transactionId20
	 */
	public void startexecuteCommandByParamList(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList executeCommandByParamList18,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId19,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId20,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
