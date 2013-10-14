class: center, middle, inverse

# JAXB, XML schemas & Dozer 
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #4*
<br>**University of Trento** 

---

## Outline

* Introduction to JAXB
* XML schema
* Java Annotation
* Example: from schema to java representations
* Example: Generate an XML document from an Object Model
* Exercise
* Dozer
* Assignment

---

## Introduction to JAXB

* JAXB = **J**ava **A**rchitecture for **X**ML **B**inding
* Java standard that defines how Java objects are converted **from** and **to** XML. 
* As opposed to XPATH, now we can map XML to a set of Java Classes and restrict our Java program to java objects (not a document tree)
* JAXB Provides two main features: 
	* the ability to **marshal** (i.e., convert) Java objects into XML
	* the ability to **un-marshal** XML back into Java objects
* https://jaxb.java.net/

---

## JAXB Architecture

![](https://raw.github.com/cdparra/introsde2013/master/lab4/resources/JAXB-Architecture.png)


---

## XSD: XML Schema Definition (1)

* An XML schema describes the structure of an XML document
* An XML Schema is written in XML
* It is an XML‐based alternative to DTD (document type definition - which is yet another set of markups to learn)
* XML Schema is a W3C Recommendation: http://www.w3.org/2001/XMLSchema

---

## XSD: XML Schema Definition (1)

* An XML Schema defines:
	* **elements** that can appear in a document
	* **attributes** that can appear in a document
	* **data types** for elements and attributes
	* which elements are **child** elements
	* the **order** of child elements
	* whether an element is **empty** or can include **text**
	* **default and fixed values** for elements and attributes

---

## Example 1: XSD 

```xml 
	<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
		xmlns:example="http://www.example.com/Example" 
    	targetNamespace="http://www.example.com/Example">
    	<xsd:complexType name="Person">
        	<xsd:sequence>
            	<xsd:element name="firstName" type="xsd:string"/>
	            <xsd:element name="lastName"  type="xsd:string"/>
    	        <xsd:element name="age"       type="xsd:int"/>
        	    <xsd:element name="health-profile" type="HealthProfile"/>
         	</xsd:sequence>
	        <xsd:attribute name="ssn"     type="xsd:ID"/>
    	    <xsd:attribute name="version" type="xsd:int"/>
    	</xsd:complexType>
    	<xsd:complexType name="HealthProfile">
        	<xsd:sequence>
            	<xsd:element name="weight" type="xsd:decimal"/>
            	<xsd:element name="height"  type="xsd:decimal"/>
         	</xsd:sequence>
         	<xsd:attribute name="ssn"     type="xsd:ID"/>
         	<xsd:attribute name="version" type="xsd:int"/>
    	</xsd:complexType>
	</xsd:schema>
```

---


## Assignment #1

* Replace the HashMap db in the HealthProfile Reader with a xml file as follows

```xml
<people>
    <person>
        <firstname>George R. R.</firstname>
        <lastname>Martin</lastname>
        <healthprofile>
            <weitgh>120</weitgh>
            <height>1.65</height>
        </healthprofile>
    </person>
    <!-- add more people to the db --> 
</people>
```

* Use xpath to implement methods like getWeight and getHeight
* Make a function which prints all people in the list with detail
* A function which accepts name as parameter and print that particular person HealthProfile
* A function which accepts weight and an operator (=, > , <) as parameters and prints people that fulfill that condition.