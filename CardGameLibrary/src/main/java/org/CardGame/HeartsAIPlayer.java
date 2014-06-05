package org.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YongHui on 5/30/2014.
 */
public class HeartsAIPlayer extends HeartsPlayer{

    public HeartsAIPlayer(int playerNum) {
        super(playerNum);
    }

    @Override
    public void play(HeartsGameState state) {

    }

    @Override
    public ArrayList<Card> PassCards() {
        return null;
    }
}
