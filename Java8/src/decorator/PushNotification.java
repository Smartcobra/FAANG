package decorator;

class PushNotification extends NotificationDecorator {
    public PushNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String send(String message) {
        return super.send(message) + " | Push Notification Sent";
    }
}