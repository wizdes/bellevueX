package org.CardGame;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsGameState {

    private int endScore;
    private HeartsScoreboard scoreboard;
    private HeartsPassingDirection passingDirection;

    private ArrayList<Card> trickInPlay;

    public HeartsGameState(ArrayList<HeartsPlayer> players)
    {
        this.scoreboard = new HeartsScoreboard(players,endScore);
        this.passingDirection = HeartsPassingDirection.Left;
        this.trickInPlay = new ArrayList<Card>();
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

    public void resetTrickInPlay(){
        trickInPlay.clear();
    }

    public void playCard(Card playedCard) {
        trickInPlay.add(playedCard);
    }
}
