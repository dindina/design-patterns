package structural;



interface Myclient{

    void call();
}

interface MyAdaptee{

    void method1();
    void method2();
}

class MyAdapter implements Myclient{

    MyAdaptee myAdaptee;
    MyAdapter(MyAdaptee my){
        this.myAdaptee = my;
    }


    @Override
    public void call() {
        myAdaptee.method1();
        myAdaptee.method2();
    }
}


public class MyAdpater {
}
