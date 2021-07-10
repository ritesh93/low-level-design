package com.ritesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
public class TopicSubscriber {
    private AtomicInteger offset = new AtomicInteger(0);
    private ISubscriber subscriber;
    TopicSubscriber(ISubscriber subscriber){
        this.subscriber = subscriber;
    }
}
