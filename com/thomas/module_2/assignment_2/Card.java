package com.thomas.module_2.assignment_2;

/**
 This class represents a playing card in a deck of cards.

 Each card has a suit and a rank, which determine its value and properties.

 This class provides methods for accessing and manipulating these properties.
 */
@SuppressWarnings({"unused", "ClassCanBeRecord"})
public class Card {
    private final Suit suit; // The suit of the card.
    private final Rank rank; // The rank of the card.

    /**
     Constructor for Card class.

     @param suit the suit of the card
     @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     Determines if the card is a face card (Jack, Queen, or King).

     @return true if the card is a face card, false otherwise
     */
    public boolean isFaceCard() {
        return rank == Rank._J || rank == Rank._Q || rank == Rank._K;
    }

    /**
     Determines if the card is a number card (not a face card).

     @return true if the card is a number card, false otherwise
     */
    public boolean isNumberCard() {
        return !isFaceCard();
    }

    /**
     Gets the numeric value of the card, based on its rank.

     @return the value of the card
     */
    public int getValue() {
        return rank.value;
    }

    /**
     Gets the rank of the card.

     @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     Gets the suit of the card.

     @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     Returns a string representation of the card, in the format "{rank} of {suit}".

     @return a string representation of the card
     */
    @Override
    public String toString() {
        return rank.name + " of " + suit;
    }
}