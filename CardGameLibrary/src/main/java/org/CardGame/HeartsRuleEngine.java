package org.CardGame;

import java.util.ArrayList;

// Represents a Card
public class HeartsRuleEngine {
    HeartsGameState gameState;

    ArrayList<IRule> rules;

    public HeartsRuleEngine(HeartsGameState state) {
        gameState = state;
        rules = new ArrayList<IRule>();
    }

    public boolean CheckRules(ArrayList<Card> hand, Card played)
    {
        for(IRule r : rules)
        {
            if(!r.Check(gameState,hand, played)){
                return false;
            }
        }

        return true;
    }
}
