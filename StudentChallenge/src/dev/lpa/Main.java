package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.LPAStudentComparator;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++){
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);
        //Ordered
        //10000 Ann F           Python          2020     99.1%
        //10001 Tim B           Java            2022     62.9%
        //10002 Cathy B         C++             2020     48.2%
        //10003 Tim Q           Java            2018     17.7%
        //10004 John Z          C++             2018     42.2%
        //10005 Bill T          C++             2019     66.5%
        //...

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("Course", "Python");

        matches.sort(new LPAStudentComparator());
        printList(matches);
        //Matches
        //10021 Ann P           Python          2019     16.1%
        //10011 Bill H          Python          2020     20.1%
        //10019 Ann K           Python          2019     28.1%
        //10022 Bill S          Python          2021     34.0%

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);
        //Ordered
        //10011 Bill H          Python          2020     20.1%
        //10019 Ann K           Python          2019     28.1%
        //10021 Ann P           Python          2019     16.1%
        //10022 Bill S          Python          2021     34.0%

    }

    public static void printList(List<?> students){
        for (var student : students){
            System.out.println(student);
        }
    }
}
