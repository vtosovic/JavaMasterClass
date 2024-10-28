package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")));

        var c0 = new EmployeeComparator<StoreEmployee>();
        // static nested class on the Employee class
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        // using the inner class on StoreEmployee
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();

        // LOCAL CLASS
        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        var c3 = new NameSort<StoreEmployee>();

        //ANONYMOUS CLASS
        // comparator is abstract, can't be instantiated, so this is not a call to an interface
        // after adding {}, error is that a method needs to be implemented
        // so we implement a compare method
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, c4);
        // this is the same, but all in one line
        // hard to read, IntelliJ suggest Lambda
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //Sorting with Comparator: dev.lpa.domain.EmployeeComparator@119d7047
        //Target  10322 Bud      2016
        //Walmart 10515 Joe      2021
        //Walmart 10215 Marty    2018
        //Target  10015 Meg      2019
        //Macys   10105 Tom      2020
        // class following $ is a nested class
        //Sorting with Comparator: dev.lpa.domain.Employee$EmployeeComparator@3b9a45b3
        //Target  10322 Bud      2016
        //Walmart 10515 Joe      2021
        //Walmart 10215 Marty    2018
        //Target  10015 Meg      2019
        //Macys   10105 Tom      2020
        // after $ is an inner class
        //Sorting with Comparator: dev.lpa.domain.StoreEmployee$StoreComparator@7699a589
        //Macys   10105 Tom      2020
        //Target  10322 Bud      2016
        //Target  10015 Meg      2019
        //Walmart 10215 Marty    2018
        //Walmart 10515 Joe      2021

        // local comparator
        //Sorting with Comparator: dev.lpa.RunMethods$1NameSort@4dd8dc3
        //Target  10322 Bud      2016
        //Walmart 10515 Joe      2021
        //Walmart 10215 Marty    2018
        //Target  10015 Meg      2019
        //Macys   10105 Tom      2020

        // no name here!
        //Sorting with Comparator: dev.lpa.RunMethods$1@568db2f2
        //Target  10322 Bud      2016
        //Walmart 10515 Joe      2021
        //Walmart 10215 Marty    2018
        //Target  10015 Meg      2019
        //Macys   10105 Tom      2020
        //Sorting with Comparator: dev.lpa.RunMethods$2@5fd0d5ae
        //Target  10322 Bud      2016
        //Walmart 10515 Joe      2021
        //Walmart 10215 Marty    2018
        //Target  10015 Meg      2019
        //Macys   10105 Tom      2020
    }

    // generic
    // using the comparator same type as T, or super type of T
    public static <T> void sortIt(List<T> list,
                                  Comparator<? super T> comparator){
        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list){
            System.out.println(employee);
        }
    }
}
