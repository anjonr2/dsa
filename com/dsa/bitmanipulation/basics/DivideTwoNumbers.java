package com.dsa.bitmanipulation.basics;

/*Divide two numbers without multiplication and division */
public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1)
            return dividend;

        // variable to store the sign of the result
        boolean isPositive = true;

        if (dividend >= 0 && divisor < 0)
            isPositive = false;
        else if (dividend <= 0 && divisor > 0)
            isPositive = false;

        long numerator = dividend;
        long denominator = divisor;

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        int ans = 0;
        while (numerator >= denominator) {
            int cnt = 0;
            while (numerator >= (denominator << (cnt + 1))) {
                cnt += 1;
            }
            ans += (1 << cnt);
            numerator -= (denominator << cnt);
        }
        return isPositive ? ans : -ans;
    }
}
