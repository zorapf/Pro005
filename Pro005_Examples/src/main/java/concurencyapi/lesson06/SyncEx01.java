package concurencyapi.lesson06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncEx01 {

    public static void main(String[] args) {
        Counter counter = new Counter();

        ExecutorService es =
                Executors.newFixedThreadPool(2);

        Runnable task01 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500_000; i++) {
                    counter.increment();
//                    counter.incrementSync();
//                    counter.incrementSyncMethod();
                }
            }
        };
        es.submit(task01);

        Runnable task02 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500_000; i++) {
                    counter.increment();
//                    counter.incrementSync();
//                    counter.incrementSyncMethod();
                }
            }
        };
        es.submit(task02);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(counter.value());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}
