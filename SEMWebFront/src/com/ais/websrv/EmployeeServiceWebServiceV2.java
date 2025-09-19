/**
 * EmployeeServiceWebServiceV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ais.websrv;

public interface EmployeeServiceWebServiceV2 extends java.rmi.Remote {
    public Permission.bean.ais.com.SSOResponse getUserEmailListOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getProgCodeRoot(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse syncUserSession(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse decreaseCounter(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getAllPermission(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getAuthorizeOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse logOut(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getProgCode(java.lang.String tokenId) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getPermission(java.lang.String tokenId, java.lang.String progCode) throws java.rmi.RemoteException;
    public Permission.bean.ais.com.SSOResponse getToken(java.lang.String username, java.lang.String password, java.lang.String module, java.lang.String ou_type, java.lang.String projectCode) throws java.rmi.RemoteException;
}
