package com.thomas.module_2.assignment_3.comparators;

import com.thomas.module_2.assignment_3.Card;

import java.util.Comparator;

/**
 This comparator compares two cards based on whether they are face cards or not.
 A face card is any card with a value of 11, 12, or 13, which are the Jack, Queen, and King cards, respectively.
 This comparator returns -1 if the first card is a face card and the second card is not, 1 if the second card is a face
 card and the first card is not, and 0 if both cards are face cards or both are not face cards.
 */
public class CompareFaceCard implements Comparator<Card> {

    /**
     Compares two cards based on whether they are face cards or not.

     @param card1 the first card to compare
     @param card2 the second card to compare
     @return -1 if the first card is a face card and the second card is not, 1 if the second card is a face
     card and the first card is not, and 0 if both cards are face cards or both are not face cards.
     */
    @Override
    public int compare(Card card1, Card card2) {
        return Boolean.compare(card1.isFaceCard(), card2.isFaceCard());
    }
}