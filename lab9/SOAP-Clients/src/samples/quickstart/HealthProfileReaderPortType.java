/**
 * HealthProfileReaderPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package samples.quickstart;

public interface HealthProfileReaderPortType extends java.rmi.Remote {
    public java.lang.String setParameterValue(java.lang.String firstname, java.lang.String lastname, java.lang.String parameter, java.lang.Double value) throws java.rmi.RemoteException;
    public service.health.pojos.xsd.HealthProfile getHealthProfile(java.lang.String firstname, java.lang.String lastname) throws java.rmi.RemoteException;
    public java.lang.String getParameterValue(java.lang.String firstname, java.lang.String lastname, java.lang.String parameter) throws java.rmi.RemoteException;
}
