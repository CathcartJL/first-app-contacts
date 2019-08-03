package com.example.contact.controller;

import com.example.contact.model.Contact;

public class ContactController {

    public Contact getContact() {
        return new Contact("John", 23);
    }

    public boolean equateContacts(Contact contact1, Contact contact2) {
        if (contact1.equals(contact2)) {
            return true;
        } else {
            return false;
        }

    }

}
