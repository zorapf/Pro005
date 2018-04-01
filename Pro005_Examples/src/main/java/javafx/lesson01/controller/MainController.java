package javafx.lesson01.controller;

import javafx.fxml.FXML;
import javafx.lesson01.model.PrintModel;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField fldLogin;

    @FXML
    private TextField fldPassword;

    @FXML
    private TextField fldPasswordConfirm;

    @FXML
    private void registrationOnClick() {
        if (fldPassword.getText()
                .equals(fldPasswordConfirm.getText())) {
            PrintModel.print(fldLogin.getText(),
                    fldPassword.getText(), fldPasswordConfirm.getText());
        }
    }

    @FXML
    private void cancelOnClick() {
        System.exit(0);
    }
}
