package com.thomas.module_2.assignment_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Main {
    public static void main(String[] args) {
        // Generate a deck of cards
        List<Card> deck = generateDeck();

        // Draw the first 7 cards from the deck to form a hand
        List<Card> hand = deck.subList(0, 7);

        // Print the hand
        System.out.println(hand);
    }

    /**
     * Generates a standard deck of 52 cards, with one card for each rank and suit combination.
     *
     * @return a linked list containing the 52 cards in the deck
     */
    private static LinkedList<Card> generateDeck() {
        // Define the possible ranks of cards
        Rank[] ranks = {
                Rank._A,
                Rank._2,
                Rank._3,
                Rank._4,
                Rank._5,
                Rank._6,
                Rank._7,
                Rank._8,
                Rank._9,
                Rank._10,
                Rank._J,
                Rank._Q,
                Rank._K
        };

        // Define the possible suits of cards
        Suit[] suits = {
                Suit.CLUBS,
                Suit.DIAMONDS,
                Suit.HEARTS,
                Suit.SPADES
        };

        // Create an empty linked list to hold the cards in the deck
        LinkedList<Card> deck = new LinkedList<>();

        // For each suit, add one card of each rank to the deck
        for (Suit s : suits) {
            for (Rank r : ranks) {
                deck.add(new Card(s, r));
            }
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        // Return the shuffled deck
        return deck;
    }

}