package dev.lpa;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello World again");

        String[] splitString = "Hello World again".split(" ");
        printTexts(splitString);

        System.out.println("_".repeat(20));
        printTexts("Hello");
        System.out.println("_".repeat(20));
        printTexts("Hello", "World", "again");
        System.out.println("_".repeat(20));
        printTexts();
        String [] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(",", sArray));


        }

    private static void printTexts(String... textList){
        for (String t : textList){
            System.out.println(t);
        }
    }
}
