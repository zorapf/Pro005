package javafx.lesson01.model;

public class PrintModel {

    public static void print(
            String login,
            String password,
            String passwordConfirm) {
        System.out.println(
                "\nLogin           : " + login +
                "\nPassword        : " + password +
                "\nPasswordConfirm : " + passwordConfirm
        );
    }
}
