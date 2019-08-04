package com.example.contact.controller;

import com.example.contact.model.Contact;
import com.example.contact.services.ContactRepositoryI;
import com.example.contact.services.ContactRepositoryCsvImpl;

import java.util.List;

public class ContactController {

    private ContactRepositoryI contactRepository;

    public ContactController() {

        this.contactRepository = ContactRepositoryCsvImpl.getInstance();
    }

    public Contact getContact() {
        return new Contact("John", 23);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    public boolean equateContacts(Contact contact1, Contact contact2) {
        if (contact1.equals(contact2)) {
            return true;
        } else {
            return false;
        }

    }


    public void saveContact(Contact contact) {
        contactRepository.save(contact);

    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

}
