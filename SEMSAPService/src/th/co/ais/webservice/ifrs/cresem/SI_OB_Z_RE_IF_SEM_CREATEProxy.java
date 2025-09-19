package th.co.ais.webservice.ifrs.cresem;

public class SI_OB_Z_RE_IF_SEM_CREATEProxy implements th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATE {
  private String _endpoint = null;
  private th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATE sI_OB_Z_RE_IF_SEM_CREATE = null;
  
  public SI_OB_Z_RE_IF_SEM_CREATEProxy() {
    _initSI_OB_Z_RE_IF_SEM_CREATEProxy();
  }
  
  public SI_OB_Z_RE_IF_SEM_CREATEProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_OB_Z_RE_IF_SEM_CREATEProxy();
  }
  
  private void _initSI_OB_Z_RE_IF_SEM_CREATEProxy() {
    try {
      sI_OB_Z_RE_IF_SEM_CREATE = (new th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATEServiceLocator()).getHTTPS_Port();
      if (sI_OB_Z_RE_IF_SEM_CREATE != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CREATE)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CREATE)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_OB_Z_RE_IF_SEM_CREATE != null)
      ((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CREATE)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.ifrs.cresem.SI_OB_Z_RE_IF_SEM_CREATE getSI_OB_Z_RE_IF_SEM_CREATE() {
    if (sI_OB_Z_RE_IF_SEM_CREATE == null)
      _initSI_OB_Z_RE_IF_SEM_CREATEProxy();
    return sI_OB_Z_RE_IF_SEM_CREATE;
  }
  
  public th.co.ais.webservice.ifrs.cresem.bean.Z_RE_IF_SEM_CREATEResponse SI_OB_Z_RE_IF_SEM_CREATE(th.co.ais.webservice.ifrs.cresem.bean.Z_RE_IF_SEM_CREATE parameters) throws java.rmi.RemoteException{
    if (sI_OB_Z_RE_IF_SEM_CREATE == null)
      _initSI_OB_Z_RE_IF_SEM_CREATEProxy();
    return sI_OB_Z_RE_IF_SEM_CREATE.SI_OB_Z_RE_IF_SEM_CREATE(parameters);
  }
  
  
}