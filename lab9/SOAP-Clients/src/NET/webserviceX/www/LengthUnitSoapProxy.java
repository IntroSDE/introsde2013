package NET.webserviceX.www;

public class LengthUnitSoapProxy implements NET.webserviceX.www.LengthUnitSoap {
  private String _endpoint = null;
  private NET.webserviceX.www.LengthUnitSoap lengthUnitSoap = null;
  
  public LengthUnitSoapProxy() {
    _initLengthUnitSoapProxy();
  }
  
  public LengthUnitSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initLengthUnitSoapProxy();
  }
  
  private void _initLengthUnitSoapProxy() {
    try {
      lengthUnitSoap = (new NET.webserviceX.www.LengthUnitLocator()).getlengthUnitSoap();
      if (lengthUnitSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lengthUnitSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lengthUnitSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lengthUnitSoap != null)
      ((javax.xml.rpc.Stub)lengthUnitSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public NET.webserviceX.www.LengthUnitSoap getLengthUnitSoap() {
    if (lengthUnitSoap == null)
      _initLengthUnitSoapProxy();
    return lengthUnitSoap;
  }
  
  public double changeLengthUnit(double lengthValue, NET.webserviceX.www.Lengths fromLengthUnit, NET.webserviceX.www.Lengths toLengthUnit) throws java.rmi.RemoteException{
    if (lengthUnitSoap == null)
      _initLengthUnitSoapProxy();
    return lengthUnitSoap.changeLengthUnit(lengthValue, fromLengthUnit, toLengthUnit);
  }
  
  
}