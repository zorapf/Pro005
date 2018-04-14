package concurencyapi.lesson05;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledEx05 {

    public static void main(String[] args) throws InterruptedException {
        /* Отложеный запуск задачи */
        System.out.println("Старт метода main()");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Отложенная задача!");
            }
        };

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        /* 1-й параметр - задача к отложеному выполнению
        *  2-й параметр - задержка перед началом выполнения задачи
        *  3-й параметр - ЕИ */
        ScheduledFuture sf = ses.schedule(task, 5, TimeUnit.SECONDS);
        while (!sf.isDone()) {
            System.out.println("До запуска осталось : " + sf.getDelay(TimeUnit.MILLISECONDS));
        }

        System.out.println("Завершение метода main()");
        ses.shutdown();
    }
}
