/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package common.bean.ais.com;

public class Message  implements java.io.Serializable {
    /* /** 
     *  * 
     * @return Returns the errorCode.
     *  * / */
    private java.lang.String errorCode;

    /* /** 
     *  * 
     * @return Returns the tokenId.
     *  * / */
    private java.lang.String tokenId;

    /* /** 
     *  * 
     * @return Returns the errorMesg.
     *  * / */
    private java.lang.String errorMesg;

    /* /** 
     *  * 
     * @return Returns the flag.
     *  * / */
    private boolean flag;

    /* /** 
     *  * 
     * @return Returns the serviceName.
     *  * / */
    private java.lang.String serviceName;

    /* /** 
     *  * 
     * @return Returns the type.
     *  * / */
    private int type;

    /* /** 
     *  * 
     * @return Returns the serviceType.
     *  * / */
    private java.lang.String serviceType;

    public Message() {
    }

    public Message(
           java.lang.String errorCode,
           java.lang.String tokenId,
           java.lang.String errorMesg,
           boolean flag,
           java.lang.String serviceName,
           int type,
           java.lang.String serviceType) {
           this.errorCode = errorCode;
           this.tokenId = tokenId;
           this.errorMesg = errorMesg;
           this.flag = flag;
           this.serviceName = serviceName;
           this.type = type;
           this.serviceType = serviceType;
    }


    /**
     * Gets the errorCode value for this Message.
     * 
     * @return errorCode   * /** 
     *  * 
     * @return Returns the errorCode.
     *  * /
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this Message.
     * 
     * @param errorCode   * /** 
     *  * 
     * @return Returns the errorCode.
     *  * /
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the tokenId value for this Message.
     * 
     * @return tokenId   * /** 
     *  * 
     * @return Returns the tokenId.
     *  * /
     */
    public java.lang.String getTokenId() {
        return tokenId;
    }


    /**
     * Sets the tokenId value for this Message.
     * 
     * @param tokenId   * /** 
     *  * 
     * @return Returns the tokenId.
     *  * /
     */
    public void setTokenId(java.lang.String tokenId) {
        this.tokenId = tokenId;
    }


    /**
     * Gets the errorMesg value for this Message.
     * 
     * @return errorMesg   * /** 
     *  * 
     * @return Returns the errorMesg.
     *  * /
     */
    public java.lang.String getErrorMesg() {
        return errorMesg;
    }


    /**
     * Sets the errorMesg value for this Message.
     * 
     * @param errorMesg   * /** 
     *  * 
     * @return Returns the errorMesg.
     *  * /
     */
    public void setErrorMesg(java.lang.String errorMesg) {
        this.errorMesg = errorMesg;
    }


    /**
     * Gets the flag value for this Message.
     * 
     * @return flag   * /** 
     *  * 
     * @return Returns the flag.
     *  * /
     */
    public boolean isFlag() {
        return flag;
    }


    /**
     * Sets the flag value for this Message.
     * 
     * @param flag   * /** 
     *  * 
     * @return Returns the flag.
     *  * /
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    /**
     * Gets the serviceName value for this Message.
     * 
     * @return serviceName   * /** 
     *  * 
     * @return Returns the serviceName.
     *  * /
     */
    public java.lang.String getServiceName() {
        return serviceName;
    }


    /**
     * Sets the serviceName value for this Message.
     * 
     * @param serviceName   * /** 
     *  * 
     * @return Returns the serviceName.
     *  * /
     */
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }


    /**
     * Gets the type value for this Message.
     * 
     * @return type   * /** 
     *  * 
     * @return Returns the type.
     *  * /
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this Message.
     * 
     * @param type   * /** 
     *  * 
     * @return Returns the type.
     *  * /
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Gets the serviceType value for this Message.
     * 
     * @return serviceType   * /** 
     *  * 
     * @return Returns the serviceType.
     *  * /
     */
    public java.lang.String getServiceType() {
        return serviceType;
    }


    /**
     * Sets the serviceType value for this Message.
     * 
     * @param serviceType   * /** 
     *  * 
     * @return Returns the serviceType.
     *  * /
     */
    public void setServiceType(java.lang.String serviceType) {
        this.serviceType = serviceType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Message)) return false;
        Message other = (Message) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.tokenId==null && other.getTokenId()==null) || 
             (this.tokenId!=null &&
              this.tokenId.equals(other.getTokenId()))) &&
            ((this.errorMesg==null && other.getErrorMesg()==null) || 
             (this.errorMesg!=null &&
              this.errorMesg.equals(other.getErrorMesg()))) &&
            this.flag == other.isFlag() &&
            ((this.serviceName==null && other.getServiceName()==null) || 
             (this.serviceName!=null &&
              this.serviceName.equals(other.getServiceName()))) &&
            this.type == other.getType() &&
            ((this.serviceType==null && other.getServiceType()==null) || 
             (this.serviceType!=null &&
              this.serviceType.equals(other.getServiceType())));
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
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getTokenId() != null) {
            _hashCode += getTokenId().hashCode();
        }
        if (getErrorMesg() != null) {
            _hashCode += getErrorMesg().hashCode();
        }
        _hashCode += (isFlag() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getServiceName() != null) {
            _hashCode += getServiceName().hashCode();
        }
        _hashCode += getType();
        if (getServiceType() != null) {
            _hashCode += getServiceType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:com.ais.bean.common", "Message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenId");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "TokenId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMesg");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "ErrorMesg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flag");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "Flag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "ServiceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("java:com.ais.bean.common", "ServiceType"));
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
