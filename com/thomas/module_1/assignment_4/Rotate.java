package com.thomas.module_1.assignment_4;

/**
 This interface provides methods to rotate an object
 */
@SuppressWarnings("unused")
public interface Rotate {
    /**
     * Rotates the object by 90 degrees.
     */
    void rotate90();

    /**
     * Rotates the object by 180 degrees.
     */
    void rotate180();

    /**
     * Rotates the object by the specified degree.
     * @param degree the degree to rotate the object by
     */
    void rotate(double degree);

}