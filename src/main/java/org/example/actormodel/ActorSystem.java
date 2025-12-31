package org.example.actormodel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ActorSystem {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<String,Actor> actorRegister = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    public void startActor(Actor actor){
        String actorId = "actor-"+ idCounter.incrementAndGet();
        actor.setActorId(actorId);
        actorRegister.put(actorId, actor);
        executor.submit(actor);
    }

    public Actor getActorById(String actorId){
        return actorRegister.get(actorId);
    }

    public void shutdown(){
        executor.shutdown();
    }
}
