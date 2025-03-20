package soliddesign;


// Bad Example: High-level module depending on low-level module
class LightBulb {
    public void turnOn() {
        // ...
    }

    public void turnOff() {
        // ...
    }
}

class Switch {
    private LightBulb lightBulb;

    public Switch() {
        this.lightBulb = new LightBulb();
    }

    public void operate() {
        lightBulb.turnOn();
    }
}

// Good Example: High-level module depending on abstraction
interface Switchable {
    void turnOn();

    void turnOff();
}

class LightBulb1 implements Switchable {
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
    // ...
}

class Switch1 {
    private Switchable device;

    public Switch1(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
public class DependencyInversionPrinciple {
    /*
    When the Dependency Inversion Principle (DIP) is not followed, you'll encounter several issues that negatively impact the flexibility, maintainability, and testability of your code.
    Tight Coupling Between High-Level and Low-Level Modules:


    Reduced Reusability:
    Failing to follow the DIP leads to a rigid and inflexible system where high-level policies are controlled by low-level details.

 This results in code that is difficult to maintain, test, and extend. By adhering to DIP, you create a more decoupled and modular system that is better suited for change
     */

}
