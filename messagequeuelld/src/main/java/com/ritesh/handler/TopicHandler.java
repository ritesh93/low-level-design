package com.ritesh.handler;

import com.ritesh.model.Topic;
import com.ritesh.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private Topic topic;
    Map<String, SubscriberWorker> subscriberWorkerMap;

    public TopicHandler(Topic topic){
        this.topic = topic;
        subscriberWorkerMap = new HashMap<String, SubscriberWorker>();
    }

    public void publish(){
        for(TopicSubscriber topicSubscriber  : topic.getSubscriberList()){
            startSubscriberWorker(topicSubscriber);
        }
    }

    private void startSubscriberWorker(TopicSubscriber  topicSubscriber){
        if(!subscriberWorkerMap.containsKey(topicSubscriber.getSubscriber().getId())){
            subscriberWorkerMap.put(topicSubscriber.getSubscriber().getId(),  new SubscriberWorker(topic, topicSubscriber));
            new Thread(() -> subscriberWorkerMap.get(topicSubscriber.getSubscriber().getId())).start();
        }
        subscriberWorkerMap.get(topicSubscriber.getSubscriber().getId()).wakeUpIfNeeded();
    }
}
