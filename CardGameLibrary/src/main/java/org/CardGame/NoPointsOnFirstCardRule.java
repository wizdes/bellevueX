package org.CardGame;

import java.util.ArrayList;

/**
 * Created by YongHui on 6/4/2014.
 */
public class NoPointsOnFirstCardRule implements IRule {

    @Override
    public boolean Check(HeartsGameState gameState, ArrayList<Card> hand, Card played) {
        int trickNumber = gameState.getTrickNumber();
        if(trickNumber != 1){
            return true;
        }

        if(played.suit == Card.Suit.Hearts) {
            for(Card c : hand)
            {
                if(c.suit != Card.Suit.Hearts) {
                    return false;
                }
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
