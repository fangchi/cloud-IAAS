/**
 * WS_SSOSessionCredential.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.bladelogic.webservices.framework.xsd;

/**
 * WS_SSOSessionCredential bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class WS_SSOSessionCredential implements
		org.apache.axis2.databinding.ADBBean {
	/*
	 * This type was generated from the piece of schema that had name =
	 * WS_SSOSessionCredential Namespace URI =
	 * http://bladelogic.com/webservices/framework/xsd Namespace Prefix = ns1
	 */

	/**
	 * field for AuthType
	 */

	protected java.lang.String localAuthType;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localAuthTypeTracker = false;

	public boolean isAuthTypeSpecified() {
		return localAuthTypeTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getAuthType() {
		return localAuthType;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            AuthType
	 */
	public void setAuthType(java.lang.String param) {
		localAuthTypeTracker = true;

		this.localAuthType = param;

	}

	/**
	 * field for AuthorizedRoles This was an Array!
	 */

	protected com.bladelogic.webservices.framework.xsd.WSRoleId[] localAuthorizedRoles;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localAuthorizedRolesTracker = false;

	public boolean isAuthorizedRolesSpecified() {
		return localAuthorizedRolesTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return com.bladelogic.webservices.framework.xsd.WSRoleId[]
	 */
	public com.bladelogic.webservices.framework.xsd.WSRoleId[] getAuthorizedRoles() {
		return localAuthorizedRoles;
	}

	/**
	 * validate the array for AuthorizedRoles
	 */
	protected void validateAuthorizedRoles(
			com.bladelogic.webservices.framework.xsd.WSRoleId[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            AuthorizedRoles
	 */
	public void setAuthorizedRoles(
			com.bladelogic.webservices.framework.xsd.WSRoleId[] param) {

		validateAuthorizedRoles(param);

		localAuthorizedRolesTracker = true;

		this.localAuthorizedRoles = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            com.bladelogic.webservices.framework.xsd.WSRoleId
	 */
	public void addAuthorizedRoles(
			com.bladelogic.webservices.framework.xsd.WSRoleId param) {
		if (localAuthorizedRoles == null) {
			localAuthorizedRoles = new com.bladelogic.webservices.framework.xsd.WSRoleId[] {};
		}

		// update the setting tracker
		localAuthorizedRolesTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localAuthorizedRoles);
		list.add(param);
		this.localAuthorizedRoles = (com.bladelogic.webservices.framework.xsd.WSRoleId[]) list
				.toArray(new com.bladelogic.webservices.framework.xsd.WSRoleId[list
						.size()]);

	}

	/**
	 * field for ClientAddress
	 */

	protected java.lang.String localClientAddress;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localClientAddressTracker = false;

	public boolean isClientAddressSpecified() {
		return localClientAddressTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getClientAddress() {
		return localClientAddress;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ClientAddress
	 */
	public void setClientAddress(java.lang.String param) {
		localClientAddressTracker = true;

		this.localClientAddress = param;

	}

	/**
	 * field for ExpirationTime
	 */

	protected java.util.Calendar localExpirationTime;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localExpirationTimeTracker = false;

	public boolean isExpirationTimeSpecified() {
		return localExpirationTimeTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.util.Calendar
	 */
	public java.util.Calendar getExpirationTime() {
		return localExpirationTime;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ExpirationTime
	 */
	public void setExpirationTime(java.util.Calendar param) {
		localExpirationTimeTracker = true;

		this.localExpirationTime = param;

	}

	/**
	 * field for MaximumLifeTime
	 */

	protected java.util.Calendar localMaximumLifeTime;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localMaximumLifeTimeTracker = false;

	public boolean isMaximumLifeTimeSpecified() {
		return localMaximumLifeTimeTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.util.Calendar
	 */
	public java.util.Calendar getMaximumLifeTime() {
		return localMaximumLifeTime;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            MaximumLifeTime
	 */
	public void setMaximumLifeTime(java.util.Calendar param) {
		localMaximumLifeTimeTracker = true;

		this.localMaximumLifeTime = param;

	}

	/**
	 * field for RolePreference
	 */

	protected java.lang.String localRolePreference;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localRolePreferenceTracker = false;

	public boolean isRolePreferenceSpecified() {
		return localRolePreferenceTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getRolePreference() {
		return localRolePreference;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            RolePreference
	 */
	public void setRolePreference(java.lang.String param) {
		localRolePreferenceTracker = true;

		this.localRolePreference = param;

	}

	/**
	 * field for ServiceTicketString
	 */

	protected java.lang.String localServiceTicketString;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localServiceTicketStringTracker = false;

	public boolean isServiceTicketStringSpecified() {
		return localServiceTicketStringTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getServiceTicketString() {
		return localServiceTicketString;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ServiceTicketString
	 */
	public void setServiceTicketString(java.lang.String param) {
		localServiceTicketStringTracker = true;

		this.localServiceTicketString = param;

	}

	/**
	 * field for ServiceUrl
	 */

	protected java.lang.String localServiceUrl;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localServiceUrlTracker = false;

	public boolean isServiceUrlSpecified() {
		return localServiceUrlTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getServiceUrl() {
		return localServiceUrl;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ServiceUrl
	 */
	public void setServiceUrl(java.lang.String param) {
		localServiceUrlTracker = true;

		this.localServiceUrl = param;

	}

	/**
	 * field for ServiceUrls This was an Array!
	 */

	protected java.lang.String[] localServiceUrls;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localServiceUrlsTracker = false;

	public boolean isServiceUrlsSpecified() {
		return localServiceUrlsTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getServiceUrls() {
		return localServiceUrls;
	}

	/**
	 * validate the array for ServiceUrls
	 */
	protected void validateServiceUrls(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ServiceUrls
	 */
	public void setServiceUrls(java.lang.String[] param) {

		validateServiceUrls(param);

		localServiceUrlsTracker = true;

		this.localServiceUrls = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addServiceUrls(java.lang.String param) {
		if (localServiceUrls == null) {
			localServiceUrls = new java.lang.String[] {};
		}

		// update the setting tracker
		localServiceUrlsTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localServiceUrls);
		list.add(param);
		this.localServiceUrls = (java.lang.String[]) list
				.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for Site
	 */

	protected java.lang.String localSite;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localSiteTracker = false;

	public boolean isSiteSpecified() {
		return localSiteTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getSite() {
		return localSite;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Site
	 */
	public void setSite(java.lang.String param) {
		localSiteTracker = true;

		this.localSite = param;

	}

	/**
	 * field for UpdateSRPPasswordOnly
	 */

	protected boolean localUpdateSRPPasswordOnly;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localUpdateSRPPasswordOnlyTracker = false;

	public boolean isUpdateSRPPasswordOnlySpecified() {
		return localUpdateSRPPasswordOnlyTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return boolean
	 */
	public boolean getUpdateSRPPasswordOnly() {
		return localUpdateSRPPasswordOnly;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            UpdateSRPPasswordOnly
	 */
	public void setUpdateSRPPasswordOnly(boolean param) {

		// setting primitive attribute tracker to true
		localUpdateSRPPasswordOnlyTracker = true;

		this.localUpdateSRPPasswordOnly = param;

	}

	/**
	 * field for UserName
	 */

	protected java.lang.String localUserName;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localUserNameTracker = false;

	public boolean isUserNameSpecified() {
		return localUserNameTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getUserName() {
		return localUserName;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            UserName
	 */
	public void setUserName(java.lang.String param) {
		localUserNameTracker = true;

		this.localUserName = param;

	}

	/**
	 * field for WebServicesUrls This was an Array!
	 */

	protected java.lang.String[] localWebServicesUrls;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localWebServicesUrlsTracker = false;

	public boolean isWebServicesUrlsSpecified() {
		return localWebServicesUrlsTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getWebServicesUrls() {
		return localWebServicesUrls;
	}

	/**
	 * validate the array for WebServicesUrls
	 */
	protected void validateWebServicesUrls(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            WebServicesUrls
	 */
	public void setWebServicesUrls(java.lang.String[] param) {

		validateWebServicesUrls(param);

		localWebServicesUrlsTracker = true;

		this.localWebServicesUrls = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addWebServicesUrls(java.lang.String param) {
		if (localWebServicesUrls == null) {
			localWebServicesUrls = new java.lang.String[] {};
		}

		// update the setting tracker
		localWebServicesUrlsTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localWebServicesUrls);
		list.add(param);
		this.localWebServicesUrls = (java.lang.String[]) list
				.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * 
	 * @param parentQName
	 * @param factory
	 * @return org.apache.axiom.om.OMElement
	 */
	public org.apache.axiom.om.OMElement getOMElement(
			final javax.xml.namespace.QName parentQName,
			final org.apache.axiom.om.OMFactory factory)
			throws org.apache.axis2.databinding.ADBException {

		org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(
				this, parentQName);
		return factory.createOMElement(dataSource, parentQName);

	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {
		serialize(parentQName, xmlWriter, false);
	}

	public void serialize(final javax.xml.namespace.QName parentQName,
			javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
			throws javax.xml.stream.XMLStreamException,
			org.apache.axis2.databinding.ADBException {

		java.lang.String prefix = null;
		java.lang.String namespace = null;

		prefix = parentQName.getPrefix();
		namespace = parentQName.getNamespaceURI();
		writeStartElement(prefix, namespace, parentQName.getLocalPart(),
				xmlWriter);

		if (serializeType) {

			java.lang.String namespacePrefix = registerPrefix(xmlWriter,
					"http://bladelogic.com/webservices/framework/xsd");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":WS_SSOSessionCredential", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"WS_SSOSessionCredential", xmlWriter);
			}

		}
		if (localAuthTypeTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "authType", xmlWriter);

			if (localAuthType == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localAuthType);

			}

			xmlWriter.writeEndElement();
		}
		if (localAuthorizedRolesTracker) {
			if (localAuthorizedRoles != null) {
				for (int i = 0; i < localAuthorizedRoles.length; i++) {
					if (localAuthorizedRoles[i] != null) {
						localAuthorizedRoles[i]
								.serialize(
										new javax.xml.namespace.QName(
												"http://bladelogic.com/webservices/framework/xsd",
												"authorizedRoles"), xmlWriter);
					} else {

						writeStartElement(
								null,
								"http://bladelogic.com/webservices/framework/xsd",
								"authorizedRoles", xmlWriter);

						// write the nil attribute
						writeAttribute("xsi",
								"http://www.w3.org/2001/XMLSchema-instance",
								"nil", "1", xmlWriter);
						xmlWriter.writeEndElement();

					}

				}
			} else {

				writeStartElement(null,
						"http://bladelogic.com/webservices/framework/xsd",
						"authorizedRoles", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}
		}
		if (localClientAddressTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "clientAddress", xmlWriter);

			if (localClientAddress == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localClientAddress);

			}

			xmlWriter.writeEndElement();
		}
		if (localExpirationTimeTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "expirationTime", xmlWriter);

			if (localExpirationTime == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localExpirationTime));

			}

			xmlWriter.writeEndElement();
		}
		if (localMaximumLifeTimeTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "maximumLifeTime", xmlWriter);

			if (localMaximumLifeTime == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localMaximumLifeTime));

			}

			xmlWriter.writeEndElement();
		}
		if (localRolePreferenceTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "rolePreference", xmlWriter);

			if (localRolePreference == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localRolePreference);

			}

			xmlWriter.writeEndElement();
		}
		if (localServiceTicketStringTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "serviceTicketString", xmlWriter);

			if (localServiceTicketString == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localServiceTicketString);

			}

			xmlWriter.writeEndElement();
		}
		if (localServiceUrlTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "serviceUrl", xmlWriter);

			if (localServiceUrl == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localServiceUrl);

			}

			xmlWriter.writeEndElement();
		}
		if (localServiceUrlsTracker) {
			if (localServiceUrls != null) {
				namespace = "http://bladelogic.com/webservices/framework/xsd";
				for (int i = 0; i < localServiceUrls.length; i++) {

					if (localServiceUrls[i] != null) {

						writeStartElement(null, namespace, "serviceUrls",
								xmlWriter);

						xmlWriter
								.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localServiceUrls[i]));

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/framework/xsd";
						writeStartElement(null, namespace, "serviceUrls",
								xmlWriter);
						writeAttribute("xsi",
								"http://www.w3.org/2001/XMLSchema-instance",
								"nil", "1", xmlWriter);
						xmlWriter.writeEndElement();

					}

				}
			} else {

				// write the null attribute
				// write null attribute
				writeStartElement(null,
						"http://bladelogic.com/webservices/framework/xsd",
						"serviceUrls", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localSiteTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "site", xmlWriter);

			if (localSite == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localSite);

			}

			xmlWriter.writeEndElement();
		}
		if (localUpdateSRPPasswordOnlyTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "updateSRPPasswordOnly",
					xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException(
						"updateSRPPasswordOnly cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localUpdateSRPPasswordOnly));
			}

			xmlWriter.writeEndElement();
		}
		if (localUserNameTracker) {
			namespace = "http://bladelogic.com/webservices/framework/xsd";
			writeStartElement(null, namespace, "userName", xmlWriter);

			if (localUserName == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localUserName);

			}

			xmlWriter.writeEndElement();
		}
		if (localWebServicesUrlsTracker) {
			if (localWebServicesUrls != null) {
				namespace = "http://bladelogic.com/webservices/framework/xsd";
				for (int i = 0; i < localWebServicesUrls.length; i++) {

					if (localWebServicesUrls[i] != null) {

						writeStartElement(null, namespace, "webServicesUrls",
								xmlWriter);

						xmlWriter
								.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localWebServicesUrls[i]));

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/framework/xsd";
						writeStartElement(null, namespace, "webServicesUrls",
								xmlWriter);
						writeAttribute("xsi",
								"http://www.w3.org/2001/XMLSchema-instance",
								"nil", "1", xmlWriter);
						xmlWriter.writeEndElement();

					}

				}
			} else {

				// write the null attribute
				// write null attribute
				writeStartElement(null,
						"http://bladelogic.com/webservices/framework/xsd",
						"webServicesUrls", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		xmlWriter.writeEndElement();

	}

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace.equals("http://bladelogic.com/webservices/framework/xsd")) {
			return "ns1";
		}
		return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	}

	/**
	 * Utility method to write an element start tag.
	 */
	private void writeStartElement(java.lang.String prefix,
			java.lang.String namespace, java.lang.String localPart,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
		if (writerPrefix != null) {
			xmlWriter.writeStartElement(namespace, localPart);
		} else {
			if (namespace.length() == 0) {
				prefix = "";
			} else if (prefix == null) {
				prefix = generatePrefix(namespace);
			}

			xmlWriter.writeStartElement(prefix, localPart, namespace);
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
	}

	/**
	 * Util method to write an attribute with the ns prefix
	 */
	private void writeAttribute(java.lang.String prefix,
			java.lang.String namespace, java.lang.String attName,
			java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (xmlWriter.getPrefix(namespace) == null) {
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		xmlWriter.writeAttribute(namespace, attName, attValue);
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeAttribute(java.lang.String namespace,
			java.lang.String attName, java.lang.String attValue,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}
	}

	/**
	 * Util method to write an attribute without the ns prefix
	 */
	private void writeQNameAttribute(java.lang.String namespace,
			java.lang.String attName, javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		java.lang.String attributeNamespace = qname.getNamespaceURI();
		java.lang.String attributePrefix = xmlWriter
				.getPrefix(attributeNamespace);
		if (attributePrefix == null) {
			attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		}
		java.lang.String attributeValue;
		if (attributePrefix.trim().length() > 0) {
			attributeValue = attributePrefix + ":" + qname.getLocalPart();
		} else {
			attributeValue = qname.getLocalPart();
		}

		if (namespace.equals("")) {
			xmlWriter.writeAttribute(attName, attributeValue);
		} else {
			registerPrefix(xmlWriter, namespace);
			xmlWriter.writeAttribute(namespace, attName, attributeValue);
		}
	}

	/**
	 * method to handle Qnames
	 */

	private void writeQName(javax.xml.namespace.QName qname,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String namespaceURI = qname.getNamespaceURI();
		if (namespaceURI != null) {
			java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			if (prefix == null) {
				prefix = generatePrefix(namespaceURI);
				xmlWriter.writeNamespace(prefix, namespaceURI);
				xmlWriter.setPrefix(prefix, namespaceURI);
			}

			if (prefix.trim().length() > 0) {
				xmlWriter.writeCharacters(prefix
						+ ":"
						+ org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			} else {
				// i.e this is the default namespace
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(qname));
			}

		} else {
			xmlWriter
					.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(qname));
		}
	}

	private void writeQNames(javax.xml.namespace.QName[] qnames,
			javax.xml.stream.XMLStreamWriter xmlWriter)
			throws javax.xml.stream.XMLStreamException {

		if (qnames != null) {
			// we have to store this data until last moment since it is not
			// possible to write any
			// namespace data after writing the charactor data
			java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			java.lang.String namespaceURI = null;
			java.lang.String prefix = null;

			for (int i = 0; i < qnames.length; i++) {
				if (i > 0) {
					stringToWrite.append(" ");
				}
				namespaceURI = qnames[i].getNamespaceURI();
				if (namespaceURI != null) {
					prefix = xmlWriter.getPrefix(namespaceURI);
					if ((prefix == null) || (prefix.length() == 0)) {
						prefix = generatePrefix(namespaceURI);
						xmlWriter.writeNamespace(prefix, namespaceURI);
						xmlWriter.setPrefix(prefix, namespaceURI);
					}

					if (prefix.trim().length() > 0) {
						stringToWrite
								.append(prefix)
								.append(":")
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					} else {
						stringToWrite
								.append(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(qnames[i]));
					}
				} else {
					stringToWrite
							.append(org.apache.axis2.databinding.utils.ConverterUtil
									.convertToString(qnames[i]));
				}
			}
			xmlWriter.writeCharacters(stringToWrite.toString());
		}

	}

	/**
	 * Register a namespace prefix
	 */
	private java.lang.String registerPrefix(
			javax.xml.stream.XMLStreamWriter xmlWriter,
			java.lang.String namespace)
			throws javax.xml.stream.XMLStreamException {
		java.lang.String prefix = xmlWriter.getPrefix(namespace);
		if (prefix == null) {
			prefix = generatePrefix(namespace);
			javax.xml.namespace.NamespaceContext nsContext = xmlWriter
					.getNamespaceContext();
			while (true) {
				java.lang.String uri = nsContext.getNamespaceURI(prefix);
				if (uri == null || uri.length() == 0) {
					break;
				}
				prefix = org.apache.axis2.databinding.utils.BeanUtil
						.getUniquePrefix();
			}
			xmlWriter.writeNamespace(prefix, namespace);
			xmlWriter.setPrefix(prefix, namespace);
		}
		return prefix;
	}

	/**
	 * databinding method to get an XML representation of this object
	 * 
	 */
	public javax.xml.stream.XMLStreamReader getPullParser(
			javax.xml.namespace.QName qName)
			throws org.apache.axis2.databinding.ADBException {

		java.util.ArrayList elementList = new java.util.ArrayList();
		java.util.ArrayList attribList = new java.util.ArrayList();

		if (localAuthTypeTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"authType"));

			elementList.add(localAuthType == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localAuthType));
		}
		if (localAuthorizedRolesTracker) {
			if (localAuthorizedRoles != null) {
				for (int i = 0; i < localAuthorizedRoles.length; i++) {

					if (localAuthorizedRoles[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"authorizedRoles"));
						elementList.add(localAuthorizedRoles[i]);
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"authorizedRoles"));
						elementList.add(null);

					}

				}
			} else {

				elementList.add(new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/framework/xsd",
						"authorizedRoles"));
				elementList.add(localAuthorizedRoles);

			}

		}
		if (localClientAddressTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"clientAddress"));

			elementList.add(localClientAddress == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localClientAddress));
		}
		if (localExpirationTimeTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"expirationTime"));

			elementList.add(localExpirationTime == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localExpirationTime));
		}
		if (localMaximumLifeTimeTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"maximumLifeTime"));

			elementList.add(localMaximumLifeTime == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localMaximumLifeTime));
		}
		if (localRolePreferenceTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"rolePreference"));

			elementList.add(localRolePreference == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localRolePreference));
		}
		if (localServiceTicketStringTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"serviceTicketString"));

			elementList.add(localServiceTicketString == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localServiceTicketString));
		}
		if (localServiceUrlTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"serviceUrl"));

			elementList.add(localServiceUrl == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localServiceUrl));
		}
		if (localServiceUrlsTracker) {
			if (localServiceUrls != null) {
				for (int i = 0; i < localServiceUrls.length; i++) {

					if (localServiceUrls[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"serviceUrls"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localServiceUrls[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"serviceUrls"));
						elementList.add(null);

					}

				}
			} else {

				elementList.add(new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/framework/xsd",
						"serviceUrls"));
				elementList.add(null);

			}

		}
		if (localSiteTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd", "site"));

			elementList.add(localSite == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localSite));
		}
		if (localUpdateSRPPasswordOnlyTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"updateSRPPasswordOnly"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localUpdateSRPPasswordOnly));
		}
		if (localUserNameTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/framework/xsd",
					"userName"));

			elementList.add(localUserName == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localUserName));
		}
		if (localWebServicesUrlsTracker) {
			if (localWebServicesUrls != null) {
				for (int i = 0; i < localWebServicesUrls.length; i++) {

					if (localWebServicesUrls[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"webServicesUrls"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localWebServicesUrls[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/framework/xsd",
										"webServicesUrls"));
						elementList.add(null);

					}

				}
			} else {

				elementList.add(new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/framework/xsd",
						"webServicesUrls"));
				elementList.add(null);

			}

		}

		return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(
				qName, elementList.toArray(), attribList.toArray());

	}

	/**
	 * Factory class that keeps the parse method
	 */
	public static class Factory {

		/**
		 * static method to create the object Precondition: If this object is an
		 * element, the current or next start element starts this object and any
		 * intervening reader events are ignorable If this object is not an
		 * element, it is a complex type and the reader is at the event just
		 * after the outer start element Postcondition: If this object is an
		 * element, the reader is positioned at its end element If this object
		 * is a complex type, the reader is positioned at the end element of its
		 * outer element
		 */
		public static WS_SSOSessionCredential parse(
				javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			WS_SSOSessionCredential object = new WS_SSOSessionCredential();

			int event;
			java.lang.String nillableValue = null;
			java.lang.String prefix = "";
			java.lang.String namespaceuri = "";
			try {

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.getAttributeValue(
						"http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
					java.lang.String fullTypeName = reader
							.getAttributeValue(
									"http://www.w3.org/2001/XMLSchema-instance",
									"type");
					if (fullTypeName != null) {
						java.lang.String nsPrefix = null;
						if (fullTypeName.indexOf(":") > -1) {
							nsPrefix = fullTypeName.substring(0,
									fullTypeName.indexOf(":"));
						}
						nsPrefix = nsPrefix == null ? "" : nsPrefix;

						java.lang.String type = fullTypeName
								.substring(fullTypeName.indexOf(":") + 1);

						if (!"WS_SSOSessionCredential".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (WS_SSOSessionCredential) com.bladelogic.webservices.skeleton.login.ExtensionMapper
									.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList list2 = new java.util.ArrayList();

				java.util.ArrayList list9 = new java.util.ArrayList();

				java.util.ArrayList list13 = new java.util.ArrayList();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"authType").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setAuthType(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"authorizedRoles").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list2.add(null);
						reader.next();
					} else {
						list2.add(com.bladelogic.webservices.framework.xsd.WSRoleId.Factory
								.parse(reader));
					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone2 = false;
					while (!loopDone2) {
						// We should be at the end element, but make sure
						while (!reader.isEndElement())
							reader.next();
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement()
								&& !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting
							// the xml structure
							loopDone2 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/framework/xsd",
									"authorizedRoles").equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list2.add(null);
									reader.next();
								} else {
									list2.add(com.bladelogic.webservices.framework.xsd.WSRoleId.Factory
											.parse(reader));
								}
							} else {
								loopDone2 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setAuthorizedRoles((com.bladelogic.webservices.framework.xsd.WSRoleId[]) org.apache.axis2.databinding.utils.ConverterUtil
							.convertToArray(
									com.bladelogic.webservices.framework.xsd.WSRoleId.class,
									list2));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"clientAddress").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setClientAddress(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"expirationTime").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setExpirationTime(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToDateTime(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"maximumLifeTime").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setMaximumLifeTime(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToDateTime(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"rolePreference").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setRolePreference(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"serviceTicketString").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setServiceTicketString(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"serviceUrl").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setServiceUrl(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"serviceUrls").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list9.add(null);

						reader.next();
					} else {
						list9.add(reader.getElementText());
					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone9 = false;
					while (!loopDone9) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement()
								&& !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting
							// the xml structure
							loopDone9 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/framework/xsd",
									"serviceUrls").equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list9.add(null);

									reader.next();
								} else {
									list9.add(reader.getElementText());
								}
							} else {
								loopDone9 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setServiceUrls((java.lang.String[]) list9
							.toArray(new java.lang.String[list9.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"site").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setSite(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"updateSRPPasswordOnly").equals(reader
								.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "updateSRPPasswordOnly"
										+ "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setUpdateSRPPasswordOnly(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToBoolean(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"userName").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setUserName(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(content));

					} else {

						reader.getElementText(); // throw away text nodes if
													// any.
					}

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/framework/xsd",
								"webServicesUrls").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list13.add(null);

						reader.next();
					} else {
						list13.add(reader.getElementText());
					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone13 = false;
					while (!loopDone13) {
						// Ensure we are at the EndElement
						while (!reader.isEndElement()) {
							reader.next();
						}
						// Step out of this element
						reader.next();
						// Step to next element event.
						while (!reader.isStartElement()
								&& !reader.isEndElement())
							reader.next();
						if (reader.isEndElement()) {
							// two continuous end elements means we are exiting
							// the xml structure
							loopDone13 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/framework/xsd",
									"webServicesUrls").equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list13.add(null);

									reader.next();
								} else {
									list13.add(reader.getElementText());
								}
							} else {
								loopDone13 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setWebServicesUrls((java.lang.String[]) list13
							.toArray(new java.lang.String[list13.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement())
					// A start element we are not expecting indicates a trailing
					// invalid property
					throw new org.apache.axis2.databinding.ADBException(
							"Unexpected subelement " + reader.getName());

			} catch (javax.xml.stream.XMLStreamException e) {
				throw new java.lang.Exception(e);
			}

			return object;
		}

	}// end of factory class

}
