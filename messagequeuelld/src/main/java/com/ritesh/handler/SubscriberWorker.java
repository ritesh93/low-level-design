package com.ritesh.handler;

import com.ritesh.model.Topic;
import com.ritesh.model.TopicSubscriber;
import lombok.SneakyThrows;

public class SubscriberWorker implements Runnable{
    private Topic topic;
    private TopicSubscriber topicSubscriber;

    SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber){
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @SneakyThrows
    public void run() {
        synchronized (topicSubscriber){
            while(true){
                int currentOffset = topicSubscriber.getOffset().get();
                while(currentOffset >= topic.getMessageList().size()){
                    topicSubscriber.wait();
                }
                topicSubscriber.getSubscriber().consume(topic.getMessageList().get(currentOffset));
                topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset+1);
            }
        }
    }

    public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
