package th.co.ais.webservice.chgvenbank;

public class SI_Z_FIAP_SEM_CHGVENBANKProxy implements th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANK {
  private String _endpoint = null;
  private th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANK sI_Z_FIAP_SEM_CHGVENBANK = null;
  
  public SI_Z_FIAP_SEM_CHGVENBANKProxy() {
    _initSI_Z_FIAP_SEM_CHGVENBANKProxy();
  }
  
  public SI_Z_FIAP_SEM_CHGVENBANKProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_CHGVENBANKProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_CHGVENBANKProxy() {
    try {
      sI_Z_FIAP_SEM_CHGVENBANK = (new th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANKServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_CHGVENBANK != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHGVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHGVENBANK)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_CHGVENBANK != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHGVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.chgvenbank.SI_Z_FIAP_SEM_CHGVENBANK getSI_Z_FIAP_SEM_CHGVENBANK() {
    if (sI_Z_FIAP_SEM_CHGVENBANK == null)
      _initSI_Z_FIAP_SEM_CHGVENBANKProxy();
    return sI_Z_FIAP_SEM_CHGVENBANK;
  }
  
  public th.co.ais.webservice.chgvenbank.bean.Z_FIAP_SEM_CHGVENBANKResponse SI_Z_FIAP_SEM_CHGVENBANK(th.co.ais.webservice.chgvenbank.bean.Z_FIAP_SEM_CHGVENBANK parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_CHGVENBANK == null)
      _initSI_Z_FIAP_SEM_CHGVENBANKProxy();
    return sI_Z_FIAP_SEM_CHGVENBANK.SI_Z_FIAP_SEM_CHGVENBANK(parameters);
  }
  
  
}