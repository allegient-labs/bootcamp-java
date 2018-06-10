package com.dmi.loancalculator.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.loancalculator.service.HitCountService;

@RestController
public class ResetHitCountController {

    @Autowired
    private HitCountService counterService;
    
    @CrossOrigin(origins="*")
    @RequestMapping(value="/resetHitCount", method = RequestMethod.GET)
    public String resetCount() {
        counterService.resetHitCount();
        return "OK";
    }
}