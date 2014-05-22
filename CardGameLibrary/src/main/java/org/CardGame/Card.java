package org.CardGame;

// Represents a Card
public class Card {

    // Represents a Suit of a Card
    public enum Suit {
        Club,
        Diamond,
        Hearts,
        Spade
    }

    public int value;
    public Suit suit;

    public Card(int i, Suit s) {
        suit = s;
        value = i;
    }

    public String toString()
    {
        return String.format("{0} {1}", value, suit.toString());
    }
}
