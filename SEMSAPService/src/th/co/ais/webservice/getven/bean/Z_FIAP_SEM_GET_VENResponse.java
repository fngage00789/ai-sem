/**
 * Z_FIAP_SEM_GET_VENResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package th.co.ais.webservice.getven.bean;

import java.util.Arrays;

public class Z_FIAP_SEM_GET_VENResponse  implements java.io.Serializable {
    private th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR;

    private th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX;

    private java.lang.String e_RETURNCODE;

    private th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL;

    private th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX;

    private th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE;

    private th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE;

    private th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL;

    private th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES;

    public Z_FIAP_SEM_GET_VENResponse() {
    }

    public Z_FIAP_SEM_GET_VENResponse(
           th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR,
           th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX,
           java.lang.String e_RETURNCODE,
           th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL,
           th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX,
           th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE,
           th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE,
           th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL,
           th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES) {
           this.c_VENDOR = c_VENDOR;
           this.c_WTAX = c_WTAX;
           this.e_RETURNCODE = e_RETURNCODE;
           this.g_EMAIL = g_EMAIL;
           this.g_FAX = g_FAX;
           this.g_MOBILE = g_MOBILE;
           this.g_PROFILE = g_PROFILE;
           this.g_TEL = g_TEL;
           this.t_MESSAGES = t_MESSAGES;
    }


    /**
     * Gets the c_VENDOR value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return c_VENDOR
     */
    public th.co.ais.webservice.getven.bean.ZCVENDOR[] getC_VENDOR() {
        return c_VENDOR;
    }


    /**
     * Sets the c_VENDOR value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param c_VENDOR
     */
    public void setC_VENDOR(th.co.ais.webservice.getven.bean.ZCVENDOR[] c_VENDOR) {
        this.c_VENDOR = c_VENDOR;
    }


    /**
     * Gets the c_WTAX value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return c_WTAX
     */
    public th.co.ais.webservice.getven.bean.ZCWTAX[] getC_WTAX() {
        return c_WTAX;
    }


    /**
     * Sets the c_WTAX value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param c_WTAX
     */
    public void setC_WTAX(th.co.ais.webservice.getven.bean.ZCWTAX[] c_WTAX) {
        this.c_WTAX = c_WTAX;
    }


    /**
     * Gets the e_RETURNCODE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return e_RETURNCODE
     */
    public java.lang.String getE_RETURNCODE() {
        return e_RETURNCODE;
    }


    /**
     * Sets the e_RETURNCODE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param e_RETURNCODE
     */
    public void setE_RETURNCODE(java.lang.String e_RETURNCODE) {
        this.e_RETURNCODE = e_RETURNCODE;
    }


    /**
     * Gets the g_EMAIL value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return g_EMAIL
     */
    public th.co.ais.webservice.getven.bean.ZGEMAIL[] getG_EMAIL() {
        return g_EMAIL;
    }


    /**
     * Sets the g_EMAIL value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param g_EMAIL
     */
    public void setG_EMAIL(th.co.ais.webservice.getven.bean.ZGEMAIL[] g_EMAIL) {
        this.g_EMAIL = g_EMAIL;
    }


    /**
     * Gets the g_FAX value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return g_FAX
     */
    public th.co.ais.webservice.getven.bean.ZGFAX[] getG_FAX() {
        return g_FAX;
    }


    /**
     * Sets the g_FAX value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param g_FAX
     */
    public void setG_FAX(th.co.ais.webservice.getven.bean.ZGFAX[] g_FAX) {
        this.g_FAX = g_FAX;
    }


    /**
     * Gets the g_MOBILE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return g_MOBILE
     */
    public th.co.ais.webservice.getven.bean.ZGMOBILE[] getG_MOBILE() {
        return g_MOBILE;
    }


    /**
     * Sets the g_MOBILE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param g_MOBILE
     */
    public void setG_MOBILE(th.co.ais.webservice.getven.bean.ZGMOBILE[] g_MOBILE) {
        this.g_MOBILE = g_MOBILE;
    }


    /**
     * Gets the g_PROFILE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return g_PROFILE
     */
    public th.co.ais.webservice.getven.bean.ZGPROFILE[] getG_PROFILE() {
        return g_PROFILE;
    }


    /**
     * Sets the g_PROFILE value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param g_PROFILE
     */
    public void setG_PROFILE(th.co.ais.webservice.getven.bean.ZGPROFILE[] g_PROFILE) {
        this.g_PROFILE = g_PROFILE;
    }


    /**
     * Gets the g_TEL value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return g_TEL
     */
    public th.co.ais.webservice.getven.bean.ZGTEL[] getG_TEL() {
        return g_TEL;
    }


    /**
     * Sets the g_TEL value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param g_TEL
     */
    public void setG_TEL(th.co.ais.webservice.getven.bean.ZGTEL[] g_TEL) {
        this.g_TEL = g_TEL;
    }


    /**
     * Gets the t_MESSAGES value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @return t_MESSAGES
     */
    public th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] getT_MESSAGES() {
        return t_MESSAGES;
    }


    /**
     * Sets the t_MESSAGES value for this Z_FIAP_SEM_GET_VENResponse.
     * 
     * @param t_MESSAGES
     */
    public void setT_MESSAGES(th.co.ais.webservice.getven.bean.EBPP_MESSAGES[] t_MESSAGES) {
        this.t_MESSAGES = t_MESSAGES;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_FIAP_SEM_GET_VENResponse)) return false;
        Z_FIAP_SEM_GET_VENResponse other = (Z_FIAP_SEM_GET_VENResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.c_VENDOR==null && other.getC_VENDOR()==null) || 
             (this.c_VENDOR!=null &&
              java.util.Arrays.equals(this.c_VENDOR, other.getC_VENDOR()))) &&
            ((this.c_WTAX==null && other.getC_WTAX()==null) || 
             (this.c_WTAX!=null &&
              java.util.Arrays.equals(this.c_WTAX, other.getC_WTAX()))) &&
            ((this.e_RETURNCODE==null && other.getE_RETURNCODE()==null) || 
             (this.e_RETURNCODE!=null &&
              this.e_RETURNCODE.equals(other.getE_RETURNCODE()))) &&
            ((this.g_EMAIL==null && other.getG_EMAIL()==null) || 
             (this.g_EMAIL!=null &&
              java.util.Arrays.equals(this.g_EMAIL, other.getG_EMAIL()))) &&
            ((this.g_FAX==null && other.getG_FAX()==null) || 
             (this.g_FAX!=null &&
              java.util.Arrays.equals(this.g_FAX, other.getG_FAX()))) &&
            ((this.g_MOBILE==null && other.getG_MOBILE()==null) || 
             (this.g_MOBILE!=null &&
              java.util.Arrays.equals(this.g_MOBILE, other.getG_MOBILE()))) &&
            ((this.g_PROFILE==null && other.getG_PROFILE()==null) || 
             (this.g_PROFILE!=null &&
              java.util.Arrays.equals(this.g_PROFILE, other.getG_PROFILE()))) &&
            ((this.g_TEL==null && other.getG_TEL()==null) || 
             (this.g_TEL!=null &&
              java.util.Arrays.equals(this.g_TEL, other.getG_TEL()))) &&
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
        if (getC_VENDOR() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getC_VENDOR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getC_VENDOR(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getC_WTAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getC_WTAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getC_WTAX(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getE_RETURNCODE() != null) {
            _hashCode += getE_RETURNCODE().hashCode();
        }
        if (getG_EMAIL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_EMAIL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_EMAIL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_FAX() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_FAX());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_FAX(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_MOBILE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_MOBILE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_MOBILE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_PROFILE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_PROFILE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_PROFILE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getG_TEL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getG_TEL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getG_TEL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        new org.apache.axis.description.TypeDesc(Z_FIAP_SEM_GET_VENResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", ">Z_FIAP_SEM_GET_VEN.Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c_VENDOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "C_VENDOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZCVENDOR"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("c_WTAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "C_WTAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZCWTAX"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("e_RETURNCODE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "E_RETURNCODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_EMAIL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_EMAIL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGEMAIL"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_FAX");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_FAX"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGFAX"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_MOBILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_MOBILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGMOBILE"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_PROFILE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_PROFILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGPROFILE"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("g_TEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "G_TEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZGTEL"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_MESSAGES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_MESSAGES"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "EBPP_MESSAGES"));
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
		return "Z_FIAP_SEM_GET_VENResponse [__equalsCalc=" + __equalsCalc
				+ ", __hashCodeCalc=" + __hashCodeCalc + ", c_VENDOR="
				+ Arrays.toString(c_VENDOR) + ", c_WTAX="
				+ Arrays.toString(c_WTAX) + ", e_RETURNCODE=" + e_RETURNCODE
				+ ", g_EMAIL=" + Arrays.toString(g_EMAIL) + ", g_FAX="
				+ Arrays.toString(g_FAX) + ", g_MOBILE="
				+ Arrays.toString(g_MOBILE) + ", g_PROFILE="
				+ Arrays.toString(g_PROFILE) + ", g_TEL="
				+ Arrays.toString(g_TEL) + ", t_MESSAGES="
				+ Arrays.toString(t_MESSAGES) + "]";
	}
	

}
