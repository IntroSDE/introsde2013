package introsde.client;

import introsde.document.ws.HelloWorld;
import introsde.document.ws.HelloWorldImplService;
import introsde.document.ws.Person;

public class HelloWorldClient {
	public static void main(String[] args) {
		HelloWorldImplService helloDocService = new HelloWorldImplService();
		HelloWorld helloDoc = helloDocService
				.getHelloWorldImplPort();
		
		System.out.println("Trying 'getHelloWorldAsString': "
				+ helloDoc.getHelloWorldAsString("Pinco"));
		
		System.out.println("Trying 'readPerson': " + helloDoc.readPerson(0));
		
		Person person = new Person();
		person.setFirstname("Chuck");
		person.setLastname("Norris");
		System.out.println("Trying 'sayHelloTo': " + helloDoc.sayHelloTo(person));

	}
}
