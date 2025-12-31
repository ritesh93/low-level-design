package org.example.coffeevendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Ingredient, Integer> stock = new HashMap<>();

    boolean hasSufficientIngredients(Breverage breverage){
        for(Map.Entry<Ingredient, Integer> entry : breverage.recipe.entrySet()){
            int available = stock.getOrDefault(entry.getKey(), 0);
            if(available < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    void consumeIngredient(Breverage breverage){
        for(Map.Entry<Ingredient, Integer> entry : breverage.recipe.entrySet()){
            stock.put(entry.getKey(), stock.getOrDefault(entry.getKey(), 0) - entry.getValue());
        }
    }

    void reStock(Ingredient ingredient, int quantity){
        stock.put(ingredient, stock.getOrDefault(ingredient,0) + quantity);
    }
}
