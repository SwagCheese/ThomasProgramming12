package com.thomas.module_1.assignment_2;

@SuppressWarnings("unused")
public abstract class TwoDShape {
    private double width;
    private double height;

    public TwoDShape() {
        width = 1;
        height = 1;
    }

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public abstract double getArea(); // We do not know what type of shape it is, and leave it to another class to implement this method

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return "TwoDShape[width=" + width + ",height=" + height + "]";
    }
}
