package com.thomas.introduction;

@SuppressWarnings("unused")
class Circle {
    private double radius;

    public Circle() {
        // I guess just do a random radius if they don't supply one
        radius = Math.random();
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}