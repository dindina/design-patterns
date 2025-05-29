package soliddesign;


// Low-level module: Concrete Stripe Payment Gateway
class StripeGateway {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " using Stripe.");
        // ... actual Stripe API calls ...
    }
}

// Low-level module: Concrete PayPal Payment Gateway
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Making payment of $" + amount + " using PayPal.");
        // ... actual PayPal API calls ...
    }
}

// High-level module: Payment Processor
// VIOLATES DIP: Depends directly on concrete low-level implementations
class PaymentProcessor {
    private StripeGateway stripeGateway; // Direct dependency
    private PayPalGateway payPalGateway; // Direct dependency

    public PaymentProcessor() {
        this.stripeGateway = new StripeGateway(); // Creates concrete dependency
        this.payPalGateway = new PayPalGateway(); // Creates concrete dependency
    }

    public void processPayment(double amount, String method) {
        if ("stripe".equalsIgnoreCase(method)) {
            stripeGateway.charge(amount);
        } else if ("paypal".equalsIgnoreCase(method)) {
            payPalGateway.makePayment(amount);
        } else {
            System.out.println("Unsupported payment method: " + method);
        }
    }
}

// Client Code
class DipViolationExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(100.0, "stripe");
        processor.processPayment(50.0, "paypal");
        processor.processPayment(25.0, "googlepay"); // Will be unsupported
    }
}

// principle followed
// 1. Abstraction (Interface): High-level and Low-level modules depend on this.
// This defines the "contract" for any payment gateway.
interface PaymentGateway {
    void processPayment(double amount);
}

// 2. Low-level modules (Concrete Implementations) depend on the Abstraction.
// They implement the contract defined by the interface.
class StripeGatewayNew implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Charging $" + amount + " using Stripe Gateway.");
        // ... actual Stripe API calls ...
    }
}

class PayPalGatewayNew implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Making payment of $" + amount + " using PayPal Gateway.");
        // ... actual PayPal API calls ...
    }
}

class GooglePayGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " using Google Pay Gateway.");
        // ... actual Google Pay API calls ...
    }
}

// 3. High-level module (PaymentProcessor) depends on the Abstraction.
// It receives its dependency (the PaymentGateway) through its constructor (Dependency Injection).
class PaymentProcessorNew {
    private PaymentGateway paymentGateway; // Dependency is now on the abstraction

    // Constructor Injection: The dependency is provided from outside
    public PaymentProcessorNew(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void executePayment(double amount) {
        System.out.println("PaymentProcessor initiating payment...");
        paymentGateway.processPayment(amount); // Calls the abstracted method
        System.out.println("Payment initiated successfully.");
    }
}

// Client Code: Responsible for "wiring up" the dependencies
class DipExample {
    public static void main(String[] args) {
        // Use Stripe Gateway
        PaymentGateway stripe = new StripeGatewayNew();
        PaymentProcessorNew processor1 = new PaymentProcessorNew(stripe);
        processor1.executePayment(100.0);

        System.out.println("\n--- Switching Payment Gateway ---");

        // Use PayPal Gateway (without changing PaymentProcessor logic)
        PaymentGateway paypal = new PayPalGatewayNew();
        PaymentProcessorNew processor2 = new PaymentProcessorNew(paypal);
        processor2.executePayment(75.50);

        System.out.println("\n--- Adding a new Payment Gateway ---");

        // Use Google Pay Gateway (without changing PaymentProcessor logic)
        PaymentGateway googlePay = new GooglePayGateway();
        PaymentProcessorNew processor3 = new PaymentProcessorNew(googlePay);
        processor3.executePayment(200.0);

        System.out.println("\n--- Testing Payment Processor with a Mock ---");

        // Example for testing: You can easily substitute with a mock
        class MockPaymentGateway implements PaymentGateway {
            @Override
            public void processPayment(double amount) {
                System.out.println("MOCK: Simulating payment of $" + amount);
            }
        }
        PaymentGateway mockGateway = new MockPaymentGateway();
        PaymentProcessorNew testProcessor = new PaymentProcessorNew(mockGateway);
        testProcessor.executePayment(999.99); // No actual API calls, just testing
    }
}


public class DependencyInversionPrinciple {
    /*
     * The Dependency Inversion Principle states two key things:

        High-level modules should not depend on low-level modules. Both should depend on abstractions.
        Abstractions should not depend on details. Details should depend on abstractions.
     */

     /*
    When the Dependency Inversion Principle (DIP) is not followed, you'll encounter several issues that negatively impact the flexibility, maintainability, and testability of your code.
    Tight Coupling Between High-Level and Low-Level Modules:


    Reduced Reusability:
    Failing to follow the DIP leads to a rigid and inflexible system where high-level policies are controlled by low-level details.

 This results in code that is difficult to maintain, test, and extend. By adhering to DIP, you create a more decoupled and modular system that is better suited for change
     */

}
