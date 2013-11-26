package samples.quickstart;

public class HealthProfileReaderPortTypeProxy implements samples.quickstart.HealthProfileReaderPortType {
  private String _endpoint = null;
  private samples.quickstart.HealthProfileReaderPortType healthProfileReaderPortType = null;
  
  public HealthProfileReaderPortTypeProxy() {
    _initHealthProfileReaderPortTypeProxy();
  }
  
  public HealthProfileReaderPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initHealthProfileReaderPortTypeProxy();
  }
  
  private void _initHealthProfileReaderPortTypeProxy() {
    try {
      healthProfileReaderPortType = (new samples.quickstart.HealthProfileReaderLocator()).getHealthProfileReaderHttpSoap11Endpoint();
      if (healthProfileReaderPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)healthProfileReaderPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)healthProfileReaderPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (healthProfileReaderPortType != null)
      ((javax.xml.rpc.Stub)healthProfileReaderPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public samples.quickstart.HealthProfileReaderPortType getHealthProfileReaderPortType() {
    if (healthProfileReaderPortType == null)
      _initHealthProfileReaderPortTypeProxy();
    return healthProfileReaderPortType;
  }
  
  public java.lang.String setParameterValue(java.lang.String firstname, java.lang.String lastname, java.lang.String parameter, java.lang.Double value) throws java.rmi.RemoteException{
    if (healthProfileReaderPortType == null)
      _initHealthProfileReaderPortTypeProxy();
    return healthProfileReaderPortType.setParameterValue(firstname, lastname, parameter, value);
  }
  
  public service.health.pojos.xsd.HealthProfile getHealthProfile(java.lang.String firstname, java.lang.String lastname) throws java.rmi.RemoteException{
    if (healthProfileReaderPortType == null)
      _initHealthProfileReaderPortTypeProxy();
    return healthProfileReaderPortType.getHealthProfile(firstname, lastname);
  }
  
  public java.lang.String getParameterValue(java.lang.String firstname, java.lang.String lastname, java.lang.String parameter) throws java.rmi.RemoteException{
    if (healthProfileReaderPortType == null)
      _initHealthProfileReaderPortTypeProxy();
    return healthProfileReaderPortType.getParameterValue(firstname, lastname, parameter);
  }
  
  
}