package strategy.notification;

public class EmailNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Email Notification: " + message);
    }
}
