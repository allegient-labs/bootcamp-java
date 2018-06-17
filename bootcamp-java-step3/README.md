# Spring Bootcamp Step 3

This section is about Redis on Cloud Foundry. Changes:

1. Allocate a free Redis cloud service on your Pivotal Web Services instance

2. Implement a Redis based hit counter

3. Change the configuration - use the memory hit counter locally, use the Redis hit counter on the cloud (add CloudConfiguration class, add a profile to the @Bean class in DmibankApplication)

4. Change the manifest.yml file to include a reference to your Redis service:

   ```yaml
    services:
    - redis
   ```
5. Rebuild and push the app
   `mvn clean package`
   ` cf push`
   
6. Exercise the application by scaling up and down, stopping and starting. Through it all you should see that the hit count remains consistent

   https://dmi-bank-anxious-fossa.cfapps.io/payment?amount=180000&rate=6&years=30
   