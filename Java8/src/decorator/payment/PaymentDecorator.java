package decorator.payment;

public abstract class PaymentDecorator implements Payment {
    protected Payment decoratedPayment;

    public PaymentDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void makePayment() {
        decoratedPayment.makePayment();
    }
}
