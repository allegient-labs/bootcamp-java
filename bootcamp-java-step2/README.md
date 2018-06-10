# Spring Bootcamp Step 2

This section is about Cloud Foundry.  Only two changes:

1. Add the "instance" attribute to CalculatedPayment and initialize with System.getenv("CF_INSTANCE_INDEX")
2. Add the manifest so it can be pushed to cloud foundry 

Sample URLs:

http://localhost:8080/payment?amount=180000&rate=6&years=30

http://localhost:8080/swagger-ui.html

https://dmi-loan-calculator-humble-zebra.cfapps.io/payment?amount=180000&rate=6&years=30

https://dmi-loan-calculator-humble-zebra.cfapps.io/swagger-ui.html
