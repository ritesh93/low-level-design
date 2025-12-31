package designpattern.decorator;

public class RetryDecorator implements IEmailService{
    IEmailService emailService;

    RetryDecorator(IEmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public void send(String from, String to) {
        System.out.println("Retrying the send email for 3 times");
        for(int i=0;i<3;i++){
            emailService.send(from, to);
        }
    }
}
