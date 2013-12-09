package introsde.document.ws;
 
import introsde.document.ws.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface HelloWorld{
	@WebMethod String getHelloWorldAsString(String name);
	@WebMethod String sayHelloTo(@WebParam(name="person") Person person);
	@WebMethod Person readPerson(@WebParam(name="personId") int personId);
}