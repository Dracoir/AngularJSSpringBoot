# N-Tiered Web application, using Spring Boot and AngularJS

## Overview
This project was part of a lunch and learn series I conducted for co-workers.  This is why you may see "Lunch and Learn" or "ll" references plastered all over the code.

This project is broken up into three sub-projects: The AngularJS View layer, the Spring REST Controller layer and the Spring Model layer. It demonstrates a basic example of a Spring REST application being accessed by an AngularJS application. The REST/controller uses Spring Boot to implement Spring REST and the models layer uses Spring Boot to implement Spring data core, Hibernate and the H2 in-memory database.

The n-tiered projects are:

* ll-model
  * Models layer
* ll-web
  * Controller layer
* ll-web-angular
  * View layer

Both Java projects (model and controller layers) are configured using _Spring Boot_. To learn more about _Spring Boot_, please visit Spring's [Building an Application with Spring Boot](http://spring.io/guides/gs/spring-boot/) guide, which offers a great introduction to Spring Boot.

All projects, with the exception of the AngularJS project, use Java configuration files, rather than XML files. Everything from beans to items normally defined inside web.xml are represented in Java configuration files. This form of configuration has been around since servlet 2.5. Stop configuring with XML!

Below are instructions on how to build each project.

## ll-model
This represents the model layer, handling all the connections to the H2 in-memory database.  The only configuration for the database connection is through the `data.properties` file. Spring Boot uses its conditional annotations to understand which database configuration beans to instantiate and their respective properties, based on the data in the `data.properties` file.

This project represents a basic example of the Spring data repository package,  _Spring Boot_ configuration conventions and AspectJ logging. It also implements a _services_ layer, further abstracting the _models_ layer from any project using this library.

### Build and run
To build this project, simply navigate to the root directory of the project, and type:

* gradlew

By default, it will execute the _clean_, _build_ and _install_ tasks.

## ll-web
This represents the _controller_ layer, and only uses the _services_ layer from the ll-models dependency to get and post database information.  It also exposes a simple REST API that retrieves and sends data to a view. Being a REST layer, ll-web does not know nor care what view is consuming or otherwise changing its data.

### Build and run
To build this project, simply navigate to the root directory of the project, and type:

* gradlew

By default, it will execute the _clean_, _build_ and _bootRun_ tasks.  The _bootRun_ task is a feature in Spring Boot, where an embedded instance of Tomcat is executed, completely abstracted from the user. So when this final task executes, you will have a Tomcat instance running on default port 8080, listening for HTTP PUT, GET, POST and DELETE REST requests.

Once the _bootRun_ task completes, to view the API interface, via this project's [Swagger integration] (http://swagger.io/), navigate to:

* http://localhost:8080/people_rest/swagger-ui.html

## ll-web-angular
This represents the view and is written entirely in AngularJS, using AngularJS's $q to make asynchronous calls to the REST API.  The AngularJS $q calls assume that the project is located at _localhost_, on port _8080_.

### Build and run
To build this project, simply navigate to the root directory of the project, and type:

* gulp clean-run
