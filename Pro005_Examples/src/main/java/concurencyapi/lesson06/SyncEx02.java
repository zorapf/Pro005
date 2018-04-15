package concurencyapi.lesson06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SyncEx02 {

    /*Lock API - библиотека которая включена в
    * состав Concurrency API, для синхронизации
    * потоков*/
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Counter counter = new Counter();

        ExecutorService es = Executors.newFixedThreadPool(2);

        Runnable task01 = new Runnable() {
            @Override
            public void run() {
                /*lock() - устанавливает блокировку потока*/
                locker.lock();
                /*isHeldByCurrentThread() - проверяет получение
                * блокировки текущим потоком*/
                if (locker.isHeldByCurrentThread()) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("Выполнение задачи №01");
                        for (int i = 0; i < 5_000; i++) {
                            counter.increment();
                        }
                        System.out.println("*********************");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Результат : " + counter.value());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                /*unlock() - снимает блокировку потока*/
                locker.unlock();
            }
        };
        es.submit(task01);

        Runnable task02 = new Runnable() {
            @Override
            public void run() {
                /*isLocked() - проверяет установлина ли
                * блокировка каким либо из потоков */
                while (locker.isLocked()) {
                    try {
                        System.out.println("Попытка установить блокировку -> ");
                        TimeUnit.MILLISECONDS.sleep(250);
                        System.out.println("false");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    while (!locker.tryLock(100, TimeUnit.MILLISECONDS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (locker.isHeldByCurrentThread()) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("Выполнение задачи №02");
                        for (int i = 0; i < 2_500; i++) {
                            counter.increment();
                        }
                        System.out.println("*********************");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Результат : " + counter.value());
                    } catch (InterruptedException exc) {}
                }

                locker.unlock();
            }
        };
        es.submit(task02);


        es.shutdown();
    }
}
