package th.co.ais.webservice.masterbank;

public class SI_Z_FIAP_SEM_MASTERBANKProxy implements th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANK {
  private String _endpoint = null;
  private th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANK sI_Z_FIAP_SEM_MASTERBANK = null;
  
  public SI_Z_FIAP_SEM_MASTERBANKProxy() {
    _initSI_Z_FIAP_SEM_MASTERBANKProxy();
  }
  
  public SI_Z_FIAP_SEM_MASTERBANKProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_MASTERBANKProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_MASTERBANKProxy() {
    try {
      sI_Z_FIAP_SEM_MASTERBANK = (new th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANKServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_MASTERBANK != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_MASTERBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_MASTERBANK)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_MASTERBANK != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_MASTERBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.masterbank.SI_Z_FIAP_SEM_MASTERBANK getSI_Z_FIAP_SEM_MASTERBANK() {
    if (sI_Z_FIAP_SEM_MASTERBANK == null)
      _initSI_Z_FIAP_SEM_MASTERBANKProxy();
    return sI_Z_FIAP_SEM_MASTERBANK;
  }
  
  public th.co.ais.webservice.masterbank.bean.Z_FIAP_SEM_MASTERBANKResponse SI_Z_FIAP_SEM_MASTERBANK(th.co.ais.webservice.masterbank.bean.Z_FIAP_SEM_MASTERBANK parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_MASTERBANK == null)
      _initSI_Z_FIAP_SEM_MASTERBANKProxy();
    return sI_Z_FIAP_SEM_MASTERBANK.SI_Z_FIAP_SEM_MASTERBANK(parameters);
  }
  
  
}