package javafx.lesson03.model;

import javafx.lesson03.domain.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsModel {

    private static final String FILE_NAME =
            "/home/egboldyr/IdeaProjects/Pro005/src/main/resources/datasource/source.dat";

    public static void save(List<Contact> contacts) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Contact contact : contacts) {
                fw.append(contact.toString()).append("\r\n");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contact> open() {
        List<Contact> contacts = new ArrayList<>();
        try (FileReader fr = new FileReader(FILE_NAME)) {
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                Contact contact = new Contact(
                        data[0], data[1], data[2], data[3]);
                contacts.add(contact);
            }
            return contacts;
        } catch (IOException e) {
            System.err.println("DataSource not found!");
            return null;
        }
    }
}
