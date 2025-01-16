package decorator.notification;

public class NotificationDecorator implements Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String send(String message) {
        return notification.send(message);
    }
}
