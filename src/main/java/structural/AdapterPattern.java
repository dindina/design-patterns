package structural;

// Target Interface (Client Expects):
interface Target {
    void request(int number);
}

// Adaptee (Existing Class with Incompatible Interface):
class Adaptee {
    public void specificRequest(String str) {
        System.out.println("Adaptee: Performing a specific request." + str);
    }
}

// Adapter (Adapts Adaptee to Target):
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request(int number) {
        System.out.println("Adapter: Translating request to specific request.");
        adaptee.specificRequest(String.valueOf(number));
        System.out.println("Adapter: Request completed.");
    }
}

// Client Class:
public class AdapterPattern {
    public static void main(String[] args) {
        // Using the Adaptee directly (wouldn't work if Target was needed):
        Adaptee adaptee = new Adaptee();
        adaptee.specificRequest("10");

        System.out.println("\n--- Using the Adapter ---");

        // Using the Adapter to make the Adaptee compatible with the Target:
        Target target = new Adapter(adaptee);
        target.request(10);
    }
}