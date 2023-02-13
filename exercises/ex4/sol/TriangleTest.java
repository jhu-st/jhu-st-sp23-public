import jhu.cs422.Triangle;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("all")
public class TriangleTest {

    // partitioning on the output domain here. Note you could do partitioning
    // on input space too e.g. negative, zero, and positive for each of a, b and c
    // 1) invalid
    // 2) scalene
    // 3) isosceles
    // 4) equilateral

    // 1)
    @Tag("EP")
    @Test
    public void testTriangleIvalid() {
        assertEquals(0 , Triangle.triangle(-1, -2, -3));
    }

    // 2)
    @Tag("EP")
    @Test
    public void testTriangleScalene() {
        assertEquals(1 , Triangle.triangle(2, 3, 4));
    }

    // 3)
    @Tag("EP")
    @Test
    public void testTriangleIsosceles() {
        assertEquals(2 , Triangle.triangle(2, 2, 3));
    }

    // 4)
    @Tag("EP")
    @Test
    public void testTriangleEquilateral() {
        assertEquals(3 , Triangle.triangle(1, 1, 1));
    }


    // Boundary Analysis: test values 0, -1, MAX_INT, MIN_INT etc.

    // Expected v Actual Discrepancy detected: Does not rule out "all values set to zero" as invalid.
    @Test
    @Tag("BA")
    public void testTriangleIvalidABCZeros() {
        assertEquals(0 , Triangle.triangle(0, 0, 0));
    }

    @Tag("BA")
    @Test
    public void testTriangleIvalidABZeros() {
        assertEquals(0 , Triangle.triangle(0, 0, 1));
    }

    @Tag("BA")
    @Test
    public void testTriangleIvalidACZeros() {
        assertEquals(0 , Triangle.triangle(1, 0, 1));
    }


    @Tag("BA")
    @Test
    public void testTriangleIvalidCZero() {
        assertEquals(0 , Triangle.triangle(1, 1, 0));
    }

    @Tag("BA")
    @Test
    public void testTriangleIvalidAZero() {
        assertEquals(0 , Triangle.triangle(0, 1, 1));
    }

    // Expected v Actual Discrepancy detected: Does not rule out "all values set to -1" as invalid.
    @Tag("BA")
    @Test
    public void testTriangleIvalidABCNegativeEqual() {
        assertEquals(0 , Triangle.triangle(-1, -1, -1));
    }

    // Passes!
    @Tag("BA")
    @Test
    public void testTriangleIvalidABCNegativeNotEqual() {
        assertEquals(0 , Triangle.triangle(-1, -2, -3));
    }

    // Expected v Actual Discrepancy detected: Does not rule out "all values set to -2" as invalid.
    // At this point, it seems the check for equilateral is done before check for invalidity
    @Tag("BA")
    @Test
    public void testTriangleIvalidABCNegativeEqual2() {
        assertEquals(0 , Triangle.triangle(-2, -2, -2));
    }



    // Now, let us do some testing on boundary analysis on:
    // a > b+c, c > b+a, and b > a+c

    // 1. a + b is equal c
    @Tag("BA")
    @Test
    public void testTriangleIvalidAPlusBIsC() {
        assertEquals(0 , Triangle.triangle(1, 2, 3));
    }

    // 1. a + b is equal c
    // Expected v Actual Discrepancy detected: Does not rule out  as invalid whe
    // a plus c is equal to b

    @Tag("BA")
    @Test
    public void testTriangleIvalidAPlusCIsB() {
        assertEquals(0 , Triangle.triangle(1, 3, 2));
    }

    // 1. a + b is equal c

    @Tag("BA")
    @Test
    public void testTriangleIvalidBPlusCIsA() {
        assertEquals(0 , Triangle.triangle(3, 1, 2));
    }


    // SUMMARY
    // At least three possible issues (faults):
    // 1: check for equilateral comes before check for invalid based on zero
    // 2: check for equilateral comes before check for invalid based on negative
    // 3: if a+c is equal to b, it does not return invalid



}