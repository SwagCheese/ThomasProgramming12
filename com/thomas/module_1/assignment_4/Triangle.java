package com.thomas.module_1.assignment_4;

/**
 * The Triangle class is a subclass of TwoDShape and implements the Rotate interface.
 */
@SuppressWarnings("unused")
public class Triangle extends TwoDShape implements Rotate {
    private double side1; // the length of the first side of the triangle
    private double side2; // the length of the second side of the triangle
    private double side3; // the length of the third side of the triangle

    private double rotationDegrees = 0; // the degree of rotation of the triangle

    /**
     * Instantiates a new Triangle with the given width and height.
     *
     * @param width  the width of the triangle
     * @param height the height of the triangle
     */
    public Triangle(double width, double height) {
        super(width, height);
    }

    /**
     * Instantiates a new Triangle with the given width, height and colour.
     *
     * @param width  the width of the triangle
     * @param height the height of the triangle
     * @param colour the colour of the triangle
     */
    public Triangle(double width, double height, Colour colour) {
        super(colour);

        setWidth(width);
        setHeight(height);
    }

    /**
     * Instantiates a new Triangle with the given side lengths.
     *
     * @param side1 the length of the first side of the triangle
     * @param side2 the length of the second side of the triangle
     * @param side3 the length of the third side of the triangle
     */
    public Triangle(double side1, double side2, double side3) {
        super(Colour.NONE);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setWidth(side3);
        setHeight(heronsHeight());
    }

    /**
     * Instantiates a new Triangle with the given side lengths and colour.
     *
     * @param side1  the length of the first side of the triangle
     * @param side2  the length of the second side of the triangle
     * @param side3  the length of the third side of the triangle
     * @param colour the colour of the triangle
     */
    public Triangle(double side1, double side2, double side3, Colour colour) {
        super(colour);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setWidth(side3);
        setHeight(heronsHeight());
    }

    /**
     * Computes and returns the area of the triangle.
     *
     * @return the area of the triangle
     */
    @Override
    public double getArea() {
        return 0.5 * getWidth() * getHeight();
    }

    /**
     * Computes and returns the height of the triangle using Heron's formula.
     * In the course it specified to make this private, however I can't test it unless it is public
     *
     * @return the height of the triangle
     */
    public double heronsHeight() {
        double s = (side1 + side2 + side3) / 2;

        double length = (2 * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))) / side3;

        return (Double.isNaN(length)) ? 0 : length;
    }

    /**
     * Gets side 1.
     *
     * @return the length of the first side
     */
    public double getSide1() {
        return side1;
    }

    /**
     * Sets the length of the first side.
     *
     * @param side1 the length of the first side
     */
    public void setSide1(double side1) {
        this.side1 = side1;
        setHeight(heronsHeight());
    }

    /**
     * Gets side 2.
     *
     * @return the length of the second side
     */
    public double getSide2() {
        return side2;
    }

    /**
     * Sets the length of the second side.
     *
     * @param side2 the length of the second side
     */
    public void setSide2(double side2) {
        this.side2 = side2;
        setHeight(heronsHeight());
    }

    /**
     * Gets side 3.
     *
     * @return the length of the third side
     */
    public double getSide3() {
        return side3;
    }

    /**
     * Sets the length of the third side.
     *
     * @param side3 the length of the third side
     */
    public void setSide3(double side3) {
        this.side3 = side3;
        setHeight(heronsHeight());
    }

    /**
     * Gets rotation degrees.
     *
     * @return the rotation degrees
     */
    public double getRotationDegrees() {
        return rotationDegrees;
    }

    /**

     Rotates the triangle by 90 degrees.
     */
    @Override
    public void rotate90() {
        rotate(90);
    }

    /**
     Rotates the triangle by 180 degrees.
     */
    @Override
    public void rotate180() {
        rotate(180);
    }

    /**
     Rotates the triangle by a given number of degrees.

     @param degree The number of degrees to rotate the triangle by.
     */
    @Override
    public void rotate(double degree) {
        rotationDegrees = (rotationDegrees + degree) % 360;
    }

    /**
     Returns a string representation of the triangle.

     @return A string representation of the triangle.
     */
    @Override
    public String toString() {
        if (side1 == 0 && side2 == 0 && side3 == 0) {
            return "Triangle[width=" + getWidth() + ",height=" + getHeight() + ",rotation=" + rotationDegrees + ",colour=" + getColour() + "]"; // this runs if the side lengths were not set
        }

        return "Triangle[side1=" + side1 + ",side2=" + side2 + ",side3=" + side3 + ",rotation=" + rotationDegrees + ",colour=" + getColour() + "]";
    }
}
