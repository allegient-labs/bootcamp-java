# Spring Bootcamp Step 1

1. Go to https://start.spring.io/
2. Create a Maven project with Java and Spring Boot 2.0.2
3. Group id: com.dmi.bootcamp
4. Artifact: xxx-bootcamp-java where xxx are your initials
5. Dependencies: Web


After generation...

Add swagger:

```xml
    <!-- Swagger setup... -->
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger2</artifactId>
      <version>2.8.0</version>
    </dependency>
    <dependency>
      <groupId>io.springfox</groupId>
      <artifactId>springfox-swagger-ui</artifactId>
      <version>2.8.0</version>
    </dependency>
    <dependency> <!-- required for java 9+ -->
      <groupId>javax.xml.bind</groupId>
      <artifactId>jaxb-api</artifactId>
    </dependency>
```

With the project in this state all tests should pass and it should be runnable locally. Swagger should work.

Sample URLs:

http://localhost:8080/payment?amount=180000&rate=6&years=30

http://localhost:8080/swagger-ui.html


