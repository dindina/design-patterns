package behavioral;

import java.util.concurrent.*;

public class JavaCommandPattern {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Executing task in thread: " + Thread.currentThread().getName());
        };

        executor.submit(task);
        executor.shutdown();
    }
}
