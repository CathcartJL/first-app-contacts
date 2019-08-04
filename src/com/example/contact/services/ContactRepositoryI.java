package com.example.contact.services;

import com.example.contact.model.Contact;

import java.util.List;

public interface ContactRepositoryI {

    public void save(Contact contact);
    public List<Contact> getAllContacts();
    public void delete(Contact contact);
    public void saveAll(List<Contact> contactList);

}
