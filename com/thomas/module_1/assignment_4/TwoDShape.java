package com.thomas.module_1.assignment_4;

@SuppressWarnings("unused")
public abstract class TwoDShape {/**
 * The width of the two-dimensional shape.
 */
private double width;

    /**
     * The height of the two-dimensional shape.
     */
    private double height;

    /**
     * The color of the two-dimensional shape.
     */
    private Colour colour = Colour.NONE;

    /**
     * Constructs a new TwoDShape object with the specified colour.
     * Sets the width and height to 1.
     *
     * @param colour The colour of the two-dimensional shape.
     */
    public TwoDShape(Colour colour) {
        width = 1;
        height = 1;
        this.colour = colour;
    }

    /**
     * Constructs a new TwoDShape object with the specified width and height.
     *
     * @param width The width of the two-dimensional shape.
     * @param height The height of the two-dimensional shape.
     */
    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the area of the two-dimensional shape.
     * This method is abstract and will be implemented by a subclass.
     *
     * @return The area of the two-dimensional shape.
     */
    public abstract double getArea();

    /**
     * Sets the width of the two-dimensional shape.
     *
     * @param width The width of the two-dimensional shape.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Sets the height of the two-dimensional shape.
     *
     * @param height The height of the two-dimensional shape.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the width of the two-dimensional shape.
     *
     * @return The width of the two-dimensional shape.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the height of the two-dimensional shape.
     *
     * @return The height of the two-dimensional shape.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the colour of the two-dimensional shape.
     *
     * @return The colour of the two-dimensional shape.
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * Returns a string representation of the TwoDShape object.
     *
     * @return A string representation of the TwoDShape object.
     */
    public String toString() {
        return "TwoDShape[width=" + width + ",height=" + height + "colour:" + colour + "]";
    }
}
