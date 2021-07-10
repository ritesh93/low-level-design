package com.ritesh.public_interface;

import com.ritesh.handler.TopicHandler;
import com.ritesh.model.ISubscriber;
import com.ritesh.model.Message;
import com.ritesh.model.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    Map<String, TopicHandler> topicProcessor = new HashMap<>();

    public Topic createTopic(String topicName){
      String topicId = UUID.randomUUID().toString();
      Topic topic = new Topic(topicId, "topic1");
      topicProcessor.putIfAbsent(topicId, new TopicHandler(topic));
      return topic;
    }

    public void publish(Topic topic, Message message){
        topic.addMessage(message);
        topicProcessor.get(topic.getTopicId()).publish();
    }

    public void subscribe(Topic topic, ISubscriber subscriber){
        topic.addSubscriber(subscriber);
    }
}
