package com.cbs.edu.java8;

import java.time.*;

public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate birthday = LocalDate.of(1992, Month.DECEMBER, 26);
        System.out.println(birthday);

        LocalDate localDate = LocalDate.ofYearDay(2017, 74);
        System.out.println(localDate);

        LocalTime time = LocalTime.of(12, 0);
        System.out.println(time);

        LocalTime curTime = LocalTime.now();
        System.out.println(curTime);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        LocalDate localDate1 = now.plusDays(1);

        Period period = Period.between(birthday, now);
        System.out.println(period.toTotalMonths());

        Duration duration = Duration.between(birthday.atStartOfDay(), now.atStartOfDay());
        System.out.println(duration.toDays());

        LocalDate parsedDate = LocalDate.parse("1992-12-26");
        System.out.println(parsedDate);
    }
}
