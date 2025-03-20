package creational;

enum SingletonEnum {

    INSTANCE;
    private String dbURL = "jdbc://localhost:4040";
    private int connections = 10;

    public String getDbURL() {
        return dbURL;
    }

    public int getConnections() {
        return connections;
    }
}

public class EnumSingleton{

    public static void main(String[] args) {
        System.out.println(SingletonEnum.INSTANCE.getConnections());
        System.out.println(SingletonEnum.INSTANCE.getDbURL());

    }
}


