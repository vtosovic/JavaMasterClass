package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person (String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                // we can access a Record from the super class
                new Main.Person("Lucy", "Van Pelt"),
                // or locally
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));
    // Anonymous
        var comparatorLastName = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        // instead of comparatorLastName, we use:
        //new Comparator<Person>(){
        //            @Override
        //            public int compare(Person o1, Person o2) {
        //                return o1.lastName().compareTo(o2.lastName());
        //            }
        //        }
        // and then use IntelliJ to replace it with Lambda:
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);
        //[Sally Brown, Charlie Brown, Peppermint Patty, Lucy Van Pelt, Linus Van Pelt]


        // This CANNOT be turned into lambda, because it has MORE than one abstract method
        // adding this will get an error
        //@FunctionalInterface
        interface EnhancedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return(result == 0 ? secondLevel(o1, o2):result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
        //[Charlie Brown, Sally Brown, Peppermint Patty, Linus Van Pelt, Lucy Van Pelt]
    }
}
