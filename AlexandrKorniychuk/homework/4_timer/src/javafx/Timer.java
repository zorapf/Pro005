package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Timer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Timer");
        primaryStage.setResizable(false);
        Parent main = FXMLLoader.load(getClass().getResource("/resources/view/main.fxml"));
        primaryStage.setScene(new Scene(main));

        primaryStage.show();
    }
}
