package th.co.ais.webservice.getvenbank;

public class SI_Z_FIAP_SEM_GETVENBANKProxy implements th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANK {
  private String _endpoint = null;
  private th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANK sI_Z_FIAP_SEM_GETVENBANK = null;
  
  public SI_Z_FIAP_SEM_GETVENBANKProxy() {
    _initSI_Z_FIAP_SEM_GETVENBANKProxy();
  }
  
  public SI_Z_FIAP_SEM_GETVENBANKProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_GETVENBANKProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_GETVENBANKProxy() {
    try {
      sI_Z_FIAP_SEM_GETVENBANK = (new th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANKServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_GETVENBANK != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GETVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GETVENBANK)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_GETVENBANK != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GETVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.getvenbank.SI_Z_FIAP_SEM_GETVENBANK getSI_Z_FIAP_SEM_GETVENBANK() {
    if (sI_Z_FIAP_SEM_GETVENBANK == null)
      _initSI_Z_FIAP_SEM_GETVENBANKProxy();
    return sI_Z_FIAP_SEM_GETVENBANK;
  }
  
  public th.co.ais.webservice.getvenbank.bean.Z_FIAP_SEM_GETVENBANKResponse SI_Z_FIAP_SEM_GETVENBANK(th.co.ais.webservice.getvenbank.bean.Z_FIAP_SEM_GETVENBANK parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_GETVENBANK == null)
      _initSI_Z_FIAP_SEM_GETVENBANKProxy();
    return sI_Z_FIAP_SEM_GETVENBANK.SI_Z_FIAP_SEM_GETVENBANK(parameters);
  }
  
  
}