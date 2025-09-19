/**
 * Z_RE_IF_SEM_CREATEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ais.sem.ifrs16.webservice.cresem.bean;

public class Z_RE_IF_SEM_CREATEResponse  implements java.io.Serializable {
    /* SAP Contract creatred Response */
    private com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE[] CONTRACTRESPONSE;

    public Z_RE_IF_SEM_CREATEResponse() {
    }

    public Z_RE_IF_SEM_CREATEResponse(
           com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE[] CONTRACTRESPONSE) {
           this.CONTRACTRESPONSE = CONTRACTRESPONSE;
    }


    /**
     * Gets the CONTRACTRESPONSE value for this Z_RE_IF_SEM_CREATEResponse.
     * 
     * @return CONTRACTRESPONSE   * SAP Contract creatred Response
     */
    public com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE[] getCONTRACTRESPONSE() {
        return CONTRACTRESPONSE;
    }


    /**
     * Sets the CONTRACTRESPONSE value for this Z_RE_IF_SEM_CREATEResponse.
     * 
     * @param CONTRACTRESPONSE   * SAP Contract creatred Response
     */
    public void setCONTRACTRESPONSE(com.ais.sem.ifrs16.webservice.cresem.bean.ZREIF_S_CONTRACTRESPONSE[] CONTRACTRESPONSE) {
        this.CONTRACTRESPONSE = CONTRACTRESPONSE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_RE_IF_SEM_CREATEResponse)) return false;
        Z_RE_IF_SEM_CREATEResponse other = (Z_RE_IF_SEM_CREATEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CONTRACTRESPONSE==null && other.getCONTRACTRESPONSE()==null) || 
             (this.CONTRACTRESPONSE!=null &&
              java.util.Arrays.equals(this.CONTRACTRESPONSE, other.getCONTRACTRESPONSE())));
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
        if (getCONTRACTRESPONSE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCONTRACTRESPONSE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCONTRACTRESPONSE(), i);
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
        new org.apache.axis.description.TypeDesc(Z_RE_IF_SEM_CREATEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_RE_IF_SEM_CREATE.Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACTRESPONSE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACTRESPONSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_CONTRACTRESPONSE"));
        elemField.setMinOccurs(0);
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
