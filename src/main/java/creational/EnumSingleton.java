package creational;
enum Singleton {
    instance;

private String config;

private Singleton(){

    config = System.getProperty("config", null);
    System.out.println("in init " + config);
}

public String getConfig(){
    return this.config;


}
}

public class EnumSingleton{
    public static void main(String[] args) {
        Singleton instance = Singleton.instance;
        System.out.println(instance.getConfig());

    }
}
