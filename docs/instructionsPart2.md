# Spring Bootcamp Step 2

1. Go to https://run.pivotal.io/ and sign up for a free account with Pivotal web services

2. Install the cloud foundry CLI from https://docs.cloudfoundry.org/cf-cli/install-go-cli.html

   Verify the installation by entering the command `cf help` from a terminal window

3. Login to Pivotal Web Services

   From a terminal window, enter the command `cf login -a https://api.run.pivotal.io`
   
4. Prepare the application for deployment

   - Change the `CalculatedPayment` class as follows:
      - Add a `public String getPcfInstance()` method. The method should return the value from `System.getenv("CF_INSTANCE_INDEX")`
   - Add a file called `manifest.yml` to the root directory of the project. The file should contain the following

      ```yaml
      applications:
      - name: dmi-bank
        buildpack: java_buildpack
        memory: 768M
        path: target/dmibank-0.0.1-SNAPSHOT.jar
        random-route: true
      ```
   
5. Deploy the application

   - Open a terminal window in the root directory of your application
   - Enter the command `mvn clean package` this will build the application
   - Enter the command `cf push` this will deploy your application for cloud foundry. Make note of the randomw route that is generated on deployment. For example "dmi-bank-anxious-fossa.cfapps.io"


6. Exercise your application and the swagger UI.

   https://dmi-bank-anxious-fossa.cfapps.io/payment?amount=180000&rate=6&years=30

   https://dmi-bank-anxious-fossa.cfapps.io/swagger-ui.html

7. Scale the application

   Enter the command `cf scale dmi-bank -i 2` this will start two instances of your application
   
   After a few minutes, the second version of the app will be started. If you exercise the payment URL you should see that the pcfInstance changes between "0" and "1". You should also notice that the hit count is not consistent between the two instances.
   
   Scale the app back down with `cf scale dmi-bank -i 1`
   
8. Various Cloud Foundry Commands

   Stop the application with `cf stop dmi-bank`
   
   Start the application with `cf start dmi-bank`. Notice how the hit counter resets.
   
   Examine recent events with the command `cf events dmi-bank`. You should see your scale up and down activities as well as the restart.
   
   Examine the logs with `cf logs dmi-bank --recent`
