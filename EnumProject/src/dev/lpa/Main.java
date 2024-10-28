package dev.lpa;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);
        // TUES

        System.out.printf("Name is %s, Ordinal Value = %d%n",
                weekDay.name(), weekDay.ordinal());
        // Name is TUES, Ordinal Value = 2

        for (int i = 0; i <10 ; i++) {
            weekDay = getRandomDay();
            System.out.printf("Name is %s, Ordinal Value = %d%n",
                    weekDay.name(), weekDay.ordinal() +1);
        }
        //Name is SAT, Ordinal Value = 7
        //Name is SUN, Ordinal Value = 1
        //Name is TUES, Ordinal Value = 3
        //Name is MON, Ordinal Value = 2
        //Name is FRI, Ordinal Value = 6
        //Name is MON, Ordinal Value = 2
        //Name is SAT, Ordinal Value = 7
        //Name is WED, Ordinal Value = 4
        //Name is THURS, Ordinal Value = 5
        //Name is FRI, Ordinal Value = 6

        for (int i = 0; i <10 ; i++) {
            weekDay = getRandomDay();
            switchDayOfWeek(weekDay);
        }
        //Sunday is Day 1
        //Monday is Day 2
        //Tuesday is Day 3
        //Friday is Day 6
        //Friday is Day 6
        //Saturday is Day 7
        //Thursday is Day 5
        //Sunday is Day 1
        //Monday is Day 2
        //Wednesday is Day 4

        for (Topping topping : Topping.values()){
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
        //MUSTARD : 0.0
        //PICKLES : 0.0
        //BACON : 1.5
        //CHEDDAR : 1.0
        //TOMATO : 0.0
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }

    public static void switchDayOfWeek (DayOfTheWeek weekDay){
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay){ // we can use enum also
            case WED -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is Day " + weekDayInteger);
        }
    }
}
