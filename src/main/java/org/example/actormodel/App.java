package org.example.actormodel;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = new ActorSystem();
        Actor Ritesh = new ExampleActor(system);
        Actor Ankita = new ExampleActor(system);
        system.startActor(Ritesh);
        system.startActor(Ankita);
        Ritesh.send(new Message("Hello Ankita", Ankita.getActorId()));
        Ankita.send(new Message("Hello Ritesh", Ritesh.getActorId()));
        Thread.sleep(200);
        Ritesh.stop();
        Ankita.stop();
        system.shutdown();
    }
}
