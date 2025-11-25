//Submit Tasks to a 3-thread Pool

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 0; i <= 3; i++){
            final int id = i;

            service.submit(()->{
               System.out.println("Task " + id + " executed by " + Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}
