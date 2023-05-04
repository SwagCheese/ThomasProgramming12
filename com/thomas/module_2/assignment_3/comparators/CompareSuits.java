package com.thomas.module_2.assignment_3.comparators;

import com.thomas.module_2.assignment_3.Card;

import java.util.Comparator;

/**
 This class provides a comparison method for Card objects based on their suit.
 */
 public class CompareSuits implements Comparator<Card> {

     /**
      Compares two Card objects based on their suit in alphabetical order.

      @param card1 the first Card object to compare
      @param card2 the second Card object to compare
      @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Card card1, Card card2) {
        // Convert the suit of each card to a string and compare them using a case-insensitive string comparator
        return String.CASE_INSENSITIVE_ORDER.compare(card1.getSuit().toString(), card2.getSuit().toString());
    }
}