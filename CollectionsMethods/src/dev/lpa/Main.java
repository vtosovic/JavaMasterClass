package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {

// making a lis of 13 Aces of Hearts
        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);
//        ---------------------------
//                Aces of Hearts
//        A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)

        // initializing the list just sets it to the size 52, does not populate it
        // unlike an Array
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("card.size() = " + cards.size());
        //[]
        //card.size() = 0


        // to populate it, use nCopies:
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);
        //---------------------------
        //Aces of Hearts
        //A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);
        //---------------------------
        //Kings of Clubs
        //K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)

        // variable arguments of number of cards
        //Collections.addAll(cards, cardArray);
        // you cannot pass array on the addAll method:
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 1);
        //---------------------------
        //Card Collection with Aces added
        //A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)

        // COPY
        // first is destination, second is source
        // this will be an error, if addAll was not there, as source does not fit. It must be populated
        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 1);
        //---------------------------
        //Card Collection with Kings copied
        //K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)

        // what happens if there is more in destination then source
        // this will replace fist 13 aces with kings
        // this method copies elements from one array to another, it does not
        // return a copy of your list
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);
        //---------------------------
//        Card Collection with Kings copied
//        K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)
//        A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12) A♥(12)


        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);
        // this will return the same as Kings of Clubs
//        ---------------------------
//                List Copy of Kings
//        K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11) K♣(11)


        //SHUFFLE
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        //REVERSE
        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck", 4);

        //Current Deck
        //2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) J♣(9) Q♣(10) K♣(11) A♣(12)
        //2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11) A♦(12)
        //2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) 10♥(8) J♥(9) Q♥(10) K♥(11) A♥(12)
        //2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)
        //---------------------------
        //Shuffled Deck
        //Q♠(10) 3♣(1) 8♥(6) 5♦(3) K♥(11) J♠(9) A♣(12) 6♦(4) 8♦(6) K♠(11) 8♠(6) A♦(12) 10♥(8)
        //Q♣(10) 4♣(2) A♥(12) 9♦(7) J♣(9) 3♠(1) 4♥(2) 5♠(3) 5♣(3) K♦(11) J♥(9) 2♠(0) Q♥(10)
        //K♣(11) 6♣(4) 7♠(5) 3♦(1) 9♠(7) 2♦(0) 6♥(4) 10♠(8) 4♠(2) 10♣(8) 2♣(0) 2♥(0) J♦(9)
        //9♣(7) 4♦(2) 10♦(8) 7♦(5) Q♦(10) 7♣(5) 7♥(5) A♠(12) 6♠(4) 9♥(7) 3♥(1) 8♣(6) 5♥(3)
        //---------------------------
        //Reversed Deck
        //5♥(3) 8♣(6) 3♥(1) 9♥(7) 6♠(4) A♠(12) 7♥(5) 7♣(5) Q♦(10) 7♦(5) 10♦(8) 4♦(2) 9♣(7)
        //J♦(9) 2♥(0) 2♣(0) 10♣(8) 4♠(2) 10♠(8) 6♥(4) 2♦(0) 9♠(7) 3♦(1) 7♠(5) 6♣(4) K♣(11)
        //Q♥(10) 2♠(0) J♥(9) K♦(11) 5♣(3) 5♠(3) 4♥(2) 3♠(1) J♣(9) 9♦(7) A♥(12) 4♣(2) Q♣(10)
        //10♥(8) A♦(12) 8♠(6) K♠(11) 8♦(6) 6♦(4) A♣(12) J♠(9) K♥(11) 5♦(3) 8♥(6) 3♣(1) Q♠(10)

        //SORT
        //Collections.sort
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                        .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);
        //---------------------------
        //Standard Deck sorted by rank, suit
        //2♣(0) 2♦(0) 2♥(0) 2♠(0)
        //3♣(1) 3♦(1) 3♥(1) 3♠(1)
        //4♣(2) 4♦(2) 4♥(2) 4♠(2)
        //5♣(3) 5♦(3) 5♥(3) 5♠(3)
        //6♣(4) 6♦(4) 6♥(4) 6♠(4)
        //7♣(5) 7♦(5) 7♥(5) 7♠(5)
        //8♣(6) 8♦(6) 8♥(6) 8♠(6)
        //9♣(7) 9♦(7) 9♥(7) 9♠(7)
        //10♣(8) 10♦(8) 10♥(8) 10♠(8)
        //J♣(9) J♦(9) J♥(9) J♠(9)
        //Q♣(10) Q♦(10) Q♥(10) Q♠(10)
        //K♣(11) K♦(11) K♥(11) K♠(11)
        //A♣(12) A♦(12) A♥(12) A♠(12)

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);
        //---------------------------
        //Sorted by rank, suit reversed
        //A♠(12) A♥(12) A♦(12) A♣(12)
        //K♠(11) K♥(11) K♦(11) K♣(11)
        //Q♠(10) Q♥(10) Q♦(10) Q♣(10)
        //J♠(9) J♥(9) J♦(9) J♣(9)
        //10♠(8) 10♥(8) 10♦(8) 10♣(8)
        //9♠(7) 9♥(7) 9♦(7) 9♣(7)
        //8♠(6) 8♥(6) 8♦(6) 8♣(6)
        //7♠(5) 7♥(5) 7♦(5) 7♣(5)
        //6♠(4) 6♥(4) 6♦(4) 6♣(4)
        //5♠(3) 5♥(3) 5♦(3) 5♣(3)
        //4♠(2) 4♥(2) 4♦(2) 4♣(2)
        //3♠(1) 3♥(1) 3♦(1) 3♣(1)
        //2♠(0) 2♥(0) 2♦(0) 2♣(0)

        // kings are from 4 to 7
        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings, "Kings in deck", 1);
        //---------------------------
        //Kings in deck
        //K♠(11) K♥(11) K♦(11) K♣(11)

        // tens are from 16 to 19
        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens, "Tens in deck", 1);
        //---------------------------
        //Tens in deck
        //10♠(8) 10♥(8) 10♦(8) 10♣(8)

        // get an integer, indexOfSubList
        // returns an integer if tens are found in the deck
        // -1 if no
        // elements must be contiguously found
        int sublistIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + sublistIndex);
        System.out.println("Contains = " + deck.containsAll(tens));
        //sublist index for tens = 16
        //Contains = true

        Collections.shuffle(deck);
        int sublistIndex1 = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + sublistIndex1);
        System.out.println("Contains = " + deck.containsAll(tens));
        //sublist index for tens = -1
        //Contains = true

        // DISJOINT
        // true if elements have nothing in common
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);
        //disjoint = false
        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);
        //disjoint = true

        // binarySearch
        // this will not work on the already reversed deck
        // it must be sorted previously
        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        // for smaller, unsorted lists, use indexOf
        System.out.println("foundIndex = " + deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));
        //foundIndex = 34
        //foundIndex = 34 <- if not sorted: foundIndex = 17
        //10♥(8)

        // replaceAll
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        // after resorting, 10s are on 32-36
        Card.printDeck(deck.subList(32,36), "Tens row", 1);
        //---------------------------
        //Tens row
        //10♥(8) 10♦(8) 10♥(8) 10♠(8)

        //the other way around
        //THIS IS BOOLEAN
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32,36), "Tens row", 1);
        //---------------------------
        //Tens row
        //10♣(8) 10♦(8) 10♣(8) 10♠(8)

        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)){
            System.out.println("Tens of heats replaced with tens of clubs");
        } else {
            System.out.println("No tens of hearts found");
        }
        //No tens of hearts found

        // frequency
        System.out.println("Ten of Clubs Card = " +
                Collections.frequency(deck, tenOfClubs));
        //Ten of Clubs Card = 2

        // min and max
        System.out.println("Best Card = " +
                Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst Card = " +
                Collections.min(deck, sortingAlgorithm));
        //Best Card = A♠(12)
        //Worst Card = 2♣(0)

        // rotate
        var sortBySuit = Comparator.comparing(Card::suit).
                thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck,"Sorted by Suit, Rank", 4);
        //---------------------------
        //Sorted by Suit, Rank
        //2♣(0) 3♣(1) 4♣(2) 5♣(3) 6♣(4) 7♣(5) 8♣(6) 9♣(7) 10♣(8) 10♣(8) J♣(9) Q♣(10) K♣(11)
        //A♣(12) 2♦(0) 3♦(1) 4♦(2) 5♦(3) 6♦(4) 7♦(5) 8♦(6) 9♦(7) 10♦(8) J♦(9) Q♦(10) K♦(11)
        //A♦(12) 2♥(0) 3♥(1) 4♥(2) 5♥(3) 6♥(4) 7♥(5) 8♥(6) 9♥(7) J♥(9) Q♥(10) K♥(11) A♥(12)
        //2♠(0) 3♠(1) 4♠(2) 5♠(3) 6♠(4) 7♠(5) 8♠(6) 9♠(7) 10♠(8) J♠(9) Q♠(10) K♠(11) A♠(12)


        // creating list with only clubs cards
        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        // positive number moves that many elements to the beginning
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + 2 + ": " + copied);
        // last two are move to be the first two:
        //UnRotated: [2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), 10♣(8), 10♣(8), J♣(9), Q♣(10), K♣(11)]
        //Rotated 2: [Q♣(10), K♣(11), 2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), 10♣(8), 10♣(8), J♣(9)]

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, -2);
        System.out.println("UnRotated: " + deck.subList(0, 13));
        System.out.println("Rotated " + -2 + ": " + copied);
        //first two moved to the end
        // UnRotated: [2♣(0), 3♣(1), 4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), 10♣(8), 10♣(8), J♣(9), Q♣(10), K♣(11)]
        //Rotated -2: [4♣(2), 5♣(3), 6♣(4), 7♣(5), 8♣(6), 9♣(7), 10♣(8), 10♣(8), J♣(9), Q♣(10), K♣(11), 2♣(0), 3♣(1)]

        // SWAP

        copied = new ArrayList<>(deck.subList(0,13));
        // we need to swap first half with other, so only to i/2
        for(int i = 0; i <copied.size() /2; i++) {
            Collections.swap(copied, i, copied.size() -1 -i);
        }
        System.out.println("Manual reverse: " + copied);
        //Manual reverse: [K♣(11), Q♣(10), J♣(9), 10♣(8), 10♣(8), 9♣(7), 8♣(6), 7♣(5), 6♣(4), 5♣(3), 4♣(2), 3♣(1), 2♣(0)]

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using reverse: " + copied);
        //Using reverse: [K♣(11), Q♣(10), J♣(9), 10♣(8), 10♣(8), 9♣(7), 8♣(6), 7♣(5), 6♣(4), 5♣(3), 4♣(2), 3♣(1), 2♣(0)]
        // swap is more granular
    }
}
