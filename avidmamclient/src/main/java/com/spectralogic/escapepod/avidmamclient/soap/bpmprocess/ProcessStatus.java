/**
 * ProcessStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spectralogic.escapepod.avidmamclient.soap.bpmprocess;

public class ProcessStatus  implements java.io.Serializable {
    private java.lang.String errorMessage;

    private java.lang.String guid;

    private java.lang.String lifecycle;

    private java.lang.String maintitle;

    private java.lang.String progress;

    public ProcessStatus() {
    }

    public ProcessStatus(
           java.lang.String errorMessage,
           java.lang.String guid,
           java.lang.String lifecycle,
           java.lang.String maintitle,
           java.lang.String progress) {
           this.errorMessage = errorMessage;
           this.guid = guid;
           this.lifecycle = lifecycle;
           this.maintitle = maintitle;
           this.progress = progress;
    }


    /**
     * Gets the errorMessage value for this ProcessStatus.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this ProcessStatus.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the guid value for this ProcessStatus.
     * 
     * @return guid
     */
    public java.lang.String getGuid() {
        return guid;
    }


    /**
     * Sets the guid value for this ProcessStatus.
     * 
     * @param guid
     */
    public void setGuid(java.lang.String guid) {
        this.guid = guid;
    }


    /**
     * Gets the lifecycle value for this ProcessStatus.
     * 
     * @return lifecycle
     */
    public java.lang.String getLifecycle() {
        return lifecycle;
    }


    /**
     * Sets the lifecycle value for this ProcessStatus.
     * 
     * @param lifecycle
     */
    public void setLifecycle(java.lang.String lifecycle) {
        this.lifecycle = lifecycle;
    }


    /**
     * Gets the maintitle value for this ProcessStatus.
     * 
     * @return maintitle
     */
    public java.lang.String getMaintitle() {
        return maintitle;
    }


    /**
     * Sets the maintitle value for this ProcessStatus.
     * 
     * @param maintitle
     */
    public void setMaintitle(java.lang.String maintitle) {
        this.maintitle = maintitle;
    }


    /**
     * Gets the progress value for this ProcessStatus.
     * 
     * @return progress
     */
    public java.lang.String getProgress() {
        return progress;
    }


    /**
     * Sets the progress value for this ProcessStatus.
     * 
     * @param progress
     */
    public void setProgress(java.lang.String progress) {
        this.progress = progress;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProcessStatus)) return false;
        ProcessStatus other = (ProcessStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.guid==null && other.getGuid()==null) || 
             (this.guid!=null &&
              this.guid.equals(other.getGuid()))) &&
            ((this.lifecycle==null && other.getLifecycle()==null) || 
             (this.lifecycle!=null &&
              this.lifecycle.equals(other.getLifecycle()))) &&
            ((this.maintitle==null && other.getMaintitle()==null) || 
             (this.maintitle!=null &&
              this.maintitle.equals(other.getMaintitle()))) &&
            ((this.progress==null && other.getProgress()==null) || 
             (this.progress!=null &&
              this.progress.equals(other.getProgress())));
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
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getGuid() != null) {
            _hashCode += getGuid().hashCode();
        }
        if (getLifecycle() != null) {
            _hashCode += getLifecycle().hashCode();
        }
        if (getMaintitle() != null) {
            _hashCode += getMaintitle().hashCode();
        }
        if (getProgress() != null) {
            _hashCode += getProgress().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProcessStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "ProcessStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "ErrorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "Guid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lifecycle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "Lifecycle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maintitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "Maintitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.blue-order.com/ma/workflowlibraryws/bpmprocess", "Progress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
