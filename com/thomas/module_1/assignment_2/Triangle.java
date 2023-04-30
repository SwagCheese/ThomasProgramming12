package com.thomas.module_1.assignment_2;


@SuppressWarnings("unused")
public class Triangle extends TwoDShape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height) {
        super(width, height);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        setWidth(side3);
        setHeight(heronsHeight());
    }

    @Override
    public double getArea() {
        return 0.5 * getWidth() * getHeight();
    }

    private double heronsHeight() {
        double s = (side1 + side2 + side3) / 2;

        return (2 * Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))) / side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
        setHeight(heronsHeight());
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
        setHeight(heronsHeight());
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
        setHeight(heronsHeight());
    }

    @Override
    public String toString() {
        if (side1 == 0 && side2 == 0 && side3 == 0) {
            return "Triangle[width=" + getWidth() + ",height=" + getHeight() + "]"; // this runs if the side lengths were not set
        }

        return "Triangle[side1=" + side1 + ",side2=" + side2 + ",side3=" + side3 + "]";
    }
}
