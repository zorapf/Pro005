package javafx.model;

import javafx.domian.ConvertTorRi;
import javafx.domian.Counter;
import javafx.scene.control.TextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Logical {
    public static boolean pause = false;
    private static ConvertTorRi con = new ConvertTorRi();
    private static boolean firstStart = false;
    private static Counter counter = new Counter();
    private static int min = 0;
    private static int hour = 0;
    private static  ExecutorService es = Executors.newFixedThreadPool(2);

    public static void start(TextField fldTime) {

        Runnable task = () -> {
            try {
                for (int i = 0; i < (i + 5); i++) {
                    if(pause) {
                        es.shutdown();
                    } else if(!pause) {
                        counter.incrementSyncMethod();
                        fldTime.setText(getTimeStr());
                        TimeUnit.MILLISECONDS.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        if(!firstStart) {
            es.submit(task);

        }
        firstStart = true;
    }
    public static void stop(TextField fldTime) {
        counter.setToZero();
        min = 0; hour = 0;
//        fldTime.setText("00:00:00");
        fldTime.setText("--:--:--");
    }
    private static synchronized  String getTimeStr() {

        if(counter.value() == 60) {
            counter.setToZero();
            min++;
        }  if(min == 60) {
            min = 0;
            hour++;
        }

//        String mil;
//        if(counter.value() < 10) {
//            mil = String.valueOf("0" + counter.value());
//        } else {
//            mil = String.valueOf(counter.value());
//        }
//        String s;
//        if(min < 10) {
//            s = String.valueOf("0" + min);
//        } else {
//            s = String.valueOf(min);
//        }
//        String m;
//        if(hour < 10) {
//            m = String.valueOf("0" + hour);
//        } else {
//            m = String.valueOf(hour);
//        }
//        return m + ":" + s + ":" + mil;

        return con.Convertor(hour, min, counter.value());
    }
}
