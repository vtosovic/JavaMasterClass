package dev.lpa.domain;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee > implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2){
        return o1.getName().compareTo(o2.getName());
        // this will not work, it is private
        //return o1.yearStarted - o2.yearStarted;
    }
}
