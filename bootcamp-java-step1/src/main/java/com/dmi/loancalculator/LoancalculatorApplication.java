package com.dmi.loancalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dmi.loancalculator.service.HitCountService;
import com.dmi.loancalculator.service.HitCountServiceInMemory;
import com.dmi.loancalculator.service.PaymentCalculator;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    public PaymentCalculator paymentCalulator() {
        return new PaymentCalculator();
    }
    
    @Bean
    public HitCountService hitCountService() {
        return new HitCountServiceInMemory();
    }
}
