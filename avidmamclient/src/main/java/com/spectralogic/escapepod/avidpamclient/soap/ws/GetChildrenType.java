/**
 * GetChildrenType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * Parameters for the GetChildren operation. Gets the child nodes
 * located under the location
 *         pointed to by InterplayURI. IncludeFolders, IncludeFiles,
 * and IncludeMOBs allow the results to be filtered by
 *         the type of node. If not passed in, they each default to true.
 * The optional NameFilter allows the results to be
 *         filtered based on name and a regular expression. The optional
 * ReturnAttributes allows the caller to
 *         specifically indicate what attributes should be returned for
 * each asset.
 */
public class GetChildrenType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String interplayURI;

    private java.lang.Boolean includeFolders;

    private java.lang.Boolean includeFiles;

    private java.lang.Boolean includeMOBs;

    private java.lang.String nameFilter;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public GetChildrenType() {
    }

    public GetChildrenType(
           java.lang.String interplayURI,
           java.lang.Boolean includeFolders,
           java.lang.Boolean includeFiles,
           java.lang.Boolean includeMOBs,
           java.lang.String nameFilter,
           com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.interplayURI = interplayURI;
           this.includeFolders = includeFolders;
           this.includeFiles = includeFiles;
           this.includeMOBs = includeMOBs;
           this.nameFilter = nameFilter;
           this.returnAttributes = returnAttributes;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the interplayURI value for this GetChildrenType.
     * 
     * @return interplayURI
     */
    public java.lang.String getInterplayURI() {
        return interplayURI;
    }


    /**
     * Sets the interplayURI value for this GetChildrenType.
     * 
     * @param interplayURI
     */
    public void setInterplayURI(java.lang.String interplayURI) {
        this.interplayURI = interplayURI;
    }


    /**
     * Gets the includeFolders value for this GetChildrenType.
     * 
     * @return includeFolders
     */
    public java.lang.Boolean getIncludeFolders() {
        return includeFolders;
    }


    /**
     * Sets the includeFolders value for this GetChildrenType.
     * 
     * @param includeFolders
     */
    public void setIncludeFolders(java.lang.Boolean includeFolders) {
        this.includeFolders = includeFolders;
    }


    /**
     * Gets the includeFiles value for this GetChildrenType.
     * 
     * @return includeFiles
     */
    public java.lang.Boolean getIncludeFiles() {
        return includeFiles;
    }


    /**
     * Sets the includeFiles value for this GetChildrenType.
     * 
     * @param includeFiles
     */
    public void setIncludeFiles(java.lang.Boolean includeFiles) {
        this.includeFiles = includeFiles;
    }


    /**
     * Gets the includeMOBs value for this GetChildrenType.
     * 
     * @return includeMOBs
     */
    public java.lang.Boolean getIncludeMOBs() {
        return includeMOBs;
    }


    /**
     * Sets the includeMOBs value for this GetChildrenType.
     * 
     * @param includeMOBs
     */
    public void setIncludeMOBs(java.lang.Boolean includeMOBs) {
        this.includeMOBs = includeMOBs;
    }


    /**
     * Gets the nameFilter value for this GetChildrenType.
     * 
     * @return nameFilter
     */
    public java.lang.String getNameFilter() {
        return nameFilter;
    }


    /**
     * Sets the nameFilter value for this GetChildrenType.
     * 
     * @param nameFilter
     */
    public void setNameFilter(java.lang.String nameFilter) {
        this.nameFilter = nameFilter;
    }


    /**
     * Gets the returnAttributes value for this GetChildrenType.
     * 
     * @return returnAttributes
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] getReturnAttributes() {
        return returnAttributes;
    }


    /**
     * Sets the returnAttributes value for this GetChildrenType.
     * 
     * @param returnAttributes
     */
    public void setReturnAttributes(com.spectralogic.escapepod.avidpamclient.soap.ws.AttributeType[] returnAttributes) {
        this.returnAttributes = returnAttributes;
    }


    /**
     * Gets the extension value for this GetChildrenType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this GetChildrenType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this GetChildrenType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this GetChildrenType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetChildrenType)) return false;
        GetChildrenType other = (GetChildrenType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interplayURI==null && other.getInterplayURI()==null) || 
             (this.interplayURI!=null &&
              this.interplayURI.equals(other.getInterplayURI()))) &&
            ((this.includeFolders==null && other.getIncludeFolders()==null) || 
             (this.includeFolders!=null &&
              this.includeFolders.equals(other.getIncludeFolders()))) &&
            ((this.includeFiles==null && other.getIncludeFiles()==null) || 
             (this.includeFiles!=null &&
              this.includeFiles.equals(other.getIncludeFiles()))) &&
            ((this.includeMOBs==null && other.getIncludeMOBs()==null) || 
             (this.includeMOBs!=null &&
              this.includeMOBs.equals(other.getIncludeMOBs()))) &&
            ((this.nameFilter==null && other.getNameFilter()==null) || 
             (this.nameFilter!=null &&
              this.nameFilter.equals(other.getNameFilter()))) &&
            ((this.returnAttributes==null && other.getReturnAttributes()==null) || 
             (this.returnAttributes!=null &&
              java.util.Arrays.equals(this.returnAttributes, other.getReturnAttributes()))) &&
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
        if (getInterplayURI() != null) {
            _hashCode += getInterplayURI().hashCode();
        }
        if (getIncludeFolders() != null) {
            _hashCode += getIncludeFolders().hashCode();
        }
        if (getIncludeFiles() != null) {
            _hashCode += getIncludeFiles().hashCode();
        }
        if (getIncludeMOBs() != null) {
            _hashCode += getIncludeMOBs().hashCode();
        }
        if (getNameFilter() != null) {
            _hashCode += getNameFilter().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetChildrenType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "GetChildrenType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayURI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "InterplayURI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeFolders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "IncludeFolders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeFiles");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "IncludeFiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("includeMOBs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "IncludeMOBs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/assets/types", "NameFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
