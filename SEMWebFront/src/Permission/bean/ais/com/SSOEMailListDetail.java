/**
 * SSOEMailListDetail.java
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
public class SSOEMailListDetail  implements java.io.Serializable {
    private Permission.bean.ais.com.SSOProgCode SSOProgCode;

    private Permission.bean.ais.com.SSOSubmodule SSOSubmodule;

    private java.lang.String[] emailList;

    public SSOEMailListDetail() {
    }

    public SSOEMailListDetail(
           Permission.bean.ais.com.SSOProgCode SSOProgCode,
           Permission.bean.ais.com.SSOSubmodule SSOSubmodule,
           java.lang.String[] emailList) {
           this.SSOProgCode = SSOProgCode;
           this.SSOSubmodule = SSOSubmodule;
           this.emailList = emailList;
    }


    /**
     * Gets the SSOProgCode value for this SSOEMailListDetail.
     * 
     * @return SSOProgCode
     */
    public Permission.bean.ais.com.SSOProgCode getSSOProgCode() {
        return SSOProgCode;
    }


    /**
     * Sets the SSOProgCode value for this SSOEMailListDetail.
     * 
     * @param SSOProgCode
     */
    public void setSSOProgCode(Permission.bean.ais.com.SSOProgCode SSOProgCode) {
        this.SSOProgCode = SSOProgCode;
    }


    /**
     * Gets the SSOSubmodule value for this SSOEMailListDetail.
     * 
     * @return SSOSubmodule
     */
    public Permission.bean.ais.com.SSOSubmodule getSSOSubmodule() {
        return SSOSubmodule;
    }


    /**
     * Sets the SSOSubmodule value for this SSOEMailListDetail.
     * 
     * @param SSOSubmodule
     */
    public void setSSOSubmodule(Permission.bean.ais.com.SSOSubmodule SSOSubmodule) {
        this.SSOSubmodule = SSOSubmodule;
    }


    /**
     * Gets the emailList value for this SSOEMailListDetail.
     * 
     * @return emailList
     */
    public java.lang.String[] getEmailList() {
        return emailList;
    }


    /**
     * Sets the emailList value for this SSOEMailListDetail.
     * 
     * @param emailList
     */
    public void setEmailList(java.lang.String[] emailList) {
        this.emailList = emailList;
    }

    public java.lang.String getEmailList(int i) {
        return this.emailList[i];
    }

    public void setEmailList(int i, java.lang.String _value) {
        this.emailList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SSOEMailListDetail)) return false;
        SSOEMailListDetail other = (SSOEMailListDetail) obj;
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
              this.SSOSubmodule.equals(other.getSSOSubmodule()))) &&
            ((this.emailList==null && other.getEmailList()==null) || 
             (this.emailList!=null &&
              java.util.Arrays.equals(this.emailList, other.getEmailList())));
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
        if (getEmailList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEmailList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEmailList(), i);
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
        new org.apache.axis.description.TypeDesc(SSOEMailListDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOEMailListDetail"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailList");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "EmailList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
