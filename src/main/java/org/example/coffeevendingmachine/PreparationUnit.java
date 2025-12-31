package org.example.coffeevendingmachine;

public class PreparationUnit {
    boolean prepare(Breverage breverage){
        System.out.println("Preparing"+ breverage.name);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException exception){
            Thread.currentThread().interrupt();
        }
        System.out.println(breverage.name + "is ready!");
        return true;
    }
}
