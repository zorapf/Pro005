package concurencyapi.lesson06;

public class Counter {

    private int count;

    public void increment() {
       count++;
    }

    public void incrementSync() {
        //Блок синхронизации данных
        //Основное назначение блока синхронизации
        //контроль над изменением данных в
        //многопоточных приложениях
        synchronized (this) {
            count++;
        }
    }

    public synchronized void incrementSyncMethod() {
        count++;
    }

    public int value() {
        return count;
    }
}
