/**
 * ClientPayLoad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.bladelogic.webservices.model.clitunnel.xsd;

/**
 * ClientPayLoad bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ClientPayLoad implements org.apache.axis2.databinding.ADBBean {
	/*
	 * This type was generated from the piece of schema that had name =
	 * ClientPayLoad Namespace URI =
	 * http://bladelogic.com/webservices/model/clitunnel/xsd Namespace Prefix =
	 * ns7
	 */

	/**
	 * field for ArgumentNameArray This was an Array!
	 */

	protected java.lang.String[] localArgumentNameArray;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localArgumentNameArrayTracker = false;

	public boolean isArgumentNameArraySpecified() {
		return localArgumentNameArrayTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getArgumentNameArray() {
		return localArgumentNameArray;
	}

	/**
	 * validate the array for ArgumentNameArray
	 */
	protected void validateArgumentNameArray(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ArgumentNameArray
	 */
	public void setArgumentNameArray(java.lang.String[] param) {

		validateArgumentNameArray(param);

		localArgumentNameArrayTracker = true;

		this.localArgumentNameArray = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addArgumentNameArray(java.lang.String param) {
		if (localArgumentNameArray == null) {
			localArgumentNameArray = new java.lang.String[] {};
		}

		// update the setting tracker
		localArgumentNameArrayTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localArgumentNameArray);
		list.add(param);
		this.localArgumentNameArray = (java.lang.String[]) list
				.toArray(new java.lang.String[list.size()]);

	}

	/**
	 * field for DataHandlerArray This was an Array!
	 */

	protected javax.activation.DataHandler[] localDataHandlerArray;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localDataHandlerArrayTracker = false;

	public boolean isDataHandlerArraySpecified() {
		return localDataHandlerArrayTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return javax.activation.DataHandler[]
	 */
	public javax.activation.DataHandler[] getDataHandlerArray() {
		return localDataHandlerArray;
	}

	/**
	 * validate the array for DataHandlerArray
	 */
	protected void validateDataHandlerArray(javax.activation.DataHandler[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            DataHandlerArray
	 */
	public void setDataHandlerArray(javax.activation.DataHandler[] param) {

		validateDataHandlerArray(param);

		localDataHandlerArrayTracker = true;

		this.localDataHandlerArray = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            javax.activation.DataHandler
	 */
	public void addDataHandlerArray(javax.activation.DataHandler param) {
		if (localDataHandlerArray == null) {
			localDataHandlerArray = new javax.activation.DataHandler[] {};
		}

		// update the setting tracker
		localDataHandlerArrayTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localDataHandlerArray);
		list.add(param);
		this.localDataHandlerArray = (javax.activation.DataHandler[]) list
				.toArray(new javax.activation.DataHandler[list.size()]);

	}

	/**
	 * field for FileNameArray This was an Array!
	 */

	protected java.lang.String[] localFileNameArray;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localFileNameArrayTracker = false;

	public boolean isFileNameArraySpecified() {
		return localFileNameArrayTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String[]
	 */
	public java.lang.String[] getFileNameArray() {
		return localFileNameArray;
	}

	/**
	 * validate the array for FileNameArray
	 */
	protected void validateFileNameArray(java.lang.String[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            FileNameArray
	 */
	public void setFileNameArray(java.lang.String[] param) {

		validateFileNameArray(param);

		localFileNameArrayTracker = true;

		this.localFileNameArray = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.String
	 */
	public void addFileNameArray(java.lang.String param) {
		if (localFileNameArray == null) {
			localFileNameArray = new java.lang.String[] {};
		}

		// update the setting tracker
		localFileNameArrayTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localFileNameArray);
		list.add(param);
		this.localFileNameArray = (java.lang.String[]) list
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
					"http://bladelogic.com/webservices/model/clitunnel/xsd");
			if ((namespacePrefix != null)
					&& (namespacePrefix.trim().length() > 0)) {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						namespacePrefix + ":ClientPayLoad", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"ClientPayLoad", xmlWriter);
			}

		}
		if (localArgumentNameArrayTracker) {
			if (localArgumentNameArray != null) {
				namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
				for (int i = 0; i < localArgumentNameArray.length; i++) {

					if (localArgumentNameArray[i] != null) {

						writeStartElement(null, namespace, "argumentNameArray",
								xmlWriter);

						xmlWriter
								.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localArgumentNameArray[i]));

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
						writeStartElement(null, namespace, "argumentNameArray",
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
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"argumentNameArray", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localDataHandlerArrayTracker) {
			if (localDataHandlerArray != null) {
				namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
				for (int i = 0; i < localDataHandlerArray.length; i++) {

					if (localDataHandlerArray[i] != null) {

						writeStartElement(null, namespace, "dataHandlerArray",
								xmlWriter);

						try {
							org.apache.axiom.util.stax.XMLStreamWriterUtils
									.writeDataHandler(xmlWriter,
											localDataHandlerArray[i], null,
											true);
						} catch (java.io.IOException ex) {
							throw new javax.xml.stream.XMLStreamException(
									"Unable to read data handler for dataHandlerArray["
											+ i + "]", ex);
						}

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
						writeStartElement(null, namespace, "dataHandlerArray",
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
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"dataHandlerArray", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localFileNameArrayTracker) {
			if (localFileNameArray != null) {
				namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
				for (int i = 0; i < localFileNameArray.length; i++) {

					if (localFileNameArray[i] != null) {

						writeStartElement(null, namespace, "fileNameArray",
								xmlWriter);

						xmlWriter
								.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localFileNameArray[i]));

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
						writeStartElement(null, namespace, "fileNameArray",
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
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"fileNameArray", xmlWriter);

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
		if (namespace
				.equals("http://bladelogic.com/webservices/model/clitunnel/xsd")) {
			return "ns7";
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

		if (localArgumentNameArrayTracker) {
			if (localArgumentNameArray != null) {
				for (int i = 0; i < localArgumentNameArray.length; i++) {

					if (localArgumentNameArray[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"argumentNameArray"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localArgumentNameArray[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"argumentNameArray"));
						elementList.add(null);

					}

				}
			} else {

				elementList
						.add(new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"argumentNameArray"));
				elementList.add(null);

			}

		}
		if (localDataHandlerArrayTracker) {
			if (localDataHandlerArray != null) {
				for (int i = 0; i < localDataHandlerArray.length; i++) {

					if (localDataHandlerArray[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"dataHandlerArray"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localDataHandlerArray[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"dataHandlerArray"));
						elementList.add(null);

					}

				}
			} else {

				elementList
						.add(new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"dataHandlerArray"));
				elementList.add(null);

			}

		}
		if (localFileNameArrayTracker) {
			if (localFileNameArray != null) {
				for (int i = 0; i < localFileNameArray.length; i++) {

					if (localFileNameArray[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"fileNameArray"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localFileNameArray[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"fileNameArray"));
						elementList.add(null);

					}

				}
			} else {

				elementList
						.add(new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"fileNameArray"));
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
		public static ClientPayLoad parse(
				javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			ClientPayLoad object = new ClientPayLoad();

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

						if (!"ClientPayLoad".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (ClientPayLoad) com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper
									.getTypeObject(nsUri, type, reader);
						}

					}

				}

				// Note all attributes that were handled. Used to differ normal
				// attributes
				// from anyAttributes.
				java.util.Vector handledAttributes = new java.util.Vector();

				reader.next();

				java.util.ArrayList list1 = new java.util.ArrayList();

				java.util.ArrayList list2 = new java.util.ArrayList();

				java.util.ArrayList list3 = new java.util.ArrayList();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"argumentNameArray").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list1.add(null);

						reader.next();
					} else {
						list1.add(reader.getElementText());
					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone1 = false;
					while (!loopDone1) {
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
							loopDone1 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/model/clitunnel/xsd",
									"argumentNameArray").equals(reader
									.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list1.add(null);

									reader.next();
								} else {
									list1.add(reader.getElementText());
								}
							} else {
								loopDone1 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setArgumentNameArray((java.lang.String[]) list1
							.toArray(new java.lang.String[list1.size()]));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"dataHandlerArray").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list2.add(null);
						reader.next();
					} else {
						list2.add(org.apache.axiom.util.stax.XMLStreamReaderUtils
								.getDataHandlerFromElement(reader));

					}
					// loop until we find a start element that is not part of
					// this array
					boolean loopDone2 = false;
					while (!loopDone2) {
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
							loopDone2 = true;
						} else {
							if (new javax.xml.namespace.QName(
									"http://bladelogic.com/webservices/model/clitunnel/xsd",
									"dataHandlerArray")
									.equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list2.add(null);
									reader.next();
								} else {
									list2.add(org.apache.axiom.util.stax.XMLStreamReaderUtils
											.getDataHandlerFromElement(reader));

								}
							} else {
								loopDone2 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setDataHandlerArray((javax.activation.DataHandler[]) org.apache.axis2.databinding.utils.ConverterUtil
							.convertToArray(javax.activation.DataHandler.class,
									list2));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"fileNameArray").equals(reader.getName())) {

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
									"http://bladelogic.com/webservices/model/clitunnel/xsd",
									"fileNameArray").equals(reader.getName())) {

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

					object.setFileNameArray((java.lang.String[]) list3
							.toArray(new java.lang.String[list3.size()]));

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
