package designpattern.strategy;

public class FlatDiscountStrategy implements DiscountStrategy{
    @Override
    public void apply(Cart cart) {
        cart.setTotalValue(cart.getTotalValue() - 100);
    }
}
