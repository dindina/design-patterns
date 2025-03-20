package soliddesign;


// Bad Example: Fat interface
interface Worker {
    void work();

    void eat();
}

class HumanWorker implements Worker {
    @Override
    public void work() {
        // ...
    }

    @Override
    public void eat() {
        // ...
    }
}

class RobotWorker implements Worker {
    @Override
    public void work() {
        // ...
    }

    @Override
    public void eat() {
        // Robots don't eat, but we have to implement this method
    }
}

// Good Example: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker1 implements Workable, Eatable {
    @Override
    public void work() {

    }

    @Override
    public void eat() {

    }
    // ...
}

class RobotWorker1 implements Workable {
    @Override
    public void work() {

    }
    // ...
}
public class InterfaceSegregationPrinciple {

    /*Violating the Interface Segregation Principle (ISP) can lead to several problems in your software design.
    Here's what typically happens:
    Fat Interfaces and Unused Methods:
    Code Bloat and Complexity:
    Tight Coupling:
    Difficulty in Testing:
    Unnecessary Implementations with dummy code

     */
}
