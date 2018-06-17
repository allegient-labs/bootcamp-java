package com.dmi.bootcamp.dmibank.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmi.bootcamp.dmibank.service.HitCountService;

@RestController
public class ResetHitCountController {

    @Autowired
    private HitCountService hitCountService;
    
    @GetMapping("/resetHitCount")
    public ResponseEntity<?> reset() {
        hitCountService.resetHitCount();
        
        return ResponseEntity.noContent().build();
    }
}
