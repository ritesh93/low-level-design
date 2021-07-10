package com.ritesh.public_interface;

import com.ritesh.model.ISubscriber;
import com.ritesh.model.Message;
import com.ritesh.model.Topic;

import java.util.UUID;

public class DriverProgram {
    public static void main(String[] args){
        Queue queue = new Queue();
        Topic topic1 = queue.createTopic("topic 1");
        Topic topic2 = queue.createTopic("topic 2");
        ISubscriber subscriber = new SleepingSubscriber(UUID.randomUUID().toString(), 1000L);
        queue.subscribe(topic1, subscriber);
        Message m1 = new Message("message 1");
        queue.publish(topic1, m1);
    }
}
