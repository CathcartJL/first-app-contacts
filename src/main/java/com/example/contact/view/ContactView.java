package com.example.contact.view;

import com.example.contact.controller.ContactController;
import com.example.contact.model.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactView {

    private Scanner scan = new Scanner(System.in);
    private ContactController contactController;

    public ContactView(ContactController contactController) {
        this.contactController = contactController;
    }

    public void displayContact() {
        System.out.println(contactController.getContact());
    }

    public void compareContacts() {

        String name =null;
        Integer age;

        System.out.println("Enter contact name: ");
        name = scan.nextLine();

        System.out.println("Enter contact age");
        age = scan.nextInt();
        scan.nextLine();
        Contact contact1 = new Contact(name, age);

        System.out.println("Enter contact name: ");
        name = scan.nextLine();

        System.out.println("Enter contact age");
        age = scan.nextInt();
        Contact contact2 = new Contact(name, age);

        if (contactController.equateContacts(contact1, contact2)) {
            System.out.println("Contacts are the same");
        } else {
            System.out.println("Contacts are NOT the same");
        }
    }

    public void createContact() {
        System.out.println("Enter contact name: ");
        String name = scan.nextLine();

        System.out.println("Enter contact age: ");
        Integer age = scan.nextInt();
        scan.nextLine();

        contactController.saveContact(new Contact(name, age));
    }

    public void showAllContacts() {
        List<Contact> contactList = contactController.getAllContacts();
         displayContactsTable(contactList);
    }

    private void displayContactsTable(List<Contact> contactList) {
        String dataPattern = "| %6d | %-30s | %4d |";
        String titlePattern = "| %-6s | %-30s | %-4s |";

        System.out.println("+------------------------------------------------+");
        System.out.println("| Contacts                                       |");
        System.out.println("+------------------------------------------------+");
        System.out.println(String.format(titlePattern, "Index", "Name", "Age"));


        for (int i = 0; i <contactList.size(); i++) {
            System.out.println(
                String.format(dataPattern,
                        i,
                        contactList.get(i).getName(),
                        contactList.get(i).getAge())
        );
        }
        System.out.println("+------------------------------------------------+");
    }

    public void deleteContact() {

        List<Contact> contactList = contactController.getAllContacts();
        displayContactsTable(contactList);

        System.out.println();
        System.out.println("Enter the index of the contact you wish to delete:");
        System.out.print("> ");


        Integer contactIndex = scan.nextInt();
        scan.nextLine();

        contactController.deleteContact(contactIndex);
    }

    public void deleteAllContactsById() {
        System.out.println("Enter contact name: ");
        String name = scan.nextLine();

        System.out.println("Enter contact age: ");
        Integer age = scan.nextInt();
        scan.nextLine();
        //contactController.deleteContact(new Contact(name, age));
    }

    public void options() {
        //Sentry variable
        String response = "";
        while (!response.equals("q")) {

            System.out.println("\n\nEnter a command or q to quit");
            System.out.println("--------------------------------");
            System.out.println("Options");
            System.out.println("dis - Displays contact");
            System.out.println("all - Show all contacts");
            System.out.println("cmp - Compares contacts");
            System.out.println("new - Creates new contact");
            System.out.println("del - Delete contact");
            System.out.print("> ");

            response = scan.nextLine().trim();

            switch (response) {
                case "dis":
                    displayContact();
                    break;
                case "cmp":
                    compareContacts();
                    break;
                case "new":
                    createContact();
                    break;
                case "all":
                    showAllContacts();
                    break;
                case "del":
                    deleteContact();
                    break;
                default:
                    System.out.println("Invalid input!");
            }


        }
    }

}
