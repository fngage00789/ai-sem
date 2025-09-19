/**
 * SSOResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Permission.bean.ais.com;

import java.io.ObjectInputStream;

/**
 * /** 
 *  * 
 * @author  elmo_8201
 *  * /
 */
public class SSOResponse implements java.io.Serializable {
    private java.lang.String tokenId;

    private common.bean.ais.com.Message message;

    private Permission.bean.ais.com.SSOProgCode SSOProgCode;

    private Permission.bean.ais.com.SSOProgDesc[] SSOProgCodeList;

    private Permission.bean.ais.com.SSOCompCode[] SSOCompCode;

    private Permission.bean.ais.com.SSOEMailListDetail[] SSOEMailListDetail;

    private Permission.bean.ais.com.SSOAuthorizeSubmodule[] SSOAuthorizeSubmodule;

    private Permission.bean.ais.com.SSOProgCode[] SSOProgCodecArr;

    public SSOResponse() {
    }

    public SSOResponse(
           java.lang.String tokenId,
           common.bean.ais.com.Message message,
           Permission.bean.ais.com.SSOProgCode SSOProgCode,
           Permission.bean.ais.com.SSOProgDesc[] SSOProgCodeList,
           Permission.bean.ais.com.SSOCompCode[] SSOCompCode,
           Permission.bean.ais.com.SSOEMailListDetail[] SSOEMailListDetail,
           Permission.bean.ais.com.SSOAuthorizeSubmodule[] SSOAuthorizeSubmodule,
           Permission.bean.ais.com.SSOProgCode[] SSOProgCodecArr) {
           this.tokenId = tokenId;
           this.message = message;
           this.SSOProgCode = SSOProgCode;
           this.SSOProgCodeList = SSOProgCodeList;
           this.SSOCompCode = SSOCompCode;
           this.SSOEMailListDetail = SSOEMailListDetail;
           this.SSOAuthorizeSubmodule = SSOAuthorizeSubmodule;
           this.SSOProgCodecArr = SSOProgCodecArr;
    }


    /**
     * Gets the tokenId value for this SSOResponse.
     * 
     * @return tokenId
     */
    public java.lang.String getTokenId() {
        return tokenId;
    }


    /**
     * Sets the tokenId value for this SSOResponse.
     * 
     * @param tokenId
     */
    public void setTokenId(java.lang.String tokenId) {
        this.tokenId = tokenId;
    }


    /**
     * Gets the message value for this SSOResponse.
     * 
     * @return message
     */
    public common.bean.ais.com.Message getMessage() {
        return message;
    }


    /**
     * Sets the message value for this SSOResponse.
     * 
     * @param message
     */
    public void setMessage(common.bean.ais.com.Message message) {
        this.message = message;
    }


    /**
     * Gets the SSOProgCode value for this SSOResponse.
     * 
     * @return SSOProgCode
     */
    public Permission.bean.ais.com.SSOProgCode getSSOProgCode() {
        return SSOProgCode;
    }


    /**
     * Sets the SSOProgCode value for this SSOResponse.
     * 
     * @param SSOProgCode
     */
    public void setSSOProgCode(Permission.bean.ais.com.SSOProgCode SSOProgCode) {
        this.SSOProgCode = SSOProgCode;
    }


    /**
     * Gets the SSOProgCodeList value for this SSOResponse.
     * 
     * @return SSOProgCodeList
     */
    public Permission.bean.ais.com.SSOProgDesc[] getSSOProgCodeList() {
        return SSOProgCodeList;
    }


    /**
     * Sets the SSOProgCodeList value for this SSOResponse.
     * 
     * @param SSOProgCodeList
     */
    public void setSSOProgCodeList(Permission.bean.ais.com.SSOProgDesc[] SSOProgCodeList) {
        this.SSOProgCodeList = SSOProgCodeList;
    }

    public Permission.bean.ais.com.SSOProgDesc getSSOProgCodeList(int i) {
        return this.SSOProgCodeList[i];
    }

    public void setSSOProgCodeList(int i, Permission.bean.ais.com.SSOProgDesc _value) {
        this.SSOProgCodeList[i] = _value;
    }


    /**
     * Gets the SSOCompCode value for this SSOResponse.
     * 
     * @return SSOCompCode
     */
    public Permission.bean.ais.com.SSOCompCode[] getSSOCompCode() {
        return SSOCompCode;
    }


    /**
     * Sets the SSOCompCode value for this SSOResponse.
     * 
     * @param SSOCompCode
     */
    public void setSSOCompCode(Permission.bean.ais.com.SSOCompCode[] SSOCompCode) {
        this.SSOCompCode = SSOCompCode;
    }

    public Permission.bean.ais.com.SSOCompCode getSSOCompCode(int i) {
        return this.SSOCompCode[i];
    }

    public void setSSOCompCode(int i, Permission.bean.ais.com.SSOCompCode _value) {
        this.SSOCompCode[i] = _value;
    }


    /**
     * Gets the SSOEMailListDetail value for this SSOResponse.
     * 
     * @return SSOEMailListDetail
     */
    public Permission.bean.ais.com.SSOEMailListDetail[] getSSOEMailListDetail() {
        return SSOEMailListDetail;
    }


