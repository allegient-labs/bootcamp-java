package com.dmi.bootcamp.bank.dmibank.http;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.bootcamp.bank.dmibank.domain.CalculatedPayment;
import com.dmi.bootcamp.bank.dmibank.service.HitCountService;
import com.dmi.bootcamp.payment.calculator.PaymentCalculator;

import io.swagger.annotations.ApiOperation;

@RestController
public class PaymentController {
    
    @Autowired
    private HitCountService counterService;

    @Autowired
    private PaymentCalculator paymentCalculator;
    
    @ApiOperation("Calculate a loan payment")
    @CrossOrigin(origins="*")
    @GetMapping("/payment")
    public ResponseEntity<CalculatedPayment> calculatePayment(@RequestParam("amount") double amount,
            @RequestParam("rate") double rate,
            @RequestParam("years") int years) {

        BigDecimal payment = paymentCalculator.calculate(amount, rate, years);
        
        CalculatedPayment calculatedPayment = new CalculatedPayment.Builder()
                .withAmount(amount)
                .withRate(rate)
                .withYears(years)
                .withPayment(payment)
                .withHitCount(counterService.incrementHitCount())
                .build();
        
        return ResponseEntity.ok(calculatedPayment);
    }
}