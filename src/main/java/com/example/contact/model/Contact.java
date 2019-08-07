package com.example.contact.model;

import java.util.Objects;

public class Contact {

    private String name;
    private Integer age;

    public Contact() { }

    public Contact(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {

        if (! (obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        return Objects.equals(this.name, contact.name)
                && Objects.equals(this.age, contact.age);
    }
}
