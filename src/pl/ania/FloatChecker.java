package pl.ania;

import java.util.regex.Pattern;

public class FloatChecker implements Checker<Float> {
    @Override
    public Float check(String userChoice) {
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        if (pattern.matcher(userChoice).matches()) {
            try {
                return Float.valueOf(userChoice);
            } catch (NumberFormatException nfe) {

            }

        }
        System.out.println("Niepoprawna waga!");
        return null;
    }
}