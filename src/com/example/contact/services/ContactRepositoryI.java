package com.example.contact.services;

import com.example.contact.model.Contact;

import java.util.List;

public interface ContactRepositoryI {

    public void save(Contact contact);
    public List<Contact> getAllContacts();
    public void delete(Integer contactIndex);
    public void saveAll(List<Contact> contactList);

}
