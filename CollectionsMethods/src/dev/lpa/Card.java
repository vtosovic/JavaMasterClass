package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage(){
            // ascii for club, diamond, heart, spade
            return (new char[]{9827,9830,9829,9824})[this.ordinal()];

        }

    }
    @Override
    public String toString() {
        // retrieve one digit, unless it is 10, then retrieve 2 digits
        int index = face.equals("10") ? 2 : 1;
        // retrieve first number or a letter, or just 10 if it is 10
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(),rank);
    }

    public static Card getNumericCard(Suit suit, int cardNumber){
        if (cardNumber > 1 && cardNumber <11){
            // return card with the rank. Rank is 0 for the lowest card, 2
            return new Card(suit, String.valueOf(cardNumber), cardNumber -2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev){
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1){
            return new Card(suit,"" + abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    public static List<Card> getStandardDeck(){
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()){
            for (int i=2; i <= 10; i++){
                deck.add(getNumericCard(suit, i));
            }
            for (char c : new char[] {'J', 'Q', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("---------------------------");
        if (description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size()/rows;
        for (int i = 0; i < rows; i++){
            // it will be 0, 13, 26, 39
            int startIndex = i * cardsInRow;
            int endIndex =  startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

}
