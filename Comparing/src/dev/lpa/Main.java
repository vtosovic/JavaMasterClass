package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }
        //5 > 0: compareTo=1
        //5 == 5: compareTo=0
        //5 < 10: compareTo=-1
        //5 > -50: compareTo=1
        //5 < 50: compareTo=-1

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }
        //banana > apple: compareTo=1
        //banana == banana: compareTo=0
        //banana < pear: compareTo=-14
        //banana > BANANA: compareTo=32

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
        //[BANANA, apple, banana, pear]

        System.out.println("A:" + (int) 'A' + " " + "a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + " " + "b:" + (int) 'b');
        System.out.println("P:" + (int) 'P' + " " + "p:" + (int) 'p');
        //A:65 a:97
        //B:66 b:98
        //P:80 p:112

        Student tim = new Student("Tim");
        Student [] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        //[1001 - Zach (1.75), 1002 - Tim (3.69), 1003 - Ann (2.38)]


        System.out.println("result = " + tim.compareTo(new Student("TIM")));
        //result = -1

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
        // without .reversed()
        //[1003 - Ann (1.58), 1002 - Tim (1.67), 1001 - Zach (2.59)]
        // with .reversed() - reversed GPA order
        //[1003 - Ann (3.73), 1001 - Zach (2.61), 1002 - Tim (2.08)]
    }
}
class StudentGPAComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student>{
    String name;
    private int id;
    protected double gpa;
    private static int LAST_ID = 1000;
    private static Random random = new Random();


    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }



    @Override
    //no need to cast like previous
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));

    }
// if we leave this we get ERASURE error
//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }


}
