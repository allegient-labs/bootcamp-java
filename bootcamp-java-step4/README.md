# Spring Bootcamp Step 4

This section is about Spring data with an in memory database

Add the following to the POM:

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
    </dependency>
```

1. Create the domain class Person
2. Create the repository PersonRepository
3. Create the PersonController for the REST interface

Good reference article:

https://dzone.com/articles/leverage-http-status-codes-to-build-a-rest-service
