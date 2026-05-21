//package org.example.ratelimiter.manager;
//
//import org.example.ratelimiter.config.RateLimitConfig;
//import org.example.ratelimiter.model.TokenBucket;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class HierarchicalRateLimitManager {
//    private final TokenBucket globalBucket = new TokenBucket(1000, 100);
//    private final Map<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();
//
//    public boolean isAllowed(String userId, RateLimitConfig rateLimitConfig){
//        TokenBucket userBucket = userBuckets.computeIfAbsent(userId, k -> new TokenBucket(rateLimitConfig.getCapacity(),rateLimitConfig.getRefillRate()));
//        synchronized (this){
//            if(globalBucket.tryConsume()){
//                if(userBucket.tryConsume()){
//                    return true;
//                }
//                else{
//                    // rollback globaltoken
//                }
//            }
//        }
//        return false;
//    }
//}
