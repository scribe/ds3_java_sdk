/**
 * LinkToMOBType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the LinkToMOB operaiton. Creates a new link (or
 * reference) to the MOB specified
 *         by InterplayMOBURI. The link is added to the location specified
 * by InterplayPathURI.
 */
public class LinkToMOBType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayMOBURI;

    private java.lang.String interplayPathURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public LinkToMOBType() {
    }

    public LinkToMOBType(
           java.lang.String interplayMOBURI,
           java.lang.String interplayPathURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayMOBURI = interplayMOBURI;
           this.interplayPathURI = interplayPathURI;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayMOBURI value for this LinkToMOBType.
     * 
     * @return interplayMOBURI
     */
    public java.lang.String getInterplayMOBURI() {
        return interplayMOBURI;
    }


    /**
     * Sets the interplayMOBURI value for this LinkToMOBType.
     * 
     * @param interplayMOBURI
     */
    public void setInterplayMOBURI(java.lang.String interplayMOBURI) {
        this.interplayMOBURI = interplayMOBURI;
    }


    /**
     * Gets the interplayPathURI value for this LinkToMOBType.
     * 
     * @return interplayPathURI
     */
    public java.lang.String getInterplayPathURI() {
        return interplayPathURI;
    }


    /**
     * Sets the interplayPathURI value for this LinkToMOBType.
     * 
     * @param interplayPathURI
     */
    public void setInterplayPathURI(java.lang.String interplayPathURI) {
        this.interplayPathURI = interplayPathURI;
    }


    /**
     * Gets the extension value for this LinkToMOBType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this LinkToMOBType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this LinkToMOBType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this LinkToMOBType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LinkToMOBType)) return false;
        LinkToMOBType other = (LinkToMOBType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayMOBURI==null && other.getInterplayMOBURI()==null) || 
             (this.interplayMOBURI!=null &&
              this.interplayMOBURI.equals(other.getInterplayMOBURI()))) &&
            ((this.interplayPathURI==null && other.getInterplayPathURI()==null) || 
             (this.interplayPathURI!=null &&
              this.interplayPathURI.equals(other.getInterplayPathURI()))) &&
            ((this.extension==null && other.getExtension()==null) || 
             (this.extension!=null &&
              this.extension.equals(other.getExtension()))) &&
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getInterplayMOBURI() != null) {
            _hashCode += getInterplayMOBURI().hashCode();
        }
        if (getInterplayPathURI() != null) {
            _hashCode += getInterplayPathURI().hashCode();
        }
        if (getExtension() != null) {
            _hashCode += getExtension().hashCode();
        }
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LinkToMOBType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "LinkToMOBType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayMOBURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayMOBURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayPathURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayPathURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ExtensionType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
