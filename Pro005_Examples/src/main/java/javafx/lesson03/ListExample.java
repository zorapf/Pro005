package javafx.lesson03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView - Demo");
        primaryStage.setResizable(false);
        Parent main = FXMLLoader.load(
                getClass()
                        .getResource("/javafx/lesson03/view/main.fxml")
        );
        primaryStage.setScene(new Scene(main));
        primaryStage.show();
    }
}
