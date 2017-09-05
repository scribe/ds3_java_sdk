/**
 * GetResolutionsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the GetResolutions operation. This operation is
 * helpful to determine the
 *         available resolutions before issuing a delete. ReportDetails
 * should be set to true to receive a per-asset report
 *         on resolutions, otherwise only a summary is returned.
 */
public class GetResolutionsType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String[] interplayURIs;

    private java.lang.Boolean onlineResolutionsOnly;

    private java.lang.Boolean reportDetails;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetResolutionsType() {
    }

    public GetResolutionsType(
           java.lang.String[] interplayURIs,
           java.lang.Boolean onlineResolutionsOnly,
           java.lang.Boolean reportDetails,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURIs = interplayURIs;
           this.onlineResolutionsOnly = onlineResolutionsOnly;
           this.reportDetails = reportDetails;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURIs value for this GetResolutionsType.
     * 
     * @return interplayURIs
     */
    public java.lang.String[] getInterplayURIs() {
        return interplayURIs;
    }


    /**
     * Sets the interplayURIs value for this GetResolutionsType.
     * 
     * @param interplayURIs
     */
    public void setInterplayURIs(java.lang.String[] interplayURIs) {
        this.interplayURIs = interplayURIs;
    }


    /**
     * Gets the onlineResolutionsOnly value for this GetResolutionsType.
     * 
     * @return onlineResolutionsOnly
     */
    public java.lang.Boolean getOnlineResolutionsOnly() {
        return onlineResolutionsOnly;
    }


    /**
     * Sets the onlineResolutionsOnly value for this GetResolutionsType.
     * 
     * @param onlineResolutionsOnly
     */
    public void setOnlineResolutionsOnly(java.lang.Boolean onlineResolutionsOnly) {
        this.onlineResolutionsOnly = onlineResolutionsOnly;
    }


    /**
     * Gets the reportDetails value for this GetResolutionsType.
     * 
     * @return reportDetails
     */
    public java.lang.Boolean getReportDetails() {
        return reportDetails;
    }


    /**
     * Sets the reportDetails value for this GetResolutionsType.
     * 
     * @param reportDetails
     */
    public void setReportDetails(java.lang.Boolean reportDetails) {
        this.reportDetails = reportDetails;
    }


    /**
     * Gets the extension value for this GetResolutionsType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetResolutionsType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetResolutionsType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetResolutionsType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetResolutionsType)) return false;
        GetResolutionsType other = (GetResolutionsType) obj;
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
            ((this.onlineResolutionsOnly==null && other.getOnlineResolutionsOnly()==null) || 
             (this.onlineResolutionsOnly!=null &&
              this.onlineResolutionsOnly.equals(other.getOnlineResolutionsOnly()))) &&
            ((this.reportDetails==null && other.getReportDetails()==null) || 
             (this.reportDetails!=null &&
              this.reportDetails.equals(other.getReportDetails()))) &&
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
        if (getOnlineResolutionsOnly() != null) {
            _hashCode += getOnlineResolutionsOnly().hashCode();
        }
        if (getReportDetails() != null) {
            _hashCode += getReportDetails().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetResolutionsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetResolutionsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURIs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURIs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onlineResolutionsOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "OnlineResolutionsOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReportDetails"));
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
