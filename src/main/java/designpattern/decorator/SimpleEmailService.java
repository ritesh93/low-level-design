package designpattern.decorator;

public class SimpleEmailService implements IEmailService{
    public void send(String from, String to){
        System.out.println("Email sent from::"+ from+":: to ::"+ to);
    }
}
