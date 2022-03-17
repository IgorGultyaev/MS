package com.company;

import java.util.*;
import java.util.stream.Collector;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static Map<MissedCall, String> createMissedCalls (Map <String, Contact> contacts, Map<MissedCall, String>  missedCalls, int num){
        for (int numMC = 0; numMC < num; numMC++) {
            String phone = DataGenerator.getRNDPhone(DataGenerator.RNDRangePhone);

            if (contacts.containsKey(phone)) {
                phone = contacts.get(phone).getFIO();
            }
            missedCalls.put(new MissedCall(), phone);
        }
        return missedCalls;
    }

    public static void printContacts(Map<String, Contact> contacts) {
        System.out.println("Вывести на печать " + contacts.size() + " Записей? Введите да/нет");
        String choice = scanner.nextLine();
        if (choice.equals("да")) {
            contacts.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }

        public static void printMissedCalls(Map<MissedCall, String> calls) {
        System.out.println("Вывести на печать " + calls.size() + " Записей? Введите да/нет");
        String choice = scanner.nextLine();
        if (choice.equals("да")) {
            calls.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }



    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();

        System.out.println("Введите количество контактов, которые необходимо создать");
        String numberRecords = scanner.nextLine();
        int intNumberRecords = Integer.parseInt(numberRecords);
        contacts = DataGenerator.formationContacts(intNumberRecords, contacts);

        printContacts(contacts);
        System.out.println("Введите колличество пропущенных звонков");
        String numMissedCall = scanner.nextLine();

        Map<MissedCall, String> missedCalls = new TreeMap<>();
        createMissedCalls(contacts, missedCalls,Integer.parseInt(numMissedCall));

        printMissedCalls(missedCalls);

    }
}
