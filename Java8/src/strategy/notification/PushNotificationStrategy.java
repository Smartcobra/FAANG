package strategy.notification;

public class PushNotificationStrategy implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("SMS Notification: " + message);
    }
}
