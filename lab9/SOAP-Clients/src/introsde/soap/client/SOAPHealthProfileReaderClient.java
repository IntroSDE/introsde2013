package introsde.soap.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class SOAPHealthProfileReaderClient {

	private static EndpointReference targetEPR = new EndpointReference(
			"http://localhost:8080/axis2/services/HealthProfileReader");

	public static OMElement getParameterValuePayload(String firstname,
			String lastname, String parameter) {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(
				"http://quickstart.samples/xsd", "tns");

		OMElement method = fac.createOMElement("getParameterValue", omNs);

		OMElement firstnameValue = fac.createOMElement("firstname", omNs);
		firstnameValue.addChild(fac.createOMText(firstnameValue, firstname));
		method.addChild(firstnameValue);

		OMElement lastnameValue = fac.createOMElement("lastname", omNs);
		lastnameValue.addChild(fac.createOMText(lastnameValue, lastname));
		method.addChild(lastnameValue);

		OMElement parameterValue = fac.createOMElement("parameter", omNs);
		parameterValue.addChild(fac.createOMText(parameterValue, parameter));
		method.addChild(parameterValue);
		return method;
	}

	public static void main(String[] args) {

		try {

			OMElement payload = getParameterValuePayload("Pinco", "Pallino",
					"bmi");
			Options options = new Options();
			options.setTo(targetEPR); // this sets the location of MyService
										// service

			ServiceClient serviceClient = new ServiceClient();
			serviceClient.setOptions(options);

			OMElement result = serviceClient.sendReceive(payload);

			System.out.println(result);
		} catch (AxisFault axisFault) {
			axisFault.printStackTrace();
		}
	}
}
