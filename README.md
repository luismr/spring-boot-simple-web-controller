# Getting Started

## Requirements

You can use [SDKMAN](https://sdkman.io/) to manage your Java and Maven runtimes, and there is a very good tutorial about how to use SDKMAN [here](https://www.baeldung.com/java-sdkman-intro).

* Java 17

```shell
sdk install java 17.0.3.6.1-amzn
```

* Maven 3.8.5

```shell
sdk install maven 3.8.5
```

## Build and Run

### Using Maven

#### Build

```shell
mvn clean install
```

#### Running only the Tests

```shell
mvn test
```

#### Running the application

```shell
mvn spring-boot:run
```

### Using IDE

I used [IntelliJ Idea](https://www.jetbrains.com/idea/) from [JetBrains](https://www.jetbrains.com/)  to build this application but you also can use [Eclipse](https://www.eclipse.org/downloads/), or [Netbeans](https://netbeans.apache.org/download/index.html) to run this application. 

## Documentation

### References

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.1/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [How to use SDKMAN](https://www.baeldung.com/java-sdkman-intro)
