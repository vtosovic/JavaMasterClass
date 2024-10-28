package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        String name = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));
        //TIM

        Function<String,String> lastName = s -> s.concat(" Buchalka");
        // using andThen to chain
        Function<String,String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));
        //TIM Buchalka

        // using compose for the other way around - first uppercase, then concatenate
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));
        //TIM BUCHALKA

        // make it uppercase
        Function<String, String[]> f0 = uCase
                //append Buchalka
                .andThen(s -> s.concat(" Buchalka"))
                //split by " " into array of strings
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));
        //[TIM, Buchalka]

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " +s[0]);
        System.out.println(f1.apply(name));
        //BUCHALKA, TIM

        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));
        //13

        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));
        //A - Ann
        //B - Bob
        //C - Carol

        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);
        System.out.println("combined1 = " + combined1.test(name));
        //combined1 = true
        Predicate<String> combined2 = p3.and(p4);
        System.out.println("combined2 = " + combined2.test(name));
        //combined2 = false
        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("combined3 = " + combined3.test(name));
        //combined3 = true

        record Person(String fistName, String lastName){}

        List<Person> list = new ArrayList<>(Arrays.asList(
           new Person("Peter", "Pan"),
           new Person("Peter", "PumpkinEater"),
           new Person("Minnie", "Mouse"),
           new Person("Mickey", "Mouse")
        ));

        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);
        //Person[fistName=Minnie, lastName=Mouse]
        //Person[fistName=Mickey, lastName=Mouse]
        //Person[fistName=Peter, lastName=Pan]
        //Person[fistName=Peter, lastName=PumpkinEater]

        // Comparing method
        System.out.println("----------");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);
        //----------
        //Person[fistName=Minnie, lastName=Mouse]
        //Person[fistName=Mickey, lastName=Mouse]
        //Person[fistName=Peter, lastName=Pan]
        //Person[fistName=Peter, lastName=PumpkinEater]

        System.out.println("----------");
        list.sort(Comparator.comparing(Person::lastName)
                        .thenComparing(Person::fistName));
        list.forEach(System.out::println);
        //----------
        //Person[fistName=Mickey, lastName=Mouse]
        //Person[fistName=Minnie, lastName=Mouse]
        //Person[fistName=Peter, lastName=Pan]
        //Person[fistName=Peter, lastName=PumpkinEater]

        System.out.println("----------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::fistName).reversed());
        list.forEach(System.out::println);
        //----------
        //Person[fistName=Peter, lastName=PumpkinEater]
        //Person[fistName=Peter, lastName=Pan]
        //Person[fistName=Minnie, lastName=Mouse]
        //Person[fistName=Mickey, lastName=Mouse]
    }
}
