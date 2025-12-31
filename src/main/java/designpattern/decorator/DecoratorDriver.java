package designpattern.decorator;

public class DecoratorDriver {
    public static void main(String[] args){
        LoggingDecorator loggingDecorator = new LoggingDecorator(new SimpleEmailService());
        RetryDecorator retryDecorator = new RetryDecorator(loggingDecorator);
        retryDecorator.send("Ritesh","ankita");
    }
}
