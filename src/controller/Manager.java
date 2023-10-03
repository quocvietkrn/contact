package controller;

import java.util.ArrayList;

import model.Contact;
import view.Validation;

public class Manager {
   

    //display menu
    public static int menu() {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.println("1. Add a contact.");
        System.out.println("2. Display all contact.");
        System.out.println("3. Delete a contact.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    // tao moi contact
    public static void createContact(ArrayList<Contact> lc) {
        System.out.print("Enter id contact: ");
        int contactId = Validation.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = Validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = Validation.checkInputString();
        System.out.print("Enter group: ");
        String group = Validation.checkInputString();
        System.out.print("Enter address: ");
        String address = Validation.checkInputString();
        System.out.print("Please input Phone flow: "
        + "1234567890"
        + "123-456-7890 "
        + "123-456-7890 x1234 "
        + "123-456-7890 ext1234"
        + "(123)-456-7890"
        + "123.456.7890"
        + "123 456 7890"
        + "Enter Phone: "
        );
        String phone = Validation.checkInputPhone();
        lc.add(new Contact(contactId, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.err.println("Add successful.");
    }

    // show all contact
    public static void printAllContact(ArrayList<Contact> lc) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //in thông tin theo thứ tự
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    // delete contact
    public static void deleteContactd(ArrayList<Contact> lc) {
        System.out.print("Enter id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            System.err.println("Not found contact.");
            return;
        } else {
            lc.remove(contactDelete);
        }
        System.err.println("Delete successful.");
    }

    //get contact by id
    public static Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }
}
