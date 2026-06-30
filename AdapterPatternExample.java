interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using PayPal.");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        PaymentProcessor payment1 = new PayPalAdapter(new PayPalGateway());
        payment1.processPayment(500);

        PaymentProcessor payment2 = new StripeAdapter(new StripeGateway());
        payment2.processPayment(1000);
    }
}
