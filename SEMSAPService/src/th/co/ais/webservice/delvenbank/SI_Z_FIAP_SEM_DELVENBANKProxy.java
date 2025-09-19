package th.co.ais.webservice.delvenbank;

public class SI_Z_FIAP_SEM_DELVENBANKProxy implements th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANK {
  private String _endpoint = null;
  private th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANK sI_Z_FIAP_SEM_DELVENBANK = null;
  
  public SI_Z_FIAP_SEM_DELVENBANKProxy() {
    _initSI_Z_FIAP_SEM_DELVENBANKProxy();
  }
  
  public SI_Z_FIAP_SEM_DELVENBANKProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_DELVENBANKProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_DELVENBANKProxy() {
    try {
      sI_Z_FIAP_SEM_DELVENBANK = (new th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANKServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_DELVENBANK != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_DELVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_DELVENBANK)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_DELVENBANK != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_DELVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.delvenbank.SI_Z_FIAP_SEM_DELVENBANK getSI_Z_FIAP_SEM_DELVENBANK() {
    if (sI_Z_FIAP_SEM_DELVENBANK == null)
      _initSI_Z_FIAP_SEM_DELVENBANKProxy();
    return sI_Z_FIAP_SEM_DELVENBANK;
  }
  
  public th.co.ais.webservice.delvenbank.bean.Z_FIAP_SEM_DELVENBANKResponse SI_Z_FIAP_SEM_DELVENBANK(th.co.ais.webservice.delvenbank.bean.Z_FIAP_SEM_DELVENBANK parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_DELVENBANK == null)
      _initSI_Z_FIAP_SEM_DELVENBANKProxy();
    return sI_Z_FIAP_SEM_DELVENBANK.SI_Z_FIAP_SEM_DELVENBANK(parameters);
  }
  
  
}