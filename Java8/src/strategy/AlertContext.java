package strategy;

public class AlertContext {
    private AlertStrategy strategy;

    // Set the strategy at runtime
    public void setStrategy(AlertStrategy strategy) {
        this.strategy = strategy;
    }

    // Use the strategy to send alert
    public void sendAlert(String message) {
        if (strategy != null) {
            strategy.sendAlert(message);
        } else {
            System.out.println("No alert strategy set.");
        }
    }
}
