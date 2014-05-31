package org.CardGame;

import java.util.ArrayList;
import java.util.Random;

// Standard 52-Card Deck
public class CardDeck {
    Random rand = new Random();
    ArrayList<Card> cards = new ArrayList<Card>();

    public final int MIN_CARD_VALUE = 1;
    public final int MAX_CARD_VALUE = 13;

    public CardDeck(){
        initializeDeck();
    }

    private void initializeDeck() {
        for(int i = MIN_CARD_VALUE; i <= MAX_CARD_VALUE; i++){
            for(Card.Suit s : Card.Suit.values()){
                cards.add(new Card(i, s));
            }
        }
    }

    // Performs Ficher-Yates shuffle on Deck.
    public void shuffle() {
        for(int i = 0; i < cards.size(); i++){
            int val = rand.nextInt(cards.size() - i);
            Card temp = cards.get(i);
            cards.set(i,cards.get(val));
            cards.set(val,temp);
        }
    }

    // Picks one card from the deck.
    public Card draw(){
        // Remove from end.
        return cards.remove(cards.size() - 1);
    }

    // Opens a new pack of cards!
    public void reset() {
        cards.clear();
        initializeDeck();
    }

    public int size() {
        return cards.size();
    }
}
