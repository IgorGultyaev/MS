package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter ;

public class DateTimeRecord implements Comparable<DateTimeRecord> {
    private LocalDateTime time;

    public DateTimeRecord() {
        time = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(),
                DataGenerator.getRandom(12), DataGenerator.getRandom(12), DataGenerator.getRandom(12));
    }
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm:ss");
        return dtf.format(time);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int compareTo(DateTimeRecord dateTimeRecord) {
        return time.compareTo(dateTimeRecord.getTime());
    }
}
