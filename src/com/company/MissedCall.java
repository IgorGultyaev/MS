package com.company;

import java.util.Map;
import java.util.TreeMap;

public class MissedCall {

    private Map<DateTimeRecord, String> missedCalls;

    public MissedCall() {
        missedCalls = new TreeMap();
    }

    public void addMissedCallRND(String phoneNumber, PhoneBook phoneBook) {

        missedCalls.put(new DateTimeRecord(), phoneNumber);
    }

    public void printMissedCalls(PhoneBook phoneBook) {
        this.missedCalls.forEach((key, value)
                -> System.out.println(key + " : " +
                (phoneBook.containsPhone(value) ? phoneBook.getFIOByNumber(value) : value)));

    }
//TODO избавиться от всех методов, передающих мапу, даже геттеры, должны выдавать только конкретные поля, что бы не допустить добавления
    public String toString() {
        return missedCalls.toString();
    }

}
