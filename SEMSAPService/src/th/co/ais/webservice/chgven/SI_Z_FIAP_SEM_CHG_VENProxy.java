package th.co.ais.webservice.chgven;

public class SI_Z_FIAP_SEM_CHG_VENProxy implements th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VEN {
  private String _endpoint = null;
  private th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VEN sI_Z_FIAP_SEM_CHG_VEN = null;
  
  public SI_Z_FIAP_SEM_CHG_VENProxy() {
    _initSI_Z_FIAP_SEM_CHG_VENProxy();
  }
  
  public SI_Z_FIAP_SEM_CHG_VENProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_CHG_VENProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_CHG_VENProxy() {
    try {
      sI_Z_FIAP_SEM_CHG_VEN = (new th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VENServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_CHG_VEN != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHG_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHG_VEN)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_CHG_VEN != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CHG_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.chgven.SI_Z_FIAP_SEM_CHG_VEN getSI_Z_FIAP_SEM_CHG_VEN() {
    if (sI_Z_FIAP_SEM_CHG_VEN == null)
      _initSI_Z_FIAP_SEM_CHG_VENProxy();
    return sI_Z_FIAP_SEM_CHG_VEN;
  }
  
  public th.co.ais.webservice.chgven.bean.Z_FIAP_SEM_CHG_VENResponse SI_Z_FIAP_SEM_CHG_VEN(th.co.ais.webservice.chgven.bean.Z_FIAP_SEM_CHG_VEN parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_CHG_VEN == null)
      _initSI_Z_FIAP_SEM_CHG_VENProxy();
    return sI_Z_FIAP_SEM_CHG_VEN.SI_Z_FIAP_SEM_CHG_VEN(parameters);
  }
  
  
}