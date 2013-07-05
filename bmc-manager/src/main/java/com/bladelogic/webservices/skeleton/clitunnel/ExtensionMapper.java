/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.bladelogic.webservices.skeleton.clitunnel;

/**
 * ExtensionMapper class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ExtensionMapper {

	public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
			java.lang.String typeName, javax.xml.stream.XMLStreamReader reader)
			throws java.lang.Exception {

		if ("http://bladelogic.com/webservices/app/remote/xsd"
				.equals(namespaceURI) && "BlRemoteException".equals(typeName)) {

			return com.bladelogic.webservices.app.remote.xsd.BlRemoteException.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/cli/factory/xsd"
				.equals(namespaceURI)
				&& "CommandLoadException".equals(typeName)) {

			return com.bladelogic.webservices.cli.factory.xsd.CommandLoadException.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/mfw/util/xsd"
				.equals(namespaceURI) && "BlException".equals(typeName)) {

			return com.bladelogic.webservices.mfw.util.xsd.BlException.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/model/clitunnel/xsd"
				.equals(namespaceURI) && "Result".equals(typeName)) {

			return com.bladelogic.webservices.model.clitunnel.xsd.Result.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/framework/xsd"
				.equals(namespaceURI) && "Exception".equals(typeName)) {

			return com.bladelogic.webservices.framework.xsd.Exception.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/model/clitunnel/xsd"
				.equals(namespaceURI) && "ClientPayLoad".equals(typeName)) {

			return com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/cli/factory/xsd"
				.equals(namespaceURI)
				&& "CommandNotFoundException".equals(typeName)) {

			return com.bladelogic.webservices.cli.factory.xsd.CommandNotFoundException.Factory
					.parse(reader);

		}

		if ("http://bladelogic.com/webservices/mfw/util/xsd"
				.equals(namespaceURI) && "BaseException".equals(typeName)) {

			return com.bladelogic.webservices.mfw.util.xsd.BaseException.Factory
					.parse(reader);

		}

		throw new org.apache.axis2.databinding.ADBException("Unsupported type "
				+ namespaceURI + " " + typeName);
	}

}
