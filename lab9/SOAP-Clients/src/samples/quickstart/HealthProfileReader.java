/**
 * HealthProfileReader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package samples.quickstart;

public interface HealthProfileReader extends javax.xml.rpc.Service {
    public java.lang.String getHealthProfileReaderHttpSoap11EndpointAddress();

    public samples.quickstart.HealthProfileReaderPortType getHealthProfileReaderHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public samples.quickstart.HealthProfileReaderPortType getHealthProfileReaderHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
