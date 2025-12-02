# Jakarta-Faces-Skeleton

**Table of Content**

* [Overview](#overview)
* [Quick Start](#quick-start)
* [Development Tools](#development-tools)
* [Jakarta Technology](#jakarta-technology)
* [Project Structure](#project-structure)
* [Maven-Dependencies](#maven-dependencies)
* [Persistence-Application](#persistence-application)
* [Web-Application](#web-application)
* [CDI-Application](#cdi-application)
* [Fases-Application](#fases-application)
* [Test-Application](#test-application)

---

## Overview

This is a *Skeleton* for an **Jakarta-Faces** application, based on **Jakarta EE** technologies.
* The **goal** is to show the necessary structure with all required tools and (MAVEN) dependencies for any **Web Application** project.

---

## Quick Start

The application can be started as a *WAR* on a Jakarta EE compliant server (e.g., WildFly, Payara) or locally as a *JAR* (with embedded WildFly), using an H2 in-memory database.

1. run in cmd: ``mvn install`` to build deployable  **.war** file
2. then browse: [http://localhost:8080/index.xhtml](http://localhost:8080/index.xhtml)

- (**optional only for WildFly:** ``mvn package`` for standalone application as executable **.jar**)

---

## Development Tools

- **JDK 11+:** (Java Development Kit) [download](https://www.oracle.com/de/java/technologies/downloads)
- **IDE: Eclipse**: (Integrated Development Environment) [download](https://www.eclipse.org/downloads/packages/)
- **Build Tool: Maven** [download](https://maven.apache.org)
- **Versioning System: Git** 
- **Repository: GitHub** 

---

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

---

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

---

## Maven-Dependencies

*  Open the details section to see the ```pom.xml``` file with the required dependencies:

**TODO: explain of nessesary dependencies of pom.xml in the details section**

<details>
	
```xml



```

</details>

---

## Persistence-Application

To enable **Persistence-Application**, add a ```persistence.xml``` file in to the ```resources/META-INF``` folder
* Specify the connection properties according to JPA specification of ```persistence.xml``` file 

Open the details section to see the required properties:

**TODO: explain the persistence.xml**

<details>
	
```xml


```

</details>

---

## Web-Application

To enable the **Web-Application**, add the ```web.xml``` file in to the  ```webapp/WEB-INF``` folder
* Open the details section to see the required Servlet-Mapping and configuration:

**TODO: add web.xml describe shortly**

<details>
	
```xml


```

</details>

---

## CDI-Application

To enable, add an empty ```beans.xml``` file in to the  ```webapp/WEB-INF``` folder

**TODO: sample of persistence.xml**

<details>
	
```xml


```

</details>

---

## Fases-Application

Java Server Faces is a web application framework (built on top of the Servlet API) that uses facelets and allow building **XHTML web-pages**, **templates**, **managing validation** and **navigation** as well as communication with Java Beans by using **Context and Dependency Injection** (CDI). It seperates the UI (**.xhtml**) and the logic (**Java Beans**) and allows data exchange through CDI and Expression Language.

The the (Http) requests of Faces are handled in a lifecycle with 6 phases:

```
1. Restoring the component tree
2. Applying (and converting) request values
3. Process Validation
4. Updating Model Values
5. Invoking the application
6. Rendering the response
```
   
To enable **Faces** application, add a ```faces-config.xml``` file in to the  ```webapp/WEB-INF``` folder.

**TODO: sample of persistence.xml**

<details>
	
```xml


```

</details>

**(optional)** - Instead of using ```faces-config.xml``` file, a programmatic approche can be used. There for create a class e.g. ```FacesAppConfig.java``` with annotations ```@FacesConfig``` and ```@ApplicationScoped```. Even this empty class enables JSF with modern features.

```java
@FacesConfig
@ApplicationScoped
public class FacesAppConfig {
	// replacement of 'faces-config.xml' file
}
```

* For Filters and Listeners new classes with the annotations @WebFilter and @WebListener are used.
* Beans are used for implicit navigation. faces-config can be used for explicit navigation.

Regardless of the approach an empty ```beans.xml``` is also necessary (same folder as ```web.xml```).  
A ```faces-config.xml``` is not needed in modern projects unless for explicit navigation.  

---

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

---

## Test-Application

- Use **JUnit 5** for unit tests.
  
