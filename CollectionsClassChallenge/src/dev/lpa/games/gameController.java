// Five Card Draw

//The dealer shuffles the deck, and asks another player to cut the deck.
//The dealer deals the cards one at a time to each player, starting with the player on the dealer's left, until each player has 5 cards.
//Each player evaluates his hand for certain card combinations, called card ranks.
//Each player can discard up to 3 cards.
//The dealer will replace discarded cards from the remaining pile, in the order they've been shuffled.
//Each player reevaluates his hand if he drew new cards, and bets on his hand.

package dev.lpa.games;

import dev.lpa.games.poker.PokerGame;

public class gameController {

    public static void main(String[] args) {

        PokerGame fiveCardDraw = new PokerGame(8, 5);
        fiveCardDraw.startPlay();
    }
}
