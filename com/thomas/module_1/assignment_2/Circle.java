package com.thomas.module_1.assignment_2;

@SuppressWarnings("unused")
public class Circle extends TwoDShape {
    public static final double PI = 3.141592653589793; // not sure why we don't just use Math.PI but this is what the instructions say

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
