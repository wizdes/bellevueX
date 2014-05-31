package org.CardGame;

/**
 * Created by YongHui on 5/30/2014.
 */
public abstract class CardPlayer <T>{

    public abstract void Play(T state);

    public abstract void ReceiveCard(Card card);
}
