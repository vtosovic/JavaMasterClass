package dev.lpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);
        //for TreeSet, Array and Collection:
        //[Anna, Bob, Carol, David, Edna]
        //for HashSet:
        //[Edna, Bob, David, Carol, Anna]


        list.add("Fred");
        list.addAll(Arrays.asList("George","Gary","Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
//        [Anna, Bob, Carol, David, Edna, Fred, George, Gary, Grace]
//        Gary is in the list? true
        // for HashSet
        //[Gary, Edna, Bob, George, Grace, David, Fred, Carol, Anna]
        //Gary is in the list? true


        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
        //[Anna, Bob, Carol, David, Edna, Fred]
        //Gary is in the list? false
        // for HashSet:
        //[Edna, Bob, David, Fred, Carol, Anna]
        //Gary is in the list? false

        // this will not work, as Collection interface has no sort
        //list.sort();
    }
}
