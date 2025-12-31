package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;

public abstract class VendingMachineState {
    VendingMachine vendingMachine;

    VendingMachineState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
}
