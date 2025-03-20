package creational.singleton;

public class Singleton {

    private static Singleton instance;

    public static synchronized  Singleton getInstance(){
        if(instance == null)
        {
            return  new Singleton();
        }else {
            return instance;
        }

    }

}
