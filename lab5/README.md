# REST-based Web Services (I)
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #5*
<br>**University of Trento** 
<br> Guiding notes based on **Helen Paik's** slides for the School of Computer Science and Engineering University of New South Wales

---

## Outline

* REST principles recap
* Building REST Services Servlet Example
* Building REST Services with Jersey

---

## What's REST?

* The term Representational State Transfer (REST) was introduced and defined in 2000 by Roy Fielding in his doctoral dissertation
* It is an **architectural style** of networked systems (not a protocol - not a specification), by which **resources** are exposed through out the system. 
* REST is a client-server architecture.
* Only representations of **resources** are exposed to the client
* The representation of resources places the client application in a **state**.
* Client state may evolve by **traversing hyperlinks** and obtaining **new representations**


---

## REST Principles
* Resource identification through **URI**
* **Uniform interface:** resources are manipulated using a fixed set operations (HTTP GET, POST, PUT, DELETE methods) 
* Self-descriptive messages: resources are decoupled from their representation

---

## REST Principles: RESTful Flavor

* **Stateful interactions through hyperlinks**: every interaction with a resource is stateless, i.e., request messages are self-contained. 

--- 

## REST principles: resources 

* Resource: Any *thing* (noun) that is worthy of being given a unique ID (URI) and be accessible via client
* Resources are something the server is responsible for managing Resources must have representations to be ’transmitted’ to cliente.g., resources in the starbucks example: order, payment (represented in XML)

---

## REST principles: uniform interface

**Uniform Interface:** Uniform ‘verbs’ that go with the resources (noun)* Given a resource (coffee order): a representation in XML```xml
<order xmlns="urn:starbucks">   <drink>latte</drink></order>```
* POST /starbucks/orders (to create an order)
	* returns: location: /starbucks/orders/order?id=1234
* GET /starbucks/orders/order?id=1234 (to read an order)
* PUT /starbucks/orders/order?id=1234 (to update an existing order)
* DELETE /starbucks/orders/order?id=1234 (to delete an existing order)

---

## REST principles: hypermedia


**Connectedness/Links:** Resources may contain links to other resourcese.g., Order resource is linked to Payment resource**In response to POSTing an order**```
201 CreatedLocation: /starbucks/orders/order?id=1234Content-Type: application/xmlContent-Length: ...<order xmlns="urn:starbucks">  <drink>latte</drink>  <link rel="payment" href="/starbucks/payments/order?id=1234"          type="application/xml"/></order>```Both forward/backward links, when possible (e.g., order having ’cancel/delete’ link)

---

## REST principles: hypermedia

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/GET-Parts.png)

---

## REST principles: hypermedia

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/GET-Specific-Part.png)

---

## REST principles: satefy and idempotence
REST Uniform Interface, if properly followed, gives you two properties:* **Safety (GET):** Read-only operations. The operations on a resource do not change any server state. The client can call the operations 10 times, 1000 times, it has no effect on the server state.* **Idempotence (GET, PUT and DELETE):** Operations that have the same “effect" whether you apply them once or more than once. An effect here may well be a change of server state. An operation on a resource is idempotent if making a request once has the same effect as making the identical request multiple times.


---

## REST principles: representations

One resource, many representations

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/REST-Representations.png)

---

## REST principles: representations

* **XML**
```xml
<animals>
	<dog>
		<name>Rufus</name>
		<breed>Labrador</breed>
	</dog>
	<dog>
		<name>Marty</name>
		<breed>whippet</breed>
	</dog>
	<cat name="Matilda" />
</animals>
```
* **JSON**
```json
{ animals : {
	dog: [ 	{ 	name:"Rufus",
		  		breed:"Labrador"
			},
			{ 
				name:"Marty",
		  		breed:"whippet"
			}
		],
	cat : {
			name:"Matilda" 
		}
	}
}
```

---

## Building REST Services

* REST does not requires you to use a specific client or server-side framework in order to write your Web services. All you need is: 
	* a client or server that supports the HTTP protocol (i.e., a web server, a browser).
	* choose a language of your choice* **In Java:** You’d use servlets and override doGet(), doPost(), doPUT() and doDelete()	* URLs contains: servlet path + path info (all you need to process a request in REST)	* You could use a third-party library for generating specific content type (CSV, JSON or XML, etc.) or use Strings concatenations for simple responses.


