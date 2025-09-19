/**
 * SSOProgDesc.java
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
public class SSOProgDesc  implements java.io.Serializable {
    private java.lang.String progCode;

    private java.lang.String progDesc;

    public SSOProgDesc() {
    }

    public SSOProgDesc(
           java.lang.String progCode,
           java.lang.String progDesc) {
           this.progCode = progCode;
           this.progDesc = progDesc;
    }


    /**
     * Gets the progCode value for this SSOProgDesc.
     * 
     * @return progCode
     */
    public java.lang.String getProgCode() {
        return progCode;
    }


    /**
     * Sets the progCode value for this SSOProgDesc.
     * 
     * @param progCode
     */
    public void setProgCode(java.lang.String progCode) {
        this.progCode = progCode;
    }


    /**
     * Gets the progDesc value for this SSOProgDesc.
     * 
     * @return progDesc
     */
    public java.lang.String getProgDesc() {
        return progDesc;
    }


    /**
     * Sets the progDesc value for this SSOProgDesc.
     * 
     * @param progDesc
     */
    public void setProgDesc(java.lang.String progDesc) {
        this.progDesc = progDesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SSOProgDesc)) return false;
        SSOProgDesc other = (SSOProgDesc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.progCode==null && other.getProgCode()==null) || 
             (this.progCode!=null &&
              this.progCode.equals(other.getProgCode()))) &&
            ((this.progDesc==null && other.getProgDesc()==null) || 
             (this.progDesc!=null &&
              this.progDesc.equals(other.getProgDesc())));
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
        if (getProgCode() != null) {
            _hashCode += getProgCode().hashCode();
        }
        if (getProgDesc() != null) {
            _hashCode += getProgDesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SSOProgDesc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgDesc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progCode");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "ProgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("progDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "ProgDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
