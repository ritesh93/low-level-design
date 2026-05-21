package org.example.ratelimiter.config;

import org.example.ratelimiter.model.RateLimitingEntity;

public abstract class RateLimitConfig {
    private final long capacity;

    public RateLimitConfig(long capacity){
        this.capacity = capacity;
    }

    public long getCapacity(){
        return capacity;
    }

    public abstract RateLimitingEntity createEntity();
}
