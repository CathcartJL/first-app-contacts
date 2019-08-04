package com.example.contact.services;

import com.example.contact.model.Contact;

import java.util.List;

public interface ContactRepositoryI {

    public void save(Contact contact);
    public List<Contact> getAllContacts();

}
