package com.thomas.introduction;

import java.util.Scanner;

class HotDogs {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many hot dogs would you like to buy?");
        int numHotDogs = scanner.nextInt();

        System.out.println("How many drinks would you like to buy?");
        int numDrinks = scanner.nextInt();

        double cost = numHotDogs*3.50 + numDrinks*1.00;
        cost *= 1.12; // add tax

        // the Math.round call rounds the cost to 2 decimal places and removes any floating point precision errors
        System.out.println("You owe $" + Math.round(cost * 100) / 100 + ", including tax.");
    }
}