package org.CardGame;

import java.util.ArrayList;

/**
 * Created by YongHui on 6/4/2014.
 */
public interface IRule {
    public boolean Check(HeartsGameState gameState, ArrayList<Card> hand, Card played);

    public ArrayList<Card> GetPlayable(HeartsGameState gameState, ArrayList<Card> hand);
}
