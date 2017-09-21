/**
 * WorkGroupDetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The details of a configured Interplay Engine, including the configured
 * workgroup name, the
 *         Interplay Engine host name, and the Interplay Engine version,
 * the Archive Engine host name, and the Archive
 *         Engine version.
 */
public class WorkGroupDetailsType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String workgroupName;

    private java.lang.String interplayEngineHost;

    private java.lang.String interplayEngineVersion;

    private java.lang.String archiveEngineHost;

    private java.lang.String archiveEngineVersion;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public WorkGroupDetailsType() {
    }

    public WorkGroupDetailsType(
           java.lang.String workgroupName,
           java.lang.String interplayEngineHost,
           java.lang.String interplayEngineVersion,
           java.lang.String archiveEngineHost,
           java.lang.String archiveEngineVersion,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.workgroupName = workgroupName;
           this.interplayEngineHost = interplayEngineHost;
           this.interplayEngineVersion = interplayEngineVersion;
           this.archiveEngineHost = archiveEngineHost;
           this.archiveEngineVersion = archiveEngineVersion;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the workgroupName value for this WorkGroupDetailsType.
     * 
     * @return workgroupName
     */
    public java.lang.String getWorkgroupName() {
        return workgroupName;
    }


    /**
     * Sets the workgroupName value for this WorkGroupDetailsType.
     * 
     * @param workgroupName
     */
    public void setWorkgroupName(java.lang.String workgroupName) {
        this.workgroupName = workgroupName;
    }


    /**
     * Gets the interplayEngineHost value for this WorkGroupDetailsType.
     * 
     * @return interplayEngineHost
     */
    public java.lang.String getInterplayEngineHost() {
        return interplayEngineHost;
    }


    /**
     * Sets the interplayEngineHost value for this WorkGroupDetailsType.
     * 
     * @param interplayEngineHost
     */
    public void setInterplayEngineHost(java.lang.String interplayEngineHost) {
        this.interplayEngineHost = interplayEngineHost;
    }


    /**
     * Gets the interplayEngineVersion value for this WorkGroupDetailsType.
     * 
     * @return interplayEngineVersion
     */
    public java.lang.String getInterplayEngineVersion() {
        return interplayEngineVersion;
    }


    /**
     * Sets the interplayEngineVersion value for this WorkGroupDetailsType.
     * 
     * @param interplayEngineVersion
     */
    public void setInterplayEngineVersion(java.lang.String interplayEngineVersion) {
        this.interplayEngineVersion = interplayEngineVersion;
    }


    /**
     * Gets the archiveEngineHost value for this WorkGroupDetailsType.
     * 
     * @return archiveEngineHost
     */
    public java.lang.String getArchiveEngineHost() {
        return archiveEngineHost;
    }


    /**
     * Sets the archiveEngineHost value for this WorkGroupDetailsType.
     * 
     * @param archiveEngineHost
     */
    public void setArchiveEngineHost(java.lang.String archiveEngineHost) {
        this.archiveEngineHost = archiveEngineHost;
    }


    /**
     * Gets the archiveEngineVersion value for this WorkGroupDetailsType.
     * 
     * @return archiveEngineVersion
     */
    public java.lang.String getArchiveEngineVersion() {
        return archiveEngineVersion;
    }


    /**
     * Sets the archiveEngineVersion value for this WorkGroupDetailsType.
     * 
     * @param archiveEngineVersion
     */
    public void setArchiveEngineVersion(java.lang.String archiveEngineVersion) {
        this.archiveEngineVersion = archiveEngineVersion;
    }


    /**
     * Gets the extension value for this WorkGroupDetailsType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this WorkGroupDetailsType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this WorkGroupDetailsType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this WorkGroupDetailsType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkGroupDetailsType)) return false;
        WorkGroupDetailsType other = (WorkGroupDetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.workgroupName==null && other.getWorkgroupName()==null) || 
             (this.workgroupName!=null &&
              this.workgroupName.equals(other.getWorkgroupName()))) &&
            ((this.interplayEngineHost==null && other.getInterplayEngineHost()==null) || 
             (this.interplayEngineHost!=null &&
              this.interplayEngineHost.equals(other.getInterplayEngineHost()))) &&
            ((this.interplayEngineVersion==null && other.getInterplayEngineVersion()==null) || 
             (this.interplayEngineVersion!=null &&
              this.interplayEngineVersion.equals(other.getInterplayEngineVersion()))) &&
            ((this.archiveEngineHost==null && other.getArchiveEngineHost()==null) || 
             (this.archiveEngineHost!=null &&
              this.archiveEngineHost.equals(other.getArchiveEngineHost()))) &&
            ((this.archiveEngineVersion==null && other.getArchiveEngineVersion()==null) || 
             (this.archiveEngineVersion!=null &&
              this.archiveEngineVersion.equals(other.getArchiveEngineVersion()))) &&
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
        if (getWorkgroupName() != null) {
            _hashCode += getWorkgroupName().hashCode();
        }
        if (getInterplayEngineHost() != null) {
            _hashCode += getInterplayEngineHost().hashCode();
        }
        if (getInterplayEngineVersion() != null) {
            _hashCode += getInterplayEngineVersion().hashCode();
        }
        if (getArchiveEngineHost() != null) {
            _hashCode += getArchiveEngineHost().hashCode();
        }
        if (getArchiveEngineVersion() != null) {
            _hashCode += getArchiveEngineVersion().hashCode();
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
        new org.apache.axis.description.TypeDesc(WorkGroupDetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkGroupDetailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workgroupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkgroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayEngineHost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "InterplayEngineHost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interplayEngineVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "InterplayEngineVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archiveEngineHost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "ArchiveEngineHost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archiveEngineVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "ArchiveEngineVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extension");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "Extension"));
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
