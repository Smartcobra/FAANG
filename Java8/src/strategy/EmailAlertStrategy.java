package strategy;

public class EmailAlertStrategy implements AlertStrategy {
    private String email;

    public EmailAlertStrategy(String email) {
        this.email = email;
    }

    @Override
    public void sendAlert(String message) {
        // Logic to send an email alert
        System.out.println("Sending email to " + email + ": " + message);
    }
}
