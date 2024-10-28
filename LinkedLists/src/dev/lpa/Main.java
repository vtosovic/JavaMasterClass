package dev.lpa;

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

       // LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        // output
        // [Alice Springs, Brisbane, Darwin, Canberra, Sydney, Hobart, Melbourne, Toowoomba]

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);
        // output without list.remove
        // [Alice Springs, Darwin, Canberra, Hobart, Melbourne, Toowoomba]

        // gettingElements(placesToVisit);

        printItinerary(placesToVisit);
        printItinerary2(placesToVisit);
        printItinerary3(placesToVisit);
        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list){
        list.addFirst("Darwin");
        list.addLast("Hobart");
        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack Methods - puts on the top
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        // removes first element of the list and returns it
        String s1 = list.remove();
        System.out.println(s1 + " was removed");
        // output
        // Alice Springs was removed
        //[Darwin, Canberra, Hobart, Melbourne, Toowoomba]

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");
        // output
        // Darwin was removed
        //[Canberra, Hobart, Melbourne, Toowoomba]

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");
        // output
        // Toowoomba was removed
        //[Canberra, Hobart, Melbourne]

        // Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");
        // output
        // Canberra was removed
        //Hobart was removed
        //Melbourne was removed
        //[]

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop(); // removes first element
        System.out.println(p4 + " was removed");
        // output:
        // [Canberra, Brisbane, Sydney]
        //Canberra was removed
        //[Brisbane, Sydney]
    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Retrieved Element = " + list.get(4));
        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());
        //Retrieved Element = Sydney
        //First Element = Alice Springs
        //Last Element = Toowoomba

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.indexOf("Melbourne"));
        //Darwin is at position: 2
        //Melbourne is at position: 6

        // Queue retrieval method FIFO
        System.out.println("Element from element() = " + list.element());
        // Element from element() = Alice Springs
        // Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
        // Element from peek() = Alice Springs
        //Element from peekFirst() = Alice Springs
        //Element from peekLast() = Toowoomba
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        for (int i =1; i <list.size(); i++){
            System.out.println("--> From: " + list.get(i -1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
        // Trip starts at Alice Springs
        //--> From: Alice Springs to Brisbane
        //--> From: Brisbane to Darwin
        //--> From: Darwin to Canberra
        //--> From: Canberra to Sydney
        //--> From: Sydney to Hobart
        //--> From: Hobart to Melbourne
        //--> From: Melbourne to Toowoomba
        //Trip ends at Toowoomba
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list){
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());

        //Trip starts at Alice Springs
        //--> From: Alice Springs to Alice Springs
        //--> From: Alice Springs to Brisbane
        //--> From: Brisbane to Darwin
        //--> From: Darwin to Canberra
        //--> From: Canberra to Sydney
        //--> From: Sydney to Hobart
        //--> From: Hobart to Melbourne
        //--> From: Melbourne to Toowoomba
        //Trip ends at Toowoomba
    }
    public static void printItinerary3(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
        //Trip starts at Alice Springs
        //--> From: Alice Springs to Brisbane
        //--> From: Brisbane to Darwin
        //--> From: Darwin to Canberra
        //--> From: Canberra to Sydney
        //--> From: Sydney to Hobart
        //--> From: Hobart to Melbourne
        //--> From: Melbourne to Toowoomba
        //Trip ends at Toowoomba
    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()){
            //System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }
        // iterator is on the end already, and cannot be moved to the beggining
        // so this does nothing
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());

        }
        System.out.println(list);
        //Toowoomba
        //Melbourne
        //Hobart
        //Sydney
        //Canberra
        //Darwin
        //Lake Wivenhoe
        //Brisbane
        //Alice Springs
        //[Alice Springs, Brisbane, Lake Wivenhoe, Darwin, Canberra, Sydney, Hobart, Melbourne, Toowoomba]

        // this moves iterator to position 3
        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
        //Darwin
    }
}
