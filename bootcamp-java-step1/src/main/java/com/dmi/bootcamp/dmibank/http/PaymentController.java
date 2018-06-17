package com.dmi.bootcamp.dmibank.http;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.bootcamp.dmibank.domain.CalculatedPayment;
import com.dmi.bootcamp.dmibank.service.HitCountService;
import com.dmi.bootcamp.payment.calculator.PaymentCalculator;

@RestController
public class PaymentController {

    @Autowired
    private PaymentCalculator paymentCalculator;
    
    @Autowired
    private HitCountService hitCountService;
    
    @GetMapping("/payment")
    public ResponseEntity<CalculatedPayment> calculatePayment(@RequestParam("amount") double amount,
            @RequestParam("rate") double rate,
            @RequestParam("years") int years) {

        BigDecimal payment = paymentCalculator.calculate(amount, rate, years);
        
        CalculatedPayment cp = new CalculatedPayment();
        cp.setAmount(amount);
        cp.setHitCount(hitCountService.incrementHitCount());
        cp.setPayment(payment);
        cp.setRate(rate);
        cp.setYears(years);

        return ResponseEntity.ok(cp);
    }
}
