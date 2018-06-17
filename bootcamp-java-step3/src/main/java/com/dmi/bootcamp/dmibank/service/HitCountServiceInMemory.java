package com.dmi.bootcamp.dmibank.service;

public class HitCountServiceInMemory implements HitCountService {

    private long hitCount;
    
    @Override
    public long incrementHitCount() {
        hitCount++;
        return hitCount;
    }

    @Override
    public void resetHitCount() {
        hitCount = 0;
    }
}
