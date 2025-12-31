package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;

public class HasMoneyState extends VendingMachineState{

    public HasMoneyState(VendingMachine vendingMachine){
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        vendingMachine.setCurrentVendingMachineState(new DispensingState(vendingMachine));
        vendingMachine.dispenseItem();
    }
}
