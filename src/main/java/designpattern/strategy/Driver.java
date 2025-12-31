package designpattern.strategy;

public class Driver {
    public static void main(String[] args){
        Cart cart = new Cart(150);
        StrategyFactory strategyFactory = new PercentageDiscountStrategyCreator();
        DiscountStrategy strategy = strategyFactory.createDiscountStrategy();
        strategy.apply(cart);
        System.out.println("After applying Discount cart value::"+ cart.getTotalValue());
    }
}
