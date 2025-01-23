package decorator.notification;

public class Main {
    public static void main(String[] args) {
        Notification basicNotification = new BasicNotification();
        Notification emailAndSmsNotification = new SMSNotification(new EmailNotification(basicNotification));
        Notification fullNotification = new PushNotification(emailAndSmsNotification);

        System.out.println(fullNotification.send("System Alert"));
    }
}
