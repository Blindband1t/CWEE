package model;

import exceptions.DomainException;
import util.Logger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Cedric on 8/04/2017.
 */
public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards =  new ArrayList<>();
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
                    Logger.print_err(e);
                }

            }
        }
    }


    //simuleert het afnemen van de kaarten
    public void cut() throws DomainException
    {

        //copies from dealer
        int subindex = (int) Math.round(Math.random()*50 + 1);
        ArrayList<Card> deckNew = new ArrayList<Card>();

        deckNew.addAll(cards.subList(subindex, 52));
        deckNew.addAll(cards.subList(0, subindex));
        setCards(deckNew);

        //this were I forgot how to program
//        //copy maken van het spel kaarten
//        ArrayList<Card> tmpDeck = new ArrayList<Card>(cards);
//
//        //Ergens in het midden van het spel een willekurige plaats zoeken om de kaarten af te nemen
//        //TODO: dit kan een sowieso een beetje efficienter
//        int rand  = (int) Math.floor(Math.random() * 16) + 18;
//        int index = 0;
//        //Alle kaarten vanaf de willekeurige locatie op de eerste plaats zetten in het deck
//        for(int i = rand; i < cards.size(); i++)
//        {
//            cards.set(index, tmpDeck.remove(rand));
//            index++;
//        }
//        //Alle kaarten die eerst in het begin stonden vanachter toevoegen aan de rest van de kaarten
//        for(int i = 0; i < rand; i++)
//        {
//            cards.set(index, tmpDeck.remove(0));
//            index++;
//        }
    }


    //simuleert het schudden van de kaarten
    public void shuffle()
    {
        //copied from dealer
        Collections.shuffle(cards);

        //this were I forgot how to program
//        //copy maken van het spel kaarten
//        ArrayList<Card> tmpDeck = new ArrayList<Card>();
//
//        //50x de kaarten random op een andere plaats steken.
//        for(int j = 0; j < 50; j++)
//        {
//            tmpDeck.addAll(cards);
//            //kies een willekeurige kaart uit de overblijvende kaarten en plaats deze achteraan de stapel.
//            for(int i = 0; i < cards.size(); i++)
//            {
//                int rand = (int) Math.floor(Math.random() * tmpDeck.size());
//                cards.set(i, tmpDeck.remove(rand));
//            }
//        }
    }

    @Override
    public String toString() {
        String msg = "Deck of Cards: " + cards.toString();
        return msg;
    }

    public Card viewCardAt(int index) throws DomainException
    {
        if(index < 0 || index >= cards.size())
            throw new DomainException("De kaart op index (" + index + ") bestaat niet.");
        else
            return new Card(cards.get(index));
    }

    public Card getCardAt(int index) throws DomainException
    {
        if(index < 0 || index >= cards.size())
            throw new DomainException("De kaart op index (" + index + ") bestaat niet.");
        else
            return cards.remove(index);
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
