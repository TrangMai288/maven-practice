package theInternet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat2 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        String dateString = "08/28/1999";

        try {
            Date dateParsed = dateFormat.parse(dateString);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateParsed);

            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            System.out.println("Day: " + dayOfMonth);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
