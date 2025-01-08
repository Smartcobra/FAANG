package decorator;

class EmailNotification extends NotificationDecorator {
    public EmailNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String send(String message) {
        return super.send(message) + " | Email Sent";
    }
}