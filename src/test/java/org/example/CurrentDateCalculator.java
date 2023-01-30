package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CurrentDateCalculator {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfYear = currentDate.withDayOfYear(1);

        long daysBetween = ChronoUnit.DAYS.between(firstDayOfYear, currentDate);
        long daysMultiplied = daysBetween * 2;

        String result = String.valueOf(daysMultiplied);
        if (result.length() == 2) {
            result = "0" + result;
        } else if (result.length() == 1) {
            result = "00" + result;
        }

        System.out.println("Number of days between first day of year and today multiplied by 2: " + result);
    }
}
