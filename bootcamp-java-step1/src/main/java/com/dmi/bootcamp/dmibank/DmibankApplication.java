package com.dmi.bootcamp.dmibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dmi.bootcamp.dmibank.service.HitCountService;
import com.dmi.bootcamp.dmibank.service.HitCountServiceInMemory;
import com.dmi.bootcamp.payment.calculator.PaymentCalculator;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DmibankApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmibankApplication.class, args);
    }
    
    @Bean
    public HitCountService hitCountService() {
        return new HitCountServiceInMemory();
    }
    
    @Bean
    public PaymentCalculator paymentCalculator() {
        return new PaymentCalculator();
    }
}
