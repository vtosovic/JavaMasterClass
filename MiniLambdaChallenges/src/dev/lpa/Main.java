package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for(String part:parts){
                    System.out.println(part);
                }
            }
        };
// MULTI LINED VERSION
        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part:parts){
                System.out.println(part);
            }
        };

        printWords.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");

        // USING FOR EACH
        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };
        printWordsForEach.accept("Let's split this up into an array");

        // SINGLE LINE CODE
        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printWordsConcise.accept("Let's split this up into an array");


        // SECOND CHALLENGE
        // Using Unary, or Binary
        UnaryOperator<String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // THIRD CHALLENGE
        //apply(T t);
        System.out.println(everySecondChar.apply("1234567890"));
        //24680

        // FIFTH CHALLENGE

        String result = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(result);

        // SIXTH CHALLENGE
        Supplier<String> iLoveJava = () -> "I Love Java!";
        //or
        Supplier<String> iLoveJava2 = () -> {return "I Love Java!";};

        // SEVENTH CHALLENGE
        System.out.println(iLoveJava.get());
        System.out.println(iLoveJava2.get());
        //I Love Java!
        //I Love Java!


    }

    public static String everySecondChar(String source){

        StringBuilder returnVal = new StringBuilder();
        for (int i =0; i < source.length(); i++) {
            if(i % 2 ==1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
    // FOURTH CHALLENGE
    public static String everySecondCharacter(Function<String, String> func,
                                              String source) {
        return func.apply(source);
    }
}
