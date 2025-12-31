package org.example.coffeevendingmachine;

public class VendingMachine {
    Inventory inventory = new Inventory();
    PreparationUnit preparationUnit = new PreparationUnit();
    State state = State.IDLE;

    boolean serve(Breverage breverage){
        if(state != State.IDLE){
            System.out.println("Machine busy. Please wait");
            return false;
        }
        if(!inventory.hasSufficientIngredients(breverage)){
            System.out.println("Out of stock for " + breverage.name);
            state = State.OUT_OF_STOCK;
            return false;
        }
        state = State.PROCESSING;
        inventory.consumeIngredient(breverage);
        preparationUnit.prepare(breverage);
        state = State.IDLE;
        return true;
    }

    void restock(Ingredient ingredient, int qty) {
        inventory.reStock(ingredient, qty);
        if (state == State.OUT_OF_STOCK) {
            state = State.IDLE;
        }
    }
}
