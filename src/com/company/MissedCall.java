package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class MissedCall implements Comparable<MissedCall>{
    private LocalDateTime time;

    public MissedCall() {
        time = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(),
                DataGenerator.getRandom(12), DataGenerator.getRandom(12), DataGenerator.getRandom(12));
    }

    public String getContact(Map<String, Contact> contacts, String numberPhone) {
        if (contacts.containsKey(numberPhone)) {
            return contacts.get(numberPhone).getFIO();
        } else {
            return numberPhone;
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm:ss");
        return dtf.format(time);
    }
@Override
    public int compareTo (MissedCall missedCall){
        return time.compareTo(missedCall.getTime());
    }
}
