package org.example.ratelimiter;

import org.example.ratelimiter.config.RateLimitConfig;
import org.example.ratelimiter.manager.RateLimitManager;
import org.example.ratelimiter.model.TokenBucket;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(2, 1);
        RateLimitManager manager = new RateLimitManager(2, 1);
        RateLimitConfig rateLimitConfig = new RateLimitConfig(2,1);
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        Thread.sleep(1000);
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
        System.out.println("Call ratelimitManager"+ manager.isAllowed("client1", rateLimitConfig));
    }
}
