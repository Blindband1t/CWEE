package model;

import exceptions.DomainException;

import java.util.ArrayList;

/**
 * Created by Cedric on 8/04/2017.
 */
public class Deck
{
    private ArrayList<Card> cards;


    public Deck()
    {
        cards =  new ArrayList<Card>();
        createDeck();
    }

    private void createDeck()
    {
        for(int i = 0; i < Card.Suit.values().length; i++)
        {
            for(int j = 0; j < Card.Value.values().length; j++)
            {

                try {
                    cards.add(new Card(Card.Suit.values()[i],Card.Value.values()[j]));
                } catch (DomainException e) {
                    System.out.println("EXCEPTION = >" + e.getMessage());
                }

            }
        }
    }

    @Override
    public String toString() {
        String msg = "Deck of Cards: " + cards.toString();
        return msg;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void setCards(ArrayList<Card> c ) throws DomainException{
        if (c == null || c.isEmpty())
        {
            throw new DomainException("your set of cards is empty");
        }
        this.cards = c;
    }



}
