package introsde.ws;

import introsde.ws.model.Person;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "introsde.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
	
	@Override
	public String sayHelloTo(Person person) {
		return "Hello " + person.getFirstname() + " " + person.getLastname();
	}

	@Override
	public Person readPerson(int personId) { 
		return new Person("Person","Test");
	}
}
