package com.ais.websrv;

public class EmployeeServiceWebServiceV2Proxy implements com.ais.websrv.EmployeeServiceWebServiceV2 {
  private String _endpoint = null;
  private com.ais.websrv.EmployeeServiceWebServiceV2 employeeServiceWebServiceV2 = null;
  
  public EmployeeServiceWebServiceV2Proxy() {
    _initEmployeeServiceWebServiceV2Proxy();
  }
  
  public EmployeeServiceWebServiceV2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceWebServiceV2Proxy();
  }
  
  private void _initEmployeeServiceWebServiceV2Proxy() {
    try {
      employeeServiceWebServiceV2 = (new com.ais.websrv.EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
      if (employeeServiceWebServiceV2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeServiceWebServiceV2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeServiceWebServiceV2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeServiceWebServiceV2 != null)
      ((javax.xml.rpc.Stub)employeeServiceWebServiceV2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ais.websrv.EmployeeServiceWebServiceV2 getEmployeeServiceWebServiceV2() {
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2;
  }
  
  public Permission.bean.ais.com.SSOResponse getUserEmailListOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getUserEmailListOfSubmoduleOnProgramCode(moduleAbv, progCode);
  }
  
  public Permission.bean.ais.com.SSOResponse getProgCodeRoot(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getProgCodeRoot(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse syncUserSession(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.syncUserSession(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse decreaseCounter(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.decreaseCounter(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse getAllPermission(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getAllPermission(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse getAuthorizeOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getAuthorizeOfSubmoduleOnProgramCode(moduleAbv, progCode);
  }
  
  public Permission.bean.ais.com.SSOResponse logOut(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.logOut(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse getProgCode(java.lang.String tokenId) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getProgCode(tokenId);
  }
  
  public Permission.bean.ais.com.SSOResponse getPermission(java.lang.String tokenId, java.lang.String progCode) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getPermission(tokenId, progCode);
  }
  
  public Permission.bean.ais.com.SSOResponse getToken(java.lang.String username, java.lang.String password, java.lang.String module, java.lang.String ou_type, java.lang.String projectCode) throws java.rmi.RemoteException{
    if (employeeServiceWebServiceV2 == null)
      _initEmployeeServiceWebServiceV2Proxy();
    return employeeServiceWebServiceV2.getToken(username, password, module, ou_type, projectCode);
  }
  
  
}