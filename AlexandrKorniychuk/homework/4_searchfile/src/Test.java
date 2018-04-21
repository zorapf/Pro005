package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static List<Runnable> tasks = new ArrayList<>();
    private static int n = 0;

    private static List<File> dirs(String directoryName, String findFile) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<>();

        File[] fList = directory.listFiles();

        assert fList != null;
        for (File file : fList) {
            if (file.isFile()) {
                if(file.getName().equals(findFile)) {
//                    System.out.println("level folder: " + tasks.size());
                    System.out.println("file is here: \"" + file.getAbsolutePath() + "\"");
                }
            } else if (file.isDirectory()) {
                 {
                     n ++;
                     ExecutorService es = Executors.newFixedThreadPool(n);
                    tasks.add(() -> resultList.addAll(dirs(file.getAbsolutePath(),findFile)));

                    es.submit(tasks.get(tasks.size() - 1));
                    es.shutdown();
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter directory: ");
        final String path = sc.nextLine();
        System.out.print("enter file: ");
        final String findFile = sc.nextLine();

        dirs(path,findFile);
    }

}
