package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;

public class DispensingState extends VendingMachineState{

    public DispensingState(VendingMachine vendingMachine){
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        // already triggered by HasMoneyState
    }
}
