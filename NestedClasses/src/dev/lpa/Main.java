package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Laura", 2018)));

        // when the class is not netsted
        //        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        // calling nested class
        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e : employees){
            System.out.println(e);
        }


        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        // CALLING INNER CLASS
        // instance of new StoreEmployee, then instance of new Store comparator
        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee e : storeEmployees){
            System.out.println(e);
        }
        //Store Members
        //Macys   10105 Tom      2020
        //Target  10322 Bud      2016
        //Target  10015 Meg      2019
        //Walmart 10215 Marty    2018
        //Walmart 10515 Joe      2021

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);
        //With Pig Latin Names
        //Marty artyMay Piggy
        //Meg egMay Piggy
        //Joe oeJay Piggy
        //Tom omTay Piggy
        //Bud udBay Piggy

    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";
        //local class
        class DecoratedEmployee extends StoreEmployee
            implements Comparable<DecoratedEmployee> {

            //IntelliJ warns that these variables might be final or effectively final!
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                //using variable from superclass
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " +pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            // remove first character, moved to position 0, added suffix "ay
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }
        //this will make an error, as the method must be effectively final or final
        //so, this will change the value, and it is not final
        //lastName = "Latin";
        newList.sort(null);
        for (var dEmployee : newList){
            // accessing private attributes outside of the class declarations
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }
    }
}
