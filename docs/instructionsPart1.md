# Spring Bootcamp Step 1

1. Generate the project

    - Go to https://start.spring.io/
    - Create a Maven project with Java and Spring Boot 2.0.3
    - Group id: com.dmi.bootcamp
    - Artifact: dmibank
    - Dependencies:
        - Web
        - JPA
        - Redis
        - H2
        - Cloud Connectors
    - Generate the project, unzip the file somewhere convenient
    - Open your IDE and import the project as a Maven project. If you are on Java 9+ there will be a test failure. We will resolve that in the next section.

2. Add the following dependencies to the POM. This will enable Swagger and will resolve the Java 9+ error

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

    This should resolve the test failure.

3. Add your payment calculator library as a maven dependency  

    ```xml
    <dependency>
      <groupId>com.dmi.bootcamp</groupId>
      <artifactId>payment-calculator</artifactId>
      <version>1.0.0</version>
    </dependency>
    ```

4. Implement a Hit Counter

    - Create a package "com.dmi.bootcamp.dmibank.service"
    - Create an interface `HitCountService` in that package. The interface should have these methods:
        ```java
        long incrementHitCount();
        void resetHitCount();
        ```
    - Create a class `HitCountCerviceInMemory` in that package. Implement the `HitCountService` by simply working with an internal long value

5. Create an object to hold the return value from the service call

    - Create a package "com.dmi.bootcamp.dmibank.domain"
    - Create a class `CalculatedPayment` in that package. The class should have these fields/getters/setters:
        ```java
        private double amount;
        private double rate;
        private int years;
        private BigDecimal payment;
        private long hitCount;
        ```

6. Write a REST Controller for your calculator

    - Create a new package "com.dmi.bootcamp.dmibank.http"
    - Add a class "PaymentController" in that package
    - Add the `@RestController` annotation to the class
    - Add a private attribute to hold the PaymentCalculator and use `@Autowired` to inform the Spring container
    - Add a private attribute to hold the HitCountService (use the interface) and use `@Autowired` to inform the Spring container
    - Add a method that will respond to a URL like "/payment?amount=100000&rate=4&years=30" (hint - use `@GetMapping` annotation on the method, and use `@RequestParam` annotation on the method parameters)

7. Wire up the dependencies and enable Swagger

    - Alter the class `DmibankApplication` as follows
    - Add the 1@EnableSwagger21 annotation to the class
    - Add a method annotated with `@Bean` that will return a new instance of the `HitCountServiceInMemory`
    - Add a method annotated with `@Bean` that will return a new instance of the `PaymentCalculator`

8. Start the application

    Run the class `DmibankApplication` as a Java application in Eclipse. This will start the application and the embedded Tomcat container. The application should now respond to browser requests. The following URLs should work:      

    http://localhost:8080/payment?amount=180000&rate=6&years=30

    http://localhost:8080/swagger-ui.html

    Play with swagger a bit to get a feel for it


