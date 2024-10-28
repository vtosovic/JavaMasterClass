package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15); // preferred but unnecessary
        Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9
        int unboxedInt = boxedInt.intValue(); // unnecessary

        // Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        // output: java.lang.Integer
        //System.out.println(autoUnboxed.getClass().getName());

        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        //[50, null, null, null, null]

        System.out.println(wrapperArray[0].getClass().getName());
        //java.lang.Integer <-- Java wrapped 50 to Integer before assigning it
        // to the Array

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));
        //[a, b, c, d] <-- Autoboxing

        var ourList = getList(1, 2, 3, 4, 5);
        System.out.println(ourList);
        //[1, 2, 3, 4, 5]

    }

    private static ArrayList<Integer> getList(Integer... varargs){
        // instead of Integer varargs, int can be used
        ArrayList<Integer> aList = new ArrayList<>();
            for (int i : varargs){
                aList.add(i); // autoboxing
            }
            return aList;
    }

    private static int returnAnInt(Integer i){
        return i; // unboxes the i
    }

    private static Integer returnAnInteger(int i){
        return i; // boxes the i
    }

    private static Double getDoubleObject(){
        return Double.valueOf(100.00);
    }

    private static Double getLiteralDoublePrimitive(){
        return 100.00;
    }
}
