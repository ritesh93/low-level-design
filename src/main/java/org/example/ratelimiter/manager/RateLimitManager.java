package org.example.ratelimiter.manager;

import org.example.ratelimiter.config.RateLimitConfig;
import org.example.ratelimiter.config.SlidingWindowConfig;
import org.example.ratelimiter.config.TokenBucketConfig;
import org.example.ratelimiter.model.RateLimitingEntity;
import org.example.ratelimiter.model.SlidingWindowLogEntity;
import org.example.ratelimiter.model.TokenBucket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitManager {

    private final Map<String, RateLimitingEntity> registry = new ConcurrentHashMap<>();
//    private final long capacity;
//    private final double refillRate;
//
//    public RateLimitManager(long capacity, double refillRate){
//        this.capacity = capacity;
//        this.refillRate = refillRate;
//    }

    public boolean isAllowed(String clientId, RateLimitConfig rateLimitConfig){
        RateLimitingEntity rateLimitingEntity = registry.computeIfAbsent(clientId, k -> rateLimitConfig.createEntity());
        return rateLimitingEntity.tryConsume();
    }

    private RateLimitingEntity createEntity(RateLimitConfig rateLimitConfig){
        if(rateLimitConfig instanceof SlidingWindowConfig){
            SlidingWindowConfig config = (SlidingWindowConfig) rateLimitConfig;
            return new SlidingWindowLogEntity(config.getCapacity(), config.getWindowSizeMs());
        }else if(rateLimitConfig instanceof TokenBucketConfig){
            TokenBucketConfig tokenBucketConfig = (TokenBucketConfig) rateLimitConfig;
            return new TokenBucket(tokenBucketConfig.getCapacity(), tokenBucketConfig.getRefillRatePerSecond());
        }
        throw new IllegalArgumentException("Unknown cnfiguration type:"+ rateLimitConfig.getClass().getName());
    }
}
