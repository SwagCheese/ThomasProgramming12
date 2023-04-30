package com.thomas.module_1.assignment_1;

@SuppressWarnings("unused")
public class TwoDShape {
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

    public double getArea() {
        return width * height; // Calculate it as if it's a rectangle by default
    }

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
