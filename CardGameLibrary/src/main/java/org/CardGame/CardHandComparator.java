package org.CardGame;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by YongHui on 5/31/2014.
 */
public class CardHandComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(o1.suit.ordinal() < o2.suit.ordinal())
        {
            return -1;
        }
        if(o1.suit.ordinal() > o2.suit.ordinal())
        {
            return 1;
        }
        if(o1.value < o2.value)
        {
            return -1;
        }
        if(o1.value > o2.value)
        {
            return 1;
        }

        return 0;
    }
}
