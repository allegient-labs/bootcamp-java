package com.dmi.bootcamp.bank.dmibank.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.bootcamp.bank.dmibank.service.HitCountService;

@RestController
public class ResetHitCountController {

    @Autowired
    private HitCountService counterService;
    
    @CrossOrigin(origins="*")
    @GetMapping("/resetHitCount")
    public String resetCount() {
        counterService.resetHitCount();
        return "OK";
    }
}