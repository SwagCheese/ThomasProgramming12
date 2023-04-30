package com.thomas.module_1.assignment_4.tests;

import com.thomas.module_1.assignment_4.Colour;
import com.thomas.module_1.assignment_4.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
    /**
     * Test get area with zero length.
     */
    @Test
    public void testGetAreaWithZeroLength() {
        assertEquals(0, new Triangle(0, 10, Colour.GREEN).getArea());
        assertEquals(0, new Triangle(10, 0, Colour.RED).getArea());
        assertEquals(0, new Triangle(0, 0, Colour.BLUE).getArea());
    }

    /**
     * Test get area with negative length.
     */
    @Test
    public void testGetAreaWithNegativeLength() {
        assertEquals(-100, new Triangle(-10, 20, Colour.RED).getArea());
        assertEquals(-100, new Triangle(10, -20, Colour.GREEN).getArea());
        assertEquals(100, new Triangle(-10, -20, Colour.NONE).getArea());
    }

    /**
     * Test get area with non triangle.
     */
    @Test
    public void testGetAreaWithNonTriangle() {
        assertEquals(0, new Triangle(10, 20, 30, Colour.GREEN).getArea());
        assertEquals(0, new Triangle(1, 2, 3).getArea());
    }

    /**
     * Test get area with decimal length.
     */
    @Test
    public void testGetAreaWithDecimalLength() {
        assertEquals(10, new Triangle(2.5, 8, Colour.RED).getArea());
        assertEquals(20.9998, new Triangle(6, 7, 9.2).getArea(), 0.0001);
    }

    /**
     * Test get area with large values.
     */
    @Test
    public void testGetAreaWithLargeValues() {
        assertEquals(1000000000, new Triangle(100000, 20000, Colour.NONE).getArea());
        assertEquals(250000000, new Triangle(500000, 1000).getArea());
    }

    /**
     * Test get area with all equal lengths.
     */
    @Test
    public void testGetAreaWithAllEqualLengths() {
        assertEquals(84.8705, new Triangle(14, 14, 14, Colour.BLUE).getArea(), 0.0001);
        assertEquals(0.5239, new Triangle(1.1, 1.1, 1.1).getArea(), 0.0001);
    }

    /**
     * Test herons height equal sides.
     */
    @Test
    public void testHeronsHeightEqualSides() {
        assertEquals(1.7321, new Triangle(2, 2, 2, Colour.RED).heronsHeight(), 0.0001);
        assertEquals(2.5981, new Triangle(3, 3, 3, Colour.RED).heronsHeight(), 0.0001);
        assertEquals(3.4641, new Triangle(4, 4, 4, Colour.RED).heronsHeight(), 0.0001);
    }

    /**
     * Test herons height negative length.
     */
    @Test
    public void testHeronsHeightNegativeLength() {
        assertEquals(-1.4524, new Triangle(-2, -3, -4, Colour.RED).heronsHeight(), 0.0001);
    }

    /**
     * Test herons height zero length.
     */
    @Test
    public void testHeronsHeightZeroLength() {
        assertEquals(0, new Triangle(0, 0, 0, Colour.GREEN).heronsHeight());
    }
}