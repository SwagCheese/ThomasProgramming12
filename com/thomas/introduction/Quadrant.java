package com.thomas.introduction;

import java.util.Scanner;

class Quadrant {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double x = scanner.nextDouble(), y = scanner.nextDouble();

        if (x > 0) {
            if (y > 0) {
                System.out.println("Quadrant #1");
            } else if (y < 0) {
                System.out.println("Quadrant #4");
            } else {
                System.out.println("Between Quadrant #1 and Quadrant #4");
            }
        } else if (x < 0) {
            if (y > 0) {
                System.out.println("Quadrant #2");
            } else if (y < 0) {
                System.out.println("Quadrant #3");
            } else {
                System.out.println("Between Quadrant #2 and Quadrant #3");
            }
        } else {
            if (y > 0) {
                System.out.println("Between Quadrant #1 and Quadrant #2");
            } else if (y < 0) {
                System.out.println("Between Quadrant #3 and Quadrant #4");
            } else {
                System.out.println("Origin");
            }
        }
    }
}