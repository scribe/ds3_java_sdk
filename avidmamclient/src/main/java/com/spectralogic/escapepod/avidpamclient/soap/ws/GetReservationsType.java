/**
 * GetReservationsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the GetReservations operation.It accepts a list
 * of Interplay URIs and an
 *         optional Boolean parameter called CheckAllLinks. The Interplay
 * URIs should reference valid Avid assets or
 *         folders. If CheckAllLinks is set to true, then it will check
 * all links to the asset for reservations. The
 *         default setting of the CheckAllLinks parameter is false.
 */
public class GetReservationsType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String[] interplayURIs;

    private java.lang.Boolean checkAllLinks;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetReservationsType() {
    }

    public GetReservationsType(
           java.lang.String[] interplayURIs,
           java.lang.Boolean checkAllLinks,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURIs = interplayURIs;
           this.checkAllLinks = checkAllLinks;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURIs value for this GetReservationsType.
     * 
     * @return interplayURIs
     */
    public java.lang.String[] getInterplayURIs() {
        return interplayURIs;
    }


    /**
     * Sets the interplayURIs value for this GetReservationsType.
     * 
     * @param interplayURIs
     */
    public void setInterplayURIs(java.lang.String[] interplayURIs) {
        this.interplayURIs = interplayURIs;
    }


    /**
     * Gets the checkAllLinks value for this GetReservationsType.
     * 
     * @return checkAllLinks
     */
    public java.lang.Boolean getCheckAllLinks() {
        return checkAllLinks;
    }


    /**
     * Sets the checkAllLinks value for this GetReservationsType.
     * 
     * @param checkAllLinks
     */
    public void setCheckAllLinks(java.lang.Boolean checkAllLinks) {
        this.checkAllLinks = checkAllLinks;
    }


    /**
     * Gets the extension value for this GetReservationsType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetReservationsType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetReservationsType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetReservationsType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetReservationsType)) return false;
        GetReservationsType other = (GetReservationsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayURIs==null && other.getInterplayURIs()==null) || 
             (this.interplayURIs!=null &&
              java.util.Arrays.equals(this.interplayURIs, other.getInterplayURIs()))) &&
            ((this.checkAllLinks==null && other.getCheckAllLinks()==null) || 
             (this.checkAllLinks!=null &&
              this.checkAllLinks.equals(other.getCheckAllLinks()))) &&
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
        if (getInterplayURIs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInterplayURIs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInterplayURIs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCheckAllLinks() != null) {
            _hashCode += getCheckAllLinks().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetReservationsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetReservationsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURIs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURIs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkAllLinks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "CheckAllLinks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
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
