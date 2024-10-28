package dev.lpa;

import external.Child;

public class Main {

    public static void main(String[] args) {

        Parent parent = new Parent("Jane Doe", "01/01/1950", 4);
        Child child = new Child();

        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);

        Person joe = new Person("Joe", "01-01-1950");
        System.out.println(joe);

        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);

        Generation g = Generation.BABY_BOOMER;
        //Parent static initializer: class being constructed
        //In Parent Initializer
        //In Parent Constructor
        //In Parent Initializer
        //In Parent Constructor
        //Child: Initializer, birthOrder = 2, birthOrderString = Middle
        //Child: Constructor
        //Parent: name='Jane Doe', dob='01/01/1950'
        //Child: name='Jane Doe', dob='02/02/1920', Middle child
        //Person[name=Joe, dob=01/01/1950]
        //Person[name=Joe, dob=01/01/1950]
        //GEN_Z 2001 - 2024
        //-- SPECIAL FOR GEN_Z 2001 - 2024 --
        //MILLENNIAL 1981 - 2000
        //GEN_X 1965 - 1980
        //BABY_BOOMER 1946 - 1964
        //SILENT_GENERATION 1927 - 1945
        //GREATEST_GENERATION 1901 - 1926
    }
}
