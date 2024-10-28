package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("---> Transform to Uppercase");
        System.out.println(Arrays.toString(names));
        //[ANNA, BOB, CAROLE, DAVID, ED, FRED, GARY]

        // creating a list from array
        List<String> backedByArray = Arrays.asList(names);

        // chooses a random letter between A and D
        backedByArray.replaceAll(s -> s += " " +  getRandomChar('A', 'D') + ".");
        System.out.println("---> Add random middle initial");
        System.out.println(Arrays.toString(names));
        //[ANNA C., BOB B., CAROLE B., DAVID A., ED C., FRED B., GARY C.]

        // adding last name which is reverse first name
        // passing only first name without initial, so splitting and choosing 0 position
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("---> Add reversed name as last name");
        System.out.println(Arrays.toString(names));
        //[ANNA A. ANNA, BOB C. BOB, CAROLE B. ELORAC, DAVID A. DIVAD, ED A. DE, FRED D. DERF, GARY A. YRAG]
        // or as a list, like a for each:
        Arrays.asList(names).forEach(s -> System.out.println(s));
        //ANNA B. ANNA
        //BOB D. BOB
        //CAROLE C. ELORAC
        //DAVID C. DIVAD
        //ED D. DE
        //FRED A. DERF
        //GARY A. YRAG

        // making a copy of the list
        List<String> newList = new ArrayList<>(List.of(names));
        // comparing first part of the name until the first space
        // with the last part of the name from the last space till the end of string
        // if true, name and surname are the same, it is removed
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") +1)
        ));
        System.out.println("---> Removes names where first = last");
        newList.forEach(s -> System.out.println(s));
        //CAROLE D. ELORAC
        //DAVID A. DIVAD
        //ED D. DE
        //FRED B. DERF
        //GARY B. YRAG

        // the same, but with multiline lambda
        newList.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") +1);
            return first.equals(last);
        });
        System.out.println("---> Removes names where first = last");
        newList.forEach(s -> System.out.println(s));

    }

    public static char getRandomChar(char startChar, char endChar){
        // returns a random number between index of first and last char
        return (char) random.nextInt((int) startChar, (int) endChar +1);
    }

    // reverse characters in the string
    private static String getReversedName(String firstName){
        return new StringBuilder(firstName).reverse().toString();
    }
}
