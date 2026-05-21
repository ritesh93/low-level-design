package org.example.ratelimiter.config;

public class RateLimitConfig {
    private final long capacity;
    private final double refillRate;

    public RateLimitConfig(long capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public long getCapacity(){
        return capacity;
    }

    public double getRefillRate() {
        return refillRate;
    }
}
