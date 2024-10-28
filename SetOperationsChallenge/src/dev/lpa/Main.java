package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);
        //__________________________________________________________________________________________
        //All Tasks
        //__________________________________________________________________________________________
        //Data Access          Set Up Access Policy      LOW        null       IN_QUEUE
        //Data Access          Set Up Users              LOW        null       IN_QUEUE
        //Data Access          Write Views               LOW        null       IN_QUEUE
        //Data Design          Cross Reference Tables    HIGH       null       IN_QUEUE
        //Data Design          Employee Table            MEDIUM     null       IN_QUEUE
        //Data Design          Encryption Policy         HIGH       null       IN_QUEUE
        //Data Design          Task Table                MEDIUM     null       IN_QUEUE
        //Infrastructure       DB Access                 MEDIUM     null       IN_QUEUE
        //Infrastructure       Logging                   HIGH       null       IN_QUEUE
        //Infrastructure       Password Policy           MEDIUM     null       IN_QUEUE
        //Infrastructure       Security                  HIGH       null       IN_QUEUE

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks",annsTasks, sortByPriority);
        //__________________________________________________________________________________________
        //Ann's Tasks
        //__________________________________________________________________________________________
        //Data Design          Encryption Policy         HIGH       Ann        IN_QUEUE
        //Infrastructure       Security                  HIGH       Ann        IN_PROGRESS
        //Infrastructure       Password Policy           MEDIUM     Ann        IN_PROGRESS
        //Research             Cloud solutions           MEDIUM     Ann        IN_PROGRESS
        //Data Design          Project Table             MEDIUM     Ann        IN_QUEUE
        //Data Access          Write Views               LOW        Ann        IN_PROGRESS

        Set<Task> bobsTasks =  TaskData.getTasks("Bob");
        Set<Task> carolsTasks =  TaskData.getTasks("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);
        //__________________________________________________________________________________________
        //Assigned Tasks
        //__________________________________________________________________________________________
        //Data Access          Write Views               LOW        Ann        IN_PROGRESS
        //Data Design          Encryption Policy         HIGH       Ann        IN_QUEUE
        //Data Design          Project Table             MEDIUM     Ann        IN_QUEUE
        //Data Design          Task Table                HIGH       Carol      IN_QUEUE
        //Infrastructure       DB Access                 MEDIUM     Carol      IN_QUEUE
        //Infrastructure       Logging                   HIGH       Carol      IN_PROGRESS
        //Infrastructure       Password Policy           MEDIUM     Ann        IN_PROGRESS
        //Infrastructure       Security                  HIGH       Ann        IN_PROGRESS
        //Research             Cloud solutions           MEDIUM     Ann        IN_PROGRESS

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Tasks", everyTask);
        //__________________________________________________________________________________________
        //The True All Tasks
        //__________________________________________________________________________________________
        //Data Access          Set Up Access Policy      LOW        null       IN_QUEUE
        //Data Access          Set Up Users              LOW        null       IN_QUEUE
        //Data Access          Write Views               LOW        null       IN_QUEUE
        //Data Design          Cross Reference Tables    HIGH       null       IN_QUEUE
        //Data Design          Employee Table            MEDIUM     null       IN_QUEUE
        //Data Design          Encryption Policy         HIGH       null       IN_QUEUE
        //Data Design          Project Table             MEDIUM     Ann        IN_QUEUE
        //Data Design          Task Table                MEDIUM     null       IN_QUEUE
        //Infrastructure       DB Access                 MEDIUM     null       IN_QUEUE
        //Infrastructure       Logging                   HIGH       null       IN_QUEUE
        //Infrastructure       Password Policy           MEDIUM     null       IN_QUEUE
        //Infrastructure       Security                  HIGH       null       IN_QUEUE
        //Research             Cloud solutions           MEDIUM     Ann        IN_PROGRESS

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);
        //__________________________________________________________________________________________
        //Missing Tasks
        //__________________________________________________________________________________________
        //Data Design          Project Table             MEDIUM     Ann        IN_QUEUE
        //Research             Cloud solutions           MEDIUM     Ann        IN_PROGRESS

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);
        //__________________________________________________________________________________________
        //Unassigned Tasks
        //__________________________________________________________________________________________
        //Data Design          Cross Reference Tables    HIGH       null       IN_QUEUE
        //Data Design          Employee Table            MEDIUM     null       IN_QUEUE
        //Data Access          Set Up Access Policy      LOW        null       IN_QUEUE
        //Data Access          Set Up Users              LOW        null       IN_QUEUE

        // Find overlap
        Set<Task> overlap =  getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(carolsTasks, bobsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);
        //__________________________________________________________________________________________
        //Assigned to Multiples
        //__________________________________________________________________________________________
        //Data Design          Encryption Policy         HIGH       Ann        IN_QUEUE
        //Infrastructure       Security                  HIGH       Ann        IN_PROGRESS
        //Infrastructure       Password Policy           MEDIUM     Ann        IN_PROGRESS
        //Data Access          Write Views               LOW        Ann        IN_PROGRESS

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set,overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());

        sortAndPrint("Overlapping", overlapping, priorityNatural);
        //__________________________________________________________________________________________
        //Overlapping
        //__________________________________________________________________________________________
        //Data Design          Encryption Policy         HIGH       Ann        IN_QUEUE
        //Data Design          Encryption Policy         HIGH       Bob        IN_QUEUE
        //Infrastructure       Security                  HIGH       Ann        IN_PROGRESS
        //Infrastructure       Security                  HIGH       Bob        IN_PROGRESS
        //Infrastructure       Password Policy           MEDIUM     Ann        IN_PROGRESS
        //Infrastructure       Password Policy           MEDIUM     Bob        IN_QUEUE
        //Infrastructure       Password Policy           MEDIUM     Carol      IN_QUEUE
        //Data Access          Write Views               LOW        Ann        IN_PROGRESS
        //Data Access          Write Views               LOW        Bob        IN_PROGRESS
        //Data Access          Write Views               LOW        Carol      IN_QUEUE
    }

    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter){

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        // sort for sorting
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    // lets us pass two sets:
    private static Set<Task> getUnion(List<Set<Task>> sets){

        Set<Task> union = new HashSet<>();
        for (var taskSet : sets) {
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b){

        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b){

        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
}
