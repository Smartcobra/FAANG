package strategy;

public class PushNotificationStrategy  implements AlertStrategy {
    private String deviceToken;

    public PushNotificationStrategy(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public void sendAlert(String message) {
        // Logic to send a push notification
        System.out.println("Sending push notification to " + deviceToken + ": " + message);
    }
}
