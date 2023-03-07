public class MathUtils {

    /**
     * This returns the slope of the given points.
     * @param x1 the first x to use
     * @param x2 the end x to use
     * @param y1 the begin y to use
     * @param y2 the end y to use
     * @return the slope of the given points
     */
    public static double slope(double x1, double x2, double y1, double y2) {
        return (y2 - y1) / (x1 - x2);
    }


    /**
     * This returns the squared root mean squared error of two data sets
     * @param real the real values
     * @param predicted the predicted values
     * @return the root means squared error for two data sets
     */
    public static double rootMeansSquaredError(double[] real, double[] predicted) {
        double ret = 0.0;
        for(int i = 0; i < real.length; i++) {
            ret = Math.pow((real[i]-predicted[i]), 2);
        }
        return Math.sqrt(ret / real.length);
    }


    /**
     * This returns the sum of squares for a given vector.
     *
     * @param vector the vector to obtain the sum of squares for
     * @return the sum of squares for vector
     */
    public static double sumOfSquares(double[] vector) {
        double ret = 0;
        for(double d : vector) ret = Math.pow(d, 2);
        return ret;
    }

    /**
     * This returns the given column over n arrays
     * @param column the column to getFromOrigin values for
     * @param nums the arrays to extract values from
     * @return a double array containing all of the numbers in that column
     * for all of the arrays.
     * @throws IllegalArgumentException if the index is invalid
     */
    public static double[] getColumn(int column, double[] ... nums) {
        double[] ret = new double[nums.length];
        for(int i = 0; i < nums.length; i++) {
            double[] curr = nums[i];
            ret[i] = curr[column];
        }
        return ret;
    }


    /**
     * Normalizes the doubles in the array using a given value.
     *
     * @param doubles the array of double
     * @param sum the value by which the doubles are to be normalized
     * @exception IllegalArgumentException if sum is zero or NaN
     */
    public static void normalize(double[] doubles, double sum) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] /= sum;
        }
    }

    /**
     * This returns the entropy for a given vector of probabilities.
     * entropy = -sum (p_i * log(p_i))
     * @param probabilities a list of probabilities, probabilities should be valid values in the range (0, 1)
     * @return the entropy of the given probabilities.
     */
    public static double calEntropy(double[] probabilities) {
        double total = 0.0;
        for (double d : probabilities) {
            total += (Math.log(d) * d);
        }
        return total;
    }

}
