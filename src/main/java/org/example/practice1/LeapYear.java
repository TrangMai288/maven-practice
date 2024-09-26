package org.example.practice1;

public class LeapYear {
    /**
     * Viet mot function leap year
     * input year - int
     * return true if leap year
     * return false if leap year
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }
}
