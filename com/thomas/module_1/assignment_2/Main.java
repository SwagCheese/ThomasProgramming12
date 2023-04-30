package com.thomas.module_1.assignment_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("DuplicatedCode") List<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Circle(10)); // Circle with radius 10
        shapes.add(new Triangle(5, 10)); // Triangle with width 5 and height 10
        shapes.add(new Circle(15)); // Circle with radius 15
        shapes.add(new Triangle(3, 4, 5)); // Triangle with side lengths 3, 4, and 5

        for (TwoDShape shape : shapes) {
            System.out.println(shape.toString() + "\n" +
                    "Area: " + shape.getArea() + "\n");
        }
    }
}
