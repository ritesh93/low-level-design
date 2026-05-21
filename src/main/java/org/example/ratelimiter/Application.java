package org.example.ratelimiter;

import org.example.ratelimiter.config.RateLimitConfig;
import org.example.ratelimiter.config.SlidingWindowConfig;
import org.example.ratelimiter.manager.RateLimitManager;
import org.example.ratelimiter.model.SlidingWindowLogEntity;
import org.example.ratelimiter.model.TokenBucket;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(2, 1);
        SlidingWindowConfig rateLimitConfig = new SlidingWindowConfig(1, 1000);
        RateLimitManager manager = new RateLimitManager();
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        Thread.sleep(1000);
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
    }
}
