package concurencyapi.lesson06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncEx03 {

    private static String someValue = "before";

    public static void main(String[] args) {
        ReadWriteLock locker = new ReentrantReadWriteLock();

        ExecutorService es = Executors.newFixedThreadPool(5);

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    locker.writeLock().lock();
                    System.out.println("Начало записи данных");
                    TimeUnit.MILLISECONDS.sleep(250);
                    someValue = "newValue";
                    System.out.println(someValue);
                    TimeUnit.MILLISECONDS.sleep(250);
                    System.out.println("Завершение записи данных");
                    locker.writeLock().unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(750);
                        System.out.print(Thread.currentThread().getName() + " -> ");
                        locker.readLock().lock();
                        System.out.println(someValue);
                        locker.readLock().unlock();
                        TimeUnit.MILLISECONDS.sleep(750);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        es.submit(writeTask);
        es.submit(readTask);
        es.submit(readTask);
        es.submit(readTask);

        es.shutdown();
    }
}
