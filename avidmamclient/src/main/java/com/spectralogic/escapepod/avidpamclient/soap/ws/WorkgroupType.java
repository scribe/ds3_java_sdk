/**
 * WorkgroupType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidpamclient.soap.ws;


/**
 * The Workgroup contains a Workgroup Name, Interplay Engine Host,
 * Archive Engine Host and Media
 *         Services Engine Host.
 */
public class WorkgroupType  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private java.lang.String workgroupName;

    private java.lang.String interplayEngineHost;

    private java.lang.String archiveEngineHost;

    private java.lang.String mediaServicesEngineHost;

    private com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension;

    private org.apache.axis.message.MessageElement [] _any;

    public WorkgroupType() {
    }

    public WorkgroupType(
           java.lang.String workgroupName,
           java.lang.String interplayEngineHost,
           java.lang.String archiveEngineHost,
           java.lang.String mediaServicesEngineHost,
           com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension,
           org.apache.axis.message.MessageElement [] _any) {
           this.workgroupName = workgroupName;
           this.interplayEngineHost = interplayEngineHost;
           this.archiveEngineHost = archiveEngineHost;
           this.mediaServicesEngineHost = mediaServicesEngineHost;
           this.extension = extension;
           this._any = _any;
    }


    /**
     * Gets the workgroupName value for this WorkgroupType.
     * 
     * @return workgroupName
     */
    public java.lang.String getWorkgroupName() {
        return workgroupName;
    }


    /**
     * Sets the workgroupName value for this WorkgroupType.
     * 
     * @param workgroupName
     */
    public void setWorkgroupName(java.lang.String workgroupName) {
        this.workgroupName = workgroupName;
    }


    /**
     * Gets the interplayEngineHost value for this WorkgroupType.
     * 
     * @return interplayEngineHost
     */
    public java.lang.String getInterplayEngineHost() {
        return interplayEngineHost;
    }


    /**
     * Sets the interplayEngineHost value for this WorkgroupType.
     * 
     * @param interplayEngineHost
     */
    public void setInterplayEngineHost(java.lang.String interplayEngineHost) {
        this.interplayEngineHost = interplayEngineHost;
    }


    /**
     * Gets the archiveEngineHost value for this WorkgroupType.
     * 
     * @return archiveEngineHost
     */
    public java.lang.String getArchiveEngineHost() {
        return archiveEngineHost;
    }


    /**
     * Sets the archiveEngineHost value for this WorkgroupType.
     * 
     * @param archiveEngineHost
     */
    public void setArchiveEngineHost(java.lang.String archiveEngineHost) {
        this.archiveEngineHost = archiveEngineHost;
    }


    /**
     * Gets the mediaServicesEngineHost value for this WorkgroupType.
     * 
     * @return mediaServicesEngineHost
     */
    public java.lang.String getMediaServicesEngineHost() {
        return mediaServicesEngineHost;
    }


    /**
     * Sets the mediaServicesEngineHost value for this WorkgroupType.
     * 
     * @param mediaServicesEngineHost
     */
    public void setMediaServicesEngineHost(java.lang.String mediaServicesEngineHost) {
        this.mediaServicesEngineHost = mediaServicesEngineHost;
    }


    /**
     * Gets the extension value for this WorkgroupType.
     * 
     * @return extension
     */
    public com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType getExtension() {
        return extension;
    }


    /**
     * Sets the extension value for this WorkgroupType.
     * 
     * @param extension
     */
    public void setExtension(com.spectralogic.escapepod.avidpamclient.soap.ws.ExtensionType extension) {
        this.extension = extension;
    }


    /**
     * Gets the _any value for this WorkgroupType.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this WorkgroupType.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkgroupType)) return false;
        WorkgroupType other = (WorkgroupType) obj;
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
            ((this.archiveEngineHost==null && other.getArchiveEngineHost()==null) || 
             (this.archiveEngineHost!=null &&
              this.archiveEngineHost.equals(other.getArchiveEngineHost()))) &&
            ((this.mediaServicesEngineHost==null && other.getMediaServicesEngineHost()==null) || 
             (this.mediaServicesEngineHost!=null &&
              this.mediaServicesEngineHost.equals(other.getMediaServicesEngineHost()))) &&
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
        if (getArchiveEngineHost() != null) {
            _hashCode += getArchiveEngineHost().hashCode();
        }
        if (getMediaServicesEngineHost() != null) {
            _hashCode += getMediaServicesEngineHost().hashCode();
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
        new org.apache.axis.description.TypeDesc(WorkgroupType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "WorkgroupType"));
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
        elemField.setFieldName("archiveEngineHost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "ArchiveEngineHost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediaServicesEngineHost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://avid.com/interplay/ws/infrastructure/types", "MediaServicesEngineHost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
