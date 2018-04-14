package concurencyapi.lesson05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEx06 {

    public static void main(String[] args) {
        System.out.println("Старт метода main()");

        ScheduledExecutorService ses =
                Executors.newScheduledThreadPool(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Начало фононовой задачи");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Что-то делаем...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Что-то делаем...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Завершение фоновой задачи");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ses.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);


    }
}
