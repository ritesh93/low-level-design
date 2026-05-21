package org.example.ratelimiter.model;

public interface RateLimitingEntity {
    boolean tryConsume();
}
