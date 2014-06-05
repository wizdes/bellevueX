package org.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsHumanPlayer extends HeartsPlayer{

    public HeartsHumanPlayer(int playerNum) {
        super(playerNum);
    }

    @Override
    public void play(HeartsGameState state) {
        Scanner in = new Scanner(System.in);
        String cardNumber = in.next();
        // add ethan to gameState
        // assume ethan is sanitized

        /// assume
        Card playedCard = hand.remove(Integer.parseInt(cardNumber));

        state.tryPlayCard(playerNum, playedCard);
    }

    @Override
    public ArrayList<Card> PassCards() {
        Scanner in = new Scanner(System.in);
        String passedCards1  = in.next();
        String passedCards2  = in.next();
        String passedCards3  = in.next();
        String[] passedCards = new String[]{passedCards1, passedCards2, passedCards3};

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

        // this is because Yi & Ethan is lazy
        Collections.sort(sortedCardIndices);
        Collections.reverse(sortedCardIndices);

        for(Integer index : sortedCardIndices){
            // screw java
            cardsToReturn.add(hand.remove((int) index));
        }

        return cardsToReturn;
    }

}
