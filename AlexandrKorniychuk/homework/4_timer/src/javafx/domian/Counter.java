package javafx.domian;

public class Counter {
    private int count;
    public synchronized void incrementSyncMethod() {
        count++;
    }
    public void setToZero() {
        count = 0;
    }
    public int value() {
        return count;
    }
}
