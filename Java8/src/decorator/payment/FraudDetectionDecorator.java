package decorator.payment;

public class FraudDetectionDecorator extends PaymentDecorator {
    public FraudDetectionDecorator(Payment decoratedPayment) {
        super(decoratedPayment);
    }

    @Override
    public void makePayment() {
        addFraudDetection();
        super.makePayment();
    }

    private void addFraudDetection() {
        System.out.println("Applying fraud detection checks.");
    }
}
