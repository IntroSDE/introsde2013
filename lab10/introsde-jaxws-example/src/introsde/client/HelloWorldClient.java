package introsde.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import introsde.ws.HelloWorld;
import introsde.ws.model.Person;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:6900/ws/hello?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.introsde/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld hello = service.getPort(HelloWorld.class);
		
		
		
		System.out.println(hello.getHelloWorldAsString("Pinco"));
		String response = hello.sayHelloTo(new Person("Person","Test"));
        System.out.println("Response from the service to 'sayHelloTo': " + response);
        Person person = hello.readPerson(0);
        System.out.println("Response from the service to 'sayHelloTo': " + person.toString());       
	}
}