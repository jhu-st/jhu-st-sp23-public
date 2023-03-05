public class ArrayUtils {

    /**
     * Count positive elements
     * *
     * @param x array to search
     * @return count of positive elements in x
     * @throws NullPointerException if x is null
     */
    public static int countPositive (Integer[] x) {
        int count = 0;
        for (int i=0; i < x.length; i++) {
            if (x[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    public static int countOutsideRange(Integer arr[], int r1, int r2) {
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < r1 || arr[i] > r2) {
                count++;
            }
        }
        return count;
    }
}
