package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;

public class IdleState extends VendingMachineState{
    public IdleState(VendingMachine vendingMachine){
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an Item before inserting money");
    }

    @Override
    public void selectItem(String code) {
        if(!vendingMachine.getInventory().isAvailable(code)){
            System.out.println("Item not available");
            return;
        }
        vendingMachine.setSelectedItemCode(code);
        vendingMachine.setCurrentVendingMachineState(new ItemSelectedState(vendingMachine));
        System.out.println("Item selected: "+ code);
    }

    @Override
    public void dispense() {
        System.out.println("No item selected");
    }
}
