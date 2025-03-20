package soliddesign;


class User {
    public void saveUser() {
        // Save user to database
    }

    public void sendEmail() {
        // Send email to user
    }
}

// Good Example: Separating responsibilities
class UserRepository {
    public void saveUser() {
        // Save user to database
    }
}

class EmailService {
    public void sendEmail() {
        // Send email to user
    }
}
public class SingleResponsibility {
    //A class should have one, and only one, reason to change.
    /*Violating the Single Responsibility Principle (SRP)
    can lead to several negative consequences in your software:

    Increased Complexity and Reduced Maintainability:
    When a class has multiple responsibilities, it becomes larger and more complex.

    Tight Coupling and Increased Risk of Change:
    A change in one responsibility might require changes in other parts of the system, leading to a ripple effect.

    Difficulty in Testing:
    You have to create more test cases to cover all the different responsibilities.

    Increased Code Smells:
    Increased likelihood of merge conflicts:

    */


}
