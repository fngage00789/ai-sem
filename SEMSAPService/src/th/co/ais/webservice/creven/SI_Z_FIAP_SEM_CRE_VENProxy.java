package th.co.ais.webservice.creven;

public class SI_Z_FIAP_SEM_CRE_VENProxy implements th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VEN {
  private String _endpoint = null;
  private th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VEN sI_Z_FIAP_SEM_CRE_VEN = null;
  
  public SI_Z_FIAP_SEM_CRE_VENProxy() {
    _initSI_Z_FIAP_SEM_CRE_VENProxy();
  }
  
  public SI_Z_FIAP_SEM_CRE_VENProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_CRE_VENProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_CRE_VENProxy() {
    try {
      sI_Z_FIAP_SEM_CRE_VEN = (new th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VENServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_CRE_VEN != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CRE_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CRE_VEN)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_CRE_VEN != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_CRE_VEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.creven.SI_Z_FIAP_SEM_CRE_VEN getSI_Z_FIAP_SEM_CRE_VEN() {
    if (sI_Z_FIAP_SEM_CRE_VEN == null)
      _initSI_Z_FIAP_SEM_CRE_VENProxy();
    return sI_Z_FIAP_SEM_CRE_VEN;
  }
  
  public th.co.ais.webservice.creven.bean.Z_FIAP_SEM_CRE_VENResponse SI_Z_FIAP_SEM_CRE_VEN(th.co.ais.webservice.creven.bean.Z_FIAP_SEM_CRE_VEN parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_CRE_VEN == null)
      _initSI_Z_FIAP_SEM_CRE_VENProxy();
    return sI_Z_FIAP_SEM_CRE_VEN.SI_Z_FIAP_SEM_CRE_VEN(parameters);
  }
  
  
}