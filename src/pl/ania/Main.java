package pl.ania;


import java.util.Scanner;

public class Main {

    static Scanner reading = new Scanner(System.in);
    static CatDAO catDAO = new CatDAO();


    public static void main(String[] args) {

        String userChoice;

        System.out.println("MENU");

        do {

            System.out.println(" 1) Dodaj kota - wybierz 1 \n 2) Pokaż kota - wybierz 2 \n 3)Zamknij program - wybierz x");
            userChoice = reading.nextLine();
            if (userChoice.equals("1")) {
                addCat();
            } else if (userChoice.equals("2")) {
                showCat();

            } else if (userChoice.equalsIgnoreCase("x")) {
                System.out.println("Do widzenia!");
            } else {
                System.out.println("Nie ma takiej opcji. Proszę dokonać wyboru ponownie");
            }
        }
        while (!userChoice.equalsIgnoreCase("x"));

    }

    public static void addCat() {
        Cat cat = new Cat();
        cat.setName(readName("Podaj imie kota"));
        cat.setCatSitterName(readName("Podaj imię opiekuna kota"));
        System.out.println("Dziękuję. Znam już imię kota oraz jego opiekuna");

        cat.setBirthDate(readChoice("Podaj date urodzenia kota w formacie RRRR.MM.DD", new DateChecker()));

        cat.setWeight(readChoice("Podaj wagę kota", new FloatChecker()));

        catDAO.addCatToList(cat);

    }

    static private String readName(String message) {
        System.out.println(message);
        String userChoice = reading.nextLine();
        return userChoice;
    }

    static private <T> T readChoice(String message, Checker<T> checker) {
        boolean isCorrect;
        T checkerResult;
        do {
            isCorrect = true;
            System.out.println(message);
            String userChoice = reading.nextLine();

            checkerResult = checker.check(userChoice);
            if (checkerResult == null) {
                isCorrect = false;

            }

        } while (!isCorrect);
        return checkerResult;
    }

    static public void showCat() {

        if (!catDAO.cats.isEmpty()) {
            for (int i = 0; i < catDAO.cats.size(); i++) {
                System.out.println(catDAO.cats.get(i).getName() + " - wybierz " + (i + 1));
            }
            String userChoice = reading.nextLine();
            try {
                System.out.println(catDAO.cats.get(Integer.parseInt(userChoice) - 1).introduceYourself());
            }
            catch (IndexOutOfBoundsException ioobe){
                System.out.println("Nie ma takiego kota!");
            }
        }

        else  {
            System.out.println("Nie ma kotów na liście!");
        }
    }
}
