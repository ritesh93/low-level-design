package designpattern.decorator;

public class LoggingDecorator implements IEmailService{

    IEmailService emailService;
    LoggingDecorator(IEmailService emailService){
        this.emailService = emailService;
    }
    @Override
    public void send(String from, String to) {
        System.out.println("Logging the email send from::"+ from +"::to::"+ to);
        emailService.send(from, to);
    }
}
