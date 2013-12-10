package introsde.document.endpoint;
 
import javax.xml.ws.Endpoint;

import introsde.document.ws.HelloWorldImpl;
 
//Endpoint publisher
public class HelloWorldPublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "6901";
	public static String BASE_URL = "/ws/hello";
	
	public static String getEndpointURL() {
		return SERVER_URL+":"+PORT+BASE_URL;
	}
 
	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting HelloWorld Service...");
		System.out.println("--> Published at = "+endpointUrl);
		Endpoint.publish(endpointUrl, new HelloWorldImpl());
    }
}