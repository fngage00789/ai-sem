package th.co.ais.webservice.addvenbank;

public class SI_Z_FIAP_SEM_ADDVENBANKProxy implements th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANK {
  private String _endpoint = null;
  private th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANK sI_Z_FIAP_SEM_ADDVENBANK = null;
  
  public SI_Z_FIAP_SEM_ADDVENBANKProxy() {
    _initSI_Z_FIAP_SEM_ADDVENBANKProxy();
  }
  
  public SI_Z_FIAP_SEM_ADDVENBANKProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_Z_FIAP_SEM_ADDVENBANKProxy();
  }
  
  private void _initSI_Z_FIAP_SEM_ADDVENBANKProxy() {
    try {
      sI_Z_FIAP_SEM_ADDVENBANK = (new th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANKServiceLocator()).getHTTPS_Port();
      if (sI_Z_FIAP_SEM_ADDVENBANK != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_ADDVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_ADDVENBANK)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_Z_FIAP_SEM_ADDVENBANK != null)
      ((javax.xml.rpc.Stub)sI_Z_FIAP_SEM_ADDVENBANK)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public th.co.ais.webservice.addvenbank.SI_Z_FIAP_SEM_ADDVENBANK getSI_Z_FIAP_SEM_ADDVENBANK() {
    if (sI_Z_FIAP_SEM_ADDVENBANK == null)
      _initSI_Z_FIAP_SEM_ADDVENBANKProxy();
    return sI_Z_FIAP_SEM_ADDVENBANK;
  }
  
  public th.co.ais.webservice.addvenbank.bean.Z_FIAP_SEM_ADDVENBANKResponse SI_Z_FIAP_SEM_ADDVENBANK(th.co.ais.webservice.addvenbank.bean.Z_FIAP_SEM_ADDVENBANK parameters) throws java.rmi.RemoteException{
    if (sI_Z_FIAP_SEM_ADDVENBANK == null)
      _initSI_Z_FIAP_SEM_ADDVENBANKProxy();
    return sI_Z_FIAP_SEM_ADDVENBANK.SI_Z_FIAP_SEM_ADDVENBANK(parameters);
  }
  
  
}