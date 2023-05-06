package com.thomas.module_3.assignment_1;

import java.math.BigInteger;

/**
 A class for generating numbers in the Fibonacci sequence.
 */
public class FibonacciSequence {

    /**
     Returns the nth number in the Fibonacci sequence, starting from 0.

     @param n The index of the desired number in the sequence, 0 index.
     @return The nth number in the Fibonacci sequence.
     */
    public static BigInteger getNthNumber(int n) {
        return getNthNumber(n, BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     Helper method for recursively generating the nth number in the Fibonacci sequence.

     @param n The index of the desired number in the sequence, 0 indexed.
     @param F1 The value of the first number in the sequence.
     @param F2 The value of the second number in the sequence.

     @return The nth number in the Fibonacci sequence.
     */
    public static BigInteger getNthNumber(int n, BigInteger F1, BigInteger F2) {
        if (n == 0) {
            // Base case: if n is 0, the first number in the sequence (F1) is returned.
            return F1;
        }

        // Recursive case: the nth number in the sequence is generated by adding the previous two numbers.
        // F1 becomes the previous value of F2, and F2 becomes the sum of the previous two values.
        return getNthNumber(n - 1, F2, F1.add(F2));
    }
}
