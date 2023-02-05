package lab5;

/**
 * Starter code for lab 5.
 * @author Travis Martin & David Johnson
 */
public class TrickyMethods {
    /**
     * A generic version of firstDoublingOverFifty, from A2, which allows for
     * parameterizing the multiplier (instead of just 2) and the threshold (instead of just 50).
     * If the input parameters would result in multiplying forever, this method returns 0 
     * instead (as described below).
     * 
     * @param originalNumber the input number to be multiplied. Should be > 0,
     *                       or else this method returns 0
     * @param multiplier the number that inputNumber should be repeatedly multiplied by.
     *                   Can be any value (including negative values),
     *                   if it is -1, 0, or 1 then this method returns 0
     * @param threshold the number above which the repeated multiplication should stop.
     * @return multiplies originalNumber by multiplier until it is above (and not equal to)
     *         threshold, and returns the first value reached above threshold. If an invalid
     *         parameter is passed in, this method returns 0. If originalNumber starts out
     *         above threshold, then originalNumber should be returned
     */
    public static int multiplyUntilAboveThreshold(int originalNumber, int multiplier, int threshold) {
        if (originalNumber <= 0) {
            return 0;
        }
        if (multiplier == -1 || multiplier == 0 || multiplier == 1) {
            return 0;
        }
        int multipliedNumber = originalNumber;
        while (multipliedNumber <= threshold) {
            multipliedNumber *= multiplier;
        }
        return originalNumber;
    }
}
