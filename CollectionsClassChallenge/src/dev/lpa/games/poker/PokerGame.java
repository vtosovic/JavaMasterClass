package dev.lpa.games.poker;

import dev.lpa.Card;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {

    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    // SHUFFLE AND CUT
    public void startPlay(){
        // shuffle cards
        Collections.shuffle(deck);
        Card.printDeck(deck);
        //cut cards at the middle
        //Collections.rotate(deck, 26);
        //Card.printDeck(deck);
        //cut cards somewhere from 15 to 35
        int randomMiddle = new Random().nextInt(15, 35);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);

        deal();
        System.out.println("-----------------------");
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));

        //pokerHands.forEach(System.out::println);


        // PRINT UNDEALT CARDS

        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;

        // filling null to quickly populate the list

        //?????AU??????
        //the code replaces each card in the remainingCards list with a card from the deck list.
        // Here's what's happening: for each card c in the remainingCards,
        // the method retrieves the index of that card in the list using remainingCards.indexOf(c).
        // Then it adds cardsDealt to this index to determine which card to fetch from the deck list.
        // The card retrieved from deck.get(cardsDealt + remainingCards.indexOf(c))
        // is then used to replace the current card in remainingCards.

        // it would be easier to use a sublist...
        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining,null));
        remainingCards.replaceAll(c -> deck.get(cardsDealt + remainingCards.indexOf(c)));
        Card.printDeck(remainingCards, "Remaining Cards", 2);

    }

    // DEAL
    private void deal(){
        Card[][] hands = new Card[playerCount][cardsInHand];
        for (int deckIndex = 0, i = 0; i < cardsInHand; i++){
            for (int j = 0; j < playerCount; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }

        int playerNo = 1;
        for(Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }

    }


}
