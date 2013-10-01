# Introsde2013 @ UNITN - Lab Session #2

In this lab session, we will code a very first and simple example of a SOAP web service, using Apache AXIS 2

## Outline of the session

* ANT and Java
	* What's a build tool? 
	* What's ANT?  
	* ANT simple example: basic build file to compile a simple java program
	* Exercise
* Apache Axis and Tomcat 
	* Web Service Middle ware: An overview
	* Axis Installation
	* Deployment of a Java Web Service (JWS)
	* Running a Client with Dll Method

## Before the lab
Required resources: 
* Java
* Ant
* Tomcat
* Apache Axis 2

No experience with Java?, try out a [quick tutorial](http://www.vogella.com/articles/JavaIntroduction/article.html) 

Fetch updated lab session code from Github 
* Steps to follow in Lab 1 [solution to the exercise 1](https://github.com/cdparra/introsde2013/blob/master/lab1/solutions/Ex1.md)

## ANT and Java

In the directory [lab2/Example1/src](lab2/Example1/src)
Open Test.java

	public class Test {
    	public static void main(String args[]){
        	System.out.println("Hello World!");
    	}
	}
	
What if I have a giant project, with many classes, many source folders, many packages, and want to package them all into a single jar, or a directory, or simply want to automate build? 

Ant is a Java-based build tool
A build tool automates repetitive tasks (e.g. compiling source code, running tests, generating documentation).
Typically, without a graphical user interface (headless) directly from the command line.
Others: Maven and Gradle.
Open source
Full portable
