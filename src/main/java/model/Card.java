package model;

import exceptions.DomainException;

/**
 * Created by Lukas on 7-4-2017.
 */
public class Card {

    /*The suit of the card*/
    public enum Suit {
        SPADES, HEARTHS, CLUBS, DIAMONDS
    }

    public enum Value {

        ACE(1, "ace"),
        TWO(2, "two"),
        THREE(3, "three"),
        FOUR(4, "four"),
        FIVE(5, "five"),
        SIX(6, "six"),
        SEVEN(7, "seven"),
        EIGHT(8, "eight"),
        NINE(9, "nine"),
        TEN(10, "ten"),
        JACK(11, "jack"),
        QUEEN(12, "queen"),
        KING(13, "king");

        int value;
        String valueToText;

        Value(int value, String valueToText) {
            this.value = value;
            this.valueToText = valueToText;
        }
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) throws DomainException {
        setSuit(suit);
        setValue(value);
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) throws DomainException {
        if (suit == null)
            throw new DomainException("Suit can not be null.");
        else
            this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) throws DomainException {
        if (value == null)
            throw new DomainException("Value can not be null.");
        else
            this.value = value;
    }

    public boolean isSameSuit(Card card) {
        if (card == null)
            return false;
        if (card.getSuit().equals(suit))
            return true;
        else
            return false;
    }

    public boolean isSameValue(Card card) {
        if (card == null)
            return false;
        if (card.getValue().equals(value))
            return true;
        else
            return false;
    }

    public boolean isSameSuitAndLower(Card card) {
        if (card == null)
            return false;
        if (isSameSuit(card) && card.value.value < value.value)
            return true;
        else
            return false;
    }

    public boolean isSameSuitAndHigher(Card card)
    {
        if (card == null)
            return false;
        if (isSameSuit(card) && card.value.value > value.value)
            return true;
        else
            return false;
    }
}
