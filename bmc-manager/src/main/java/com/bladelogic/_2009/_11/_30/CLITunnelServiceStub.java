/**
 * CLITunnelServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.bladelogic._2009._11._30;

/*
 *  CLITunnelServiceStub java implementation
 */

public class CLITunnelServiceStub extends org.apache.axis2.client.Stub
		implements CLITunnelService {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(java.lang.System.currentTimeMillis())
				+ "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService(
				"CLITunnelService" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[4];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://bladelogic.com/2009/11/30",
				"executeCommandByParamString"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://bladelogic.com/2009/11/30",
				"executeCommandByParamListAndAttachment"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName(
				"http://bladelogic.com/2009/11/30",
				"executeCommandUsingAttachments"));
		_service.addOperation(__operation);

		_operations[2] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation
				.setName(new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamList"));
		_service.addOperation(__operation);

		_operations[3] = __operation;

	}

	// populates the faults
	private void populateFaults() {

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"), "executeCommandByParamString"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"), "executeCommandByParamString"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandByParamString"),
						"com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamString"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamString"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandNotFoundException"),
						"executeCommandByParamString"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException");

		faultExceptionNameMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandByParamString"),
						"com.bladelogic._2009._11._30.CommandLoadException");
		faultExceptionClassNameMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandByParamString"),
						"com.bladelogic._2009._11._30.CommandLoadException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandByParamString"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandByParamListAndAttachment"),
						"com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandNotFoundException"),
						"executeCommandByParamListAndAttachment"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"),
				"executeCommandByParamListAndAttachment"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandByParamListAndAttachment"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException");

		faultExceptionNameMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandUsingAttachments"),
						"com.bladelogic._2009._11._30.BlRemoteException");
		faultExceptionClassNameMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandUsingAttachments"),
						"com.bladelogic._2009._11._30.BlRemoteException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandUsingAttachments"),
						"com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandUsingAttachments"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandUsingAttachments"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandNotFoundException"),
						"executeCommandUsingAttachments"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"),
				"executeCommandUsingAttachments"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"),
				"executeCommandUsingAttachments"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandUsingAttachments"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"), "executeCommandByParamList"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"BlRemoteException"), "executeCommandByParamList"),
				"com.bladelogic._2009._11._30.BlRemoteException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"BlRemoteException"),
						"executeCommandByParamList"),
						"com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamList"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandNotFoundException"),
				"executeCommandByParamList"),
				"com.bladelogic._2009._11._30.CommandNotFoundException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandNotFoundException"),
						"executeCommandByParamList"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"), "executeCommandByParamList"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
				new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"CommandLoadException"), "executeCommandByParamList"),
				"com.bladelogic._2009._11._30.CommandLoadException");
		faultMessageMap
				.put(new org.apache.axis2.client.FaultMapKey(
						new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"CommandLoadException"),
						"executeCommandByParamList"),
						"com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException");

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public CLITunnelServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public CLITunnelServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext,
			java.lang.String targetEndpoint, boolean useSeparateListener)
			throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(
				configurationContext, _service);

		_serviceClient.getOptions().setTo(
				new org.apache.axis2.addressing.EndpointReference(
						targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

	}

	/**
	 * Default Constructor
	 */
	public CLITunnelServiceStub(
			org.apache.axis2.context.ConfigurationContext configurationContext)
			throws org.apache.axis2.AxisFault {

		this(configurationContext,
				"https://localhost:9843/services/CLITunnelService");

	}

	/**
	 * Default Constructor
	 */
	public CLITunnelServiceStub() throws org.apache.axis2.AxisFault {

		this("https://localhost:9843/services/CLITunnelService");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public CLITunnelServiceStub(java.lang.String targetEndpoint)
			throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#executeCommandByParamString
	 * @param executeCommandByParamString22
	 * 
	 * @param sessionId23
	 * 
	 * @param transactionId24
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse executeCommandByParamString(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString executeCommandByParamString22,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId23,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId24)

	throws java.rmi.RemoteException

	, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction(
					"bladelogicNamespace:executeCommandByParamString");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), executeCommandByParamString22,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamString")),
					new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamString"));

			env.build();

			// add the children only if the parameter is not null
			if (sessionId23 != null) {

				org.apache.axiom.om.OMElement omElementsessionId23 = toOM(
						sessionId23,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamString")));
				addHeader(omElementsessionId23, env);

			}

			// add the children only if the parameter is not null
			if (transactionId24 != null) {

				org.apache.axiom.om.OMElement omElementtransactionId24 = toOM(
						transactionId24,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamString")));
				addHeader(omElementtransactionId24, env);

			}

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(),
								"executeCommandByParamString"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamString"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass
								.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor
								.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamString"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
							throw (com.bladelogic._2009._11._30.BlRemoteException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
							throw (com.bladelogic._2009._11._30.CommandNotFoundException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
							throw (com.bladelogic._2009._11._30.CommandLoadException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#startexecuteCommandByParamString
	 * @param executeCommandByParamString22
	 * 
	 * @param sessionId23
	 * 
	 * @param transactionId24
	 */
	public void startexecuteCommandByParamString(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString executeCommandByParamString22,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId23,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId24,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction(
				"bladelogicNamespace:executeCommandByParamString");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), executeCommandByParamString22,
				optimizeContent(new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamString")),
				new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamString"));

		// add the soap_headers only if they are not null
		if (sessionId23 != null) {

			org.apache.axiom.om.OMElement omElementsessionId23 = toOM(
					sessionId23, optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamString")));
			addHeader(omElementsessionId23, env);

		}

		// add the soap_headers only if they are not null
		if (transactionId24 != null) {

			org.apache.axiom.om.OMElement omElementtransactionId24 = toOM(
					transactionId24,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamString")));
			addHeader(omElementtransactionId24, env);

		}

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultexecuteCommandByParamString((com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorexecuteCommandByParamString(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"executeCommandByParamString"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamString"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.reflect.Constructor constructor = exceptionClass
												.getConstructor(String.class);
										java.lang.Exception ex = (java.lang.Exception) constructor
												.newInstance(f.getMessage());
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamString"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
											callback.receiveErrorexecuteCommandByParamString((com.bladelogic._2009._11._30.BlRemoteException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
											callback.receiveErrorexecuteCommandByParamString((com.bladelogic._2009._11._30.CommandNotFoundException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
											callback.receiveErrorexecuteCommandByParamString((com.bladelogic._2009._11._30.CommandLoadException) ex);
											return;
										}

										callback.receiveErrorexecuteCommandByParamString(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamString(f);
									}
								} else {
									callback.receiveErrorexecuteCommandByParamString(f);
								}
							} else {
								callback.receiveErrorexecuteCommandByParamString(f);
							}
						} else {
							callback.receiveErrorexecuteCommandByParamString(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorexecuteCommandByParamString(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#executeCommandByParamListAndAttachment
	 * @param executeCommandByParamListAndAttachment26
	 * 
	 * @param sessionId27
	 * 
	 * @param transactionId28
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse executeCommandByParamListAndAttachment(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment executeCommandByParamListAndAttachment26,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId27,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId28)

	throws java.rmi.RemoteException

	, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[1].getName());
			_operationClient
					.getOptions()
					.setAction(
							"bladelogicNamespace:executeCommandByParamListAndAttachment");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()),
					executeCommandByParamListAndAttachment26,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamListAndAttachment")),
					new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamListAndAttachment"));

			env.build();

			// add the children only if the parameter is not null
			if (sessionId27 != null) {

				org.apache.axiom.om.OMElement omElementsessionId27 = toOM(
						sessionId27,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamListAndAttachment")));
				addHeader(omElementsessionId27, env);

			}

			// add the children only if the parameter is not null
			if (transactionId28 != null) {

				org.apache.axiom.om.OMElement omElementtransactionId28 = toOM(
						transactionId28,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamListAndAttachment")));
				addHeader(omElementtransactionId28, env);

			}

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(),
								"executeCommandByParamListAndAttachment"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamListAndAttachment"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass
								.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor
								.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamListAndAttachment"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
							throw (com.bladelogic._2009._11._30.BlRemoteException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
							throw (com.bladelogic._2009._11._30.CommandNotFoundException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
							throw (com.bladelogic._2009._11._30.CommandLoadException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#startexecuteCommandByParamListAndAttachment
	 * @param executeCommandByParamListAndAttachment26
	 * 
	 * @param sessionId27
	 * 
	 * @param transactionId28
	 */
	public void startexecuteCommandByParamListAndAttachment(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment executeCommandByParamListAndAttachment26,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId27,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId28,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction(
				"bladelogicNamespace:executeCommandByParamListAndAttachment");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()),
				executeCommandByParamListAndAttachment26,
				optimizeContent(new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamListAndAttachment")),
				new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamListAndAttachment"));

		// add the soap_headers only if they are not null
		if (sessionId27 != null) {

			org.apache.axiom.om.OMElement omElementsessionId27 = toOM(
					sessionId27, optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamListAndAttachment")));
			addHeader(omElementsessionId27, env);

		}

		// add the soap_headers only if they are not null
		if (transactionId28 != null) {

			org.apache.axiom.om.OMElement omElementtransactionId28 = toOM(
					transactionId28,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamListAndAttachment")));
			addHeader(omElementtransactionId28, env);

		}

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultexecuteCommandByParamListAndAttachment((com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorexecuteCommandByParamListAndAttachment(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"executeCommandByParamListAndAttachment"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamListAndAttachment"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.reflect.Constructor constructor = exceptionClass
												.getConstructor(String.class);
										java.lang.Exception ex = (java.lang.Exception) constructor
												.newInstance(f.getMessage());
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamListAndAttachment"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
											callback.receiveErrorexecuteCommandByParamListAndAttachment((com.bladelogic._2009._11._30.BlRemoteException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
											callback.receiveErrorexecuteCommandByParamListAndAttachment((com.bladelogic._2009._11._30.CommandNotFoundException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
											callback.receiveErrorexecuteCommandByParamListAndAttachment((com.bladelogic._2009._11._30.CommandLoadException) ex);
											return;
										}

										callback.receiveErrorexecuteCommandByParamListAndAttachment(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
									}
								} else {
									callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
								}
							} else {
								callback.receiveErrorexecuteCommandByParamListAndAttachment(f);
							}
						} else {
							callback.receiveErrorexecuteCommandByParamListAndAttachment(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorexecuteCommandByParamListAndAttachment(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[1].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#executeCommandUsingAttachments
	 * @param executeCommandUsingAttachments30
	 * 
	 * @param sessionId31
	 * 
	 * @param transactionId32
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse executeCommandUsingAttachments(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments executeCommandUsingAttachments30,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId31,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId32)

	throws java.rmi.RemoteException

	, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[2].getName());
			_operationClient.getOptions().setAction(
					"bladelogicNamespace:executeCommandUsingAttachments");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), executeCommandUsingAttachments30,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandUsingAttachments")),
					new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandUsingAttachments"));

			env.build();

			// add the children only if the parameter is not null
			if (sessionId31 != null) {

				org.apache.axiom.om.OMElement omElementsessionId31 = toOM(
						sessionId31,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandUsingAttachments")));
				addHeader(omElementsessionId31, env);

			}

			// add the children only if the parameter is not null
			if (transactionId32 != null) {

				org.apache.axiom.om.OMElement omElementtransactionId32 = toOM(
						transactionId32,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandUsingAttachments")));
				addHeader(omElementtransactionId32, env);

			}

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(),
								"executeCommandUsingAttachments"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandUsingAttachments"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass
								.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor
								.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandUsingAttachments"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
							throw (com.bladelogic._2009._11._30.BlRemoteException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
							throw (com.bladelogic._2009._11._30.CommandNotFoundException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
							throw (com.bladelogic._2009._11._30.CommandLoadException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#startexecuteCommandUsingAttachments
	 * @param executeCommandUsingAttachments30
	 * 
	 * @param sessionId31
	 * 
	 * @param transactionId32
	 */
	public void startexecuteCommandUsingAttachments(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments executeCommandUsingAttachments30,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId31,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId32,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[2].getName());
		_operationClient.getOptions().setAction(
				"bladelogicNamespace:executeCommandUsingAttachments");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), executeCommandUsingAttachments30,
				optimizeContent(new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandUsingAttachments")),
				new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandUsingAttachments"));

		// add the soap_headers only if they are not null
		if (sessionId31 != null) {

			org.apache.axiom.om.OMElement omElementsessionId31 = toOM(
					sessionId31, optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandUsingAttachments")));
			addHeader(omElementsessionId31, env);

		}

		// add the soap_headers only if they are not null
		if (transactionId32 != null) {

			org.apache.axiom.om.OMElement omElementtransactionId32 = toOM(
					transactionId32,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandUsingAttachments")));
			addHeader(omElementtransactionId32, env);

		}

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultexecuteCommandUsingAttachments((com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorexecuteCommandUsingAttachments(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"executeCommandUsingAttachments"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandUsingAttachments"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.reflect.Constructor constructor = exceptionClass
												.getConstructor(String.class);
										java.lang.Exception ex = (java.lang.Exception) constructor
												.newInstance(f.getMessage());
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandUsingAttachments"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
											callback.receiveErrorexecuteCommandUsingAttachments((com.bladelogic._2009._11._30.BlRemoteException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
											callback.receiveErrorexecuteCommandUsingAttachments((com.bladelogic._2009._11._30.CommandNotFoundException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
											callback.receiveErrorexecuteCommandUsingAttachments((com.bladelogic._2009._11._30.CommandLoadException) ex);
											return;
										}

										callback.receiveErrorexecuteCommandUsingAttachments(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandUsingAttachments(f);
									}
								} else {
									callback.receiveErrorexecuteCommandUsingAttachments(f);
								}
							} else {
								callback.receiveErrorexecuteCommandUsingAttachments(f);
							}
						} else {
							callback.receiveErrorexecuteCommandUsingAttachments(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorexecuteCommandUsingAttachments(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[2].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[2].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#executeCommandByParamList
	 * @param executeCommandByParamList34
	 * 
	 * @param sessionId35
	 * 
	 * @param transactionId36
	 * 
	 * @throws com.bladelogic._2009._11._30.BlRemoteException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandNotFoundException
	 *             :
	 * @throws com.bladelogic._2009._11._30.CommandLoadException
	 *             :
	 */

	public com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse executeCommandByParamList(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList executeCommandByParamList34,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId35,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId36)

	throws java.rmi.RemoteException

	, com.bladelogic._2009._11._30.BlRemoteException,
			com.bladelogic._2009._11._30.CommandNotFoundException,
			com.bladelogic._2009._11._30.CommandLoadException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient = _serviceClient
					.createClient(_operations[3].getName());
			_operationClient.getOptions().setAction(
					"bladelogicNamespace:executeCommandByParamList");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(
					true);

			addPropertyToOperationClient(
					_operationClient,
					org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
					"&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			env = toEnvelope(getFactory(_operationClient.getOptions()
					.getSoapVersionURI()), executeCommandByParamList34,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamList")),
					new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamList"));

			env.build();

			// add the children only if the parameter is not null
			if (sessionId35 != null) {

				org.apache.axiom.om.OMElement omElementsessionId35 = toOM(
						sessionId35,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamList")));
				addHeader(omElementsessionId35, env);

			}

			// add the children only if the parameter is not null
			if (transactionId36 != null) {

				org.apache.axiom.om.OMElement omElementtransactionId36 = toOM(
						transactionId36,
						optimizeContent(new javax.xml.namespace.QName(
								"http://bladelogic.com/2009/11/30",
								"executeCommandByParamList")));
				addHeader(omElementtransactionId36, env);

			}

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
					.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext
					.getEnvelope();

			java.lang.Object object = fromOM(
					_returnEnv.getBody().getFirstElement(),
					com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse.class,
					getEnvelopeNamespaces(_returnEnv));

			return (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse) object;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap
						.containsKey(new org.apache.axis2.client.FaultMapKey(
								faultElt.getQName(),
								"executeCommandByParamList"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamList"));
						java.lang.Class exceptionClass = java.lang.Class
								.forName(exceptionClassName);
						java.lang.reflect.Constructor constructor = exceptionClass
								.getConstructor(String.class);
						java.lang.Exception ex = (java.lang.Exception) constructor
								.newInstance(f.getMessage());
						// message class
						java.lang.String messageClassName = (java.lang.String) faultMessageMap
								.get(new org.apache.axis2.client.FaultMapKey(
										faultElt.getQName(),
										"executeCommandByParamList"));
						java.lang.Class messageClass = java.lang.Class
								.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt,
								messageClass, null);
						java.lang.reflect.Method m = exceptionClass.getMethod(
								"setFaultMessage",
								new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
							throw (com.bladelogic._2009._11._30.BlRemoteException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
							throw (com.bladelogic._2009._11._30.CommandNotFoundException) ex;
						}

						if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
							throw (com.bladelogic._2009._11._30.CommandLoadException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender()
						.cleanup(_messageContext);
			}
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see com.bladelogic._2009._11._30.CLITunnelService#startexecuteCommandByParamList
	 * @param executeCommandByParamList34
	 * 
	 * @param sessionId35
	 * 
	 * @param transactionId36
	 */
	public void startexecuteCommandByParamList(

			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList executeCommandByParamList34,
			com.bladelogic.webservices.framework.xsd.SessionId sessionId35,
			com.bladelogic.webservices.framework.xsd.TransactionId transactionId36,

			final com.bladelogic._2009._11._30.CLITunnelServiceCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient = _serviceClient
				.createClient(_operations[3].getName());
		_operationClient.getOptions().setAction(
				"bladelogicNamespace:executeCommandByParamList");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(
				_operationClient,
				org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
				"&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.

		env = toEnvelope(getFactory(_operationClient.getOptions()
				.getSoapVersionURI()), executeCommandByParamList34,
				optimizeContent(new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamList")),
				new javax.xml.namespace.QName(
						"http://bladelogic.com/2009/11/30",
						"executeCommandByParamList"));

		// add the soap_headers only if they are not null
		if (sessionId35 != null) {

			org.apache.axiom.om.OMElement omElementsessionId35 = toOM(
					sessionId35, optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamList")));
			addHeader(omElementsessionId35, env);

		}

		// add the soap_headers only if they are not null
		if (transactionId36 != null) {

			org.apache.axiom.om.OMElement omElementtransactionId36 = toOM(
					transactionId36,
					optimizeContent(new javax.xml.namespace.QName(
							"http://bladelogic.com/2009/11/30",
							"executeCommandByParamList")));
			addHeader(omElementtransactionId36, env);

		}

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient
				.setCallback(new org.apache.axis2.client.async.AxisCallback() {
					public void onMessage(
							org.apache.axis2.context.MessageContext resultContext) {
						try {
							org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext
									.getEnvelope();

							java.lang.Object object = fromOM(
									resultEnv.getBody().getFirstElement(),
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse.class,
									getEnvelopeNamespaces(resultEnv));
							callback.receiveResultexecuteCommandByParamList((com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse) object);

						} catch (org.apache.axis2.AxisFault e) {
							callback.receiveErrorexecuteCommandByParamList(e);
						}
					}

					public void onError(java.lang.Exception error) {
						if (error instanceof org.apache.axis2.AxisFault) {
							org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
							org.apache.axiom.om.OMElement faultElt = f
									.getDetail();
							if (faultElt != null) {
								if (faultExceptionNameMap
										.containsKey(new org.apache.axis2.client.FaultMapKey(
												faultElt.getQName(),
												"executeCommandByParamList"))) {
									// make the fault by reflection
									try {
										java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamList"));
										java.lang.Class exceptionClass = java.lang.Class
												.forName(exceptionClassName);
										java.lang.reflect.Constructor constructor = exceptionClass
												.getConstructor(String.class);
										java.lang.Exception ex = (java.lang.Exception) constructor
												.newInstance(f.getMessage());
										// message class
										java.lang.String messageClassName = (java.lang.String) faultMessageMap
												.get(new org.apache.axis2.client.FaultMapKey(
														faultElt.getQName(),
														"executeCommandByParamList"));
										java.lang.Class messageClass = java.lang.Class
												.forName(messageClassName);
										java.lang.Object messageObject = fromOM(
												faultElt, messageClass, null);
										java.lang.reflect.Method m = exceptionClass
												.getMethod(
														"setFaultMessage",
														new java.lang.Class[] { messageClass });
										m.invoke(
												ex,
												new java.lang.Object[] { messageObject });

										if (ex instanceof com.bladelogic._2009._11._30.BlRemoteException) {
											callback.receiveErrorexecuteCommandByParamList((com.bladelogic._2009._11._30.BlRemoteException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandNotFoundException) {
											callback.receiveErrorexecuteCommandByParamList((com.bladelogic._2009._11._30.CommandNotFoundException) ex);
											return;
										}

										if (ex instanceof com.bladelogic._2009._11._30.CommandLoadException) {
											callback.receiveErrorexecuteCommandByParamList((com.bladelogic._2009._11._30.CommandLoadException) ex);
											return;
										}

										callback.receiveErrorexecuteCommandByParamList(new java.rmi.RemoteException(
												ex.getMessage(), ex));
									} catch (java.lang.ClassCastException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (java.lang.ClassNotFoundException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (java.lang.NoSuchMethodException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (java.lang.reflect.InvocationTargetException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (java.lang.IllegalAccessException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (java.lang.InstantiationException e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									} catch (org.apache.axis2.AxisFault e) {
										// we cannot intantiate the class -
										// throw the original Axis fault
										callback.receiveErrorexecuteCommandByParamList(f);
									}
								} else {
									callback.receiveErrorexecuteCommandByParamList(f);
								}
							} else {
								callback.receiveErrorexecuteCommandByParamList(f);
							}
						} else {
							callback.receiveErrorexecuteCommandByParamList(error);
						}
					}

					public void onFault(
							org.apache.axis2.context.MessageContext faultContext) {
						org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
								.getInboundFaultFromMessageContext(faultContext);
						onError(fault);
					}

					public void onComplete() {
						try {
							_messageContext.getTransportOut().getSender()
									.cleanup(_messageContext);
						} catch (org.apache.axis2.AxisFault axisFault) {
							callback.receiveErrorexecuteCommandByParamList(axisFault);
						}
					}
				});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[3].getMessageReceiver() == null
				&& _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[3].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(
			org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
					.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// https://localhost:9843/services/CLITunnelService
	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.framework.xsd.SessionId param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.framework.xsd.SessionId.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.framework.xsd.TransactionId param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.framework.xsd.TransactionId.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {

		try {

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();
			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList.MY_QNAME,
									factory));
			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamString.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamStringResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.SessionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.SessionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.TransactionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.TransactionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachment.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListAndAttachmentResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.SessionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.SessionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.TransactionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.TransactionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachments.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandUsingAttachmentsResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.SessionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.SessionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.TransactionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.TransactionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamList.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.ExecuteCommandByParamListResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.BlRemoteException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandNotFoundException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.class
					.equals(type)) {

				return com.bladelogic.webservices.skeleton.clitunnel.CommandLoadException.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.SessionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.SessionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (com.bladelogic.webservices.framework.xsd.TransactionId.class
					.equals(type)) {

				return com.bladelogic.webservices.framework.xsd.TransactionId.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
