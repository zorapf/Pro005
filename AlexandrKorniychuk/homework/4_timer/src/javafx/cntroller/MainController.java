package javafx.cntroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.model.Logical;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class MainController {
    @FXML private TextField fldTime;
    @FXML private Button btnStart;
    @FXML private Button btnPause;
    @FXML private Button btnStop;
    @FXML private Button btnLap;
    @FXML private ListView<String> lstRec;
                private ObservableList<String> observableList;
    private static List<String> list = new ArrayList<>();

    private void enableButtons(boolean e) {
        btnPause.setDisable(e);
        btnStop.setDisable(e);
        btnLap.setDisable(e);
    }

    @FXML private void initialize() {
        enableButtons(true);
        observableList = FXCollections.observableArrayList(list);
        lstRec.setItems(observableList);
        System.out.println(fldTime.getText());
    }


    @FXML private void btnDoStart() {
        Logical.pause = false;
        Logical.start(fldTime);
        btnStart.setDisable(true);
        enableButtons(false);
    }
    @FXML private void btnDoPause() {
        btnStart.setDisable(false);
        btnPause.setDisable(true);
        Logical.pause = true;
    }
    @FXML private void btnDoStop() {
        Logical.pause = true;
        btnStart.setDisable(false);
        enableButtons(true);
        Logical.stop(fldTime);
    }
    @FXML private void btnDoLap() {
        System.out.println(fldTime.getText());

        list.add(fldTime.getText());
        observableList.setAll(list);
        lstRec.refresh();
    }
    @FXML private void btnDoClear() {
        list.removeAll(list);
        observableList.setAll(list);
        lstRec.refresh();
    }
}
