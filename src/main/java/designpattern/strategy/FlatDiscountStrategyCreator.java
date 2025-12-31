package designpattern.strategy;

public class FlatDiscountStrategyCreator extends StrategyFactory{

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FlatDiscountStrategy();
    }
}
