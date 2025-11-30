# JSF-Skeleton

## Overview

This is a skeleton of an Java Server Faces (JSF) application, a framework based on Java EE technologies.<br/>
The goal is to show the necessary structure and tools for any project.<br/><br/>
This example uses Wildfly 27 as the server and corresponding versions for other elements.
If no version is specified use the lastest one.<br/>
For more details use readme2<br/>

**Quick Start** <br/><br/> 
 
This project should be build for local development for WildFly application server with MAVEN as '.war' file:<br/>
 
- run MAVEN commands in the root folder of the Java project,<br/><br/>
``mvn install -DskipTests``<br/><br/>

## Tools

- **JDK 17** (Java Development Kit)
- **IDE: Eclipse**
- **Build Tool: Maven**
	- use the pom.xml to manage dependencies and build (configure mvn compiler for Java 17)
	- 'mvn help:effective-pom' can be useful
- **Repository: Git + GitHub/GitLab/BitBucket**

## Technology

- **Jakarta EE 10**
- **Servlet (Jakarta Servlet 6.0 / web-app 6.0)**
- **Main Framework: JSF 4.0 (Java Server Faces)**
	- Implementation: Mojarra 4.0 or MyFaces 4.0
- **CDI 4.0 (Context and Dependency Injection)**
	- Implementation: Weld 5
- **(Jakarta) Expression Language / EL 5.0**
- **Persistence Layer: JPA 3.1 (Java Persistence API)**
	- Implementation: Hibernate 6.1
	- define a persistence unit (persistence.xml)
- **Database: H2**
- **Java EE Server: Wildfly 27.0.1**
	For compatible versions of dependencies:
	- "https://www.wildfly.org/news/2022/11/09/WildFly-27-Final-is-released/"
	- "https://mvnrepository.com/artifact/org.wildfly.core/wildfly-core-component-matrix/27.0.1.Final"
	- contains many dependencies by default

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
 
## Namespaces
All recommended namespaces for JSF:

```xml
<html xmlns="http://www.w3.org/1999/xhtml"        //marks the page as xhtml
	xmlns:h="http://xmlns.jcp.org/jsf/html"       //html-elements
	xmlns:f="http://xmlns.jcp.org/jsf/core"       //JSF-elements
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"> //mainly for templates
</html>
```

## Config

- create an empty 'beans.xml' file
- use either:
  - 'web.xml' to configurate your webapp (define and map your FacesServlet)
  - create a 'FacesApplicationConfig.java' (add the annotations '@FacesConfig' and '@ApplicationScoped')

- 'faces-config.xml' is optional

## Optional recommendation

- PrimeFaces as a dependency (':p' namespace)
- JUnit 5 for tests