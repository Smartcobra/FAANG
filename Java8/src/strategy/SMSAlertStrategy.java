package strategy;

public class SMSAlertStrategy implements AlertStrategy {
    private String phoneNumber;

    public SMSAlertStrategy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendAlert(String message) {
        // Logic to send an SMS alert
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
