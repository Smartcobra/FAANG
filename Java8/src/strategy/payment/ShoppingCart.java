package strategy.payment;

public class ShoppingCart {
    private final PaymentStrategy paymentStrategy;
    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}
