package strategy;

public class Main {
    public static void main(String[] args) {
        AlertContext context = new AlertContext();

        // Send email alert
        context.setStrategy(new EmailAlertStrategy("example@example.com"));
        context.sendAlert("This is an email alert!");

        // Send SMS alert
        context.setStrategy(new SMSAlertStrategy("123-456-7890"));
        context.sendAlert("This is an SMS alert!");

        // Send push notification
        context.setStrategy(new PushNotificationStrategy("deviceToken123"));
        context.sendAlert("This is a push notification alert!");
    }
}
