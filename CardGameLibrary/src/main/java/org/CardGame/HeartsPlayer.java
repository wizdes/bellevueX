package org.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YongHui on 5/30/2014.
 */
public abstract class HeartsPlayer{

    protected ArrayList<Card> hand;
    protected int playerNum;

    public HeartsPlayer(int playerNum){
        this.playerNum = playerNum;
        hand = new ArrayList<Card>();
    }

    public void printHand()
    {
        for (Card c : hand)
        {
            System.out.print(c.toString() + " ");
        }
        System.out.println();
    }

    public void SortCards()
    {
        Collections.sort(hand,new CardHandComparator());
    }

    public void ReceiveCard(Card card) {
        hand.add(card);
        SortCards();
    }

    public void ReceiveCards(ArrayList<Card> cards) {
        for(Card c : cards){
            hand.add(c);
        }
        SortCards();
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public abstract void play(HeartsGameState state);

    public abstract ArrayList<Card> PassCards();
}
