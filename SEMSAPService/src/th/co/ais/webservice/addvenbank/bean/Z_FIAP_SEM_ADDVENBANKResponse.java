/**
 * Z_FIAP_SEM_ADDVENBANKResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.addvenbank.bean;

import java.util.Arrays;

public class Z_FIAP_SEM_ADDVENBANKResponse  implements java.io.Serializable {
    private java.lang.String e_RETURNCODE;

    private th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES;

    public Z_FIAP_SEM_ADDVENBANKResponse() {
    }

    public Z_FIAP_SEM_ADDVENBANKResponse(
           java.lang.String e_RETURNCODE,
           th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES) {
           this.e_RETURNCODE = e_RETURNCODE;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the e_RETURNCODE value for this Z_FIAP_SEM_ADDVENBANKResponse.
     * 
     * @return e_RETURNCODE
     */
    public java.lang.String getE_RETURNCODE() {
        return e_RETURNCODE;
    }


    /**
     * Sets the e_RETURNCODE value for this Z_FIAP_SEM_ADDVENBANKResponse.
     * 
     * @param e_RETURNCODE
     */
    public void setE_RETURNCODE(java.lang.String e_RETURNCODE) {
        this.e_RETURNCODE = e_RETURNCODE;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_ADDVENBANKResponse.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_ADDVENBANKResponse.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.addvenbank.bean.ZSEM_MESSAGES_STRUC[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_ADDVENBANKResponse)) return false;
        Z_FIAP_SEM_ADDVENBANKResponse other = (Z_FIAP_SEM_ADDVENBANKResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.e_RETURNCODE==null && other.getE_RETURNCODE()==null) || 
             (this.e_RETURNCODE!=null &&
              this.e_RETURNCODE.equals(other.getE_RETURNCODE()))) &&
            ((this.t_MESSAGES==null && other.getT_MESSAGES()==null) || 
             (this.t_MESSAGES!=null &&
              java.util.Arrays.equals(this.t_MESSAGES, other.getT_MESSAGES())));
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
        if (getE_RETURNCODE() != null) {
            _hashCode += getE_RETURNCODE().hashCode();
        }
        if (getT_MESSAGES() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_MESSAGES());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_MESSAGES(), i);
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_ADDVENBANKResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_ADDVENBANK.Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_RETURNCODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_RETURNCODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZSEM_MESSAGES_STRUC"));
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

    
	@Override
	public String toString() {
		return "Z_FIAP_SEM_ADDVENBANKResponse [__equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + ", e_RETURNCODE="
				+ e_RETURNCODE + ", t_MESSAGES=" + Arrays.toString(t_MESSAGES)
				+ "]";
	}
    
	
}