    /**
     * Sets the SSOEMailListDetail value for this SSOResponse.
     * 
     * @param SSOEMailListDetail
     */
    public void setSSOEMailListDetail(Permission.bean.ais.com.SSOEMailListDetail[] SSOEMailListDetail) {
        this.SSOEMailListDetail = SSOEMailListDetail;
    }

    public Permission.bean.ais.com.SSOEMailListDetail getSSOEMailListDetail(int i) {
        return this.SSOEMailListDetail[i];
    }

    public void setSSOEMailListDetail(int i, Permission.bean.ais.com.SSOEMailListDetail _value) {
        this.SSOEMailListDetail[i] = _value;
    }


    /**
     * Gets the SSOAuthorizeSubmodule value for this SSOResponse.
     * 
     * @return SSOAuthorizeSubmodule
     */
    public Permission.bean.ais.com.SSOAuthorizeSubmodule[] getSSOAuthorizeSubmodule() {
        return SSOAuthorizeSubmodule;
    }


    /**
     * Sets the SSOAuthorizeSubmodule value for this SSOResponse.
     * 
     * @param SSOAuthorizeSubmodule
     */
    public void setSSOAuthorizeSubmodule(Permission.bean.ais.com.SSOAuthorizeSubmodule[] SSOAuthorizeSubmodule) {
        this.SSOAuthorizeSubmodule = SSOAuthorizeSubmodule;
    }

    public Permission.bean.ais.com.SSOAuthorizeSubmodule getSSOAuthorizeSubmodule(int i) {
        return this.SSOAuthorizeSubmodule[i];
    }

    public void setSSOAuthorizeSubmodule(int i, Permission.bean.ais.com.SSOAuthorizeSubmodule _value) {
        this.SSOAuthorizeSubmodule[i] = _value;
    }


    /**
     * Gets the SSOProgCodecArr value for this SSOResponse.
     * 
     * @return SSOProgCodecArr
     */
    public Permission.bean.ais.com.SSOProgCode[] getSSOProgCodecArr() {
        return SSOProgCodecArr;
    }


    /**
     * Sets the SSOProgCodecArr value for this SSOResponse.
     * 
     * @param SSOProgCodecArr
     */
    public void setSSOProgCodecArr(Permission.bean.ais.com.SSOProgCode[] SSOProgCodecArr) {
        this.SSOProgCodecArr = SSOProgCodecArr;
    }

    public Permission.bean.ais.com.SSOProgCode getSSOProgCodecArr(int i) {
        return this.SSOProgCodecArr[i];
    }

    public void setSSOProgCodecArr(int i, Permission.bean.ais.com.SSOProgCode _value) {
        this.SSOProgCodecArr[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SSOResponse)) return false;
        SSOResponse other = (SSOResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tokenId==null && other.getTokenId()==null) || 
             (this.tokenId!=null &&
              this.tokenId.equals(other.getTokenId()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.SSOProgCode==null && other.getSSOProgCode()==null) || 
             (this.SSOProgCode!=null &&
              this.SSOProgCode.equals(other.getSSOProgCode()))) &&
            ((this.SSOProgCodeList==null && other.getSSOProgCodeList()==null) || 
             (this.SSOProgCodeList!=null &&
              java.util.Arrays.equals(this.SSOProgCodeList, other.getSSOProgCodeList()))) &&
            ((this.SSOCompCode==null && other.getSSOCompCode()==null) || 
             (this.SSOCompCode!=null &&
              java.util.Arrays.equals(this.SSOCompCode, other.getSSOCompCode()))) &&
            ((this.SSOEMailListDetail==null && other.getSSOEMailListDetail()==null) || 
             (this.SSOEMailListDetail!=null &&
              java.util.Arrays.equals(this.SSOEMailListDetail, other.getSSOEMailListDetail()))) &&
            ((this.SSOAuthorizeSubmodule==null && other.getSSOAuthorizeSubmodule()==null) || 
             (this.SSOAuthorizeSubmodule!=null &&
              java.util.Arrays.equals(this.SSOAuthorizeSubmodule, other.getSSOAuthorizeSubmodule()))) &&
            ((this.SSOProgCodecArr==null && other.getSSOProgCodecArr()==null) || 
             (this.SSOProgCodecArr!=null &&
              java.util.Arrays.equals(this.SSOProgCodecArr, other.getSSOProgCodecArr())));
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
        if (getTokenId() != null) {
            _hashCode += getTokenId().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getSSOProgCode() != null) {
            _hashCode += getSSOProgCode().hashCode();
        }
        if (getSSOProgCodeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSSOProgCodeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSSOProgCodeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSSOCompCode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSSOCompCode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSSOCompCode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSSOEMailListDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSSOEMailListDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSSOEMailListDetail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSSOAuthorizeSubmodule() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSSOAuthorizeSubmodule());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSSOAuthorizeSubmodule(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSSOProgCodecArr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSSOProgCodecArr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSSOProgCodecArr(), i);
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
        new org.apache.axis.description.TypeDesc(SSOResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenId");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "TokenId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.common", "Message"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOProgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCode"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOProgCodeList");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCodeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgDesc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOCompCode");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOCompCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOCompCode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOEMailListDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOEMailListDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOEMailListDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOAuthorizeSubmodule");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOAuthorizeSubmodule"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOAuthorizeSubmodule"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SSOProgCodecArr");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCodecArr"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.Permission", "SSOProgCode"));
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
