package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Main {

    private static Random random = new Random();

    private record Person(String first){

        public String last(String s){
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }
    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Cameron", "Donald", "Eva", "Francis"};

        Person tim = new Person("Tim");
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('D', 'M') + ".",
                // reverse just a name
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                // reverse all
                Main::reverse,
                String::new,
                s -> new String(s),
                String::valueOf,
                tim::last,
                (new Person("MARY"))::last
        ));

        applyChanges(names, list);
        //[ANNA, BOB, CAMERON, DONALD, EVA, FRANCIS]
        //[ANNA F., BOB I., CAMERON L., DONALD K., EVA M., FRANCIS E.]
        //[ANNA F. ANNA, BOB I. BOB, CAMERON L. NOREMAC, DONALD K. DLANOD, EVA M. AVE, FRANCIS E. SICNARF]
        //[ANNA .F ANNA, BOB .I BOB, CAMERON .L NOREMAC, DONALD .K DLANOD, EVA .M AVE, FRANCIS .E SICNARF]
        //[ANNA .F ANNA, BOB .I BOB, CAMERON .L NOREMAC, DONALD .K DLANOD, EVA .M AVE, FRANCIS .E SICNARF]
        //[ANNA .F ANNA, BOB .I BOB, CAMERON .L NOREMAC, DONALD .K DLANOD, EVA .M AVE, FRANCIS .E SICNARF]
        //[ANNA .F ANNA, BOB .I BOB, CAMERON .L NOREMAC, DONALD .K DLANOD, EVA .M AVE, FRANCIS .E SICNARF]
        //[Tim ANNA, Tim BOB, Tim CAMERON, Tim DONALD, Tim EVA, Tim FRANCIS]
        //[MARY Tim, MARY Tim, MARY Tim, MARY Tim, MARY Tim, MARY Tim]

    }

    private static void applyChanges(String[] names,
                                     List<UnaryOperator<String>> stringFunctions) {
        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunctions){
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int) endChar +1);
    }

    private static String reverse(String s){
        return reverse(s, 0, s.length());
    }

    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}
