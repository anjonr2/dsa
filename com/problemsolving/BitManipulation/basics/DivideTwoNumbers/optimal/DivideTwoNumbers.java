package com.problemsolving.BitManipulation.basics.DivideTwoNumbers.optimal;

public class DivideTwoNumbers {
    /*
     * Function to divide two numbers
     * without multiplication and division
     */
    public int divide(int dividend, int divisor) {
        /* Edge cases */
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;

        /* variable to store sign of the result */
        boolean isPositive = true;

        if (dividend >= 0 && divisor < 0)
            isPositive = false;
        else if (dividend <= 0 && divisor > 0)
            isPositive = false;

        long n = dividend;
        long d = divisor;

        n = Math.abs(dividend);
        d = Math.abs(divisor);

        int ans = 0;

        while (n >= d) {
            int count = 0;

            /*
             * d << (count + 1) is equal to d * 2 ^ (count + 1)
             */
            while (n >= (d << (count + 1))) {
                count = count + 1;
            }

            /*
             * 1<< count is equal to (1 * 2^count)
             */
            ans += 1 << count;
            n -= d << count;
        }

        /*
         * Handling overflowing conditions
         * ans ==(1<<31) means if ans = 2^31 which is more than Integer.MAX_VALUE =
         * 2^31-1
         * 
         * so return Integer.MAX_VALUE instead
         */
        if (ans == (1 << 31) && isPositive)
            return Integer.MAX_VALUE;
        if (ans == (1 << 31) && !isPositive)
            return Integer.MIN_VALUE;

        return isPositive ? ans : -1 * ans;
    }
}

/*
 * Time complexity : O((logN)^2)
 * Where N is the absolute value of the dividend
 * 
 * The outer loop runs for O(logN) times
 * The inner loop runs for O(logN) times as well
 */