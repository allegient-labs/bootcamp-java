# Spring Bootcamp Step 3

This section is about Redis on Cloud Foundry. Changes:

1. Allocate a free Redis cloud service on your Pivotal Web Services instance

   `cf marketplace` will show different service options
   `cf marketplace -s rediscloud` will show different service plans available for Redis Cloud
   `cf create-service rediscloud 30mb redis` will create a free instance of redis cloud named "redis" in your space

2. Implement a Redis based hit counter

    Create class `com.dmi.bootcamp.dmibank.service.HitCountServiceRedis` that implements `HitCountService`. It should look like this:

    ```java
    public class HitCountServiceRedis implements HitCountService {

      private static final String REDIS_KEY = "payment-calculator";

      @Autowired
      private RedisTemplate<String, Integer> redisTemplate;
    
      @Override
      public long incrementHitCount() {
        return redisTemplate.opsForValue().increment(REDIS_KEY, 1);
      }

      @Override
      public void resetHitCount() {
        redisTemplate.opsForValue().set(REDIS_KEY, 0);
      }
    }
    ```

3. Create a cloud based configuration

    Create class `com.dmi.bootcamp.dmibank.CloudConfiguration` that extends `AbstractCloudConfig`. It should look like this:

    ```java
    @Configuration
    @Profile("cloud")
    public class CloudConfiguration extends AbstractCloudConfig {
      @Bean
      public RedisConnectionFactory redisFactory() {
        return connectionFactory().redisConnectionFactory();
      }
    
      @Bean
      public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(redisFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
        return template;
      }
    
      @Bean
      public HitCountService hitCountService() {
        return new HitCountServiceRedis();
      }
    }
    ```

    Note the @Profile annotation - this configuration is only active in the cloud

4. Turn off the memory based hit counter in the cloud.  Add a `@Profile("!cloud")` annotation to the bean method in `DmibankApplication`

5. Change the `manifest.yml` file to include a reference to your Redis service:

   ```yaml
    services:
    - redis
   ```

6. Rebuild and push the app

   - `mvn clean package`
   - ` cf push`
   
7. Exercise the application by scaling up and down, stopping and starting. Through it all you should see that the hit count remains consistent

   https://dmi-bank-anxious-fossa.cfapps.io/payment?amount=180000&rate=6&years=30
   