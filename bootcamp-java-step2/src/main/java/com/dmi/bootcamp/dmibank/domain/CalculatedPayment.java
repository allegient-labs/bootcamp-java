package com.dmi.bootcamp.dmibank.domain;

import java.math.BigDecimal;

public class CalculatedPayment {
    private double amount;
    private double rate;
    private int years;
    private BigDecimal payment;
    private long hitCount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public long getHitCount() {
        return hitCount;
    }

    public void setHitCount(long hitCount) {
        this.hitCount = hitCount;
    }
    
    public String getPcfInstance() {
        return System.getenv("CF_INSTANCE_INDEX");
    }
}
