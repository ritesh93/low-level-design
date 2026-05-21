package org.example.ratelimiter.model;

public class TokenBucket implements RateLimitingEntity{
    private final long capacity;
    private final double refillRate;
    private double currentTokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, double refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.currentTokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    // entity level logic
    public synchronized boolean tryConsume(){
        refill();
        if(currentTokens >= 1){
            currentTokens--;
            return true;
        }
        return false;
    }

    private void refill(){
        long now = System.currentTimeMillis();
        System.out.println("LastRefillTimestamp::"+ lastRefillTimestamp);
        double tokensToAdd = ((now - lastRefillTimestamp)/ 1000.0) * refillRate;
        currentTokens = Math.min(capacity, currentTokens + tokensToAdd);
        lastRefillTimestamp = now;
    }
}
