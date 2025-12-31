package org.example.actormodel;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Actor implements Runnable{
    @Setter @Getter private String actorId;
    private final BlockingQueue<Message> mailBox = new LinkedBlockingQueue<>();
    private volatile boolean active = true;

    public void send(Message message){
        mailBox.add(message);
    }
    public void stop(){ active = false;}

    @Override
    public void run(){
        while(active){
            try{
                Message message = mailBox.take();
                onReceive(message);
            }catch(InterruptedException exception){
                Thread.currentThread().interrupt();
            }
        }
    }

    protected abstract void onReceive(Message message);

}
