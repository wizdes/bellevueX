package org.CardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsPlayer extends CardPlayer <HeartsGameState> {

    private ArrayList<Card> hand;

    public HeartsPlayer(){
        hand = new ArrayList<Card>();
    }

    @Override
    public void Play(HeartsGameState state) {
        Scanner in = new Scanner(System.in);
        String cardNumber = in.nextLine();
        // add ethan to gameState
        // assume ethan is sanitized

        /// assume
        Card playedCard = hand.remove(Integer.parseInt(cardNumber));

        state.playCard(playedCard);
    }

    @Override
    public void ReceiveCard(Card card) {
        hand.add(card);
    }

    public void ReceiveCards(ArrayList<Card> cards) {
        for(Card c : cards){
            hand.add(c);
        }
    }

    public ArrayList<Card> PassCards() {
        Scanner in = new Scanner(System.in);
        String[] passedCards  = in.nextLine().split(" ");

        in.close();

        ArrayList<Card> cardsToPass = convertStringToPassedCards(passedCards);

        return cardsToPass;
    }

    private ArrayList<Card> convertStringToPassedCards(String[] passedCards) {
        ArrayList<Card> cardsToReturn = new ArrayList<Card>();
        ArrayList<Integer> sortedCardIndices = new ArrayList<Integer>();

        for(String s : passedCards){
            int intCard = Integer.parseInt(s);
            sortedCardIndices.add(intCard);
        }

        // this is because Yi is lazy
        Collections.sort(sortedCardIndices);
        Collections.reverse(sortedCardIndices);

        for(Integer index : sortedCardIndices){
            // screw java
            cardsToReturn.add(hand.remove((int) index));
        }

        return cardsToReturn;
    }
}
