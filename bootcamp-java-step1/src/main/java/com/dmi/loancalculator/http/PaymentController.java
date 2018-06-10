package com.dmi.loancalculator.http;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.loancalculator.service.HitCountService;
import com.dmi.loancalculator.service.PaymentCalculator;

import io.swagger.annotations.ApiOperation;

@RestController
public class PaymentController {
    
    @Autowired
    private HitCountService counterService;

    @Autowired
    private PaymentCalculator paymentCalculator;
    
    @ApiOperation("Calculate a loan payment")
    @CrossOrigin(origins="*")
    @RequestMapping(value="/payment", method = RequestMethod.GET)
    public CalculatedPayment calculatePayment(@RequestParam("amount") double amount,
            @RequestParam("rate") double rate,
            @RequestParam("years") int years) {

        BigDecimal payment = paymentCalculator.calculate(amount, rate, years);
        
        return new CalculatedPayment.Builder()
                .withAmount(amount)
                .withRate(rate)
                .withYears(years)
                .withPayment(payment)
                .withHitCount(counterService.incrementHitCount())
                .build();
    }
}