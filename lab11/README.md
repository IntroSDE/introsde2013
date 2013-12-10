# SOAP Web-Services with JAX-WS (2)
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #11*
<br>**University of Trento** 

---

## Outline

* JAX-WS with models
* JAX-WS + JPA
* Javascript clients

---

## JAX-WS with models (1)

* Using classes as parameters is straightforward. 
* Using the same JAX-WS examples of last session, create a package **introsde.ws.model** 
* Add the following **Person** class to the model package

```java
package introsde.ws.model;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Person {
	private String firstname;
	private String lastname;
	public Person() {
	}
	public Person(String fname, String lname) {
		this.firstname=fname;
		this.lastname=lname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	public String toString() {
		return this.firstname+" "+this.lastname;
	}
}
```

---

## JAX-WS with models (2)

* Add the following services to the HelloWorld interface

```java
@WebMethod String sayHelloTo(@WebParam(name="person") Person person);
@WebMethod @WebResult(name="person") Person readPerson(@WebParam(name="personId") int personId);
```

* And implement them on the implementaion class

```java
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
```

---

## JAX-WS with models (3) 

* Test the new service in the client by adding:

```java
    String response = hello.sayHelloTo(new Person("Person","Test"));
    System.out.println("Response from the service to 'sayHelloTo': " + response);
    Person person = hello.readPerson(0);
    System.out.println("Response from the service to 'sayHelloTo': " + person.toString()); 
```





---

## JAX-WS with models

* Generating stubs for the client

```sh
wsimport -keep http://localhost:6902/ws/people?wsdl
```

* Use generated sources to create your client