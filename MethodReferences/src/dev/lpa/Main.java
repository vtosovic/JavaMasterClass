package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
    private static int last_id =1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chuck", "Dave"));

        // IntelliJ suggest using method reference here
        // list.forEach(s -> System.out.println(s));
        // changes to:
        list.forEach(System.out::println);
        // before replacing
        //calculator((a,b) -> a+b, 10, 25);
        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 2.5,7.5);

        // a constructor method reference. This is original:
        // Supplier<PlainOld> reference1 = () -> new PlainOld();
        // this is new:
        Supplier<PlainOld> reference1 = PlainOld::new;
        // the code is not invoked here.

        // this invokes the code
        PlainOld newPojo = reference1.get();
        //Creating a PlainOld Object: id = 1

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);
        //Creating a PlainOld Object: id = 2
        //Creating a PlainOld Object: id = 3
        //Creating a PlainOld Object: id = 4
        //Creating a PlainOld Object: id = 5
        //Creating a PlainOld Object: id = 6
        //Creating a PlainOld Object: id = 7
        //Creating a PlainOld Object: id = 8
        //Creating a PlainOld Object: id = 9
        //Creating a PlainOld Object: id = 10
        //Creating a PlainOld Object: id = 11

        // this is + for strings
        calculator((s1, s2) -> s1 + s2, "Hello ", "World");
//        Result of operation: Hello World


        // concat
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");
        // change to method reference
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String > b2 = String::concat;
        // invalid
        // UnaryOperator<String> u1 = String::concat;
        // because:
        // UnaryOperator<String> u1 = (s1, s2) -> s1.concat(s2);
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello"));
        //Hello World
        //Hello World
        //HELLO

        String result = "Hello".transform(u1);
        System.out.println("Result = " + result);
        //Result = HELLO

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);
        //Result = hello

        Function<String, Boolean> f0 =  String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);
        //Result = false

    }

    private static <T> void calculator(BinaryOperator<T> function,
                                       T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
