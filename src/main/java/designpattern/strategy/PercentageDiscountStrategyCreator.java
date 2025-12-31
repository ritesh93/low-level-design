package designpattern.strategy;

public class PercentageDiscountStrategyCreator extends StrategyFactory{

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new PercentageDiscountStrategy();
    }
}
