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
* Resources are something the server is responsible for managing Resources must have representations to be ’transmitted’ to client

---

## REST principles: uniform interface

**Uniform Interface:** Uniform ‘verbs’ that go with the resources (noun)
<order xmlns="urn:starbucks">

	* returns: location: /starbucks/orders/order?id=1234
* GET /starbucks/orders/order?id=1234 (to read an order)
* PUT /starbucks/orders/order?id=1234 (to update an existing order)
* DELETE /starbucks/orders/order?id=1234 (to delete an existing order)

---

## REST principles: hypermedia


**Connectedness/Links:** Resources may contain links to other resources
201 Created

---

## REST principles: hypermedia

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/GET-Parts.png)

---

## REST principles: hypermedia

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/GET-Specific-Part.png)

---

## REST principles: satefy and idempotence
REST Uniform Interface, if properly followed, gives you two properties:


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
	* choose a language of your choice


---

## Configuration

* For the lab, we will use **Eclipse WTP**, which provides tools for developing standard Java web applications and Java EE applications
* To install, use **Help -> Install new software -> All Available Sites**
	* You can also use only the WTP repository: **http://download.eclipse.org/webtools/repository/kepler** (might change according to your version of eclipse)
* Search for **"Web Tools Platform"** and install all what's inside that category (using the latest version)
* In old versions of eclipse, there might be a category "Web, XML, Java EE Development and OSGi Enterprise Development". Install all inside. 

![](https://raw.github.com/cdparra/introsde2013/master/lab5/resources/EclipseWTP.png)
 
* 
* 'Preferences' -> 'Server' -> 'Runtime Environments'
* Click the 'Add' button, then follow the prompts to specify the current location of your own apache tomcat runtime
* http://www.getpostman.com/

---