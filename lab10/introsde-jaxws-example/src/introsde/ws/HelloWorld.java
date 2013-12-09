package introsde.ws;

import introsde.ws.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style; 

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld { 
	@WebMethod String getHelloWorldAsString(String name);
	@WebMethod String sayHelloTo(@WebParam(name="person") Person person);
	@WebMethod @WebResult(name="person") Person readPerson(@WebParam(name="personId") int personId);
}