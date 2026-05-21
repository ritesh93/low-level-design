package org.example.ratelimiter.model;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLogEntity implements  RateLimitingEntity {
    private final long maxRequests;
    private final long windowSizeMs;
    private final Queue<Long> requestTimeStampsLog = new LinkedList<>();

    public SlidingWindowLogEntity(long maxRequests, long windowSizeMs){
        this.maxRequests = maxRequests;
        this.windowSizeMs = windowSizeMs;
    }
    @Override
    public synchronized boolean tryConsume() {
        long now = System.currentTimeMillis();
        long windowBoundary = now - windowSizeMs;
        while(!requestTimeStampsLog.isEmpty() && requestTimeStampsLog.peek() < windowBoundary){
            requestTimeStampsLog.poll();
        }

        if(requestTimeStampsLog.size() < maxRequests){
            requestTimeStampsLog.offer(now);
            return true;
        }
        return false;
    }
}
