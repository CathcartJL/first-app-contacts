package com.example.contact.view;

import com.example.contact.controller.ContactController;
import com.example.contact.model.Contact;

public class ContactView {

    private ContactController contactController;

    public ContactView(ContactController contactController) {
        this.contactController = contactController;
    }

    public void displayContact() {
        System.out.println(contactController.getContact());
    }

    public void compareContacts() {
        Contact contact1 = new Contact("Mary", 43);
        Contact contact2 = new Contact("Mary", 43);

        if (contact1.equals(contact2)) {
            System.out.println("Contacts are the same");
        } else {
            System.out.println("Contacts are NOT the same");
        }
    }

}
