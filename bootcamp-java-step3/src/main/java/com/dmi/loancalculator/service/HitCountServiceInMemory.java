package com.dmi.loancalculator.service;

public class HitCountServiceInMemory implements HitCountService {

    private long count;
    
    @Override
    public long incrementHitCount() {
        return ++count;
    }

    @Override
    public void resetHitCount() {
        count = 0;
    }
}
