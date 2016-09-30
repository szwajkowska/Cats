package pl.ania;

public class FloatChecker implements Checker<Float> {
    @Override
    public Float check(String userChoice) {
        try {
            return Float.valueOf(userChoice);
        } catch (NumberFormatException nfe) {
            System.out.println("Niepoprawna waga!");
        }
        return null;
    }
}
