package org.example.vendingmachine;

import org.example.vendingmachine.enums.Coin;

public class ItemSelectedState extends VendingMachineState{
    public ItemSelectedState(VendingMachine vendingMachine){
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addBalance(coin.getValue());
        System.out.println("coin inserted: "+ coin.getValue());
        int price = vendingMachine.getSelectedItemCode().getPrice();
        if(price <= vendingMachine.getBalance()){
            System.out.println("Machine has sufficient fund");
            vendingMachine.setCurrentVendingMachineState(new HasMoneyState(vendingMachine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Please add money as the item is already selected"+ vendingMachine.getSelectedItemCode());
    }

    @Override
    public void dispense() {
        System.out.println("Please add money as the item is already selected before calling dispense");
    }
}
