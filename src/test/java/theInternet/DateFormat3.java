package theInternet;

import java.time.LocalDate;

public class DateFormat3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        int dayOfMonth = today.getDayOfMonth();
        int next7Days = today.plusDays(7).getDayOfMonth();

        System.out.println("Day: " + dayOfMonth);
        System.out.println("Next 7 Days : " + next7Days);
    }
}
