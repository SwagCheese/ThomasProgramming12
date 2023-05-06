package com.thomas.module_3.assignment_1;

// A Java program to print the first 1000 numbers of the Fibonacci sequence
public class Main {
    public static void main(String[] args) {
        // Iterate through the first 1000 numbers of the Fibonacci sequence
        for (int i = 0; i <= 1000; ++i) {
            // Print the i-th number of the sequence using the FibonacciSequence.getNthNumber() method
            System.out.println(i + "th number: " + FibonacciSequence.getNthNumber(i));
        }
    }
}
