package coupling;

// Low-level module (Concrete implementation)
class DatabaseService {
    public void saveData(String data) {
        System.out.println("Saving data to database: " + data);
        // Actual database saving logic here
    }
}

// High-level module (Business logic)
class UserProcessor {
    private DatabaseService databaseService; // Tight coupling

    public UserProcessor() {
        this.databaseService = new DatabaseService(); // Direct instantiation
    }

    public void processUser(String userData) {
        // Business logic to process user data
        System.out.println("Processing user data: " + userData);
        databaseService.saveData(userData); // Directly calling low-level module
    }
}

public class TightCouplingExample {
    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();
        processor.processUser("John Doe");
    }
}

