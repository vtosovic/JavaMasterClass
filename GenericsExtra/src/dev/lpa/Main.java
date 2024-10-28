package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.util.QueryItem;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}


public class Main {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0 ; i < studentCount ; i++){
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printMoreLists(students);


        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0 ; i < studentCount ; i++){
            lpaStudents.add(new LPAStudent());
        }
        printMoreLists(lpaStudents);
        testList(new ArrayList<String>(List.of("Able", "Berry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));
        //String ABLE
        //String BERRY
        //String CHARLIE
        //Integer 1.0
        //Integer 2.0
        //Integer 3.0

        // creating list with var - type should be inferred
        // no type on either side!
        // it will generate as:
        // QueryList<LPAStudent> queryList = new QueryList<LPAStudent>(lpaStudents)
        // this is NON static method
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);
        //2018          John D          Python 2018     35.4%
        //2021          Bill N          Python 2021     97.6%
        //2020          Bill B          Python 2020     51.2%


        //this is STATIC method
        var students2021 =
                QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);
        //2021           Tim W          Python 2021
        //2021           Tim D            Java 2021
        //2021           Ann P          Python 2021
        //2021         Cathy Z             C++ 2021

        // not mentioning the type, just ArrayList as upper bound
        // but in the call the type must be mentioned, <Student>getMatches
//        var students2021_vague =
//                QueryList.<Student>getMatches(new ArrayList<>(),
//                        "YearStarted", "2021");
//        printMoreLists(students2021_vague);

        // Checking multiple Upper bound on the Record.
        // it will be an error if we leave just Employee, as it must
        // implement all the conditions.
        //QueryList<Employee> employeeList = new QueryList<>();
    }

 //USING UPPER BOUND
    public static void printMoreLists(List<? extends Student> students) {

        // THIS WILL NOT WORK, as wildcard cannot guess the typ
//        Student last = students.get(students.size()-1);
//        students.set(0, last);

        for (var student : students) {
            System.out.println(student.getYearStarted() + " " + student);
        }
        System.out.println();


    }


    // TYPE ERASURE ERROR - those overloaded classes have a clash in type:

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println("String " + element.toUpperCase());
//        }
//    }
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("Integer " + element.floatValue());
//        }
//    }

// THIS IS HOW TO DO IT:
    public static void testList(List<?> list){
        for (var element:list) {
            if (element instanceof String s) {
                System.out.println("String " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer " + i.floatValue());
            }
        }
    }

//    // USING LOWER BOUND, BUT MAIN METHOD WILL NOT WORK
//    public static void printMoreLists(List<? super Student> students) {
//        for (var student : students) {
//            System.out.println(student);
//        }
//        System.out.println();
//    }
}
