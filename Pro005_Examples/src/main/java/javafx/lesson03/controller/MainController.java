package javafx.lesson03.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.lesson03.domain.Contact;
import javafx.lesson03.model.ContactsModel;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.IOException;

public class MainController {

    @FXML private VBox main;

    @FXML private ListView<Contact> lstContacts;
    private ObservableList<Contact> contacts;

    @FXML
    private void initialize() {
        contacts = FXCollections
                .observableArrayList(ContactsModel.open());
        lstContacts.setItems(contacts);
    }

    @FXML
    private void addDialogOnClick() throws IOException {
        Stage dlgNewContact = new Stage();

        GridPane dlgView =
                FXMLLoader.load(
                        getClass().getResource("/javafx/lesson03/view/modal/dialog.fxml")
                );
        dlgNewContact.setTitle("New Contact - Dialog");
        dlgNewContact.setResizable(false);

        dlgNewContact.initModality(Modality.WINDOW_MODAL);     //Тип диалогового окна Модальный
        dlgNewContact.initOwner(main.getScene().getWindow());  //Главное окно

        dlgNewContact.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                contacts.setAll(ContactsModel.open());
                lstContacts.refresh();
            }
        });
        dlgNewContact.setScene(new Scene(dlgView));
        dlgNewContact.showAndWait();
    }
}
