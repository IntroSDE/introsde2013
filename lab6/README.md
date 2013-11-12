# REST-based Web Services (II)
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #6*
<br>**University of Trento** 

---

This is a DRAFT in progress

## Outline

* Frameworks
* Configuring Development environment
* REST Services example with Jersey
* Calling REST Services


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

* **Important Note**: the 'param-name' tag "com.sun.jersey.config.property.packages" is a configuration parameter. Its corresponding 'param-value' tag value should point to the package where the resource classes are located (i.e. the package "cs9322.simple.rest.hello" in our case).
If your resource classes are located in the default package you can put either "." (without quotes) as the value or completely omit the 'param-name' and 'param-value' tags.

* Note the url-pattern in servlet-mapping. Any URL with this pattern will be handled by Jersey servlet dispatcher.


---

## Testing the HelloWorld service:

* **[Run the project]** Run the project (while the project is highlighted, do right mouse click, then choose 'Run As' -> 'Run on Server'. Follow the prompt to deploy the project to your Tomcat runtime.

* **[Test it first with your browser]** try 'http://localhost:8080/introsde.simple.rest.hello/rest/helloworld'. You should see the result of sayHelloHtml() (try viewing the source of the page returned).

* **[Test it with a REST-client tool]** you can use any REST client tool, below you will find links to some of them.

---

## REST clients

* [Postman](http://www.getpostman.com) [Chrome extension]
* [Simple REST Client](https://chrome.google.com/webstore/detail/fhjcajmcbmldlhcimfajhfbgofnpcjmb) [Chrome extension]
* [rest-client](http://code.google.com/p/rest-client/) [Java, multi-platform]
* [cocoa-rest-client](http://code.google.com/p/cocoa-rest-client/) [Mac OS X]
* Let me know if you find others !

---

## Maven

* http://apache.fis.uniroma2.it/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.zip