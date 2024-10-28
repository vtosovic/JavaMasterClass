package dev.lpa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);
        hellos.forEach(s -> System.out.println(s + ": " +s.hashCode()));
        //Hello: 69609650
        //Hello: 69609650
        //Hello: 69609650
        //Hello: 69609650
        //hello: 99162322

        // this will get elements without duplicates
        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("mySet = " + mySet);
        System.out.println("# of elements = " + mySet.size());
        //mySet = [Hello, hello]
        //# of elements = 2

        for(String setValue : mySet){
            System.out.print(setValue + ": ");
            for (int i = 0; i < hellos.size(); i++){
                if (setValue == hellos.get(i)){
                    System.out.print(i + ", ");
                }
            }
            System.out.println(" ");
            //Hello: 0, 1,
            //hello: 4,
        }

        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s -> System.out.println(s + ": " + s.hashCode()));
        //Ace of Hearts: 2065951873
        //King of Clubs: 793589513
        //Queen of Spades: 1313922862

        Set<PlayingCard> deck = new HashSet<>();
        for (PlayingCard c : cards){
            // add is true if element is successfully added
            // sets don't allow duplicates
            if(!deck.add(c)){
                System.out.println("Found a duplicate for " + c);
            }
        }
        System.out.println(deck);
        // before overwrite in PlayingCard
        //[Ace of Hearts, King of Clubs, Queen of Spades]

        // after overwrite, before changing internalHash:
        //Ace of Hearts: 1
        //King of Clubs: 1
        //Queen of Spades: 1
        //--> Checking Playing card equality
        //Found a duplicate for King of Clubs
        //--> Checking Playing card equality
        //Found a duplicate for Queen of Spades
        //[Ace of Hearts]

        // after change:
        //Ace of Hearts: 11
        //King of Clubs: 12
        //Queen of Spades: 12
        //--> Checking Playing card equality
        //Found a duplicate for Queen of Spades
        //[Ace of Hearts, King of Clubs]

        // AFTER REDOING EQUALS AND HASHCODE
        //Ace of Hearts: -1834509066
        //King of Clubs: 2023815418
        //Queen of Spades: -269088580
        //[Ace of Hearts, King of Clubs, Queen of Spades]

    }
}
