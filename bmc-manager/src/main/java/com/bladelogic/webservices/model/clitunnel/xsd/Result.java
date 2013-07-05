/**
 * Result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

package com.bladelogic.webservices.model.clitunnel.xsd;

/**
 * Result bean class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class Result implements org.apache.axis2.databinding.ADBBean {
	/*
	 * This type was generated from the piece of schema that had name = Result
	 * Namespace URI = http://bladelogic.com/webservices/model/clitunnel/xsd
	 * Namespace Prefix = ns7
	 */

	/**
	 * field for Attachment This was an Array!
	 */

	protected javax.activation.DataHandler[] localAttachment;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localAttachmentTracker = false;

	public boolean isAttachmentSpecified() {
		return localAttachmentTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return javax.activation.DataHandler[]
	 */
	public javax.activation.DataHandler[] getAttachment() {
		return localAttachment;
	}

	/**
	 * validate the array for Attachment
	 */
	protected void validateAttachment(javax.activation.DataHandler[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Attachment
	 */
	public void setAttachment(javax.activation.DataHandler[] param) {

		validateAttachment(param);

		localAttachmentTracker = true;

		this.localAttachment = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            javax.activation.DataHandler
	 */
	public void addAttachment(javax.activation.DataHandler param) {
		if (localAttachment == null) {
			localAttachment = new javax.activation.DataHandler[] {};
		}

		// update the setting tracker
		localAttachmentTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localAttachment);
		list.add(param);
		this.localAttachment = (javax.activation.DataHandler[]) list
				.toArray(new javax.activation.DataHandler[list.size()]);

	}

	/**
	 * field for ClassInstance
	 */

	protected boolean localClassInstance;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localClassInstanceTracker = false;

	public boolean isClassInstanceSpecified() {
		return localClassInstanceTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return boolean
	 */
	public boolean getClassInstance() {
		return localClassInstance;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ClassInstance
	 */
	public void setClassInstance(boolean param) {

		// setting primitive attribute tracker to true
		localClassInstanceTracker = true;

		this.localClassInstance = param;

	}

	/**
	 * field for Comments
	 */

	protected java.lang.String localComments;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localCommentsTracker = false;

	public boolean isCommentsSpecified() {
		return localCommentsTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getComments() {
		return localComments;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Comments
	 */
	public void setComments(java.lang.String param) {
		localCommentsTracker = true;

		this.localComments = param;

	}

	/**
	 * field for Error
	 */

	protected java.lang.Object localError;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localErrorTracker = false;

	public boolean isErrorSpecified() {
		return localErrorTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.Object
	 */
	public java.lang.Object getError() {
		return localError;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Error
	 */
	public void setError(java.lang.Object param) {
		localErrorTracker = true;

		this.localError = param;

	}

	/**
	 * field for ExecutionTime
	 */

	protected long localExecutionTime;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localExecutionTimeTracker = false;

	public boolean isExecutionTimeSpecified() {
		return localExecutionTimeTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return long
	 */
	public long getExecutionTime() {
		return localExecutionTime;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ExecutionTime
	 */
	public void setExecutionTime(long param) {

		// setting primitive attribute tracker to true
		localExecutionTimeTracker = param != java.lang.Long.MIN_VALUE;

		this.localExecutionTime = param;

	}

	/**
	 * field for List
	 */

	protected boolean localList;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localListTracker = false;

	public boolean isListSpecified() {
		return localListTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return boolean
	 */
	public boolean getList() {
		return localList;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            List
	 */
	public void setList(boolean param) {

		// setting primitive attribute tracker to true
		localListTracker = true;

		this.localList = param;

	}

	/**
	 * field for MemoryUsed
	 */

	protected long localMemoryUsed;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localMemoryUsedTracker = false;

	public boolean isMemoryUsedSpecified() {
		return localMemoryUsedTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return long
	 */
	public long getMemoryUsed() {
		return localMemoryUsed;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            MemoryUsed
	 */
	public void setMemoryUsed(long param) {

		// setting primitive attribute tracker to true
		localMemoryUsedTracker = param != java.lang.Long.MIN_VALUE;

		this.localMemoryUsed = param;

	}

	/**
	 * field for RealInputArguments This was an Array!
	 */

	protected java.lang.Object[] localRealInputArguments;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localRealInputArgumentsTracker = false;

	public boolean isRealInputArgumentsSpecified() {
		return localRealInputArgumentsTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.Object[]
	 */
	public java.lang.Object[] getRealInputArguments() {
		return localRealInputArguments;
	}

	/**
	 * validate the array for RealInputArguments
	 */
	protected void validateRealInputArguments(java.lang.Object[] param) {

	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            RealInputArguments
	 */
	public void setRealInputArguments(java.lang.Object[] param) {

		validateRealInputArguments(param);

		localRealInputArgumentsTracker = true;

		this.localRealInputArguments = param;
	}

	/**
	 * Auto generated add method for the array for convenience
	 * 
	 * @param param
	 *            java.lang.Object
	 */
	public void addRealInputArguments(java.lang.Object param) {
		if (localRealInputArguments == null) {
			localRealInputArguments = new java.lang.Object[] {};
		}

		// update the setting tracker
		localRealInputArgumentsTracker = true;

		java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil
				.toList(localRealInputArguments);
		list.add(param);
		this.localRealInputArguments = (java.lang.Object[]) list
				.toArray(new java.lang.Object[list.size()]);

	}

	/**
	 * field for ReturnValue
	 */

	protected java.lang.Object localReturnValue;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localReturnValueTracker = false;

	public boolean isReturnValueSpecified() {
		return localReturnValueTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.Object
	 */
	public java.lang.Object getReturnValue() {
		return localReturnValue;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ReturnValue
	 */
	public void setReturnValue(java.lang.Object param) {
		localReturnValueTracker = true;

		this.localReturnValue = param;

	}

	/**
	 * field for ReturnValues
	 */

	protected java.lang.Object localReturnValues;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localReturnValuesTracker = false;

	public boolean isReturnValuesSpecified() {
		return localReturnValuesTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return java.lang.Object
	 */
	public java.lang.Object getReturnValues() {
		return localReturnValues;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            ReturnValues
	 */
	public void setReturnValues(java.lang.Object param) {
		localReturnValuesTracker = true;

		this.localReturnValues = param;

	}

	/**
	 * field for Success
	 */

	protected boolean localSuccess;

	/*
	 * This tracker boolean wil be used to detect whether the user called the
	 * set method for this attribute. It will be used to determine whether to
	 * include this field in the serialized XML
	 */
	protected boolean localSuccessTracker = false;

	public boolean isSuccessSpecified() {
		return localSuccessTracker;
	}

	/**
	 * Auto generated getter method
	 * 
	 * @return boolean
	 */
	public boolean getSuccess() {
		return localSuccess;
	}

	/**
	 * Auto generated setter method
	 * 
	 * @param param
	 *            Success
	 */
	public void setSuccess(boolean param) {

		// setting primitive attribute tracker to true
		localSuccessTracker = true;

		this.localSuccess = param;

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
						namespacePrefix + ":Result", xmlWriter);
			} else {
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "type",
						"Result", xmlWriter);
			}

		}
		if (localAttachmentTracker) {
			if (localAttachment != null) {
				namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
				for (int i = 0; i < localAttachment.length; i++) {

					if (localAttachment[i] != null) {

						writeStartElement(null, namespace, "attachment",
								xmlWriter);

						try {
							org.apache.axiom.util.stax.XMLStreamWriterUtils
									.writeDataHandler(xmlWriter,
											localAttachment[i], null, true);
						} catch (java.io.IOException ex) {
							throw new javax.xml.stream.XMLStreamException(
									"Unable to read data handler for attachment["
											+ i + "]", ex);
						}

						xmlWriter.writeEndElement();

					} else {

						// write null attribute
						namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
						writeStartElement(null, namespace, "attachment",
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
						"attachment", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localClassInstanceTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "classInstance", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException(
						"classInstance cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localClassInstance));
			}

			xmlWriter.writeEndElement();
		}
		if (localCommentsTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "comments", xmlWriter);

			if (localComments == null) {
				// write the nil attribute

				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);

			} else {

				xmlWriter.writeCharacters(localComments);

			}

			xmlWriter.writeEndElement();
		}
		if (localErrorTracker) {

			if (localError != null) {
				if (localError instanceof org.apache.axis2.databinding.ADBBean) {
					((org.apache.axis2.databinding.ADBBean) localError)
							.serialize(
									new javax.xml.namespace.QName(
											"http://bladelogic.com/webservices/model/clitunnel/xsd",
											"error"), xmlWriter, true);
				} else {
					writeStartElement(
							null,
							"http://bladelogic.com/webservices/model/clitunnel/xsd",
							"error", xmlWriter);
					org.apache.axis2.databinding.utils.ConverterUtil
							.serializeAnyType(localError, xmlWriter);
					xmlWriter.writeEndElement();
				}
			} else {

				// write null attribute
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"error", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localExecutionTimeTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "executionTime", xmlWriter);

			if (localExecutionTime == java.lang.Long.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"executionTime cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localExecutionTime));
			}

			xmlWriter.writeEndElement();
		}
		if (localListTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "list", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException(
						"list cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localList));
			}

			xmlWriter.writeEndElement();
		}
		if (localMemoryUsedTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "memoryUsed", xmlWriter);

			if (localMemoryUsed == java.lang.Long.MIN_VALUE) {

				throw new org.apache.axis2.databinding.ADBException(
						"memoryUsed cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localMemoryUsed));
			}

			xmlWriter.writeEndElement();
		}
		if (localRealInputArgumentsTracker) {

			if (localRealInputArguments != null) {
				for (int i = 0; i < localRealInputArguments.length; i++) {
					if (localRealInputArguments[i] != null) {

						if (localRealInputArguments[i] instanceof org.apache.axis2.databinding.ADBBean) {
							((org.apache.axis2.databinding.ADBBean) localRealInputArguments[i])
									.serialize(
											new javax.xml.namespace.QName(
													"http://bladelogic.com/webservices/model/clitunnel/xsd",
													"realInputArguments"),
											xmlWriter, true);
						} else {
							writeStartElement(
									null,
									"http://bladelogic.com/webservices/model/clitunnel/xsd",
									"realInputArguments", xmlWriter);
							org.apache.axis2.databinding.utils.ConverterUtil
									.serializeAnyType(
											localRealInputArguments[i],
											xmlWriter);
							xmlWriter.writeEndElement();
						}

					} else {

						// write null attribute
						writeStartElement(
								null,
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"realInputArguments", xmlWriter);

						// write the nil attribute
						writeAttribute("xsi",
								"http://www.w3.org/2001/XMLSchema-instance",
								"nil", "1", xmlWriter);
						xmlWriter.writeEndElement();

					}
				}
			} else {

				// write null attribute
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"realInputArguments", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localReturnValueTracker) {

			if (localReturnValue != null) {
				if (localReturnValue instanceof org.apache.axis2.databinding.ADBBean) {
					((org.apache.axis2.databinding.ADBBean) localReturnValue)
							.serialize(
									new javax.xml.namespace.QName(
											"http://bladelogic.com/webservices/model/clitunnel/xsd",
											"returnValue"), xmlWriter, true);
				} else {
					writeStartElement(
							null,
							"http://bladelogic.com/webservices/model/clitunnel/xsd",
							"returnValue", xmlWriter);
					org.apache.axis2.databinding.utils.ConverterUtil
							.serializeAnyType(localReturnValue, xmlWriter);
					xmlWriter.writeEndElement();
				}
			} else {

				// write null attribute
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"returnValue", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localReturnValuesTracker) {

			if (localReturnValues != null) {
				if (localReturnValues instanceof org.apache.axis2.databinding.ADBBean) {
					((org.apache.axis2.databinding.ADBBean) localReturnValues)
							.serialize(
									new javax.xml.namespace.QName(
											"http://bladelogic.com/webservices/model/clitunnel/xsd",
											"returnValues"), xmlWriter, true);
				} else {
					writeStartElement(
							null,
							"http://bladelogic.com/webservices/model/clitunnel/xsd",
							"returnValues", xmlWriter);
					org.apache.axis2.databinding.utils.ConverterUtil
							.serializeAnyType(localReturnValues, xmlWriter);
					xmlWriter.writeEndElement();
				}
			} else {

				// write null attribute
				writeStartElement(
						null,
						"http://bladelogic.com/webservices/model/clitunnel/xsd",
						"returnValues", xmlWriter);

				// write the nil attribute
				writeAttribute("xsi",
						"http://www.w3.org/2001/XMLSchema-instance", "nil",
						"1", xmlWriter);
				xmlWriter.writeEndElement();

			}

		}
		if (localSuccessTracker) {
			namespace = "http://bladelogic.com/webservices/model/clitunnel/xsd";
			writeStartElement(null, namespace, "success", xmlWriter);

			if (false) {

				throw new org.apache.axis2.databinding.ADBException(
						"success cannot be null!!");

			} else {
				xmlWriter
						.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil
								.convertToString(localSuccess));
			}

			xmlWriter.writeEndElement();
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

		if (localAttachmentTracker) {
			if (localAttachment != null) {
				for (int i = 0; i < localAttachment.length; i++) {

					if (localAttachment[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"attachment"));
						elementList
								.add(org.apache.axis2.databinding.utils.ConverterUtil
										.convertToString(localAttachment[i]));
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"attachment"));
						elementList.add(null);

					}

				}
			} else {

				elementList
						.add(new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"attachment"));
				elementList.add(null);

			}

		}
		if (localClassInstanceTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"classInstance"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localClassInstance));
		}
		if (localCommentsTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"comments"));

			elementList.add(localComments == null ? null
					: org.apache.axis2.databinding.utils.ConverterUtil
							.convertToString(localComments));
		}
		if (localErrorTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"error"));

			elementList.add(localError == null ? null : localError);
		}
		if (localExecutionTimeTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"executionTime"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localExecutionTime));
		}
		if (localListTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"list"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localList));
		}
		if (localMemoryUsedTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"memoryUsed"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localMemoryUsed));
		}
		if (localRealInputArgumentsTracker) {
			if (localRealInputArguments != null) {
				for (int i = 0; i < localRealInputArguments.length; i++) {

					if (localRealInputArguments[i] != null) {
						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"realInputArguments"));
						elementList.add(localRealInputArguments[i]);
					} else {

						elementList
								.add(new javax.xml.namespace.QName(
										"http://bladelogic.com/webservices/model/clitunnel/xsd",
										"realInputArguments"));
						elementList.add(null);

					}

				}
			} else {

				elementList
						.add(new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"realInputArguments"));
				elementList.add(localRealInputArguments);

			}

		}
		if (localReturnValueTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"returnValue"));

			elementList.add(localReturnValue == null ? null : localReturnValue);
		}
		if (localReturnValuesTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"returnValues"));

			elementList.add(localReturnValues == null ? null
					: localReturnValues);
		}
		if (localSuccessTracker) {
			elementList.add(new javax.xml.namespace.QName(
					"http://bladelogic.com/webservices/model/clitunnel/xsd",
					"success"));

			elementList.add(org.apache.axis2.databinding.utils.ConverterUtil
					.convertToString(localSuccess));
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
		public static Result parse(javax.xml.stream.XMLStreamReader reader)
				throws java.lang.Exception {
			Result object = new Result();

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

						if (!"Result".equals(type)) {
							// find namespace for the prefix
							java.lang.String nsUri = reader
									.getNamespaceContext().getNamespaceURI(
											nsPrefix);
							return (Result) com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper
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

				java.util.ArrayList list8 = new java.util.ArrayList();

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"attachment").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						list1.add(null);
						reader.next();
					} else {
						list1.add(org.apache.axiom.util.stax.XMLStreamReaderUtils
								.getDataHandlerFromElement(reader));

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
									"attachment").equals(reader.getName())) {

								nillableValue = reader
										.getAttributeValue(
												"http://www.w3.org/2001/XMLSchema-instance",
												"nil");
								if ("true".equals(nillableValue)
										|| "1".equals(nillableValue)) {
									list1.add(null);
									reader.next();
								} else {
									list1.add(org.apache.axiom.util.stax.XMLStreamReaderUtils
											.getDataHandlerFromElement(reader));

								}
							} else {
								loopDone1 = true;
							}
						}
					}
					// call the converter utility to convert and set the array

					object.setAttachment((javax.activation.DataHandler[]) org.apache.axis2.databinding.utils.ConverterUtil
							.convertToArray(javax.activation.DataHandler.class,
									list1));

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"classInstance").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "classInstance"
										+ "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setClassInstance(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToBoolean(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"comments").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if (!"true".equals(nillableValue)
							&& !"1".equals(nillableValue)) {

						java.lang.String content = reader.getElementText();

						object.setComments(org.apache.axis2.databinding.utils.ConverterUtil
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
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"error").equals(reader.getName())) {

					object.setError(org.apache.axis2.databinding.utils.ConverterUtil
							.getAnyTypeObject(
									reader,
									com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper.class));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"executionTime").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "executionTime"
										+ "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setExecutionTime(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToLong(content));

					reader.next();

				} // End of if for expected property start element

				else {

					object.setExecutionTime(java.lang.Long.MIN_VALUE);

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"list").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "list" + "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setList(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToBoolean(content));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"memoryUsed").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "memoryUsed"
										+ "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setMemoryUsed(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToLong(content));

					reader.next();

				} // End of if for expected property start element

				else {

					object.setMemoryUsed(java.lang.Long.MIN_VALUE);

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"realInputArguments").equals(reader.getName())) {

					// Process the array and step past its final element's end.

					boolean loopDone8 = false;
					javax.xml.namespace.QName startQname8 = new javax.xml.namespace.QName(
							"http://bladelogic.com/webservices/model/clitunnel/xsd",
							"realInputArguments");

					while (!loopDone8) {
						event = reader.getEventType();
						if (javax.xml.stream.XMLStreamConstants.START_ELEMENT == event
								&& startQname8.equals(reader.getName())) {

							nillableValue = reader
									.getAttributeValue(
											"http://www.w3.org/2001/XMLSchema-instance",
											"nil");
							if ("true".equals(nillableValue)
									|| "1".equals(nillableValue)) {
								list8.add(null);
								reader.next();
							} else {
								list8.add(org.apache.axis2.databinding.utils.ConverterUtil
										.getAnyTypeObject(
												reader,
												com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper.class));
							}
						} else if (javax.xml.stream.XMLStreamConstants.START_ELEMENT == event
								&& !startQname8.equals(reader.getName())) {
							loopDone8 = true;
						} else if (javax.xml.stream.XMLStreamConstants.END_ELEMENT == event
								&& !startQname8.equals(reader.getName())) {
							loopDone8 = true;
						} else if (javax.xml.stream.XMLStreamConstants.END_DOCUMENT == event) {
							loopDone8 = true;
						} else {
							reader.next();
						}

					}

					object.setRealInputArguments(list8.toArray());

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"returnValue").equals(reader.getName())) {

					object.setReturnValue(org.apache.axis2.databinding.utils.ConverterUtil
							.getAnyTypeObject(
									reader,
									com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper.class));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"returnValues").equals(reader.getName())) {

					object.setReturnValues(org.apache.axis2.databinding.utils.ConverterUtil
							.getAnyTypeObject(
									reader,
									com.bladelogic.webservices.skeleton.clitunnel.ExtensionMapper.class));

					reader.next();

				} // End of if for expected property start element

				else {

				}

				while (!reader.isStartElement() && !reader.isEndElement())
					reader.next();

				if (reader.isStartElement()
						&& new javax.xml.namespace.QName(
								"http://bladelogic.com/webservices/model/clitunnel/xsd",
								"success").equals(reader.getName())) {

					nillableValue = reader.getAttributeValue(
							"http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue)
							|| "1".equals(nillableValue)) {
						throw new org.apache.axis2.databinding.ADBException(
								"The element: " + "success"
										+ "  cannot be null");
					}

					java.lang.String content = reader.getElementText();

					object.setSuccess(org.apache.axis2.databinding.utils.ConverterUtil
							.convertToBoolean(content));

					reader.next();

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
