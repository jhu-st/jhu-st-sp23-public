public class ArrayUtils {

    /* INSTRUCTIONS: For the following four methods:
       (a) Explain what is wrong with the given code. Describe the fault precisely by proposing a modification to the code.
       (b) If possible, give a test case that does not execute the fault. If not, briefly explain why not.
       (c) If possible, give a test case that executes the fault, but does not result in an error state. If not, briefly explain why not.
       (d) If possible give a test case that results in an error state, but not a failure. Hint: Don't forget about the program counter. If not, briefly explain why not.
       (e) For the given test case, describe the first error state as well as failure (if any). Be sure to describe the complete state.
       (f) Implement your repair and verify that the given test now produces the expected output.
       (g) Implement test cases developed in steps (b) through (e) in JUnit as separate test cases.
    */

    /**
     * Find last index of element
     *
     * @param x array to search
     * @param y value to look for
     * @return last index of y in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    // test: x = [2, 3, 5]; y = 2; Expected = 0
    public static int findLast (int[] x, int y) {
        for (int i=x.length-1; i > 0; i--) {
            if (x[i] == y) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find last index of zero
     *
     * @param x array to search
     * @return last index of 0 in x; -1 if absent
     * @throws NullPointerException if x is null
     */
    // test: x = [0, 1, 0]; Expected = 2
    public static int lastZero (int[] x)  {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Count positive elements
     * *
     * @param x array to search
     * @return count of positive elements in x
     * @throws NullPointerException if x is null
     */
    // test: x = [-4, 2, 0, 2]; Expected = 2
    public static int countPositive (int[] x) {
        int count = 0;
        for (int i=0; i < x.length; i++) {
            if (x[i] >= 0) {
                count++;
            }
        }
        return count;
    }


    /**
     * Count odd or positive elements
     *
     * @param x array to search
     * @return count of odd/positive values in x
     * @throws NullPointerException if x is null
     */
    // test: x = [-3, -2, 0, 1, 4]; Expected = 3
    public static int oddOrPos(int[] x) {
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i]%2 == 1 || x[i] > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Find the length of the longest subarray with a sum less than or equal to k
     *
     * @param nums the array of integers
     * @param k the target number which must not be exceeded
     * @return the length of the longest subarray within nums such that the sum of elements of the subarray is less than or equal to k
     * @throws NullPointerException if nums is null
     */
    // test: nums = [-2, 0, 4, 5, 6] and k = 4; Expected = 3 (i.e., length of [-2, 0, 4] which is 3)
    public static int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left);
        }
        return ans;
    }

}
