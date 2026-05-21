package org.example.ratelimiter.manager;

import org.example.ratelimiter.config.RateLimitConfig;
import org.example.ratelimiter.model.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitManager {

    private final Map<String, TokenBucket> clientBuckets = new ConcurrentHashMap<>();
    private final long capacity;
    private final double refillRate;

    public RateLimitManager(long capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean isAllowed(String clientId, RateLimitConfig rateLimitConfig){
        TokenBucket bucket = clientBuckets.computeIfAbsent(clientId, k -> new TokenBucket(rateLimitConfig.getCapacity(), rateLimitConfig.getRefillRate()));
        return bucket.tryConsume();
    }
}
