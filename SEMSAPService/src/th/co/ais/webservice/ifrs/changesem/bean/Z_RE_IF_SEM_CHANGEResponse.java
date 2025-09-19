/**
 * Z_RE_IF_SEM_CHANGEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.ifrs.changesem.bean;

public class Z_RE_IF_SEM_CHANGEResponse  implements java.io.Serializable {
    /* SAP Contract creatred Response */
    private th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CHANGERESPONSE[] CONTRACTRESPONSE;

    public Z_RE_IF_SEM_CHANGEResponse() {
    }

    public Z_RE_IF_SEM_CHANGEResponse(
           th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CHANGERESPONSE[] CONTRACTRESPONSE) {
           this.CONTRACTRESPONSE = CONTRACTRESPONSE;
    }


    /**
     * Gets the CONTRACTRESPONSE value for this Z_RE_IF_SEM_CHANGEResponse.
     * 
     * @return CONTRACTRESPONSE   * SAP Contract creatred Response
     */
    public th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CHANGERESPONSE[] getCONTRACTRESPONSE() {
        return CONTRACTRESPONSE;
    }


    /**
     * Sets the CONTRACTRESPONSE value for this Z_RE_IF_SEM_CHANGEResponse.
     * 
     * @param CONTRACTRESPONSE   * SAP Contract creatred Response
     */
    public void setCONTRACTRESPONSE(th.co.ais.webservice.ifrs.changesem.bean.ZREIF_S_SEM_CHANGERESPONSE[] CONTRACTRESPONSE) {
        this.CONTRACTRESPONSE = CONTRACTRESPONSE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_RE_IF_SEM_CHANGEResponse)) return false;
        Z_RE_IF_SEM_CHANGEResponse other = (Z_RE_IF_SEM_CHANGEResponse) obj;
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
        new org.apache.axis.description.TypeDesc(Z_RE_IF_SEM_CHANGEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_RE_IF_SEM_CHANGE.Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTRACTRESPONSE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTRACTRESPONSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZREIF_S_SEM_CHANGERESPONSE"));
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
