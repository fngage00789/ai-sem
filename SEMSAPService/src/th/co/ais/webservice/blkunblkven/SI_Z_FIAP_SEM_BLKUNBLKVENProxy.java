package th.co.ais.webservice.blkunblkven;

public class SI_Z_FIAP_SEM_BLKUNBLKVENProxy implements th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVEN {
  private String _endpoint = null;
  private th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVEN sI_Z_FIAP_SEM_BLKUNBLKVEN = null;
  
  public SI_Z_FIAP_SEM_BLKUNBLKVENProxy() {
    _initSI_Z_FIAP_SEM_BLKUNBLKVENProxy();
  }
  
  public SI_Z_FIAP_SEM_BLKUNBLKVENProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_BLKUNBLKVENProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_BLKUNBLKVENProxy() {
    try {
      sI_Z_FIAP_SEM_BLKUNBLKVEN = (new th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVENServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_BLKUNBLKVEN != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_BLKUNBLKVEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_BLKUNBLKVEN)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_BLKUNBLKVEN != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_BLKUNBLKVEN)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.blkunblkven.SI_Z_FIAP_SEM_BLKUNBLKVEN getSI_Z_FIAP_SEM_BLKUNBLKVEN() {
    if (sI_Z_FIAP_SEM_BLKUNBLKVEN == null)
      _initSI_Z_FIAP_SEM_BLKUNBLKVENProxy();
    return sI_Z_FIAP_SEM_BLKUNBLKVEN;
  }
  
  public th.co.ais.webservice.blkunblkven.bean.Z_FIAP_SEM_BLKUNBLKVENResponse SI_Z_FIAP_SEM_BLKUNBLKVEN(th.co.ais.webservice.blkunblkven.bean.Z_FIAP_SEM_BLKUNBLKVEN parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_BLKUNBLKVEN == null)
      _initSI_Z_FIAP_SEM_BLKUNBLKVENProxy();
    return sI_Z_FIAP_SEM_BLKUNBLKVEN.SI_Z_FIAP_SEM_BLKUNBLKVEN(parameters);
  }
  
  
}