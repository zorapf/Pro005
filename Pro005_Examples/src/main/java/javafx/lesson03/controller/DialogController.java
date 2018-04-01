package javafx.lesson03.controller;

import javafx.fxml.FXML;
import javafx.lesson03.domain.Contact;
import javafx.lesson03.model.ContactsModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;

public class DialogController {

    @FXML private GridPane dlg;

    @FXML private TextField fldName;
    @FXML private TextField fldSurname;
    @FXML private TextField fldPhone;
    @FXML private TextField fldEmail;

    @FXML
    private void saveOnClick() {
        List<Contact> contacts = ContactsModel.open();
        Contact contact = new Contact(
                fldName.getText(),
                fldSurname.getText(),
                fldPhone.getText(),
                fldEmail.getText()
        );
        contacts.add(contact);
        ContactsModel.save(contacts);
        cancelOnClick();
    }

    @FXML
    private void cancelOnClick() {
        Stage dialog = (Stage) dlg.getScene().getWindow();
        dialog.getOnCloseRequest()
                .handle(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSE_REQUEST));
        dialog.close();
    }
}
