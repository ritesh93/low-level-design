package org.example.coffeevendingmachine;

import java.util.Map;

public class Breverage {
    String name;
    Map<Ingredient, Integer> recipe;
    Breverage(String name, Map<Ingredient, Integer> recipe){
        this.name = name;
        this.recipe = recipe;
    }
}
