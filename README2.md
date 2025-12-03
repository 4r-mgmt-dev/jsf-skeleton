# JSF-Skeleton
 
* [About](#about)
* [Tools](#tools)
* [Technology](#technology)
* [Project Structure](#project-structure)
* [Components](#components)
* [Namespaces](#namespaces)
* [Config](#config)
* [Build](#build)
* [Optional Dependencies](#optional-dependencies)

## About
**Summary**<br/><br/>
This is a skeleton of an Java Server Faces (JSF) application, a framework based on Java EE technologies.<br/>
The goal is to show the necessary structure and tools for any project.<br/><br/>
 
**Quick Start** <br/><br/> 
 
This project should be build for local development for WildFly application server with MAVEN as '.war' file:<br/>
 
- run MAVEN commands in the root folder of the Java project,<br/><br/>
``mvn install -DskipTests``<br/><br/>


## Tools
 
<h3>Java Version</h3> (Java Development Kit)
 
- **Java (JDK) 17** download: "https://www.oracle.com/de/java/technologies/downloads"

A bundle of software development tools for the programming language Java.
 
<h3>IDE Tool</h3> (Integrated Development Environment)
 
- **Eclipse (4.36.0)** download: "https://www.eclipse.org/downloads/packages/"

IDE for Enterprise Java and Web Developers. Use latest version
 
<h3>Build Tool</h3> (Dependencies Management and Build Tool)
 
- **Maven (3.9.10)** download: "https://maven.apache.org"

A tool for building, updating and installing projects. It also manages dependencies.

(You can use 'mvn archetype:generate' with the archetypeArtifactId: 'maven-archetype-webapp'
in your console to generate a web-project.)
 
<h3>Repository</h3>
 
[See the definiton of terminologies] "https://www.tutorialspoint.com/gitlab/index.htm" across the terms like Git, Gitlab, GitHub, and Bitbucket below:<br/>
- **Git.exe (2.43.0)**  - It is a source code versioning system that lets you locally track changes and push or pull changes from remote resources. Use latest version
- **GitLab, GitHub, and Bitbucket** - Platforms for sharing / backing up code. They offer Git functionality with added collaboration tools.

## Technology
- Jakarta EE 10 "https://jakarta.ee/release/10/" (formerly Java EE)
	- A platform for developing and running network applications.
- Servlet (Jakarta Servlet 6.0 / web-app 6.0)
	- a java class that can read and write HTTP-requests/-responses
	- it can interact with your data, sessions and business logic.
- Java EE Server / Servlet Container/Engine
	- Implements Jakarta EE and provides/manages apps as services (e.g. WildFly, Payara, GlassFish, WebLogic, WebSphere...).
	- Manages the servlets, their lifecycles and maps them to an URL. Routes requests to the FacesServlet (JSF).
- CDI 4.0
	- Context and Dependency Injection is a specification as part of Java EE for creating containers and injecting dependencies (Java Beans)
- JSF 4.0
	- Java Server Faces is a web application framework that uses facelets and allow building XHTML web-pages, templates, managing validation and navigation as well as communication with Java Beans (CDI)
	- It seperates the UI (.xhtml) and the logic (Java Beans) and allows data exchange through CDI and Expression Language.
	- built on top of the Servlet API
	- it handles a request in a lifecycle with 6 phases
	
	        1. Restoring the component tree
	        2. Applying (and converting) request values
	        3. Process Validation
	        4. Updating Model Values
	        5. Invoking the application
	        6. Rendering the response

- (Jakarta) Expression Language / EL 5.0
	- a dynamically interpreted language, which can reference bean values and methods
	- example expression: "#{bean.name}", a class name followed by a value or method,
	class names start with lower case
- JPA 3.1
	- Java Persistence API is a specification which maps Java objects to database entities.
	- It connects the business logic and the data layer. Implementations are for example Hibernate.
- Weld 5
    - a framework which integrates CDI beans into Java EE applications (implementation of CDI)

  
## Project Structure

```text
 skeleton/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   ├── resources/
 │   │   │   └── META-INF
 │   │   │       └── persistence.xml
 │   │   └── webapp/
 │   │       └── WEB-INF/
 │   │           ├── web.xml
 │   └── test/   ├── beans.xml
 ├── pom.xml     └── (faces-config.xml)
 └── README.md
 ```
 
 - xhtml, css, js files inside the webapp folder, java files inside the java folder
 
## Components
 
<h3>Java EE 10</h3>
 
Web components of Jakarta namespace<br/><br/>
Add the following into MAVEN project ``pom.xml`` file under ``<dependencies>`` element section:
 
```xml
<dependency>  <!-- comment bla bal -->
	<groupId>jakarta.platform</groupId>
	<artifactId>jakarta.jakartaee-api</artifactId>
	<version>10.0.0</version>
	<scope>provided</scope>
</dependency>
```
 
<h3>Java EE 10 Server</h3>
 
- **WildFly 27.0.1** is a modular and lightweight **Jakarta** based Java EE application server that helps build applications.<br/>
Download the server: "https://www.wildfly.org"

We are using compatible versions of dependencies listed on:
- "https://www.wildfly.org/news/2022/11/09/WildFly-27-Final-is-released/"
- "https://mvnrepository.com/artifact/org.wildfly.core/wildfly-core-component-matrix/27.0.1.Final"
(- "https://github.com/primefaces/primefaces?tab=readme-ov-file#versions") optional
Many are already included in the Wildfly server.

<h3>JPA Provider</h3>
 
- **Hibernate 6.1** implementation is used as JPA Provider <https://hibernate.org/>.

<h3>Database</h3>

- **H2** is an open source object-relational database system.<br/>
Download the database system: "https://www.h2database.com/html/download.html".<br/><br/>
Add the following into MAVEN project ``pom.xml`` file under ``<dependencies>`` element section:
 
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId> 
    <version>2.4.240</version>
</dependency>
 
**Persistence-unit**<br/>
The connection properties of a databases can be configured as a Persistence-unit.<br/><br/>
Add the following ``persistence.xml`` file into MAVEN project under ``/src/main/resources/META-INF`` folder:
 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence
    xmlns="https://jakarta.ee/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
    version="3.1">

    <persistence-unit name="admin-jta" transaction-type="JTA">
        <!-- Jakarta EE 10 uses the Hibernate ORM Jakarta module -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <!-- JNDI name can be configured in WildFly standalone.xml or via CLI -->
        <!-- legacy <jta-data-source>java:/AdminDS</jta-data-source> -->

        <!-- Your entity classes -->

        <class>br.com.xxx.User</class>
        <class>br.com.xxx.Whatever</class>

        <properties>
        	<property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
    		<property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"/>
    		<property name="jakarta.persistence.jdbc.user" value="sa"/>
    		<property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
            <!-- Optional Hibernate extras -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```
- there is no xsd file for 3.1 so 3_0.xsd is used instead (may cause an error message)
- alternatively use version="3.0"

**Alternative:** datasource and configuration can be done on the server site e.g. on wildfly in the standalone.xml file)
- edit the standalone.xml to fit your database and source:
```xml
<datasources>
	<datasource jndi-name="java:/AdminDS" pool-name="AdminDS" enabled="true" use-java-context="true">
    		<connection-url>jdbc:h2:mem:admin;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
    		<driver>h2</driver>
    		<security>
        		<user-name>sa</user-name>
        		<password></password>
    		</security>
	</datasource>
         <drivers>
            <driver name="h2" module="com.h2database.h2">
                <driver-class>org.h2.Driver</driver-class>
            </driver>
         </drivers>
</datasources>
 
```

**JSF implementation (Mojarra)**

```xml
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>jakarta.faces</artifactId>
    <version>4.0.0</version>
</dependency>
```

**MyFaces 4.0 ("https://myfaces.apache.org/#/core40")**
- lightweight alternative to Mojarra

```xml
<dependency>
  <groupId>org.apache.myfaces.core</groupId>
  <artifactId>myfaces-api</artifactId>
  <version>4.0.3</version>
</dependency>
<dependency>
  <groupId>org.apache.myfaces.core</groupId>
  <artifactId>myfaces-impl</artifactId>
  <version>4.0.3</version>
</dependency>
```
 
## Namespaces
All recommended namespaces for JSF:

```xml
<html xmlns="http://www.w3.org/1999/xhtml"        //marks the page as xhtml
	xmlns:h="http://xmlns.jcp.org/jsf/html"       //html-elements
	xmlns:f="http://xmlns.jcp.org/jsf/core"       //JSF-elements
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"> //mainly for templates
</html>
```

——————————————————————————————————————————————————————————————————————

## Config

There are two possible approaches for the configuration of your web application:

1. web.xml
Define all your filters, listeners, context parameters, explicit navigation, servlets, 
servlet mappings and startup page inside this file.
Use mime-mapping to add extra datatypes if necessary.
It's usually automatically created inside your src/main/webapp/WEB-INF folder when you create a webproject.
If not create one yourself.

Example web.xml:

´´´xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                             https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

    <display-name>Skeleton App</display-name>
    <servlet>
        <servlet-name>FacesServlet</servlet-name>
        <servlet-class>jakarta.faces.webapp.FacesServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>FacesServlet</servlet-name>
        <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.xhtml</welcome-file>
    </welcome-file-list>
</web-app>

´´´


2. FacesApplicationConfig.java (no web.xml in the project)

- create a 'config' folder in your 'src/main/java/packagename/
- create the javafile with the same name as stated in the title

Empty example:

```java

package com.example.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;

@FacesConfig
// you can specify the JSF version you want to use: "@FacesConfig(version = FacesConfig.Version.JSF_4_0)"
@ApplicationScoped
public class FacesApplicationConfig {
    
}

```
Even this empty class enables JSF with modern features.
For Filters and Listeners new classes with the annotations @WebFilter and @WebListener are used.
Beans are used for implicit navigation. faces-config can be used for explicit navigation.

Regardless of the approach an empty beans.xml is also necessary (same folder as web.xml).
A faces-config.xml is not needed in modern projects unless for explicit navigation.

————————————————————————————

## Build

- Maven needs to be installed, use the latest version if possible.
- Use mvn help:effective-pom in your project root to get the versions of your Maven-plugins.

Example build in your pom.xml:

```xml
<build>
        <finalName>skeleton</finalName>
        <plugins>
            <!-- Compiler plugin (configure for Java 17) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
        			<release>17</release>
        			<encoding>UTF-8</encoding>
    			</configuration>
            </plugin>

				<plugin>
          		<artifactId>maven-resources-plugin</artifactId>
          		<version>3.3.1</version>
          		<configuration>
        				<encoding>UTF-8</encoding>
    				</configuration>
        		</plugin>

            <!-- WAR plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.4.0</version>
                <configuration>
                	<!-- web.xml can be replaced by annotations -->
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
        </plugins>
</build>
```

—————————————————————————————————————————————————————————————————————————————————————————


## Optional Dependencies


**PrimeFaces**
 
PrimeFaces is a lightweight library to extend JSF components with one jar, zero-configuration and no required dependencies.<br/><br/>
Add the following into MAVEN project ``pom.xml`` file under ``<dependencies>`` element section:
 
```xml
<dependency>
    <groupId>org.primefaces</groupId>
    <artifactId>primefaces</artifactId>
    <version>15.0.9</version>
    <classifier>jakarta</classifier>
</dependency>
```

How to get started quickly with PrimeFaces see: "https://www.mastertheboss.com/category/web/primefaces/"

PrimeFaces namespace is necessary to add PrimeFaces components to the ``.xhtml`` pages.
Can be used instead of the JSF-elements(:f).
 
```xml
<html xmlns:p="http://primefaces.org/ui">
</html>
```


**OmniFaces 4.x ("https://omnifaces.org/")**

- Adds functionality to Primefaces

```xml
<dependency>
    <groupId>org.omnifaces</groupId>
    <artifactId>omnifaces</artifactId>
    <version>4.6.5</version>
</dependency>
```
- Namespaces:

xmlns:o="http://omnifaces.org/ui"
xmlns:of="http://omnifaces.org/functions"

**Primefaces Extensions**


```xml
<dependency>
    <groupId>org.primefaces.extensions</groupId>
    <artifactId>primefaces-extensions</artifactId>
    <version>15.0.10</version>
    <classifier>jakarta</classifier>
</dependency>
```

- Namespaces:

xmlns:pe="http://primefaces.org/ui/extensions"

**Primefaces Themes**

- set the theme via context parameter in the web.xml

"https://mvnrepository.com/artifact/org.primefaces.themes/all-themes"
```xml
<dependency>
    <groupId>org.primefaces.themes</groupId>
    <artifactId>all-themes</artifactId>
    <version>1.1.0</version>
</dependency>
```

**WebJars**

- provide client-side web libraries as JAR files.
- referenced like this:

```xhtml
<h:outputStylesheet library="webjars" name="bootstrap/3.1.0/css/bootstrap.min-jsf.css" />
<h:outputScript library="webjars" name="jquery/1.11.2/jquery.js" />
```
*FontAwesome*
- additional fonts

"https://mvnrepository.com/artifact/org.webjars.bower/fontawesome"
```xml
<dependency>
    <groupId>org.webjars.bower</groupId>
    <artifactId>fontawesome</artifactId>
    <version>4.7.0</version>
</dependency>
```

*ChartJS*
- Javascript library for visualizing data using different charts

```xml
"https://mvnrepository.com/artifact/org.webjars/chartjs"
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>chartjs</artifactId>
    <version>4.4.3</version>
</dependency>
```

**HikariCP**

- is a high performance JDBC connection pool
- introduction on "https://www.baeldung.com/hikaricp"
- Wildfly already provides connection pooling

"https://mvnrepository.com/artifact/com.zaxxer/HikariCP"
```xml
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>7.0.2</version>
</dependency>
```

"https://mvnrepository.com/artifact/org.hibernate/hibernate-hikaricp"
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-hikaricp</artifactId>
    <version>7.1.7.Final</version>
    <type>pom</type>
</dependency>
```


**Quartz**

- job scheduling framework
- can execute tasks that need to be performed regularly
- introduction on "https://www.baeldung.com/quartz"

"https://mvnrepository.com/artifact/org.quartz-scheduler/quartz"
```xml
<dependency>
    <groupId>org.quartz-scheduler</groupId>
    <artifactId>quartz</artifactId>
    <version>2.5.1</version>
</dependency>
```
- add quartz-jobs dependency if you want prebuilt jobs

"https://mvnrepository.com/artifact/org.quartz-scheduler/quartz-jobs"
```xml
<dependency>
    <groupId>org.quartz-scheduler</groupId>
    <artifactId>quartz-jobs</artifactId>
    <version>2.5.1</version>
</dependency>
```


**json.bind-api and yasson**

- specification and implementation of a framework, which binds classes to json documents
- already included in Wildfly

**POI**

- API to access Microsoft files

```xml
"https://mvnrepository.com/artifact/org.apache.poi/poi"
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.4.1</version>
</dependency>
```

- For modern Excel-files(2007+)
```xml
"https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml"
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.4.1</version>
</dependency>
```

**Dependencies for tests**

**JUnit 5**

- a test framework (runs and organizes tests)

"https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api"
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>6.0.1</version>
    <scope>test</scope>
</dependency>
```

"https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine"
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>6.0.1</version>
    <scope>test</scope>
</dependency>
```

- alternatively junit-jupiter contains both
- Use Vintage instead of Jupiter for old files

**Mockito**

- mocking library (creates fake objects)
- API and implementation

"https://mvnrepository.com/artifact/org.mockito/mockito-core"
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.20.0</version>
    <scope>test</scope>
</dependency>
```

- JUnit 5 support
"https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter"
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.20.0</version>
    <scope>test</scope>
</dependency>
```


**PowerMock**

- extends Mockito
- not recommended for JVMs 17+
