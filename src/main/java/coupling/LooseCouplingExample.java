package coupling;

// Abstraction (Interface)
interface DataStorage {
    void saveData(String data);
}

// Low-level module (Concrete implementation)
class DatabaseService1 implements DataStorage {
    public void saveData(String data) {
        System.out.println("Saving data to database: " + data);
        // Actual database saving logic here
    }
}

class S3StorageService implements DataStorage {
    public void saveData(String data) {
        System.out.println("Saving data to S3: " + data);
        // Actual database saving logic here
    }
}

// High-level module (Business logic)
class UserProcessor1 {
    private DataStorage dataStorage; // Dependency on abstraction

    public UserProcessor1(DataStorage dataStorage) { // Dependency injection
        this.dataStorage = dataStorage;
    }

    public void processUser(String userData) {
        // Business logic to process user data
        System.out.println("Processing user data: " + userData);
        dataStorage.saveData(userData); // Calling abstraction
    }
}

public class LooseCouplingExample {
    public static void main(String[] args) {
        DataStorage databaseService = new DatabaseService1();
        UserProcessor1 processor1 = new UserProcessor1(databaseService);
        processor1.processUser("Jane Smith");

        DataStorage s3 = new S3StorageService();
        UserProcessor1 processor2 = new UserProcessor1(s3);
        processor2.processUser("Jane Smith");


    }
}

