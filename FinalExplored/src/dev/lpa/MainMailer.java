package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {

    public static void main(String[] args) {

        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D.",
                "Carol Jones", "Ed Green Ph.D.", "Ed Green M.D.", "Ed Black"};

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println(counts);

        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("There are " + counts.get(annJonesPhd) +
                " records for " + annJonesPhd);

        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);

        System.out.println("There are " + counts.get(annJonesPhd) +
                " records for " + annJonesPhd);
        System.out.println(counts);

        StringBuilder annJones = new StringBuilder("Ann Jones");
        System.out.println("There are " + counts.get(annJones) +
                " records for " + annJones);

        System.out.println("-----------------------");
        counts.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("-----------------------");
        counts.keySet().forEach(k -> System.out.println(k + " : " + counts.get(k)));
        //{Ann Jones=3, Ann Jones Ph.D.=4, Bob Jones M.D.=5, Carol Jones=6, Ed Black=9, Ed Green M.D.=8, Ed Green Ph.D.=7}
        //There are 4 records for Ann Jones Ph.D.
        //[Ann Jones, Ann Jones, Ann Jones, Ann Jones, Ann Jones, Ann Jones, Ann Jones, Bob Jones, Bob Jones, Bob Jones, Bob Jones, Bob Jones, Carol Jones, Carol Jones, Carol Jones, Carol Jones, Carol Jones, Carol Jones, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Green, Ed Black, Ed Black, Ed Black, Ed Black, Ed Black, Ed Black, Ed Black, Ed Black, Ed Black]
        //There are null records for Ann Jones Ph.D.
        //{Ann Jones=3, Ann Jones=4, Bob Jones=5, Carol Jones=6, Ed Black=9, Ed Green=8, Ed Green=7}
        //There are 4 records for Ann Jones
        //-----------------------
        //Ann Jones : 3
        //Ann Jones : 4
        //Bob Jones : 5
        //Carol Jones : 6
        //Ed Black : 9
        //Ed Green : 8
        //Ed Green : 7
        //-----------------------
        //Ann Jones : 4
        //Ann Jones : 4
        //Bob Jones : 5
        //Carol Jones : 6
        //Ed Black : 9
        //Ed Green : 8
        //Ed Green : 8
    }

    private static List<StringBuilder> getNames(String[] names) {

        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for (String name : names) {
            for (int i = 0; i < index; i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;
    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> list) {

        List<StringBuilder> newList = new ArrayList<>();
        for (var name : list) {
            for (String suffix : new String[]{"Ph.D.", "M.D."}) {
                int startIndex = -1;
                if ((startIndex = name.indexOf(suffix)) > -1) {
                    name.replace(startIndex - 1,
                            startIndex + suffix.length(), "");
                }
            }
            newList.add(name);
        }
        return newList;
    }

}
