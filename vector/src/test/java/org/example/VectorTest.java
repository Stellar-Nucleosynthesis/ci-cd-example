package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VectorTest {
    private final double EPSILON = 0.000001;

    @Test
    @Tag("CreationTest")
    @DisplayName("Illegal dimensionality should be rejected")
    public void illegalDimensionRejectedTest() {
        assumeTrue(dimensionsSaved());
        assertThrows(IllegalArgumentException.class, () -> new Vector(-3));
    }

    @Test
    @Tag("CreationTest")
    @DisplayName("All of the vector's start values should be zero")
    public void initializationTest() {
        assumeTrue(dimensionsSaved());
        int dims = 10;
        Vector v = new Vector(dims);
        assertEquals(dims, v.dimensions());
        for (int i = 0; i < dims; i++) {
            assertEquals(0, v.get(i), EPSILON);
        }
    }

    @ParameterizedTest
    @Tag("AccessTest")
    @DisplayName("Changed coordinates' values should persist")
    @CsvSource({"5, 2, 8.0", "2, 0, 9.6", "3, 2, 7.4"})
    public void valueSavedCorrectlyTest(int dimensions, int index, double value) {
        assumeTrue(dimensionsSaved());
        Vector v = new Vector(dimensions);
        v.set(index, value);
        assertEquals(value, v.get(index), EPSILON);
    }

    @ParameterizedTest
    @Tag("AccessTest")
    @DisplayName("Accesses to illegal dimensions should not be allowed")
    @CsvSource({
            "3, -1",
            "4, 4",
            "5, 6",
            "0, 0",
    })
    public void
    illegalDimensionValueTest(int dimensions, int accessDimension) {
        assumeTrue(dimensionsSaved());
        Vector v = new Vector(dimensions);
        assertThrows(IndexOutOfBoundsException.class, () -> v.get(accessDimension));
    }

    @Test
    @Tag("OperatorTest")
    @DisplayName("Testing correct dot product calculation")
    public void dotProductCalculationTest() {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(3);
        v1.set(0, 2);
        v1.set(1, -3);
        v1.set(2, 4.5);
        Vector v2 = new Vector(3);
        v2.set(0, 9);
        v2.set(1, 2.4);
        v2.set(2, 0);
        assertEquals(10.8, Vector.dotProduct(v1, v2), EPSILON);
    }

    @Test
    @Tag("OperatorTest")
    @DisplayName("Testing dot product commutativity")
    public void dotProductCommutativityTest() {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(2);
        v1.set(0, 2);
        v1.set(1, -3);
        Vector v2 = new Vector(2);
        v2.set(0, 9);
        v2.set(1, 2.4);
        assertEquals(Vector.dotProduct(v1, v2), Vector.dotProduct(v2, v1), EPSILON);
    }

    @ParameterizedTest
    @Tag("OperatorTest")
    @DisplayName("Illegal dot product array sizes should be rejected")
    @CsvSource({"0, 4", "1, 5", "3, 2"})
    public void dotProductIllegalDimensionsTest(int dim1, int dim2) {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(dim1);
        Vector v2 = new Vector(dim2);
        assertThrows(IllegalArgumentException.class, () -> Vector.dotProduct(v1, v2));
    }

    @Test
    @Tag("OperatorTest")
    @DisplayName("Testing correct sum calculation")
    public void sumCalculationTest() {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(3);
        v1.set(0, 2);
        v1.set(1, -3);
        v1.set(2, 4.5);
        Vector v2 = new Vector(3);
        v2.set(0, 9);
        v2.set(1, 2.4);
        v2.set(2, 0);
        Vector expected = new Vector(3);
        expected.set(0, 11);
        expected.set(1, -0.6);
        expected.set(2, 4.5);
        Vector sum = Vector.sum(v1, v2);
        assertEquals(expected.get(0), sum.get(0), EPSILON);
        assertEquals(expected.get(1), sum.get(1), EPSILON);
        assertEquals(expected.get(2), sum.get(2), EPSILON);
    }

    @ParameterizedTest
    @Tag("OperatorTest")
    @DisplayName("Illegal sum array sizes should be rejected")
    @CsvSource({"0, 2", "3, 6", "4, 1"})
    public void sumIllegalDimensionsTest(int dim1, int dim2) {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(dim1);
        Vector v2 = new Vector(dim2);
        assertThrows(IllegalArgumentException.class, () -> Vector.sum(v1, v2));
    }

    @Test
    @Tag("OperatorTest")
    @DisplayName("Testing correct product calculation")
    public void productCalculationTest() {
        assumeTrue(dimensionsSaved());
        Vector v1 = new Vector(3);
        v1.set(0, 2);
        v1.set(1, -3);
        v1.set(2, 4.5);
        double multiplier = 2.5;
        Vector expected = new Vector(3);
        expected.set(0, 5);
        expected.set(1, -7.5);
        expected.set(2, 11.25);
        Vector prod = Vector.product(v1, multiplier);
        assertEquals(expected.get(0), prod.get(0), EPSILON);
        assertEquals(expected.get(1), prod.get(1), EPSILON);
        assertEquals(expected.get(2), prod.get(2), EPSILON);
    }

    private boolean dimensionsSaved() {
        Vector v1 = new Vector(3);
        Vector v2 = new Vector(0);
        return v1.dimensions() == 3 && v2.dimensions() == 0;
    }
}