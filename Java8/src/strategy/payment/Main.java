package strategy.payment;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardPayment());
        cart.checkout(1000);
        cart = new ShoppingCart(new PayPalPayment());
        cart.checkout(500);  // Output: Paid 500 using PayPal.
    }

}
