/**
 * ExecuteCommandUsingAttachments.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.bladelogic.webservices.skeleton.clitunnel;

/**
 * ExecuteCommandUsingAttachments bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ExecuteCommandUsingAttachments implements
		org.apache.axis2.databinding.ADBBean {

	public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
			"http://bladelogic.com/webservices/skeleton/clitunnel",
			"executeCommandUsingAttachments", "ns8");

	/**
	 * field for NameSpace
	 */

	protected java.lang.String localNameSpace;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localNameSpaceTracker = false;

	public boolean isNameSpaceSpecified() {
		return localNameSpaceTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNameSpace() {
		return localNameSpace;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            NameSpace
	 */
	public void setNameSpace(java.lang.String param) {
		localNameSpaceTracker = true;

		this.localNameSpace = param;

	}

	/**
	 * field for CommandName
	 */

	protected java.lang.String localCommandName;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localCommandNameTracker = false;

	public boolean isCommandNameSpecified() {
		return localCommandNameTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCommandName() {
		return localCommandName;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            CommandName
	 */
	public void setCommandName(java.lang.String param) {
		localCommandNameTracker = true;

		this.localCommandName = param;

	}

	/**
	 * field for CommandArguments This was an Array!
	 */

	protected java.lang.String[] localCommandArguments;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localCommandArgumentsTracker = false;

	public boolean isCommandArgumentsSpecified() {
		return localCommandArgumentsTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getCommandArguments() {
		return localCommandArguments;
	}

	/**
	 * validate the array for CommandArguments
	 */
	protected void validateCommandArguments(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            CommandArguments
	 */
	public void setCommandArguments(java.lang.String[] param) {

		validateCommandArguments(param);

		localCommandArgumentsTracker = true;

		this.localCommandArguments = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addCommandArguments(java.lang.String param) {
		if (localCommandArguments == null) {
			localCommandArguments = new java.lang.String[] {};
		}

		// update the setting tracker
		localCommandArgumentsTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localCommandArguments);
		list.add(param);
		this.localCommandArguments = (java.lang.String[]) list
				.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for Payload
	 */

	protected com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad localPayload;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localPayloadTracker = false;

	public boolean isPayloadSpecified() {
		return localPayloadTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad
	 */
	public com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad getPayload() {
		return localPayload;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Payload
	 */
	public void setPayload(
			com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad param) {
		localPayloadTracker = true;

		this.localPayload = param;

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
				this, MY_QNAME);
		return factory.createOMElement(dataSource, MY_QNAME);

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
					"http://bladelogic.com/webservices/skeleton/clitunnel");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":executeCommandUsingAttachments",
						xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"executeCommandUsingAttachments", xmlWriter);
			}

		}
		if (localNameSpaceTracker) {
			namespace = "http://bladelogic.com/webservices/skeleton/clitunnel";
			writeStartElement(null, namespace, "nameSpace", xmlWriter);

			if (localNameSpace == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localNameSpace);

			}

			xmlWriter.writeEndElement();
		}
		if (localCommandNameTracker) {
			namespace = "http://bladelogic.com/webservices/skeleton/clitunnel";
			writeStartElement(null, namespace, "commandName", xmlWriter);

			if (localCommandName == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localCommandName);

			}

			xmlWriter.writeEndElement();
		}
		if (localCommandArgumentsTracker) {
			if (localCommandArguments != null) {
				namespace = "http://bladelogic.com/webservices/skeleton/clitunnel";
				for (int i = 0; i < localCommandArguments.length; i++) {

					if (localCommandArguments[i] != null) {

						writeStartElement(null, namespace, "commandArguments",
								xmlWriter);

						xmlWriter
								.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localCommandArguments[i]));

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/skeleton/clitunnel";
						writeStartElement(null, namespace, "commandArguments",
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
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"commandArguments", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localPayloadTracker) {
			if (localPayload == null) {

				writeStartElement(null,
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"payload", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();
			} else {
				localPayload.serialize(new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"payload"), xmlWriter);
			}
		}
		xmlWriter.writeEndElement();

	}

	private static java.lang.String generatePrefix(java.lang.String namespace) {
		if (namespace
				.equals("http://bladelogic.com/webservices/skeleton/clitunnel")) {
			return "ns8";
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

		if (localNameSpaceTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/skeleton/clitunnel",
					"nameSpace"));

			elementList.add(localNameSpace == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localNameSpace));
		}
		if (localCommandNameTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/skeleton/clitunnel",
					"commandName"));

			elementList.add(localCommandName == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localCommandName));
		}
		if (localCommandArgumentsTracker) {
			if (localCommandArguments != null) {
				for (int i = 0; i < localCommandArguments.length; i++) {

					if (localCommandArguments[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/skeleton/clitunnel",
										"commandArguments"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localCommandArguments[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/skeleton/clitunnel",
										"commandArguments"));
						elementList.add(null);

					}

				}
			} else {

				elementList.add(new javax.xml.namespace.QName(
						"http://bladelogic.com/webservices/skeleton/clitunnel",
						"commandArguments"));
				elementList.add(null);

			}

		}
		if (localPayloadTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/skeleton/clitunnel",
					"payload"));

			elementList.add(localPayload == null ? null : localPayload);
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
		public static ExecuteCommandUsingAttachments parse(
				javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			ExecuteCommandUsingAttachments object = new ExecuteCommandUsingAttachments();

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

						if (!"executeCommandUsingAttachments".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (ExecuteCommandUsingAttachments) com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper
									.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList list3 = new java.util.ArrayList();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"nameSpace").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setNameSpace(org.apache.axis2.databinding.utils.ConverterUtil
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
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"commandName").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setCommandName(org.apache.axis2.databinding.utils.ConverterUtil
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
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"commandArguments").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list3.add(null);

						reader.next();
					} else {
						list3.add(reader.getElementText());
					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone3 = false;
					while (!loopDone3) {
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
							loopDone3 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/skeleton/clitunnel",
									"commandArguments")
									.equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list3.add(null);

									reader.next();
								} else {
									list3.add(reader.getElementText());
								}
							} else {
								loopDone3 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setCommandArguments((java.lang.String[]) list3
							.toArray(new java.lang.String[list3.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/skeleton/clitunnel",
								"payload").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						object.setPayload(null);
						reader.next();

						reader.next();

					} else {

						object.setPayload(com.bladelogic.webservices.model.clitunnel.xsd.ClientPayLoad.Factory
								.parse(reader));

						reader.next();
					}
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
