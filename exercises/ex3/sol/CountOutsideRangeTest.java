import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOutsideRangeTest {

    // The following test achieves SC but not BC
    @Test
    public void testCountOutsideRangeWithin() {
        assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{4}, 1, 3));
    }


    // The following two test cases achieve full BC
    @Test
    public void testCountOutsideRangeEmptyArray() {
        assertEquals(0, CountOutsideRange.countOutsideRange(new int[]{}, 1, 2));
    }

    @Test
    public void testCountOutsideRangeBothWithinAndOutside() {
        assertEquals(1, CountOutsideRange.countOutsideRange(new int[]{1, 5}, 3, 6));
    }

    // Definitely need more test cases using BA, EP and EG

}
