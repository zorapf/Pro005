package javafx.lesson03.model;

import javafx.lesson03.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class TestDataSource {

    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Ivan", "Ivanov", "0972546321", "ivanov@gmail.com"));
        contacts.add(new Contact("Vasilij", "Ivanov", "0972321654", "ivanovvv@gmail.com"));

        ContactsModel.save(contacts);

        List<Contact> contactsFromFile =  ContactsModel.open();
        for (Contact contact : contactsFromFile) {
            System.out.println(contact);
        }
    }
}
