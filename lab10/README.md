# SOAP Web-Services: Clients 
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #9*
<br>**University of Trento** 

---

## Outline

* JAX-WS Overview
* JAX-WS Example
* Assignment #3

---

## Pre-Requisites

* Download [JAX-WS RI](https://jax-ws.java.net/) (just in case, libraries should be already available as part of java distribution)

---

## JAX-WS Overview (1)

* JAX-WS stands for Java API for XML Web Services. 
* Technology for building web services and clients that communicate using XML. 
* JAX-WS allows developers to write message-oriented as well as RPC-oriented web services.
* Web service invocation is represented by an XML-based protocol such as SOAP. 
* SOAP defines the envelope structure, encoding rules, and conventions for representing web service invocations and responses. * Calls and responses are transmitted as SOAP messages (XML files) over HTTP.

---

## JAX-WS Overview (2)

* JAX-WS API hides SOAP's complexity from the application developer. 
* On the server side, the developer specifies the web service operations by defining methods in an interface 
* The developer also codes one or more classes that implement those methods. 
* A client creates a proxy (a local object representing the service) and then simply invokes methods on the proxy. 
* The developer does not generate or parse SOAP messages. (JAX-WS runtime system converts API calls and responses to and from SOAP messages)

---

## JAX-WS Overview (3)

![](http://docs.oracle.com/javaee/5/tutorial/doc/figures/jaxws-simpleClientAndService.gif)

---

## JAX-WS Overview (4)

* **RPC Style** web service uses the names of the method and its parameters to generate XML structures that represent a method’s call stack. 
* **Document style** indicates that the SOAP body contains a XML document which can be validated against pre-defined XML schema document. 

--- 

## JAX-WS Tutorial - RPC Style (1)

* Create a Java Project (in eclipse, let's make it a Web Dynamic Project)
* Create a package named **introsde.ws**
* Create a *Web Service Enpoint Interface*
    * A web service endpoint is a service that is published for users to access
    * The web service client is the party who access the published service
    * In this case, a **HelloWorld** java interface like the following

```java
package introsde.ws;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style; 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld{ 
	@WebMethod String getHelloWorldAsString(String name);
}
```

--- 

## JAX-WS Tutorial - RPC Style (2)

* Create the *Web Service Endpoint Implementation*

```java
package introsde.ws;
import javax.jws.WebService;
//Service Implementation
@WebService(endpointInterface = "introsde.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
}
```

--- 

## JAX-WS Tutorial - RPC Style (3)

* Create the package **introsde.endpoint**
* Create the *Web Service Endpoint Publisher* in this package
* Run your first JAX-WS Service as a Java application
* Test that is working by accessing: http://localhost:6900/ws/hello?wsdl

```java
package introsde.endpoint;
import javax.xml.ws.Endpoint;
import introsde.ws.HelloWorldImpl;
//Endpoint publisher
public class HelloWorldPublisher{
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:6900/ws/hello", new HelloWorldImpl());
    }
}
```

---

## JAX-WS Tutorial - RPC Style (4)

* Call the service via an HTTP POST request on localhost:6900/ws/hello with body

```xml
<soap:Envelope
xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
  <soap:Body xmlns:m="http://ws.introsde/">
  <m:getHelloWorldAsString>
    <arg0>Pinco</arg0>
  </m:getHelloWorldAsString>
</soap:Body>
</soap:Envelope>
```

* This should be the response

```xml
<?xml version="1.0" ?>
<S:Envelope
    xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getHelloWorldAsStringResponse
            xmlns:ns2="http://ws.introsde/">
            <return>Hello World JAX-WS Pinco</return>
        </ns2:getHelloWorldAsStringResponse>
    </S:Body>
</S:Envelope>
```

---

## JAX-WS Tutorial - Implementing Clients 

* Create a package **introsde.client** and add the following class

```java
package introsde.client;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import introsde.ws.HelloWorld;
public class HelloWorldClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:6900/ws/hello?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.introsde/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld hello = service.getPort(HelloWorld.class);
		System.out.println(hello.getHelloWorldAsString("Pinco"));
	}
}
```

---

## JAX-WS Tutorial - Implementing Clients - Automatic (1)

* You can also use **wsimport** to parse the wsdl file and generate client files (stub) to access the published web service.
* wsimport should be in JDK_PATH/bin folder.
* Create a **my-solutions** folder on your local copy of lab10.
* From the command line, execute the following inside that new folder

```sh
wsimport -keep http://localhost:6900/ws/hello?wsdl
```

---

## JAX-WS Tutorial -  Implementing Clients - Automatic (2)

* You should now have an interface and a service implementation as follows:
* File **introsde/ws/HelloWorld.java**

```java
package introsde.ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;
/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://ws.introsde/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {
    /** 
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.introsde/HelloWorld/getHelloWorldAsStringRequest", output = "http://ws.introsde/HelloWorld/getHelloWorldAsStringResponse")
    public String getHelloWorldAsString(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);
}
```

File : HelloWorldImplService.java

package com.mkyong.ws;
 
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
 
/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWorldImplService", 
	targetNamespace = "http://ws.mkyong.com/", 
	wsdlLocation = "http://localhost:9999/ws/hello?wsdl")
public class HelloWorldImplService
    extends Service
{
 
    private final static URL HELLOWORLDIMPLSERVICE_WSDL_LOCATION;
 
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9999/ws/hello?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HELLOWORLDIMPLSERVICE_WSDL_LOCATION = url;
    }
 
    public HelloWorldImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }
 
    public HelloWorldImplService() {
        super(HELLOWORLDIMPLSERVICE_WSDL_LOCATION, 
			new QName("http://ws.mkyong.com/", "HelloWorldImplService"));
    }
 
    /**
     * 
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorld getHelloWorldImplPort() {
        return (HelloWorld)super.getPort(
			new QName("http://ws.mkyong.com/", "HelloWorldImplPort"), 
			HelloWorld.class);
    }
 
    /**
     * 
     * @param features
     *  A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  
     *  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *  returns HelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorld getHelloWorldImplPort(WebServiceFeature... features) {
        return (HelloWorld)super.getPort(
			new QName("http://ws.mkyong.com/", "HelloWorldImplPort"), 
			HelloWorld.class, 
			features);
    }
 
}
Now, create a Java web service client which depends on the above generated files.

package com.mkyong.client;
 
import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;
 
public class HelloWorldClient{
 
	public static void main(String[] args) {
 
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
 
		System.out.println(hello.getHelloWorldAsString("mkyong"));
 
    }
 
}
Here’s the output

Hello World JAX-WS mkyong






---

## Other Resources

* [JAX-WS Tutorials online](http://www.mkyong.com/tutorials/jax-ws-tutorials/)
* [Oracle Java EE tutorials on JAX-WS](http://docs.oracle.com/javaee/5/tutorial/doc/bnayl.html)
* [SOAP Binding: difference between Document and RPC Style](http://java.globinch.com/enterprise-java/web-services/soap-binding-document-rpc-style-web-services-difference/#document_style_rpc_style)



