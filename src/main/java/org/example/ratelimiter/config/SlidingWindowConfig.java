package org.example.ratelimiter.config;

import org.example.ratelimiter.model.RateLimitingEntity;
import org.example.ratelimiter.model.SlidingWindowLogEntity;

public class SlidingWindowConfig extends RateLimitConfig{
    private final long windowSizeMs;
    public SlidingWindowConfig(long capacity, long windowSizeMs){
        super(capacity);
        this.windowSizeMs = windowSizeMs;
    }
    public long getWindowSizeMs(){
        return windowSizeMs;
    }

    @Override
    public RateLimitingEntity createEntity() {
        return new SlidingWindowLogEntity(this.getCapacity(), this.windowSizeMs);
    }
}
