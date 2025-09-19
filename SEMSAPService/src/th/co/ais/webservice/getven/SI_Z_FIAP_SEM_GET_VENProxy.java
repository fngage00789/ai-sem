package th.co.ais.webservice.getven;

public class SI_Z_FIAP_SEM_GET_VENProxy implements th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VEN {
  private String _endpoint = null;
  private th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VEN sI_Z_FIAP_SEM_GET_VEN = null;
  
  public SI_Z_FIAP_SEM_GET_VENProxy() {
    _initSI_Z_FIAP_SEM_GET_VENProxy();
  }
  
  public SI_Z_FIAP_SEM_GET_VENProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_GET_VENProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_GET_VENProxy() {
    try {
      sI_Z_FIAP_SEM_GET_VEN = (new th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VENServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_GET_VEN != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GET_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GET_VEN)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_GET_VEN != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_GET_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.getven.SI_Z_FIAP_SEM_GET_VEN getSI_Z_FIAP_SEM_GET_VEN() {
    if (sI_Z_FIAP_SEM_GET_VEN == null)
      _initSI_Z_FIAP_SEM_GET_VENProxy();
    return sI_Z_FIAP_SEM_GET_VEN;
  }
  
  public th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VENResponse SI_Z_FIAP_SEM_GET_VEN(th.co.ais.webservice.getven.bean.Z_FIAP_SEM_GET_VEN parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_GET_VEN == null)
      _initSI_Z_FIAP_SEM_GET_VENProxy();
    return sI_Z_FIAP_SEM_GET_VEN.SI_Z_FIAP_SEM_GET_VEN(parameters);
  }
  
  
}