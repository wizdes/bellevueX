package org.CardGame;

import java.util.ArrayList;

import javafx.util.Pair;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsGameState {

    private int endScore;
    private HeartsScoreboard scoreboard;
    private HeartsPassingDirection passingDirection;
    private boolean hasHeartsBeenPlayed;
    private ArrayList<Card> cardsPlayed;
    private int trickNumber;
    private ArrayList<Pair<Integer,Card> > trickInPlay;

    public HeartsGameState(ArrayList<HeartsPlayer> players)
    {
        this.scoreboard = new HeartsScoreboard(players,endScore);
        this.passingDirection = HeartsPassingDirection.Left;
        this.trickInPlay = new ArrayList<Pair<Integer, Card >>();
        this.hasHeartsBeenPlayed = false;
        this.trickNumber = 1;
    }

    public void NextRound() {
        this.trickInPlay = new ArrayList<Pair<Integer, Card>>();
        this.hasHeartsBeenPlayed = false;
        updatePassingDirection();
    }

    public boolean Finished()
    {
        return scoreboard.GameOver();
    }

    public HeartsPassingDirection getPassingDirection() {
        return passingDirection;
    }

    public void updatePassingDirection(){
        switch(passingDirection){
            case Left:
                passingDirection = HeartsPassingDirection.Right;
                break;
            case Right:
                passingDirection = HeartsPassingDirection.Across;
                break;
            case Across:
                passingDirection = HeartsPassingDirection.None;
                break;
            case None:
                passingDirection = HeartsPassingDirection.Left;
                break;
        }
        return;
    }

    static private int findTrickWinner(ArrayList<Pair<Integer, Card>> trickInPlay){
        Card winningCard = trickInPlay.get(0).getValue();
        int winningPlayer = trickInPlay.get(0).getKey();
        for(int i = 0; i < trickInPlay.size(); i++){
            Card cardToCompare = trickInPlay.get(i).getValue();
            if(cardToCompare.suit == winningCard.suit && cardToCompare.value > winningCard.value){
                winningCard = cardToCompare;
                winningPlayer = trickInPlay.get(i).getKey();
            }
        }
        return winningPlayer;
    }

    public int nextTrick(){
        trickNumber++;
        int trickWinner = findTrickWinner(trickInPlay);
        trickInPlay.clear();
        return trickWinner;
    }

    public boolean tryPlayCard(int playerNum, Card playedCard) {
        trickInPlay.add(new Pair(playerNum,playedCard));


        // Legal play
        if(playedCard.suit == Card.Suit.Hearts)
            hasHeartsBeenPlayed = true;

        cardsPlayed.add(playedCard);
        return true;
    }

    public ArrayList<Pair<Integer,Card >> getCurrentTrick() {
        return trickInPlay;
    }

    public boolean hasHeartsBeenPlayed() {
        return hasHeartsBeenPlayed;
    }

    public int getTrickNumber() {
        return trickNumber;
    }

    public ArrayList<Card> getCardsDiscarded() {
        return cardsPlayed;
    }
}
