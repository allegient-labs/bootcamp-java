# Spring Bootcamp Step 3

This section is about Redis on Cloud Foundry. Changes:

1. Add the following to the POM:

```xml
    <!-- Added for redis integration... -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-spring-service-connector</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-cloudfoundry-connector</artifactId>
    </dependency>
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-pool2</artifactId>
    </dependency>
```

2. Implement a Redis based hit counter
3. Change the configuration - use the memory hit counter locally, use the Redis hit counter on the cloud (add CloudConfiguration class)

The push will fail. After the push:

- cf bind-service dmi-loan-calculator redis
- cf restage dmi-loan-calculator

Can also add the following to the manifest:

```yaml
  services:
  - redis
```


Sample URLs:

http://localhost:8080/payment?amount=180000&rate=6&years=30

http://localhost:8080/swagger-ui.html

https://dmi-loan-calculator-agile-toucan.cfapps.io/payment?amount=180000&rate=6&years=30

https://dmi-loan-calculator-agile-toucan.cfapps.io/swagger-ui.html
