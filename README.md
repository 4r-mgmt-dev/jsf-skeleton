# Jakarta-Faces-Skeleton

## Overview

This is a *Skeleton* for an **Jakarta-Faces** application, based on **Jakarta EE** technologies.
* The **goal** is to show the necessary structure with all required tools and (MAVEN) dependencies for any **Web Application** project.

## Quick Start

The application can be started as a *WAR* on a Jakarta EE compliant server (e.g., WildFly, Payara) or locally as a *JAR* (with embedded WildFly), using an H2 in-memory database.

1. run in cmd: ``mvn install`` to build deployable  **.war** file
2. then browse: [http://localhost:8080/index.xhtml](http://localhost:8080/index.xhtml)


- (**optional only for WildFly:** ``mvn package`` for standalone application as executable **.jar**)

## Development Tools

- **JDK 11+:** (Java Development Kit)
- **IDE: Eclipse**
- **Build Tool: Maven**
	- use the pom.xml to manage dependencies and build (configure mvn compiler for Java 11 or 17)
	- 'mvn help:effective-pom' can be useful
- **Repository: Git + GitHub/GitLab/BitBucket**

## Jakarta Technology

- **Jakarta EE 10** (set of specification components to build java web applications)
- **Servlet** (Jakarta Servlet 6.0 / web-app 6.0)
- **CDI 4.0** (Context and Dependency Injection)
	- Implementation: Weld 5
- **JSF 4.0** (Java Server Faces or Jakarta-Faces)
	- Implementation: Mojarra 4.0 or MyFaces 4.0
- **EL 5.0** (Expression Language - provides an important mechanism for enabling the presentation layer)
- **JPA 3.1** (Java Persistence API) as Persistence Layer 
	- Implementation: Hibernate 6.1 - provide persistence
- **Java EE Server:**
	- Implementation: Wildfly 27.0.1 - For other compatible versions of dependencies see:
	- "https://www.wildfly.org/news/2022/11/09/WildFly-27-Final-is-released/"
	- "https://mvnrepository.com/artifact/org.wildfly.core/wildfly-core-component-matrix/27.0.1.Final"

## Project Structure

```text
 com.[company].[app-name]/
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
 ├── pom.xml     └── faces-config.xml
 └── README.md
 ```

**TODO: describe shortly each folder** - Why it is required  
**TODO: describe shortly each file** - Why it is required

## Application-Dependencies (pom.xml)

*  Open the details section to see the required dependencies:

**TODO: explain of nessesary dependencies of pom.xml in the details section**

<details>
	
```xml



```

</details>

## Persistence-Application (persistence.xml)

Add a ```persistence.xml``` file in to the ```resources/META-INF``` folder
* Specify the connection properties according to JPA specification of ```persistence.xml``` file 

Open the details section to see the required properties:

**TODO: explain the persistence.xml**

<details>
	
```xml


```

</details>

## Web-Application (web.xml)

Add the ```web.xml``` file in to the  ```webapp/WEB-INF``` folder
* Open the details section to see the required Servlet-Mapping and configuration:

**TODO: add web.xml describe shortly**

<details>
	
```xml


```

</details>


## CDI-Application (beans.xml)
Add an empty ```beans.xml``` file.

**TODO: sample of persistence.xml**

<details>
	
```xml


```

</details>

## Fases-Application (faces-config.xml)

Add a ```faces-config.xml``` file

**TODO: sample of persistence.xml**

<details>
	
```xml


```

</details>

**(optional)** - Instead of using ```faces-config.xml``` file, a programmatic approche can be used, there for create a class e.g. ```FacesAppConfig.java``` with annotations ```@FacesConfig``` and ```@ApplicationScoped```.

```java
@FacesConfig
@ApplicationScoped
public class FacesAppConfig {
	// replacement of 'faces-config.xml' file
}
```

### Fases-Namespaces

All nessesary namespaces for JSF:

```xml
<html xmlns="http://www.w3.org/1999/xhtml"        //marks the page as xhtml
	xmlns:h="http://xmlns.jcp.org/jsf/html"       //html-elements
	xmlns:f="http://xmlns.jcp.org/jsf/core"       //JSF-elements
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"> //mainly for templates

</html>
```

### PrimeFaces Namespaces

- PrimeFaces as a dependency (':p' namespace)

```xml

```

### OmniFaces Namespaces (Optional)

```xml

```

## Test-Application (JUnit 5)

- Use **JUnit 5** for unit tests.
  
