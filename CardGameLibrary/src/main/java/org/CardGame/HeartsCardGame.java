package org.CardGame;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by YongHui on 5/30/2014.
 */

public class HeartsCardGame {

    private CardDeck deck;
    private HeartsDealer dealer;
    private ArrayList<HeartsPlayer> players;

    private HeartsGameState gameState;

    public HeartsCardGame(int numPlayers, int endScore)
    {
        deck = new CardDeck();
        dealer = new HeartsDealer(deck);
        players = new ArrayList<HeartsPlayer>();

        gameState = new HeartsGameState(players);

        for(int i = 0; i < numPlayers; i++)
        {
            players.add(new HeartsPlayer(i));
        }
    }

    void rotateLeft(LinkedList<ArrayList<Card>> cardHolding){
        cardHolding.add(cardHolding.remove(0));
    }

    public void printHands()
    {
        for (HeartsPlayer h : players)
        {
            h.printHand();
        }
    }

    public void startGame()
    {
        while(!gameState.Finished()) {
            // Deal
            dealer.Deal(players);

            printHands();

            // Select cards to pass
            LinkedList<ArrayList<Card>> cardHolding = PassCards();
            // Receive
            ReceiveCards(cardHolding);

            printHands();

            // who ever has 2 of clubs
            // calculate later
            int offset = getStartingPlayer(players);

            // play
            for(int i = 0; i < 13; i++){
                for(int j = 0; j < 4; j++){
                    players.get((j + offset) % 4).play(gameState);
                }

                offset = gameState.nextTrick();
            }

            // Keep Score



            gameState.NextRound();
        }
    }

    private static int getStartingPlayer(ArrayList<HeartsPlayer> players){
        for(int i = 0; i < players.size(); i++){
            for(Card c : players.get(i).getHand()){
                if(c.suit == Card.Suit.Club && c.value == 2){
                    return i;
                }
            }
        }
        return -1;
    }

    private LinkedList<ArrayList<Card>> PassCards() {
        LinkedList<ArrayList<Card>> cardHolding = new LinkedList<ArrayList<Card>>();
        for (HeartsPlayer h : players)  // TODO: make this multithreaded.
        {
            cardHolding.add(h.PassCards());
        }
        return cardHolding;
    }

    private void ReceiveCards(LinkedList<ArrayList<Card>> cardHolding) {
        switch(gameState.getPassingDirection()){
            case Left:
                rotateLeft(cardHolding);
                break;
            case Right:
                // I blame Ethan
                rotateLeft(cardHolding);
                rotateLeft(cardHolding);
                rotateLeft(cardHolding);
                break;
            case Across:
                rotateLeft(cardHolding);
                rotateLeft(cardHolding);
                break;
            case None:
                break;
        }

        for (int i = 0; i < cardHolding.size(); i++)  // TODO: make this multithreaded.
        {
            players.get(i).ReceiveCards(cardHolding.get(i));
        }
    }
}
