package soliddesign;

// Bad Example: Modifying existing code to add new shapes
class Shapes {
    public void draw(String shapeType) {
        if ("rectangle".equals(shapeType)) {
            // Draw rectangle
        } else if ("circle".equals(shapeType)) {
            // Draw circle
        }
        // ... adding more shapes requires modifying this method ...
    }
}

// Good Example: Using inheritance and interfaces
interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        // Draw rectangle
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        // Draw circle
    }
}
public class OpenClosedPrinciple {

    /*
    Software entities (classes, modules, functions, etc.) should be open for extension,
    but closed for modification.

    Violating the Open/Closed Principle (OCP) can introduce significant problems in software development.

     Here's what typically happens when you don't adhere to it:  

     Increased Risk of Introducing Bugs:
     Modifying existing code, especially code that's already working,
     increases the risk of introducing unintended side effects and bugs

     Reduced Maintainability:
     Each time you need to add or change something, you have to delve into the existing code,
     understand its intricacies, and make modifications.

     Reduced Reusability:
     Difficulty in Extending Functionality:







     */
}
