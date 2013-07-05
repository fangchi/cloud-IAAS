/**
 * CLITunnelServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.bladelogic._2009._11._30;

/**
 * CLITunnelServiceCallbackHandler Callback class, Users can extend this class
 * and implement their own receiveResult and receiveError methods.
 */
public abstract class CLITunnelServiceCallbackHandler {

	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the
	 * NonBlocking Web service call is finished and appropriate method of this
	 * CallBack is called.
	 * 
	 * @param clientData
	 *            Object mechanism by which the user can pass in user data that
	 *            will be avilable at the time this callback is called.
	 */
	public CLITunnelServiceCallbackHandler(Object clientData) {
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public CLITunnelServiceCallbackHandler() {
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */

	public Object getClientData() {
		return clientData;
	}

	/**
	 * auto generated Axis2 call back method for executeCommandByParamString
	 * method override this method for handling normal response from
	 * executeCommandByParamString operation
	 */
	public void receiveResultexecuteCommandByParamString(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from executeCommandByParamString operation
	 */
	public void receiveErrorexecuteCommandByParamString(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for
	 * executeCommandByParamListAndAttachment method override this method for
	 * handling normal response from executeCommandByParamListAndAttachment
	 * operation
	 */
	public void receiveResultexecuteCommandByParamListAndAttachment(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from executeCommandByParamListAndAttachment operation
	 */
	public void receiveErrorexecuteCommandByParamListAndAttachment(
			java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for executeCommandUsingAttachments
	 * method override this method for handling normal response from
	 * executeCommandUsingAttachments operation
	 */
	public void receiveResultexecuteCommandUsingAttachments(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from executeCommandUsingAttachments operation
	 */
	public void receiveErrorexecuteCommandUsingAttachments(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for executeCommandByParamList
	 * method override this method for handling normal response from
	 * executeCommandByParamList operation
	 */
	public void receiveResultexecuteCommandByParamList(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from executeCommandByParamList operation
	 */
	public void receiveErrorexecuteCommandByParamList(java.lang.Exception e) {
	}

}
