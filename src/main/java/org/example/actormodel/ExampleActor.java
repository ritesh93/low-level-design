package org.example.actormodel;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ExampleActor extends Actor{
    private final ActorSystem actorSystem;
    @Getter private final List<String> receivedMessage = new ArrayList<>();
    Logger logger = Logger.getLogger(ExampleActor.class.getName());

    public ExampleActor(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
    }

    @Override
    protected void onReceive(Message message) {
        logger.info(getActorId() + "Received: "+ message.getContent()+ " from:"+ message.getSenderId());
        Actor sender = actorSystem.getActorById(message.getSenderId());
        if(sender != null && !message.getSenderId().equals(getActorId())){
            sender.send(new Message("I got your message ", getActorId()));
        }
    }
}
