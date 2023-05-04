package com.thomas.module_2.assignment_2;

public enum Rank {
    _A(1, "Ace"), // Represents an Ace card.
    _2(2, "Two"), // Represents a card with a value of 2.
    _3(3, "Three"), // Represents a card with a value of 3.
    _4(4, "Four"), // Represents a card with a value of 4.
    _5(5, "Five"), // Represents a card with a value of 5.
    _6(6, "Six"), // Represents a card with a value of 6.
    _7(7, "Seven"), // Represents a card with a value of 7.
    _8(8, "Eight"), // Represents a card with a value of 8.
    _9(9, "Nine"), // Represents a card with a value of 9.
    _10(10, "Ten"), // Represents a card with a value of 10.
    _J(11, "Jack"), // Represents a Jack card.
    _Q(12, "Queen"), // Represents a Queen card.
    _K(13, "King"); // Represents a King card.

    public final int value; // The numeric value associated with this card value.
    public final String name; // The name of this card value.

    /**
     Constructor for Rank enum.

     @param value the numeric value associated with this card value
     @param name the name of this card value
     */
    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }
}