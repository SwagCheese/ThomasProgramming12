package com.thomas.module_1.assignment_4;

/**
 * A class that represents a circle in two-dimensional space.
 */
@SuppressWarnings("unused")
public class Circle extends TwoDShape {

    /** The value of PI to be used in calculations. */
    public static final double PI = 3.141592653589793; // not sure why we don't just use Math.PI but this is what the instructions say

    /** The radius of the circle. */
    private double radius;

    /**
     * Constructs a circle with the specified radius and no colour.
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        super(Colour.NONE);
        this.radius = radius;
    }

    /**
     * Constructs a circle with the specified radius and colour.
     *
     * @param radius the radius of the circle
     * @param colour the colour of the circle
     */
    public Circle(double radius, Colour colour) {
        super(colour);
        this.radius = radius;
    }

    /**
     * Returns the area of the circle.
     *
     * @return the area of the circle
     */
    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius the new radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns a string representation of the circle, including its radius and colour.
     *
     * @return a string representation of the circle
     */
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ",colour=" + getColour() + "]";
    }
}
