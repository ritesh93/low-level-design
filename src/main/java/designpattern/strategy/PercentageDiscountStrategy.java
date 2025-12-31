package designpattern.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy{

    @Override
    public void apply(Cart cart) {
        cart.setTotalValue(cart.getTotalValue() * 0.9);
    }
}
