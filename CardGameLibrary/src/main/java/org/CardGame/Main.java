package org.CardGame;

import java.util.Scanner;

/**
 * Created by YongHui on 5/30/2014.
 */
public class Main {
    public static void main(String [] args){
        HeartsCardGame game = new HeartsCardGame(4, 100);
        game.startGame();
    }
}
