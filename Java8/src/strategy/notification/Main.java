package strategy.notification;

public class Main {
    public static void main(String[] args) {
        NotificationContext context = new NotificationContext(new EmailNotificationStrategy());
        context.sendNotification("System Alert"); // Output: Email Notification: System Alert

        context.setStrategy(new SMSNotificationStrategy());
        context.sendNotification("System Alert"); // Output: SMS Notification: System Alert

        context.setStrategy(new PushNotificationStrategy());
        context.sendNotification("System Alert"); // Output: Push Notification: System Alert
    }
}
