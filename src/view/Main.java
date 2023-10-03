package view;

import java.util.ArrayList;

import controller.Manager;
import model.Contact;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        contactList.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        contactList.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.createContact(contactList);
                    break;
                case 2:
                    Manager.printAllContact(contactList);
                    break;
                case 3:
                    Manager.deleteContactd(contactList);
                    break;
                case 4:
                    return;
            }
        }
    }
}
