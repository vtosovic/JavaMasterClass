package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        // factory method, static method on a class, returns a new instance of a class
        // called "of"
        List<String> list = List.of(items);
        System.out.println(list);
        // output:
        // [apples, bananas, milk, eggs]

//        // returns java.util.ImmutableCollections$ListN, and is immutable
//        System.out.println(list.getClass().getName());
//        // this returns exception
//        list.add("yogurt");

        // this works, we make new mutable array list
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);
        // output:
        // [apples, bananas, milk, eggs, yogurt]


        //simplified
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);
        // output:
        // [pickles, mustard, cheese]


        // adding all from first to the second lists
        groceries.addAll(nextList);
        System.out.println(groceries);
        // output:
        // [apples, bananas, milk, eggs, yogurt, pickles, mustard, cheese]

        System.out.println("Third items = " + groceries.get(2));
        // output:
        // Third items = milk

        if (groceries.contains("mustard")){
            System.out.println("List contains mustard");
        }
        // output:
        // List contains mustard

        groceries.add("yogurt");
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));
        // output:
        // first = 4
        // last = 8

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);
        // output:
        //[apples, bananas, milk, eggs, yogurt, pickles, mustard, cheese, yogurt]
        //[apples, milk, eggs, yogurt, pickles, mustard, cheese, yogurt]
        //[apples, milk, eggs, pickles, mustard, cheese, yogurt]

        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);
        // output:
        //[milk, pickles, mustard, cheese, yogurt]

        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);
        // output:
        //[milk, mustard, cheese]

        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());
        // output:
        // []
        // isEmpty = true

        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        System.out.println(groceries);
        // output:
        // [apples, milk, mustard, cheese, eggs, pickles, mustard, ham]

        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        // output:
        // [apples, cheese, eggs, ham, milk, mustard, mustard, pickles]

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);
        // output:
        // [pickles, mustard, mustard, milk, ham, eggs, cheese, apples]

        // to make an array:
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
        // output:
        // [pickles, mustard, mustard, milk, ham, eggs, cheese, apples]
    }
}
