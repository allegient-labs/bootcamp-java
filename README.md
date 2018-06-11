# DMI Developer Boot Camp: Java/Spring

## Introductory Topics
1. Overview of JUnit and Hamcrest
2. What are good unit tests?
    - Small
    - Repeatable
    - Independant
3. Overview of Maven
    - The POM
    - Project Structure
    - Dependency Management
    - Project Build Lifecycle
4. Understanding Maven Versioning
5. Basics for most Java projects
    - Configure the POM for Java 8+
    - Configure for JUnit
6. Exercise

## Step 1: Java/Spring

### Basics of Java Web Development
1. A little history
    - How we did Java dev without/before Spring
    - Why is Spring so dominant?
2. Basics of Java Web Development
    - The Servlet API
    - Servlet Containers
    - WAR Packaging
    - Deployment

### Basics of Spring
1. Overview of the Spring Container and Dependency Injection (IoC)
2. Overview of Spring Initializr
3. Structore of Modern Java Web Applications (Hexagonal)
    - Why we build applications this way (testable)
    - Recomendations for package structure
4. Overview of Spring REST
5. Overview of Swagger
6. Exercise

## Step 2: Pivotal Cloud Foundry
1. What is PCF?
2. Basic PCF Commands
3. Apps, Routes, Services, Spaces, etc.
4. Exercise
    - Create a free Pivotal Web Services account
    - Install the PCF CLI
    - Create a manifest file for your application
    - Push your application to PCF
    - Scale the app up/down

## Step 3: Using Cloud Services
1. Overview of Redis
2. Spring support for Redis
3. Redis in PCF
4. Changes in Spring configuration for the cloud (covers Spring profiles)
5. Exercise
    - Create a free Redis service in your PCF instance
    - Create a Redis implementation of the HitCounter service
    - Modify your Spring configuration to use Redis in the cloud
    - Push your update to PCF and verify that the hit count persists through application stop/start

## Step 4: JPA/CRUD/REST
1. Overview of JPA
2. Configuring a Spring CRUD Repository
3. Spring support for in-memory databases for testing
4. Overview of different REST Methods (Safe, idempotent, etc.)
5. Creating a REST controller for CRUD
6. Exercise

## Step 5: JPA in the Cloud
1. Spring cloud support for PostreSQL
2. How to use anin-memory database for testing and PostgreSQL for production
3. Exercise
    - Create a free PostgreSQL service in your PCF instance
    - Change the Spring configuration to use PostgreSQL in the Cloud
    - Change the manifest to map PostgreSQL to your application
    - Deploy, Test
