/**
 * Z_RE_IF_SEM_CHANGE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.ifrs.changesem.bean;

public class Z_RE_IF_SEM_CHANGE  implements java.io.Serializable {
    /* SEM/TFM Contract Upload */
    private th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CONTRACT_CHANGE_IN[] CONTRACT_DETAILS;

    public Z_RE_IF_SEM_CHANGE() {
    }

    public Z_RE_IF_SEM_CHANGE(
           th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CONTRACT_CHANGE_IN[] CONTRACT_DETAILS) {
           this.CONTRACT_DETAILS = CONTRACT_DETAILS;
    }


    /**
     * Gets the CONTRACT_DETAILS value for this Z_RE_IF_SEM_CHANGE.
     * 
     * @return CONTRACT_DETAILS   * SEM/TFM Contract Upload
     */
    public th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CONTRACT_CHANGE_IN[] getCONTRACT_DETAILS() {
        return CONTRACT_DETAILS;
    }


    /**
     * Sets the CONTRACT_DETAILS value for this Z_RE_IF_SEM_CHANGE.
     * 
     * @param CONTRACT_DETAILS   * SEM/TFM Contract Upload
     */
    public void setCONTRACT_DETAILS(th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CONTRACT_CHANGE_IN[] CONTRACT_DETAILS) {
        this.CONTRACT_DETAILS = CONTRACT_DETAILS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_RE_IF_SEM_CHANGE)) return false;
        Z_RE_IF_SEM_CHANGE other = (Z_RE_IF_SEM_CHANGE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CONTRACT_DETAILS==null && other.getCONTRACT_DETAILS()==null) || 
             (this.CONTRACT_DETAILS!=null &&
              java.util.Arrays.equals(this.CONTRACT_DETAILS, other.getCONTRACT_DETAILS())));
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
        if (getCONTRACT_DETAILS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCONTRACT_DETAILS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCONTRACT_DETAILS(), i);
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
        new org.apache.axis.description.TypeDesc(Z_RE_IF_SEM_CHANGE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_RE_IF_SEM_CHANGE"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACT_DETAILS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACT_DETAILS"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_SEM_CONTRACT_CHANGE_IN"));
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
