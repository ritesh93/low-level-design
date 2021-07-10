package com.ritesh.public_interface;

import com.ritesh.model.ISubscriber;
import com.ritesh.model.Message;

import java.util.UUID;

public class SleepingSubscriber implements ISubscriber {
    private String id;
    private Long sleepTimeInMs;
    SleepingSubscriber(String id, Long sleepTimeInMs){
        this.id = id;
        this.sleepTimeInMs = sleepTimeInMs;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("subscriber consumer method invoked");
        System.out.println(message);
        Thread.sleep(sleepTimeInMs);
        System.out.println("subscriber consumed the message");
    }
}
