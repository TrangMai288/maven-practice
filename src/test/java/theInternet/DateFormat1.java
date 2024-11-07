package theInternet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat1 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String dateString = "01/11/2024";

        try {
            Date dateParsed = dateFormat.parse(dateString);
            System.out.println(dateParsed);

            String formattedDate = dateFormat.format(dateParsed);
            System.out.println(formattedDate);
        } catch (ParseException p) {
            p.printStackTrace();
        }
    }
}
