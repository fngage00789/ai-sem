/**
 * Z_RE_IF_SEM_CREATE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ais.sem.ifrs16.webservice.cresem.bean;

public class Z_RE_IF_SEM_CREATE  implements java.io.Serializable {
    /* SEM/TFM Contract Upload */
    private com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER[] CONTRACT_DETAILS1;

    public Z_RE_IF_SEM_CREATE() {
    }

    public Z_RE_IF_SEM_CREATE(
           com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER[] CONTRACT_DETAILS1) {
           this.CONTRACT_DETAILS1 = CONTRACT_DETAILS1;
    }


    /**
     * Gets the CONTRACT_DETAILS1 value for this Z_RE_IF_SEM_CREATE.
     * 
     * @return CONTRACT_DETAILS1   * SEM/TFM Contract Upload
     */
    public com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER[] getCONTRACT_DETAILS1() {
        return CONTRACT_DETAILS1;
    }


    /**
     * Sets the CONTRACT_DETAILS1 value for this Z_RE_IF_SEM_CREATE.
     * 
     * @param CONTRACT_DETAILS1   * SEM/TFM Contract Upload
     */
    public void setCONTRACT_DETAILS1(com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTTEMPLATE_INTER[] CONTRACT_DETAILS1) {
        this.CONTRACT_DETAILS1 = CONTRACT_DETAILS1;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_RE_IF_SEM_CREATE)) return false;
        Z_RE_IF_SEM_CREATE other = (Z_RE_IF_SEM_CREATE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CONTRACT_DETAILS1==null && other.getCONTRACT_DETAILS1()==null) || 
             (this.CONTRACT_DETAILS1!=null &&
              java.util.Arrays.equals(this.CONTRACT_DETAILS1, other.getCONTRACT_DETAILS1())));
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
        if (getCONTRACT_DETAILS1() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCONTRACT_DETAILS1());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCONTRACT_DETAILS1(), i);
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
        new org.apache.axis.description.TypeDesc(Z_RE_IF_SEM_CREATE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_RE_IF_SEM_CREATE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_DETAILS1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_DETAILS1"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_CONTRACTTEMPLATE_INTER"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
