package decorator;

public class BasicNotification implements Notification {
    @Override
    public String send(String message) {
        return "Basic Notification: " + message;
    }
}