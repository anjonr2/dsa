package com.problemsolving.BitManipulation.basics.DivideTwoNumbers.brute;

public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;

        boolean isPositive = !((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0));

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        while (n >= d) {
            // substract divisor from dividend
            n -= d;

            ans += 1;
        }

        if (ans > Integer.MAX_VALUE)
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        return isPositive ? (int) ans : (int) -ans;
    }
}

/*
 * Time complexity : In the worst case when the divisor is 1, the number of
 * iterations taken will be O(dividend)
 */