---

## Configuration

* **Eclipse WTP**  Install all packages from the category "Web, XML, Java EE Development and OSGi Enterprise Development" 
* 'Preferences' -> 'Server' -> 'Runtime Environments'
* Click the 'Add' button, then follow the prompts to specify the current location of your own apache tomcat runtime
* http://www.getpostman.com/

---

## Congiguration: Jersey

A zip of Jersey is can be downloaded from Jersey Download page. But to save some bandwidth, you can use the one we saved to the course account. Note that we only saved the necessary jar files here (not the documents that come with the original download).

* https://jersey.java.net/

Unzip the downloaded zip file into your home directory. We will use this later through Eclipse WTP. Remove the zip file.

Jersey contains basically the core server and the core client. The core client provides a library to communicate with the server. Jersey is implemented as a servlet dispatcher for REST requests - so it will be deployed to Tomcat like a servlet.

--

## Hello World Example

* Create project:
	* Create a new 'Dynamic Web Project' (File -> New -> Other -> Web) and call it 'introsde.simple.rest.hello'
	* Once the project is created, navigate to WebContent/WEB-INF/lib folder
	* While the lib folder is highlighted, do 'right mouse click' to open a menu, then choose Import -> File system -> Specify the jersey_core directory you saved the jersey library files to. Note: Click and highlight the directory, but do not 'tick' the box next to the directory name. Tick the boxes next to all 8 jar files for importing (figure shown below).

---

## Hello World Resource

* For this hello world example, we are going to create a single java class as a resource.
* Create the following Java class with a package name 'cs9322.simple.rest.hello'
package cs9322.simple.rest.hello;

```java
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/helloworld")
public class HelloWorld {	
	// When client wants XML
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML() { 
	   return "<?xml version=\"1.0\"?>" + "<msg>" + "Hello World in REST" + "</msg>";
	}
	// When client wants HTML
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHtml() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello World in REST" + "</body></h1>" + "</html> ";
	}
}
```

* The above resource supports two representations (XML and HTML). We will use 'content negotiation' to select a specific representation later.
Note: you browser will always request HTML MIME type as the first preference.

---

## Register Jersey Servlet Dispatcher:

* You need to add the resource you created and a jersey servlet dispatcher in the web.xml file. The correct content of the web.xml file is shown below (the servlet and servlet-mapping below may come before the existing content in your default web.xml)
* Right click on Deployment Descriptor -> Generate Deployment Descriptor Stub
* Open it with double-click


```xml
	<servlet>
    <servlet-name>Jersey REST Service</servlet-name>
    <servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
    <init-param>
      <param-name>com.sun.jersey.config.property.packages</param-name>
      <param-value>cs9322.simple.rest.hello</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Jersey REST Service</servlet-name>
    <url-pattern>/rest/*</url-pattern>
  </servlet-mapping>
```

* Important Note: the param-name "com.sun.jersey.config.property.package" is a configuration parameter. Its value should point to the resource classes (i.e., the package 'cs9322.simple.rest.hello' in our case).

* Note the url-pattern in servlet-mapping. Any URL with this pattern will be handled by Jersey servlet dispatcher.


---

## Testing the HelloWorld service:

* **[Run the project]** Run the project (while the project is highlighted, do right mouse click, then choose 'Run As' -> 'Run on Server'. Follow the prompt to deploy the project to your Tomcat runtime.

* **[Test it first with your browser]** try 'http://localhost:8080/introsde.simple.rest.hello/rest/helloworld'. You should see the result of sayHelloHtml() (try viewing the source of the page returned).

[Test it with a REST-client tool (e.g., Chrome Simple REST Client extension)] You can get Chrome Simple REST client from the Chrome Web Store (https://chrome.google.com/webstore/detail/fhjcajmcbmldlhcimfajhfbgofnpcjmb). SS told me that you can actually install an extension for Chrome yourself ... Such an extension will be installed on your home directory.

You can use any other REST client tool you can find ... Let me know if you find a good one !

---

## Maven

* http://apache.fis.uniroma2.it/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.zip