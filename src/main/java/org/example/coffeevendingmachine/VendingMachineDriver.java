package org.example.coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineDriver {

    public static void main(String[] args){
        VendingMachine machine = new VendingMachine();
        Map<Ingredient , Integer> recipe = new HashMap<>();
        recipe.put(new Ingredient("milk"), 2);
        recipe.put(new Ingredient("sugar"), 1);
        recipe.put(new Ingredient("tea-leaves"), 3);
        Breverage coffee = new Breverage("milkcoffeee", recipe);
        machine.serve(coffee);
    }
}

