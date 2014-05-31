package org.CardGame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsScoreboard {

    private int endScore;
    private HashMap<HeartsPlayer,Integer> scores;

    public HeartsScoreboard(ArrayList<HeartsPlayer> players, int endScore)
    {
        this.endScore = endScore;

        this.scores = new HashMap<HeartsPlayer, Integer>();
        for(HeartsPlayer h : players)
        {
            scores.put(h,0);
        }
    }

    public boolean GameOver()
    {
        for(HeartsPlayer h : scores.keySet())
        {
            if(scores.get(h) >= endScore)
            {
                return true;
            }
        }

        return false;
    }
}
