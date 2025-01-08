package strategy.notification;

public class NotificationContext {
    private NotificationStrategy strategy;

    public NotificationContext(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendNotification(String message) {
        strategy.send(message);
    }
}
