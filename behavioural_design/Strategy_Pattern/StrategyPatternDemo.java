import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

// Context Class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Demo: Payment System
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose payment method (1 for PayPal, 2 for Credit Card): ");
        int choice = scanner.nextInt();
        System.out.println("Enter amount: ");
        int amount = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter PayPal email: ");
            String email = scanner.next();
            cart.setPaymentStrategy(new PayPalPayment(email));
        } else {
            System.out.println("Enter Credit Card number: ");
            String cardNumber = scanner.next();
            cart.setPaymentStrategy(new CreditCardPayment(cardNumber));
        }

        cart.checkout(amount);
    }
}
