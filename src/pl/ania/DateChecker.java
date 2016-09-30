package pl.ania;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChecker implements Checker<Date> {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public Date check(String userChoice) {
        try {
            return sdf.parse(userChoice);
        } catch (ParseException pe) {
            System.out.println("Błąd formatu daty!");
        }
        return null;
    }
}
