/**
 * EmployeeServiceWebServiceV2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ais.websrv;

import th.co.ais.web.util.WebUtil;

public class EmployeeServiceWebServiceV2ServiceLocator extends org.apache.axis.client.Service implements com.ais.websrv.EmployeeServiceWebServiceV2Service {

    public EmployeeServiceWebServiceV2ServiceLocator() {
    }


    public EmployeeServiceWebServiceV2ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeServiceWebServiceV2ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeServiceWebServiceV2SoapPort
    //private java.lang.String EmployeeServiceWebServiceV2SoapPort_address = "http://10.240.1.101:7201/EmployeeServiceWebServiceV2/EmployeeServiceWebServiceV2.jws";
    private java.lang.String EmployeeServiceWebServiceV2SoapPort_address = WebUtil.getResources("resources.application_th","wsEmployeeURL");

    public java.lang.String getEmployeeServiceWebServiceV2SoapPortAddress() {
        return EmployeeServiceWebServiceV2SoapPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeServiceWebServiceV2SoapPortWSDDServiceName = "EmployeeServiceWebServiceV2SoapPort";

    public java.lang.String getEmployeeServiceWebServiceV2SoapPortWSDDServiceName() {
        return EmployeeServiceWebServiceV2SoapPortWSDDServiceName;
    }

    public void setEmployeeServiceWebServiceV2SoapPortWSDDServiceName(java.lang.String name) {
        EmployeeServiceWebServiceV2SoapPortWSDDServiceName = name;
    }

    public com.ais.websrv.EmployeeServiceWebServiceV2 getEmployeeServiceWebServiceV2SoapPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeServiceWebServiceV2SoapPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeServiceWebServiceV2SoapPort(endpoint);
    }

    public com.ais.websrv.EmployeeServiceWebServiceV2 getEmployeeServiceWebServiceV2SoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ais.websrv.EmployeeServiceWebServiceV2ServiceSoapBindingStub _stub = new com.ais.websrv.EmployeeServiceWebServiceV2ServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeServiceWebServiceV2SoapPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeServiceWebServiceV2SoapPortEndpointAddress(java.lang.String address) {
        EmployeeServiceWebServiceV2SoapPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ais.websrv.EmployeeServiceWebServiceV2.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ais.websrv.EmployeeServiceWebServiceV2ServiceSoapBindingStub _stub = new com.ais.websrv.EmployeeServiceWebServiceV2ServiceSoapBindingStub(new java.net.URL(EmployeeServiceWebServiceV2SoapPort_address), this);
                _stub.setPortName(getEmployeeServiceWebServiceV2SoapPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeServiceWebServiceV2SoapPort".equals(inputPortName)) {
            return getEmployeeServiceWebServiceV2SoapPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://com/ais/websrv", "EmployeeServiceWebServiceV2Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://com/ais/websrv", "EmployeeServiceWebServiceV2SoapPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeServiceWebServiceV2SoapPort".equals(portName)) {
            setEmployeeServiceWebServiceV2SoapPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
