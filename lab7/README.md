# REST-based Web Services (III)
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #6*
<br>**University of Trento** 

---

This is a DRAFT in progress

## Exercise 1: HTTP Clients

* Take a look at the [HTTP Restful Client example of lab6](https://github.com/cdparra/introsde2013/blob/master/lab6/Example1-SimpleRestful/src/introsde/simple/rest/client/Test.java)
* Create a client like the one of lab6, but in this case, to communicate with the WEBDIS <key,value> quasi-REST API for storing/retrieve <key,value> type of information 

---

## Exercise 1: WEBDIS Server details

The Quasi-REST WEBIDS API (quiz: **why is quasi-REST not entirely REST?**)

* BASEURL = http://test.lifeparticipation.org/webdis/
* API Endpoints: 
	1. **Store a <key,value>:** GET /SET/key/value
	2. **Retrieve a <key,value>** GET /GET/key	
	3. **Store a <hashkey,<innerkey,value>>:** GET /HMSET/hashkey/innerkey/value
	4. **Retrieve the value for <hashkey,innerkey>:** GET BASEURL/HGET/hashkey/key
	5. **Retrieve all the <innerkey,value> for hashkey:** GET /HGETALL/hashkey
* **Notes:** 
	* 3 and 4 can recieve more than one *<key,value>* 
	* The character "/" must be replaced by "%2f" in values and keys
	* The character "." must be replaced by "%2e" in values and keys

---

## Exercise 1: WEBDIS Server Examples

* http://test.lifeparticipation.org/webdis/SET/1/pinco pallino
* http://test.lifeparticipation.org/webdis/GET/1
* http://test.lifeparticipation.org/webdis/HMSET/pinco pallino/weight/78/height/1%2e67
* http://test.lifeparticipation.org/webdis/HGETALL/pinco pallino
* http://test.lifeparticipation.org/webdis/HMGET/pinco pallino/height/weight
* Don't break the server, be polite with your requests :-)
* be mindful that you will all be querying the same key,value database, so you might want to use different "keys"

---

## Exercise 2:

* Add a services UPDATE and DELETE a person from the database 

---

## Assignment #2: Part 1

* Create a model that supports
	* People identified by an id and having at least birthdate, first and lastname
	* A Health/Lifestyle profile for each person, with measures such as **weight** and **height**
	* The history of this measures by date

---  

## Assignment #2: Part 2

* With that model, expose the following services through a RESTful API as follows:	* CRUD operations for person (GET,POST,PUT,DELETE) /person/{id}
	* GET /person should list all the names in your database (**extra points if this comes from an actual database**) 
	* GET /person/{id} should give all the personal information plus current measures of person {id} 
	* GET /person/{id}/{measure} should return the list of values (the history) of {measure} for person {id}
	* GET /person/{id}/{measure}/{mid} should return the value of {measure} identified by {mid} for person {id}
	* POST /person/{id}/{measure} should save a new value for the {measure} of person {id}
	* **Extra points:** PUT /person/{id}/{measure}/{mid} should update the value for the {measure} of person {id}
	* **Extra points:** GET /person/{id}/{measure}?before={beforeDate}&after={afterDate} should return the history of {measure} for person {id} in the specified range of date
	* **Extra points:** GET /person?maxWeight={max}&minWeight={min} retrieves people that fulfills this range (if only one fo the query params is provided, use only that)

---

## Assignment #2: Part 2

* Implement a client that call all these services and print the returned information (you can print them as you wish, in a web page or in the console) 
* Notes: 
	* It's OK to use only the Standalone server
	* Choose XML or JSON to work with. 
	* Test will be live on the VIVA Assignment evaluation (against the clients of other students)
	* Deployment details will be sent out later. 
	* Part of these services are going to be part of your final projet

---

## Assignment Rules

* Before submission make a zip file that includes only
	* All Java source files 
	* please, do not include .class or IDE generated project files
* Rename the Zip file to: your full name + assignment_no. for example: cristhian_parra_2.zip
* Submission link: www.dropitto.me/introsde2013* Password will be given and class and sent to the group
* **Soft Deadline:** 3/december, midnight. 
* **Hard Deadline:** 17/december (with the third assignment)
	* On this date, we will test the services matching clients and servers 

---

## Assignment Evaluation

* The assignment will be evaluated in terms of:
	* Requirements satisfaction
	* Execution & Deployment
	* Code design/independence/competence
	* Submitted in time ?
	* Report (or documentation)
	* Code originality (if you choose to do it in pairs) 
* Extra points are used as "recoery" you didn't finish the requirements or didn't submit in time



