package com.ais.websrv;

//validatingObjectDeserialization5
public class EmployeeServiceWebServiceProxy implements com.ais.websrv.EmployeeServiceWebService {
	private String _endpoint = null;
	private com.ais.websrv.EmployeeServiceWebService employeeServiceWebService = null;

	public EmployeeServiceWebServiceProxy() {
		_initEmployeeServiceWebServiceProxy();
	}

	public EmployeeServiceWebServiceProxy(String endpoint) {
		_endpoint = endpoint;
		_initEmployeeServiceWebServiceProxy();
	}

	private void _initEmployeeServiceWebServiceProxy() {
		try {
			employeeServiceWebService = (new com.ais.websrv.EmployeeServiceWebServiceServiceLocator()).getEmployeeServiceWebServiceSoapPort();
			if (employeeServiceWebService != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) employeeServiceWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) employeeServiceWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (employeeServiceWebService != null)
			((javax.xml.rpc.Stub) employeeServiceWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.ais.websrv.EmployeeServiceWebService getEmployeeServiceWebService() {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService;
	}

	public Permission.bean.ais.com.SSOResponse getUserEmailListOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.getUserEmailListOfSubmoduleOnProgramCode(moduleAbv, progCode);
	}

	public Permission.bean.ais.com.SSOResponse syncUserSession(java.lang.String tokenId) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.syncUserSession(tokenId);
	}

	public Permission.bean.ais.com.SSOResponse decreaseCounter(java.lang.String tokenId) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.decreaseCounter(tokenId);
	}

	public Permission.bean.ais.com.SSOResponse getAuthorizeOfSubmoduleOnProgramCode(java.lang.String moduleAbv, java.lang.String progCode) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.getAuthorizeOfSubmoduleOnProgramCode(moduleAbv, progCode);
	}

	public Permission.bean.ais.com.SSOResponse logOut(java.lang.String tokenId) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.logOut(tokenId);
	}

	public Permission.bean.ais.com.SSOResponse getProgCode(java.lang.String tokenId) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.getProgCode(tokenId);
	}

	public Permission.bean.ais.com.SSOResponse getPermission(java.lang.String tokenId, java.lang.String progCode) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.getPermission(tokenId, progCode);
	}

	public Permission.bean.ais.com.SSOResponse getToken(java.lang.String username, java.lang.String password, java.lang.String module, java.lang.String ou_type, java.lang.String projectCode) throws java.rmi.RemoteException, ClassNotFoundException, java.io.IOException {
		if (employeeServiceWebService == null)
			_initEmployeeServiceWebServiceProxy();
		return employeeServiceWebService.getToken(username, password, module, ou_type, projectCode);
	}
}