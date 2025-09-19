/**
 * SSOAuthorizeSubmodule.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Permission.bean.ais.com;


/**
 * /** 
 *  * 
 * @author  p_narue
 *  * /
 */
public class SSOAuthorizeSubmodule  implements java.io.Serializable {
    private Permission.bean.ais.com.SSOProgCode SSOProgCode;

    private Permission.bean.ais.com.SSOSubmodule SSOSubmodule;

    public SSOAuthorizeSubmodule() {
    }

    public SSOAuthorizeSubmodule(
           Permission.bean.ais.com.SSOProgCode SSOProgCode,
           Permission.bean.ais.com.SSOSubmodule SSOSubmodule) {
           this.SSOProgCode = SSOProgCode;
           this.SSOSubmodule = SSOSubmodule;
    }


    /**
     * Gets the SSOProgCode value for this SSOAuthorizeSubmodule.
     * 
     * @return SSOProgCode
     */
    public Permission.bean.ais.com.SSOProgCode getSSOProgCode() {
        return SSOProgCode;
    }


    /**
     * Sets the SSOProgCode value for this SSOAuthorizeSubmodule.
     * 
     * @param SSOProgCode
     */
    public void setSSOProgCode(Permission.bean.ais.com.SSOProgCode SSOProgCode) {
        this.SSOProgCode = SSOProgCode;
    }


    /**
     * Gets the SSOSubmodule value for this SSOAuthorizeSubmodule.
     * 
     * @return SSOSubmodule
     */
    public Permission.bean.ais.com.SSOSubmodule getSSOSubmodule() {
        return SSOSubmodule;
    }


    /**
     * Sets the SSOSubmodule value for this SSOAuthorizeSubmodule.
     * 
     * @param SSOSubmodule
     */
    public void setSSOSubmodule(Permission.bean.ais.com.SSOSubmodule SSOSubmodule) {
        this.SSOSubmodule = SSOSubmodule;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SSOAuthorizeSubmodule)) return false;
        SSOAuthorizeSubmodule other = (SSOAuthorizeSubmodule) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SSOProgCode==null && other.getSSOProgCode()==null) || 
             (this.SSOProgCode!=null &&
              this.SSOProgCode.equals(other.getSSOProgCode()))) &&
            ((this.SSOSubmodule==null && other.getSSOSubmodule()==null) || 
             (this.SSOSubmodule!=null &&
              this.SSOSubmodule.equals(other.getSSOSubmodule())));
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
        if (getSSOProgCode() != null) {
            _hashCode += getSSOProgCode().hashCode();
        }
        if (getSSOSubmodule() != null) {
            _hashCode += getSSOSubmodule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SSOAuthorizeSubmodule.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOAuthorizeSubmodule"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOProgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOSubmodule");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOSubmodule"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOSubmodule"));
        elemField.setNillable(true);
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
