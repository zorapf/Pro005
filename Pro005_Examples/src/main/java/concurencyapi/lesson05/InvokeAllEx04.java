package concurencyapi.lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllEx04 {

    public static void main(String[] args) {
        /*Запуск нескольких задач*/
        List<Callable<Integer>> tasks = new ArrayList<>();

        Callable<Integer> task01 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Задача 1 (выполнено)");
                return 100;
            }
        };
        Callable<Integer> task02 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Задача 2 (выполнено)");
                return 200;
            }
        };
        Callable<Integer> task03 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Задача 3 (выполнено)");
                return 300;
            }
        };

        tasks.addAll(Arrays.asList(task01, task02, task03));

        ExecutorService es = Executors.newFixedThreadPool(3);
        try {
            /*invokeAll(tasks) - позволяет передать несколько
            * заранее подготовленых задач, в класс исполнитель
            * на выполнение */
            List<Future<Integer>> futures = es.invokeAll(tasks);
            for (Future<Integer> result : futures) {
                System.out.println("Результат : " + result.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
