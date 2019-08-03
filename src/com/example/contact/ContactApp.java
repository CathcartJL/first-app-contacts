package com.example.contact;

import com.example.contact.controller.ContactController;
import com.example.contact.view.ContactView;

public class ContactApp {

    public static void main(String[] args) {

        ContactController contactController = new ContactController();
        ContactView contactView = new ContactView(contactController);

//        contactView.displayContact();

        contactView.compareContacts();

    }


}
