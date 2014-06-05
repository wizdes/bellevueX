package org.CardGame;

import java.util.ArrayList;

import javafx.util.Pair;

/**
 * Created by YongHui on 6/4/2014.
 */
public class FollowSuitRule implements IRule {

    @Override
    public boolean Check(HeartsGameState gameState, ArrayList<Card> hand, Card played) {
        ArrayList<Pair<Integer, Card>> trick = gameState.getCurrentTrick();
        if (trick.isEmpty()) {
            return true;
        }

        Card firstTrick = trick.get(0).getValue();
        if(played.suit == firstTrick.suit)
        {
            return true;
        }

        for (Card c : hand) {
            if(c.suit == firstTrick.suit) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ArrayList<Card> GetPlayable(HeartsGameState gameState, ArrayList<Card> played)
    {
        return null;
    }
}
