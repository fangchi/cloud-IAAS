
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.bladelogic.webservices.skeleton.assumerole;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "SessionCredentialExpiredException".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.SessionCredentialExpiredException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "SessionRejectedException".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.SessionRejectedException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "BlException".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.BlException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "SessionLoginException".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.SessionLoginException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "Exception".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.Exception.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://bladelogic.com/webservices/framework/xsd".equals(namespaceURI) &&
                  "BaseException".equals(typeName)){
                   
                            return  com.bladelogic.webservices.framework.xsd.BaseException.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    