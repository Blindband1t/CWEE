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
                //System.out.println(Card.Value.values()[j] + " ============ " + Card.Suit.values()[i]);
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
}
