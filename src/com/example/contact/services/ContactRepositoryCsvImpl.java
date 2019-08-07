package com.example.contact.services;

import com.example.contact.constants.AppConstants;
import com.example.contact.model.Contact;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryCsvImpl implements ContactRepositoryI {

    private static ContactRepositoryCsvImpl instance;

    private ContactRepositoryCsvImpl() {}

    public static synchronized ContactRepositoryCsvImpl getInstance() {
        if (instance ==null) {
            instance = new ContactRepositoryCsvImpl();
        }
        return instance;
    }



    @Override
    public void save(Contact contact) {
        try (BufferedWriter buffWrite =
                     new BufferedWriter(new FileWriter(AppConstants.CSV_FILE_PATH, true))
        ) {

            String csvValue = contact.getName() + "," + contact.getAge();
            buffWrite.write(csvValue + "\n");

        } catch (IOException ioe) {
            System.err.println("Error: " + ioe);
        }
    }

    @Override
    public void saveAll(List<Contact> contactList) {
        this.saveAll(contactList, true);
    }

    public void saveAll(List<Contact> contactList, boolean append) {
        if (!append) {
            new File(AppConstants.CSV_FILE_PATH).delete();
        }

        for (Contact contact : contactList) {
            save(contact);
        }

        System.out.println("Saved " + contactList.size() + " contacts.");

    }

    @Override
    public List<Contact> getAllContacts() {

        List<Contact> contactList = new ArrayList<>();

        try (BufferedReader buffRead =
                     new BufferedReader(new FileReader(AppConstants.CSV_FILE_PATH))
        ) {

            String line = "";
            String[] tokens;
            while ( (line = buffRead.readLine()) != null) {
                tokens = line.split(",");
                contactList.add(
                        new Contact(tokens[0], Integer.parseInt(tokens[1]))
                );

            }

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist: " + AppConstants.CSV_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contactList;
    }

    @Override
    public void delete(Integer contactIndex) {

        List<Contact> contactList = getAllContacts();

        contactList.remove(contactIndex.intValue());

        saveAll(contactList, false);

        System.out.println("Deleted contact: " + contactIndex);

    }
}
