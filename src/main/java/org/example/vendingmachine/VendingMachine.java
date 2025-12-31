package org.example.vendingmachine;

import org.example.vendingmachine.entity.Inventory;
import org.example.vendingmachine.entity.Item;
import org.example.vendingmachine.enums.Coin;

public class VendingMachine {
    private final static VendingMachine INSTANCE = new VendingMachine();
    private final Inventory inventory = new Inventory();
    private VendingMachineState currentVendingMachineState;
    private int balance = 0;
    private String selectedItemCode;

    public VendingMachine(){
        currentVendingMachineState = new IdleState(this);
    }

    //getInstance
    public static VendingMachine getInstance(){
        return INSTANCE;
    }

    //methods called by endUser for running the flow
    //dispense
    public void dispense(){
        this.currentVendingMachineState.dispense();
    }

    //addCoin
    public void insertCoin(Coin coin){
        this.currentVendingMachineState.insertCoin(coin);
    }

    //selectItem
    public void selectItem(String code){
        this.currentVendingMachineState.selectItem(code);
    }

    // methods used by Internal working of vending machine
    public void dispenseItem(){
        if(this.inventory.isAvailable(this.selectedItemCode)){
            Item item = this.inventory.getItem(this.selectedItemCode);
            if(this.balance - item.getPrice() >= 0){
                System.out.println("Item with code::"+ item.getCode() +"is dispensed");
                this.inventory.reduceStock(this.selectedItemCode);
            }
        }
    }

    void addItem(String code, String name, int quantity, int price){
        Item item = new Item(code, name, price);
        this.inventory.addItem(code, item, quantity);
    }

    void addBalance(int value){
        balance += value;
    }

    public void reset(){
        this.currentVendingMachineState = new IdleState(this);
        this.balance = 0;
        this.selectedItemCode = null;
    }

    // getters and setters
    public Inventory getInventory(){ return this.inventory;}
    public int getBalance(){ return balance;}
    public void setCurrentVendingMachineState(VendingMachineState state){
        this.currentVendingMachineState = state;
    }
    public void setSelectedItemCode(String itemCode){
        this.selectedItemCode = itemCode;
    }

    public Item getSelectedItemCode(){
        return this.inventory.getItem(selectedItemCode);
    }

}
