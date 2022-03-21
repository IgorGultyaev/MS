package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList<Contact>> phoneBook;
    private Map<String,Contact> contactByNumber;

    public PhoneBook(String nameGroup, ArrayList<Contact> contacts) {
        phoneBook = new HashMap<>();
        phoneBook.put(nameGroup, contacts);
        contactByNumber = new HashMap<>();
        if (contacts!=null){
            for (Contact contact:contacts
            ) {
                contactByNumber.put(contact.getPhoneNumber(),contact);
            }
        }
    }

    public void printContactsGroups() {
        this.phoneBook.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public void printContactsInGroups(String nameGroups) {
        this.phoneBook.get(nameGroups).toString();

    }

    public Map<String, ArrayList<Contact>> getPhoneBook() {
        return phoneBook;
    }

    public void addContactInGroup(String nameGroup, Contact contact) {
        if (!contactByNumber.containsKey(contact.getPhoneNumber())) {
            contactByNumber.put(contact.getPhoneNumber(), contact);
            if (phoneBook.containsKey(nameGroup)) {
                phoneBook.get(nameGroup).add(contact);
            } else {
                ArrayList<Contact> contacts = new ArrayList<>();
                contacts.add(contact);
                phoneBook.put(nameGroup, contacts);
            }
        }
    }

    @Override
    public String toString() {

        return phoneBook.toString();
    }

//    public Map<String, Contact> getContactByNumber() {
//        return contactByNumber;
//    }
    public String getFIOByNumber(String numberPhone){
        return contactByNumber.get(numberPhone).getFIO();
    }
    public Boolean containsPhone(String phone){
        return this.contactByNumber.containsKey(phone);
    }

}
