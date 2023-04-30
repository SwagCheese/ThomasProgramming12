package com.thomas.module_1.assignment_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("DuplicatedCode") List<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Circle(10, Colour.GREEN)); // Green circle with radius 10
        shapes.add(new Triangle(5, 10, Colour.BLUE)); // Blue triangle with width 5 and height 10
        shapes.add(new Circle(15)); // Uncolored circle with radius 15
        shapes.add(new Triangle(3, 4, 5)); // Uncolored triangle with side lengths 3, 4, and 5

        ((Triangle) shapes.get(1)).rotate(99); // rotate the first triangle 99 degrees
        ((Triangle) shapes.get(3)).rotate180(); // rotate the second triangle 180 degrees

        for (TwoDShape shape : shapes) {
            System.out.println(shape.toString() + "\n" +
                    "Area: " + shape.getArea() + "\n");
        }
    }
}
