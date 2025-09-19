/**
 * SSOSubmodule.java
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
public class SSOSubmodule  implements java.io.Serializable {
    private java.lang.String subModuleName;

    private java.lang.String subModuleDesc;

    public SSOSubmodule() {
    }

    public SSOSubmodule(
           java.lang.String subModuleName,
           java.lang.String subModuleDesc) {
           this.subModuleName = subModuleName;
           this.subModuleDesc = subModuleDesc;
    }


    /**
     * Gets the subModuleName value for this SSOSubmodule.
     * 
     * @return subModuleName
     */
    public java.lang.String getSubModuleName() {
        return subModuleName;
    }


    /**
     * Sets the subModuleName value for this SSOSubmodule.
     * 
     * @param subModuleName
     */
    public void setSubModuleName(java.lang.String subModuleName) {
        this.subModuleName = subModuleName;
    }


    /**
     * Gets the subModuleDesc value for this SSOSubmodule.
     * 
     * @return subModuleDesc
     */
    public java.lang.String getSubModuleDesc() {
        return subModuleDesc;
    }


    /**
     * Sets the subModuleDesc value for this SSOSubmodule.
     * 
     * @param subModuleDesc
     */
    public void setSubModuleDesc(java.lang.String subModuleDesc) {
        this.subModuleDesc = subModuleDesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SSOSubmodule)) return false;
        SSOSubmodule other = (SSOSubmodule) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subModuleName==null && other.getSubModuleName()==null) || 
             (this.subModuleName!=null &&
              this.subModuleName.equals(other.getSubModuleName()))) &&
            ((this.subModuleDesc==null && other.getSubModuleDesc()==null) || 
             (this.subModuleDesc!=null &&
              this.subModuleDesc.equals(other.getSubModuleDesc())));
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
        if (getSubModuleName() != null) {
            _hashCode += getSubModuleName().hashCode();
        }
        if (getSubModuleDesc() != null) {
            _hashCode += getSubModuleDesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SSOSubmodule.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOSubmodule"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subModuleName");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SubModuleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subModuleDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SubModuleDesc"));
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
