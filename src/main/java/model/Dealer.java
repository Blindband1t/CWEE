package model;

import exceptions.DomainException;

import java.util.ArrayList;
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

    //het schudden van de kaarten word volgens mij het beste gedaan in de Deck klasse

    public void shuffleDeck()
    {
        deck.shuffle();
    }

    public void cutDeck() throws DomainException
    {
        deck.cut();

    }

    public Deck getDeck(){
        return this.deck;
    }

    public void creatNewDeck(){
        deck = new Deck();
    }


}
