package javafx.lesson01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Регистрация пользователя");
        Parent view = FXMLLoader.load(getClass().getResource("/javafx/lesson01/main.fxml"));
        primaryStage.setScene(new Scene(view));
        primaryStage.show();
    }

}
