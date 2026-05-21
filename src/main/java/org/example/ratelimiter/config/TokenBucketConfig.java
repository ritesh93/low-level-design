package org.example.ratelimiter.config;

import org.example.ratelimiter.model.RateLimitingEntity;
import org.example.ratelimiter.model.TokenBucket;

public class TokenBucketConfig extends RateLimitConfig{
    private final double refillRatePerSecond;

    public TokenBucketConfig(long capacity, double refillRatePerSecond){
        super(capacity);
        this.refillRatePerSecond = refillRatePerSecond;
    }

    public double getRefillRatePerSecond(){
        return refillRatePerSecond;
    }

    @Override
    public RateLimitingEntity createEntity() {
        return new TokenBucket(this.getCapacity(), this.refillRatePerSecond);
    }
}
