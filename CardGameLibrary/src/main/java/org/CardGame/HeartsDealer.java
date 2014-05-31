package org.CardGame;

import java.util.ArrayList;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsDealer extends Dealer<HeartsPlayer> {

    private CardDeck deck;

    public HeartsDealer(CardDeck deck)
    {
        this.deck = deck;
    }

    @Override
    public void Deal(ArrayList<HeartsPlayer> players) {
        while(deck.size() > 0) {
            for (CardPlayer c : players) {
                c.ReceiveCard(deck.draw());
            }
        }
    }
}
