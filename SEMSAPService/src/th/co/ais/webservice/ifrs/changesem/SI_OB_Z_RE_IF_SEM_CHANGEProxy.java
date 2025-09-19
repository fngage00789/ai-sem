package th.co.ais.webservice.ifrs.changesem;

public class SI_OB_Z_RE_IF_SEM_CHANGEProxy implements th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGE {
  private String _endpoint = null;
  private th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGE sI_OB_Z_RE_IF_SEM_CHANGE = null;
  
  public SI_OB_Z_RE_IF_SEM_CHANGEProxy() {
    _initSI_OB_Z_RE_IF_SEM_CHANGEProxy();
  }
  
  public SI_OB_Z_RE_IF_SEM_CHANGEProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_OB_Z_RE_IF_SEM_CHANGEProxy();
  }
  
  private void _initSI_OB_Z_RE_IF_SEM_CHANGEProxy() {
    try {
      sI_OB_Z_RE_IF_SEM_CHANGE = (new th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGEServiceLocator()).getHTTPS_Port();
      if (sI_OB_Z_RE_IF_SEM_CHANGE != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CHANGE)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CHANGE)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_OB_Z_RE_IF_SEM_CHANGE != null)
      ((javax.xml.rpc.Stub)sI_OB_Z_RE_IF_SEM_CHANGE)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.ifrs.changesem.SI_OB_Z_RE_IF_SEM_CHANGE getSI_OB_Z_RE_IF_SEM_CHANGE() {
    if (sI_OB_Z_RE_IF_SEM_CHANGE == null)
      _initSI_OB_Z_RE_IF_SEM_CHANGEProxy();
    return sI_OB_Z_RE_IF_SEM_CHANGE;
  }
  
  public th.co.ais.webservice.ifrs.changesem.bean.Z_RE_IF_SEM_CHANGEResponse SI_OB_Z_RE_IF_SEM_CHANGE(th.co.ais.webservice.ifrs.changesem.bean.Z_RE_IF_SEM_CHANGE parameters) throws java.rmi.RemoteException{
    if (sI_OB_Z_RE_IF_SEM_CHANGE == null)
      _initSI_OB_Z_RE_IF_SEM_CHANGEProxy();
    return sI_OB_Z_RE_IF_SEM_CHANGE.SI_OB_Z_RE_IF_SEM_CHANGE(parameters);
  }
  
  
}