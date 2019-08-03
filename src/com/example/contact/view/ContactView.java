package com.example.contact.view;

import com.example.contact.controller.ContactController;
import com.example.contact.model.Contact;

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

    public void options() {
        //Sentry variable
        String response = "";
        while (!response.equals("q")) {

            System.out.println("\n\nEnter a command or q to quit");
            System.out.println("--------------------------------");
            System.out.println("Options");
            System.out.println("display - Displays contact");
            System.out.println("compare - Compares contacts");
            System.out.print("> ");

            response = scan.nextLine();

            switch (response) {
                case "display":
                    displayContact();
                    break;
                case "compare":
                    compareContacts();
                    break;
            }


        }
    }

}
