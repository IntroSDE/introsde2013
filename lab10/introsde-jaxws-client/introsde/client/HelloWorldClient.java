package introsde.client;

public class HelloWorldClient {
	public static void main(String[] args) {
		// Trying the RPC version
		introsde.ws.HelloWorldImplService helloService = 
				new introsde.ws.HelloWorldImplService();

		
		introsde.ws.HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println("Trying 'getHelloWorldAsString': "
				+ hello.getHelloWorldAsString("Pinco"));

		System.out.println("Trying 'readPerson': " + hello.readPerson(0));

		introsde.ws.Person p = new introsde.ws.Person();
		p.setFirstname("Chuck");
		p.setLastname("Norris");
		System.out.println("Trying 'sayHelloTo': " + hello.sayHelloTo(p));

		// Trying the Document version
		introsde.document.ws.HelloWorldImplService helloDocService = new introsde.document.ws.HelloWorldImplService();
		introsde.document.ws.HelloWorld helloDoc = helloDocService
				.getHelloWorldImplPort();
		
		System.out.println("Trying 'getHelloWorldAsString': "
				+ helloDoc.getHelloWorldAsString("Pinco"));
		
		System.out.println("Trying 'readPerson': " + helloDoc.readPerson(0));
		
		introsde.document.ws.Person pDoc = new introsde.document.ws.Person();
		pDoc.setFirstname("Chuck");
		pDoc.setLastname("Norris");
		System.out.println("Trying 'sayHelloTo': " + helloDoc.sayHelloTo(pDoc));

	}
}
