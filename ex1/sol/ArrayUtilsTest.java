import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    //1b - fault not executed
    @Test
    public void testFindLastNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.findLast(null, 3);});
    }


    //1c - fault executed but no error
    @Test
    public void testFindLastEmpty() {
        // For any input where y appears in the second or later position, there is no error. Also,
        // if x is empty, there is no error.
        assertEquals(-1, ArrayUtils.findLast(new int[]{}, 3));
    }

    //1d - fault and error but no failure
    @Test
    public void testFindLastNonExistent() {
        assertEquals(-1, ArrayUtils.findLast(new int[]{1, 2}, 3));
    }

    //1e - fault, error & failure
    @Test
    public void testFindLastExistsFirstElement() {
        assertEquals(0, ArrayUtils.findLast(new int[]{2, 3, 5}, 2));
    }

    //4b - fault not executed
    @Test
    public void testOddOrPosNull() {
        // Do not execute fault
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null);});
    }


    //4c - fault executed but no error
    @Test
    public void testOddOrPosAllPositives() {
        // Any nonempty x with only non-negative elements works, because the first part of the
        // compound if-test is not necessary unless the value is negative.
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{1, 2, 3}));
    }

    //4d (also 4e) - fault and error but no failure - not possible to write a test case that causes error but not failure
    // The reason is that error states are not repairable by subsequent processing.
    @Test
    public void testOddOrPositiveBothPositivesAndNegatives() {
        assertEquals(3, ArrayUtils.oddOrPos(new int[]{-3, -2, 0, 1, 4}));
    }

    
    //5b - does not reach the fault
    @Test
    public void testFindLengthNull() {
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(null, 0)});
    }

    //5c - fault but no error
    @Test
    public void testFindLengthNull() {
        // any test case where all elements of nums are greater than k
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(new int[]{3, 4, 5}), 2)});
    }

    //5c - fault & error but no failure
    @Test
    public void testFindLengthNull() {
        // any test case where all elements of nums are greater than k
        assertThrows(NullPointerException.class, () -> {ArrayUtils.oddOrPos(new int[]{3, 4, 5}), 2)});
    }

}
