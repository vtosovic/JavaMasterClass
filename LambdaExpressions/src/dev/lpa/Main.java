package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        for (String s:list){
            System.out.println(s);
        }

        // forEach is an easy method for looping
        System.out.println("------");
        list.forEach((var myString) -> System.out.println(myString));

        System.out.println("------");
        // using local variables only if they are NOT changed (final, effectively)
        String prefix = "nato ";
        //vars cannot have the same name as lambda's vars:
        // String myString = "enclosing Method's myString";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + myString + " means " + first);
        });
        // this is out of scope for Lambda:
        //System.out.println(myString);

        //lambda overrides Operation interface
        int result =  calculator((a,b) -> a+b, 5, 2);
        //Result of operation: 7
        var result2 = calculator((a,b) -> a/b, 10.0, 2.5);
        //Result of operation: 4.0
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden");
        //Result of operation: RALPH KRAMDEN


        var coords =Arrays.asList(
          new double[]{47.2160, -95.2348},
          new double[]{29.1566, -89.2495},
          new double[]{35.1556, -90.0659});
        coords.forEach(s -> System.out.println(Arrays.toString(s)));
        //[47.216, -95.2348]
        //[29.1566, -89.2495]
        //[35.1556, -90.0659]

        //declaring variable as lambda
        BiConsumer<Double, Double> p1 = (lat, lng) ->
                System.out.printf("[lat:%.3f long:%.3f]%n", lat, lng);
        // calling it
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
        //[lat:47.216 long:-95.235]

        System.out.println("-------");
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        //[lat:47.216 long:-95.235]
        //[lat:29.157 long:-89.250]
        //[lat:35.156 long:-90.066]


        // instead of p1, using lambda
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) ->
                        System.out.printf("[lat:%.3f long:%.3f]%n", lat, lng)));
        //[lat:47.216 long:-95.235]
        //[lat:29.157 long:-89.250]
        //[lat:35.156 long:-90.066]

        // removes each element that matches
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));
        //alpha
        //charlie
        //delta

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));
        //alpha
        //charlie
        //delta
        //echo
        //easy
        //earnest

        System.out.println("-------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));
        //-------
        //alpha
        //charlie
        //delta
        //echo


        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-------");
        list.forEach(s -> System.out.println(s));
        //a - ALPHA
        //c - CHARLIE
        //d - DELTA
        //e - ECHO

        // array of 10 null
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        //[null, null, null, null, null, null, null, null, null, null]
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
        //[, , , , , , , , , ]

        // set all Function uses array and i as integer
        Arrays.setAll(emptyStrings, (i) -> "" + (i +1)+ ". ");
        System.out.println(Arrays.toString(emptyStrings));
        //[1. , 2. , 3. , 4. , 5. , 6. , 7. , 8. , 9. , 10. ]

        // using switch also
        Arrays.setAll(emptyStrings, (i) -> "" + (i +1)+ ". "
            + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";}
        );
        System.out.println(Arrays.toString(emptyStrings));
        //[1. one, 2. two, 3. three, 4. , 5. , 6. , 7. , 8. , 9. , 10. ]

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
        //[David, Bob, Fred, David, Fred, Ed, Fred, David, David, Bob, Ed, Ann, Carol, Bob, David]
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static<T> void processPoint (T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count,
                                                  String[] values,
                                                  Supplier<Integer>s){

        String[] selectedValues = new String[count];
        for(int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
