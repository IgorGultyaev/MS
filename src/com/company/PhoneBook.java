package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList<Contact>> phoneBook;
    private Map<String, Contact> contactByNumber;

    public PhoneBook(String nameGroup, ArrayList<Contact> contacts) {
        phoneBook = new HashMap<>();
        phoneBook.put(nameGroup, contacts);
        contactByNumber = new HashMap<>();
        if (contacts != null) {
            for (Contact contact : contacts
            ) {
                contactByNumber.put(contact.getPhoneNumber(), contact);
            }
        }
    }

    public void printContactsGroups() {
        if (!phoneBook.containsKey(null)) {
            this.phoneBook.forEach((key, value) -> System.out.println(key + " : " + value));
        } else System.out.println("В телефонной книге нет контактов");
        System.out.println();
    }

    public void printContactsInGroups(String nameGroups) {
        if (!phoneBook.containsKey(null)) {
            System.out.println(this.phoneBook.get(nameGroups).toString());
        } else System.out.println("В телефонной книге нет контактов");
        System.out.println();

    }

    public void removeNull() {
        if (phoneBook.containsKey(null)) {
            phoneBook.remove(null);
        }
    }

    public int getNumRecords() {
        return contactByNumber.size();
    }
//todo не добавляет в группу если если группы нет а телефон такой есть исправить так как не добвляет контакт в ругую группу
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
        } else  if (contact.getFIO().equals(contactByNumber.get(contact.getPhoneNumber()).getFIO())){
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

    public String getFIOByNumber(String numberPhone) {
        return contactByNumber.get(numberPhone).getFIO();
    }

    public Boolean containsPhone(String phone) {
        return this.contactByNumber.containsKey(phone);
    }


    public Boolean containsGroup(String group) {
        return this.phoneBook.containsKey(group);
    }
}
