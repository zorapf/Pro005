package concurencyapi.lesson05;

import java.util.concurrent.*;

public class CallableEx02 {

    /* Callable - интерфейс который доступен
    *  в Concurrency API, позволяет нам вернуть
    *  результат работы фоновой задачи для
    *  дальнейшей обработки*/

    public static void main(String[] args) {
        Callable<String> strTask = () -> {
            System.out.println("Проводим работу");
            TimeUnit.SECONDS.sleep(3);
            return "Результат выполнения работы";
        };

        /*newFixedThreadPool(<количество активных потоков>) */
        ExecutorService es = Executors.newFixedThreadPool(2);

        /*Future<тип ожидаемого результата>*/
        Future<String> strResult = es.submit(strTask);

        try {
            System.out.println("Ожидание результата...");
            /* isDone() - позволяет проверить завершена ли задача
            *  true  - завершено
            *  false - в работе*/
            System.out.println("Задача завершена? -> " + strResult.isDone());
            if (!strResult.isDone()) {
                String string = strResult.get(5, TimeUnit.SECONDS);
                System.out.println(string);
            } else {
                System.out.println(strResult.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
