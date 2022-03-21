package com.company;

import java.util.Map;
import java.util.TreeMap;

public class MissedCall {

    private Map<DateTimeRecord, String> missedCalls;

    public MissedCall() {
        missedCalls = new TreeMap();
    }

    public void addMissedCallRND(String phoneNumber, PhoneBook phoneBook) {
//        if (phoneBook.getContactByNumber().containsKey(phoneNumber)) {
//            phoneNumber = phoneBook.getContactByNumber().get(phoneNumber).getFIO();
//        }
        missedCalls.put(new DateTimeRecord(), phoneNumber);
    }

    public void printMissedCalls(PhoneBook phoneBook) {
//        System.out.println(phoneBook.containsPhone("+7(921)-000-00-00"));
//        System.out.println(phoneBook.getContactByNumber().containsKey("+7(921)-000-00-00"));
//        System.out.println(phoneBook.getContactByNumber());
        this.missedCalls.forEach((key, value)
                -> System.out.println(key + " : " +
                (phoneBook.containsPhone(value) ? phoneBook.getFIOByNumber(value) : value)));
//        phoneBook.containsPhone(value)
    }
//TODO избавиться от всех методов, передающих мапу, даже геттеры, должны выдавать только конкретные поля, что бы не допустить добавления
    public String toString() {
        return missedCalls.toString();
    }

}
