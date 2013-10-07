# Introsde2013 @ UNITN - Lab Session #3

In this lab session, review the axis2 exercise from Lab session#2 and then head on to learn how to parse an xml file. 

## Outline

## Lab 2 Recap

Before starting with this lab, we will review the [the example 2 of Lab #2](https://github.com/cdparra/introsde2013/tree/master/lab2#example-2) step by step

	cd lab2/Example2/quickstart
	open resources/META-INF/services.xml

**1. Check the service.xml file** 


```

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

**2. Check/Adjust the build.xml file** 

First, replace the properties AXIS2_HOME and AXIS2_HOME_TOMCAT to make it fit your local configuration

	<!-- replace them appropiately to match the places where these folders are
		in your computer -->
    <property name="AXIS2_HOME_TOMCAT" value="/opt/apache-tomcat-7.0.39/webapps/axis2"/>
    <property name="AXIS2_HOME" value="/opt/axis2-1.6.2"/>

For example, in your windows PC it might look like

    <property name="AXIS2_HOME_TOMCAT" value="C:\apache-tomcat-7.0.39\webapps\axis2"/>
    <property name="AXIS2_HOME" value="C:\axis2-1.6.2"/>

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

**3. Generate WSDL and the packaged service (.aar)** 
	
	ant generate.wsdl
	ant generate.service

**4. Check that the service has been deployed** 
	
	http://localhost:8080/axis2/services/listServices
	

## XPath

### Example 1


### Exercise 1

## JAXB and Dozer (part 1)

### Example 2

### Exercise 2

	
	
 



