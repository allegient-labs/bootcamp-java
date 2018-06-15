package com.dmi.bootcamp.bank.dmibank.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class CalculatedPayment {
    private double amount;
    private double rate;
    private int years;
    private BigDecimal payment;
    private long hitCount;
    
    private CalculatedPayment(Builder builder) {
        this.amount = builder.amount;
        this.rate = builder.rate;
        this.years = builder.years;
        this.payment = builder.payment;
        this.hitCount = builder.hitCount;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public int getYears() {
        return years;
    }
    
    public long getHitCount() {
        return hitCount;
    }
    
    @JsonIgnoreType
    public static class Builder {
        private double amount;
        private double rate;
        private int years;
        private BigDecimal payment;
        private long hitCount;

        public Builder withAmount(double amount) {
            this.amount = amount;
            return this;
        }
        
        public Builder withRate(double rate) {
            this.rate = rate;
            return this;
        }
        
        public Builder withYears(int years) {
            this.years = years;
            return this;
        }
        
        public Builder withPayment(BigDecimal payment) {
            this.payment = payment;
            return this;
        }
        
        public Builder withHitCount(long hitCount) {
            this.hitCount = hitCount;
            return this;
        }
        
        public CalculatedPayment build() {
            return new CalculatedPayment(this);
        }
    }
}
