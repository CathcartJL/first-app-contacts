package com.example.contact.controller;

import com.example.contact.model.Contact;

public class ContactController {

    public Contact getContact() {
        return new Contact("John", 23);
    }

}
