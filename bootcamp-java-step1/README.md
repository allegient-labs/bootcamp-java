# Spring Bootcamp Step 1

1. Generate the project

    - Go to https://start.spring.io/
    - Create a Maven project with Java and Spring Boot 2.0.2
    - Group id: com.dmi
    - Artifact: loancalculator
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

3. Implement a loan payment calculator

    - Create a new package "com.dmi.loancalculator.service"
    - Add a class "PaymentCalculator" in that package
    - Implement the payment calculation. The method signature should be `public BigDecimal calculate(double amount, double rate, int years)` (see this wiki page for the formula: https://en.wikipedia.org/wiki/Mortgage_calculator#Monthly_payment_formula)
    - You can use something like the following to convert a Java `double` to a rounded `BigDecimal`:
        ```java
        private BigDecimal toMoney(double d) {
            BigDecimal bd = new BigDecimal(d);
            return bd.setScale(2, RoundingMode.HALF_UP);
        }
        ```
    - Write some unit tests to verify that your calculator is correct. Here are some sample values to use:
        | Amount | Rate | Years | Payment|
        |--------|------|-------|--------|
        | 200,000.00 | 6.5% | 30 | 1264.14 |
        | 180,000.00 | 0% | 30 | 500.00 |
        

With the project in this state all tests should pass and it should be runnable locally. Swagger should work.

Sample URLs:

http://localhost:8080/payment?amount=180000&rate=6&years=30

http://localhost:8080/swagger-ui.html


