package decorator.notification;

class SMSNotification extends NotificationDecorator {
    public SMSNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String send(String message) {
        return super.send(message) + " | SMS Sent";
    }
}