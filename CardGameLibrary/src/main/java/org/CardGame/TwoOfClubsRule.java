package org.CardGame;

import java.util.ArrayList;

/**
 * Created by YongHui on 6/4/2014.
 */
public class TwoOfClubsRule implements IRule {

    @Override
    public boolean Check(HeartsGameState gameState, ArrayList<Card> hand, Card played) {
        ArrayList<Card> cardsPlayed = gameState.getCardsDiscarded();
        if(!cardsPlayed.isEmpty()){
            return true;
        }

        if(played.suit == Card.Suit.Club || played.value == 2) {
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<Card> GetPlayable(HeartsGameState gameState, ArrayList<Card> played)
    {
        return null;
    }
}
