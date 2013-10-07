# Axis2 recap and XPATH 
Introduction to Service Design and Engineering 2013/2014. 
<br>*Lab session #3*
<br>**University of Trento** 

---

## Outline

* Recap axis2 web service sample of the last session
* Practice how to create a simple axis2 web service by doing lab2/Exercise3
* Example of XML parsing using XPATH and java (covered in Lecture 3)
* First part on JAXB xml parsing *(if there is time)*

---

## Lab 2 Recap

Before starting with this lab, we will review the [the example 2 of Lab #2](https://github.com/cdparra/introsde2013/tree/master/lab2#example-2) step by step.

```sh
	cd lab2/Example2/quickstart
	open resources/META-INF/services.xml
```

---

**1. Check the service.xml file** 

```xml
	<service name="StockQuoteService" <!-- The name of the service -->
		scope="application"
		targetNamespace="http://quickstart.samples/"
		<!-- Scope and nameSpace must be later matched inthe build.xml -->
	>
		<!-- a description of what the service does -->
		<description>Stock Quote Service</description>
		
		<!-- the classes that will process incoming messages to the service -->
		<!-- we are using standar message receivers already bundled with axis2 -->
		<messageReceivers>
			<messageReceiver
				mep="http://www.w3.org/2004/08/wsdl/in-only"
				class="org.apache.axis2.rpc.receivers.RPCInOnlyMessageReceiver"
			/>
			<messageReceiver
				mep="http://www.w3.org/2004/08/wsdl/in-out"
				class="org.apache.axis2.rpc.receivers.RPCMessageReceiver"
			/>
		</messageReceivers>
		
		<!-- definition of the xml schema used by the service -->
		<schema schemaNamespace="http://quickstart.samples/xsd"/>
		
		<!-- specification of what Java class is being exposed as a service -->
		<parameter
			name="ServiceClass">samples.quickstart.service.pojo.StockQuoteService
		</parameter>
	</service>
```

---

**2. Check/Adjust the build.xml file** 

First, replace the properties AXIS2_HOME and AXIS2_HOME_TOMCAT to make it fit your local configuration

```xml
	<!-- replace them appropiately to match the places where these folders are
			in your computer -->
    <property name="AXIS2_HOME_TOMCAT" 
    	       value="/opt/apache-tomcat-7.0.39/webapps/axis2"/>
    <property name="AXIS2_HOME" 
    		   value="/opt/axis2-1.6.2"/>
``` 

For example, in your windows PC it might look like

```xml
    <property name="AXIS2_HOME_TOMCAT" 
    			value="C:\apache-tomcat-7.0.39\webapps\axis2"/>
    <property name="AXIS2_HOME" 
    			value="C:\axis2-1.6.2"/>
```

---

Appart from the typical "compile" you have *generate.wsdl* and a *generate.service*. 

```xml
	<target name="generate.wsdl" depends="compile.service">
        <taskdef name="java2wsdl"
                 classname="org.apache.ws.java2wsdl.Java2WSDLTask"
                 classpathref="axis2.classpath"/>
        <!-- This is the key: java2wsdle creates the wsdle for a class -->
        <java2wsdl className="samples.quickstart.service.pojo.StockQuoteService"
                   outputLocation="${build.dir}"
                   <!-- remember, these two must be the same as in service.xml -->
                   targetNamespace="http://quickstart.samples/"
                   schemaTargetNamespace="http://quickstart.samples/xsd">
            <classpath>
                <pathelement path="${axis2.classpath}"/>
                <pathelement location="${build.dir}/classes"/>
            </classpath>
        </java2wsdl>
    </target>

	<target name="generate.service" depends="compile.service">
        <!--Copy all the classes and the service.xml file to classes folder -->
        <copy toDir="${build.dir}/classes" failonerror="false">
            <fileset dir="${basedir}/resources">
                <include name="**/*.xml"/>
            </fileset>
        </copy>
        
        <!-- Create a packaged version of the service named "StockQuoteService" -->
        <jar destfile="${build.dir}/StockQuoteService.aar">
            <fileset excludes="**/Test.class" dir="${build.dir}/classes"/>
        </jar>
        
        <!-- this part is about already deploying the service to Axis2 -->
        <copy file="${build.dir}/StockQuoteService.aar"
              toDir="${AXIS2_HOME}/repository/services"
              overwrite="yes">  
        </copy> 
    </target>
```

---

**3. Generate WSDL and the packaged service (.aar)** 

```sh	
	ant generate.wsdl
	ant generate.service
```

**4. Check that the service has been deployed** 

```sh
	Open http://localhost:8080/axis2/services/listServices
```

You should see something like:
 
![](https://raw.github.com/cdparra/introsde2013/master/lab2/resources/StockQuoteServiceDeployed.png)

---

Remember, deploying the service is simply copying the generated .aar to the services folder of axis. In the same way *removing* the service is just deleting that file.   

---

**5. Check the service WSDL** 

WSDL will be covered in a future lecture: 

	Open http://localhost:8080/axis2/services/StockQuoteService?wsdl

---

**6. Call on the available operations on the StockQuoteService** 

```sh	
	Open http://localhost:8080/axis2/services/StockQuoteService/getPrice?symbol=IBM
```
The answer is a soap message as follows: 

```xml
	<ns:getPriceResponse xmlns:ns="http://quickstart.samples/xsd">
		<ns:return>42.0</ns:return>
	</ns:getPriceResponse>
```

The StockQuoteService class has also an update operation which if called, updates the stock value for a company symbol.

```sh	
	Open http://localhost:8080/axis2/services/StockQuoteService/update?symbol=IBM&price=150
```

Calling the getPrice service now will give

```xml
	<ns:getPriceResponse xmlns:ns="http://quickstart.samples/xsd">
		<ns:return>150</ns:return>
	</ns:getPriceResponse>
```

---

**7. Exercise** 

Now, take a couple of minutes to do exercise 3 from last session: 

Modify the *HealthProfileReader* and expose it through an axis2 web service ([solution](https://github.com/cdparra/introsde2013/blob/master/lab2/solutions/Ex3))


---

## XPath

---

### Example 1
s
---


### Exercise 1

## JAXB and Dozer (part 1)

### Example 2

### Exercise 2

	
	
 



