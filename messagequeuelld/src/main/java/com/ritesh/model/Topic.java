package com.ritesh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private String topicId;
    private String topicName;
    private List<Message> messageList;
    private List<TopicSubscriber> subscriberList;

    public Topic(@NonNull String topicId, @NonNull String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        messageList = new ArrayList<>();
        subscriberList = new ArrayList<>();
    }

    public synchronized void addMessage(Message message) {
        messageList.add(message);
    }

    public synchronized void addSubscriber(ISubscriber subscriber) {
        subscriberList.add(new TopicSubscriber(subscriber));
    }
}
