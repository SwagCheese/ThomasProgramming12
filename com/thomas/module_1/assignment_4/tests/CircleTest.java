package com.thomas.module_1.assignment_4.tests;

import com.thomas.module_1.assignment_4.Circle;
import com.thomas.module_1.assignment_4.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {
    /**
     * Test area with zero radius.
     */
    @Test
    public void testAreaWithZeroRadius() {
        assertEquals(0, new Circle(0, Colour.RED).getArea());
        assertEquals(0, new Circle(0).getArea());
    }

    /**
     * Test area with positive radius.
     */
    @Test
    public void testAreaWithPositiveRadius() {
        assertEquals(Math.PI, new Circle(1, Colour.RED).getArea(), 0.001);
        assertEquals(4 * Math.PI, new Circle(2).getArea(), 0.001);
        assertEquals(9 * Math.PI, new Circle(3, Colour.BLUE).getArea(), 0.001);
    }

    /**
     * Test area with negative radius.
     */
    @Test
    public void testAreaWithNegativeRadius() {
        assertEquals(Math.PI, new Circle(-1, Colour.RED).getArea(), 0.001);
        assertEquals(4 * Math.PI, new Circle(-2).getArea(), 0.001);
        assertEquals(9 * Math.PI, new Circle(-3, Colour.BLUE).getArea(), 0.001);
    }

    /**
     * Test area with large radius.
     */
    @Test
    public void testAreaWithLargeRadius() {
        assertEquals(Double.POSITIVE_INFINITY, new Circle(Double.POSITIVE_INFINITY).getArea(), 0.001);
    }

    /**
     * Test area with na n radius.
     */
    @Test
    public void testAreaWithNaNRadius() {
        assertEquals(Double.NaN, new Circle(Double.NaN).getArea(), 0.001);
    }

    /**
     * Test area with infinite radius.
     */
    @Test
    public void testAreaWithInfiniteRadius() {
        assertEquals(Double.POSITIVE_INFINITY, new Circle(Double.POSITIVE_INFINITY, Colour.GREEN).getArea(), 0.001);
    }
}
