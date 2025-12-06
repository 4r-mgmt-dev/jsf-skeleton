# Jakarta-Faces-Skeleton

> Provided a *reusable* **template** with minimal necessary structure.

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
* [Faces-Application](#faces-application)
* [Test-Application](#test-application)

---

## Overview

This is a *Skeleton* for an **Jakarta-Faces** application, based on **Jakarta EE** technologies.
* The **goal** is to provide a *reusable* **template** with minimal necessary structure and all required tools and (MAVEN) dependencies for any **web application** project.

---

## Quick Start

The application can be started as a *WAR* on a Jakarta EE compliant server (e.g., WildFly, Payara) or locally as a *JAR* (with embedded WildFly), using an H2 in-memory database.

1. run in cmd: ``mvn install`` to build deployable  **.war** file
2. then browse: [http://localhost:8080/index.xhtml](http://localhost:8080/index.xhtml)

- (**optional only for WildFly:** ``mvn package`` for standalone application as executable **.jar**)

---

## Development Tools

- **JDK 11+:** (Java Development Kit) [Download](https://www.oracle.com/de/java/technologies/downloads)
- **IDE: Eclipse**: (Integrated Development Environment) [Download](https://www.eclipse.org/downloads/packages/)
- **Build Tool: Maven** [Download](https://maven.apache.org)
- **Versioning System: Git** [Download](https://git-scm.com/)
- **Repository: [GitHub](https://github.com/)**

---

## Jakarta Technology

- **Jakarta EE 10** (set of specification components to build java web applications)
- **Servlet** (Jakarta Servlet 6.0 / web-app 6.0)
- **CDI 4.0** (Context and Dependency Injection)
	- Implementation: Weld 5
- **JSF 4.0** (Java Server Faces or Jakarta-Faces)
	- Implementation: [Mojarra 4.0](https://github.com/eclipse-ee4j/mojarra) or [MyFaces 4.0](https://myfaces.apache.org/#/core40)
- **EL 5.0** (Expression Language - provides an important mechanism for enabling the presentation layer)
- **JPA 3.0** (Java Persistence API) as Persistence Layer 
	- Implementation: [Hibernate 6.1](https://hibernate.org/) - provides persistence
- **Java EE Server:**
	- Implementation: [Wildfly 27.0.1](https://www.wildfly.org/news/2022/11/09/WildFly-27-Final-is-released/)
 	- For other compatible versions of dependencies see: [wildfly-Core-Component-Matrix](https://mvnrepository.com/artifact/org.wildfly.core/wildfly-core-component-matrix/27.0.1.Final)

---

## Project Structure

The following structure shows the [common apache maven directory layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) for Java web-app. 

```text
 com.[company].[app-name]/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   ├── resources/
 │   │   │   └── META-INF/
 │   │   │       └── persistence.xml
 │   │   └── webapp/
 │   │       └── WEB-INF/
 │   │           ├── web.xml
 │   └── test/   ├── beans.xml
 ├── pom.xml     └── faces-config.xml
 └── README.md
 ```

- xhtml, css, js files inside the webapp folder, java files inside the java folder.
* Open the details section to see descriptions of these elements:

<details>
Folder description (descending order):
	
  - **com.[company].[app-name]/:** contains all your project files 
  - **src/:** contains your source files, to seperate your files from your build output
  - **main/:* application specific files
  - **test/:** unit and integration test code, test-specific resources
  - **java/:** java application files
  - **resources/:** config files, property files
	- **META-INF/:** meta-data like ```MANIFEST.MF```, config files (```persistence.xml```) or service files
  - **webapp/:** web application resources
  *xhtml* can be added here, to add *css* or *js* files create a resources/ folder and inside a css/ or js/ folder respectively
  webapp --> resources/ --> css/, js/
  	- **WEB-INF:** folder for your webapp-config files

File description:
  - **pom.xml:** config for your maven project and build
  - **README.md:** your project description, documentation, to-dos
  - **persistence.xml:** config for your persistence-unit (JPA)
  - **web.xml:** config for your webapp
  - **beans.xml:** config for your CDI
  - **faces-config.xml:** config for your FacesServlet

</details>

---

## Maven-Dependencies

*  Open the details section to see the ```pom.xml``` file with the required dependencies:

<details>
	
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.4r-mgmt.jsf-skeleton</groupId>
  <artifactId>jsf-skeleton</artifactId>
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>jsf-skeleton Maven Webapp</name>
  <url>http://maven.apache.org</url>

<!-- add properties for easier version control -->
  <properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>17</java.version>
		<maven.compiler.release>17</maven.compiler.release>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
		<!-- By default, do not fail on missing web.xml -->
		<failOnMissingWebXml>false</failOnMissingWebXml>
		<!-- Maven Plugins -->
		<maven-compiler-plugin.version>3.13.0</maven-compiler-plugin.version>
		<maven-war-plugin.version>3.4.0</maven-war-plugin.version>
		<maven-resources-plugin.version>3.3.1</maven-resources-plugin.version>
		<!-- Jakarta EE API -->
		<jakartaee-api.version>10.0.0</jakartaee-api.version>
		<!-- Jakarta Faces implementation-->
		<jakarta.faces.version>4.0.0</jakarta.faces.version>
		<!-- Primefaces -->
		<primefaces.version>15.0.9</primefaces.version>
		<!-- database -->
 		<h2database.version>2.4.240</h2database.version>
  </properties>  
 
  <dependencies>
    <dependency>
		<groupId>jakarta.platform</groupId>
		<artifactId>jakarta.jakartaee-api</artifactId>
		<version>${jakartaee-api.version}</version>
		<scope>provided</scope>
    </dependency>
    <dependency>
    	<groupId>org.glassfish</groupId>
    	<artifactId>jakarta.faces</artifactId>
    	<version>${jakarta.faces.version}</version>
	</dependency>
	<dependency>
    	<groupId>com.h2database</groupId>
    	<artifactId>h2</artifactId>
    	<version>${h2database.version}</version>
	</dependency>
	<!-- optional
    <dependency>
    	<groupId>org.primefaces</groupId>
    	<artifactId>primefaces</artifactId>
    	<version>${primefaces.version}</version>
    <classifier>jakarta</classifier>
	</dependency> -->
  </dependencies>
  
  <build>
        <finalName>jsf-skeleton</finalName>
        <plugins>
            <plugin>
				<!-- compiles the project to a specific Java version -->
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven-compiler-plugin.version}</version>
                <configuration>
        			<release>${java.version}</release>
        			<encoding>${project.build.sourceEncoding}</encoding>
    			</configuration>
            </plugin>
            
            <plugin>
          		<artifactId>maven-resources-plugin</artifactId>
          		<version>${maven-resources-plugin.version}</version>
          		<configuration>
        			<encoding>${project.build.sourceEncoding}</encoding>
    			</configuration>
        	</plugin>

            <plugin>
				<!-- builds the project in a war -->
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>${maven-war-plugin.version}</version>
                <configuration>
                    <failOnMissingWebXml>${failOnMissingWebXml}</failOnMissingWebXml>
                </configuration>
            </plugin>
        </plugins>
   </build>
  
</project>


```

</details>

---

## Persistence-Application

To enable **Persistence-Application**, add a ```persistence.xml``` file in to the ```resources/META-INF``` folder
* Specify the connection properties according to JPA specification of ```persistence.xml``` file 

Open the details section to see the required properties:

<details>
	
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence
    xmlns="https://jakarta.ee/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
    version="3.0">

    <persistence-unit name="admin-jta" transaction-type="JTA">
        <!-- Jakarta EE 10 uses the Hibernate ORM Jakarta module -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <!-- JNDI name configured in WildFly standalone.xml or via CLI 
        <jta-data-source>java:/AdminDS</jta-data-source>-->

        <properties>
        	<property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
			<!-- DB loaded in memory for testing purposes -->
    		<property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;"/>
    		<property name="jakarta.persistence.jdbc.user" value="sa"/>
    		<property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
			<!-- if the database already exists it is updated on startup (new data may be added) -->
            <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
            <!-- Optional Hibernate extras -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

alternatively define and use the JNDI name in your server<br/>
example in Wildfly:
- edit the ```standalone.xml```

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

</details>

---

## Web-Application

To enable the **web-application**, add the ```web.xml``` file in to the  ```webapp/WEB-INF``` folder
* Open the details section to see the required **servlet-mapping** and configuration:

<details>
	
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                             https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

    <display-name>Skeleton App</display-name>
    <servlet>
        <servlet-name>FacesServlet</servlet-name>
		<!-- sets the path to the FacesServlet -->
        <servlet-class>jakarta.faces.webapp.FacesServlet</servlet-class>
		<!-- 1 means it is loaded on startup of the server -->
        <load-on-startup>1</load-on-startup>
    </servlet>

	<!-- maps the FacesServlet to .xhtml -->
    <servlet-mapping>
        <servlet-name>FacesServlet</servlet-name>
        <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>
</web-app>

```

</details>

---

## CDI-Application

To enable, add an empty ```beans.xml``` file in to the  ```webapp/WEB-INF``` folder

<details>
	
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="https://jakarta.ee/xml/ns/jakartaee"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee 
                           https://jakarta.ee/xml/ns/jakartaee/beans_4_0.xsd"
       version="4.0"
	   <!-- options: all (all types are considered as beans), annotated (only annotated beans are considered[default option]),
	   none (no types are considered) -->
       bean-discovery-mode="annotated">
</beans>

```
When the ```beans.xml``` is empty it automatically chooses the **version** and sets **bean-discovery-mode="annotated"**.

</details>

---

## Faces-Application

Java Server Faces is a web application framework (built on top of the Servlet API) that uses facelets and allows building **XHTML web-pages**, **templates**, **managing validation** and **navigation** as well as communication with Java Beans by using **Context and Dependency Injection** (CDI). It seperates the UI (**.xhtml**) and the logic (**Java Beans**) and allows data exchange through CDI and Expression Language.

The (Http) requests of Faces are handled in a lifecycle with 6 phases:

```
1. Restoring the component tree
2. Applying (and converting) request values
3. Process Validation
4. Updating Model Values
5. Invoking the application
6. Rendering the response
```
   
Add a ```faces-config.xml``` file to the  ```webapp/WEB-INF``` folder.

<details>
	
```xml
<?xml version="1.0" encoding="UTF-8"?>
<faces-config xmlns="https://jakarta.ee/xml/ns/jakartaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
        https://jakarta.ee/xml/ns/jakartaee/web-facesconfig_4_0.xsd"
	version="4.0">
</faces-config>

```

The file is not strictly necessary for Jakarta Faces but it can handle explicit navigation, add phase-listeners etc.

</details>

**(optional)** - Instead of using ```faces-config.xml``` and ```web.xml``` files, a programmatic approach can be used. For this purpose create a class e.g. ```FacesAppConfig.java``` with annotations ```@FacesConfig``` and ```@ApplicationScoped```. Even this empty class enables JSF with modern features.

```java
@FacesConfig
@ApplicationScoped
public class FacesAppConfig {
	// replacement of 'faces-config.xml' file
}
```

* For **Filters** and **Listeners** new classes with the annotations ```@WebFilter``` and ```@WebListener``` are used.
* Beans are used for **implicit navigation**. ```faces-config.xml``` can be used for **explicit navigation** if necessary.

---

### Faces-Namespaces

All necessary namespaces for JSF:

```xml
<html xmlns="http://www.w3.org/1999/xhtml"        //marks the page as xhtml
	xmlns:h="http://xmlns.jcp.org/jsf/html"       //html-elements
	xmlns:f="http://xmlns.jcp.org/jsf/core"       //JSF-elements
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"> //mainly for templates

</html>
```

### PrimeFaces Namespaces

- [PrimeFaces](https://github.com/primefaces/primefaces) as a dependency (':p' namespace)
- [Tutorial](https://www.mastertheboss.com/category/web/primefaces/)

```xml
<html xmlns:p="http://primefaces.org/ui">
</html>
```

### OmniFaces Namespaces (Optional)

- [OmniFaces](https://omnifaces.org/) as a dependency (':o' and ':of' namespaces)
```xml
<html xmlns:o="http://omnifaces.org/ui"
xmlns:of="http://omnifaces.org/functions">
</html>
```
- adds functionality to *PrimeFaces*

---

## Test-Application

- Use **JUnit 5** as a test framework for unit tests.
- **Mockito** as a mocking library
  
