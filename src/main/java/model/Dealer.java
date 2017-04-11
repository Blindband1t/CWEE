package model;

import exceptions.DomainException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by cedricdunon on 11/04/17.
 */
public class Dealer
{
    private Deck deck;

    public Dealer ()
    {
      deck = new Deck();
    }

    public void shuffleDeck()
    {
        Collections.shuffle(deck.getCards());
    }

    public void liftDeckOfCards() throws DomainException
    {
        int subindex = (int) Math.round(Math.random()*50 + 1);
        ArrayList<Card> Decknew = new ArrayList<Card>();

        Decknew.addAll(deck.getCards().subList(subindex, 52));
        Decknew.addAll(deck.getCards().subList(0, subindex));
        deck.setCards(Decknew);
    }


}
