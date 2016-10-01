package pl.ania;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateChecker implements Checker<Date> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public Date check(String userChoice) {
        Pattern pattern = Pattern.compile("19|20[0-9]{2}\\.(0[1-9]|1[0-2])\\.(0[1-9]|[1-2][0-9]|3[0-1])");
        if (pattern.matcher(userChoice).matches()) {

            try {
                return sdf.parse(userChoice);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }

        }
        System.out.println("Błąd formatu daty!");
        return null;
    }
}
