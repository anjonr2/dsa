package com.problemsolving.String.medium.StringToAtoi.recursive;

public class StringToAtoi {
    static int helper(String s, int i, long num, int sign) {
        /* Base case */
        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int) (sign * num);

        /* Update the number */
        num = num * 10 + (s.charAt(i) - '0');

        if (num * sign <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (num * sign >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return helper(s, i + 1, num, sign);
    }

    static int myAtoi(String s) {
        int i = 0;

        /* Skip white spaces */
        while (i < s.length() && s.charAt(i) == ' ')
            i += 1;

        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i += 1;
        }

        return helper(s, i, 0, sign);
    }
}
