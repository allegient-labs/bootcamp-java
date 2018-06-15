package com.dmi.bootcamp.payment.calculator;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class PaymentCalculatorTest {
    @Test
    public void testCalculatorHappyPath() {
        PaymentCalculator pc = new PaymentCalculator();

        BigDecimal c = pc.calculate(200000.0, 6.5, 30);

        assertThat(c, is(equalTo(new BigDecimal("1264.14"))));
    }

    @Test
    public void testCalculatorZeroRate() {
        PaymentCalculator pc = new PaymentCalculator();

        BigDecimal c = pc.calculate(180000.0, 0.0, 30);

        assertThat(c, is(equalTo(new BigDecimal("500.00"))));
    }
}
