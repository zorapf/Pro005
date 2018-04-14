package concurencyapi.lesson05;

import java.util.concurrent.*;

public class CallableEx03 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(1);

        Future<String> strResult = es.submit(() -> {
            System.out.println("Задача");
            TimeUnit.SECONDS.sleep(5);
            return "Результат";
        });

        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("Ожидание...");
        while (!strResult.isDone()) {
            System.out.println("Ждем 1 сек.");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Получаем результат...");
        System.out.println(strResult.get());

        es.shutdown();
    }
}
