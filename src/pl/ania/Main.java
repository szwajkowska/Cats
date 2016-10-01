package pl.ania;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    static Scanner reading = new Scanner(System.in);


    public static void main(String[] args) {

        String userChoice;

        System.out.println("MENU");

        do {

            System.out.println(" 1) Dodaj kota - wybierz 1 \n 2) Pokaż kota - wybierz 2 \n 3)Zamknij program - wybierz x");
            userChoice = reading.nextLine();
            if (userChoice.equals("1")) {
                addCat();
            } else if (userChoice.equals("2")) {
                System.out.println("showCat()");

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
    }


    static private String readName(String message){
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
}
