# Payment Calculator

3. Implement a loan payment calculator

    - Create a new package "com.dmi.bootcamp.payment.calculator"
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

