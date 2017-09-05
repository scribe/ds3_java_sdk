/**
 * SearchType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the Search operation. Searches can be done from
 * a specified root folder against
 *         specified conditions on attributes. The optional ReturnAttributes
 * allows the caller to specifically indicate
 *         what attributes should be returned for each asset.
 */
public class SearchType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayPathURI;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType searchGroup;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes;

    private java.lang.Integer maxResults;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public SearchType() {
    }

    public SearchType(
           java.lang.String interplayPathURI,
           com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType searchGroup,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes,
           java.lang.Integer maxResults,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayPathURI = interplayPathURI;
           this.searchGroup = searchGroup;
           this.returnAttributes = returnAttributes;
           this.maxResults = maxResults;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayPathURI value for this SearchType.
     * 
     * @return interplayPathURI
     */
    public java.lang.String getInterplayPathURI() {
        return interplayPathURI;
    }


    /**
     * Sets the interplayPathURI value for this SearchType.
     * 
     * @param interplayPathURI
     */
    public void setInterplayPathURI(java.lang.String interplayPathURI) {
        this.interplayPathURI = interplayPathURI;
    }


    /**
     * Gets the searchGroup value for this SearchType.
     * 
     * @return searchGroup
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType getSearchGroup() {
        return searchGroup;
    }


    /**
     * Sets the searchGroup value for this SearchType.
     * 
     * @param searchGroup
     */
    public void setSearchGroup(com.spectralogic.escapepod.avidpamclient.soap.ws.SearchGroupType searchGroup) {
        this.searchGroup = searchGroup;
    }


    /**
     * Gets the returnAttributes value for this SearchType.
     * 
     * @return returnAttributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getReturnAttributes() {
        return returnAttributes;
    }


    /**
     * Sets the returnAttributes value for this SearchType.
     * 
     * @param returnAttributes
     */
    public void setReturnAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes) {
        this.returnAttributes = returnAttributes;
    }


    /**
     * Gets the maxResults value for this SearchType.
     * 
     * @return maxResults
     */
    public java.lang.Integer getMaxResults() {
        return maxResults;
    }


    /**
     * Sets the maxResults value for this SearchType.
     * 
     * @param maxResults
     */
    public void setMaxResults(java.lang.Integer maxResults) {
        this.maxResults = maxResults;
    }


    /**
     * Gets the extension value for this SearchType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this SearchType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this SearchType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this SearchType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchType)) return false;
        SearchType other = (SearchType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayPathURI==null && other.getInterplayPathURI()==null) || 
             (this.interplayPathURI!=null &&
              this.interplayPathURI.equals(other.getInterplayPathURI()))) &&
            ((this.searchGroup==null && other.getSearchGroup()==null) || 
             (this.searchGroup!=null &&
              this.searchGroup.equals(other.getSearchGroup()))) &&
            ((this.returnAttributes==null && other.getReturnAttributes()==null) || 
             (this.returnAttributes!=null &&
              java.util.Arrays.equals(this.returnAttributes, other.getReturnAttributes()))) &&
            ((this.maxResults==null && other.getMaxResults()==null) || 
             (this.maxResults!=null &&
              this.maxResults.equals(other.getMaxResults()))) &&
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
        if (getInterplayPathURI() != null) {
            _hashCode += getInterplayPathURI().hashCode();
        }
        if (getSearchGroup() != null) {
            _hashCode += getSearchGroup().hashCode();
        }
        if (getReturnAttributes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReturnAttributes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReturnAttributes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMaxResults() != null) {
            _hashCode += getMaxResults().hashCode();
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
        new org.apache.axis.description.TypeDesc(SearchType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayPathURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayPathURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "SearchGroupType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnAttributes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "ReturnAttributes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "AttributeType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "Attribute"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxResults");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "MaxResults"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
