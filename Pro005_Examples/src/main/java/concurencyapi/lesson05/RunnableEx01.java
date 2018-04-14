package concurencyapi.lesson05;

/* Concurrency API - библеотека инструментов
*  для удобного управления потоками */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableEx01 {

    public static void main(String[] args) throws InterruptedException {
        /*Runnable - интерфейс для описания
          отдельного потока*/
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Задание 1 (выполнено)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Задание 2 (выполнено)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /** ExecutorService (Класс Исполнитель)
         *  ExecutorService - интерфейс сервиса, для работы с потоками
         *  Executors       - класс (фабрика), котрый позволяет созтавать
         *                    необходимый сервис для запуска
         *  newSingleThreadExecutor() - исполнитель который в фоновом режиме
         *                              выполняет одну задачу */
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(task);
        es.execute(task2);

        es.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Задание 3 (выполнено)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*Завершение работы исполнителя (неправильная форма завершения)*/
//        es.shutdown();

        TimeUnit.SECONDS.sleep(15);

        if (!es.isTerminated()) {
            try {
                System.out.println("Подготовка к завершению работы исполнителя");
                System.out.println("Ожидание завершения работы 3 сек.");
                es.awaitTermination(3, TimeUnit.SECONDS);
                System.out.println("Досрочная остановка исполнителя");
                es.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
    }
}
