package com.problemsolving.String.medium.StringToAtoi.brute;

public class StringToAtoi {
    /* Method to convert string to integer */
    public int myAtoi(String input) {
        int i = 0, n = input.length();

        /* Skip leading spaces */
        while (i < n && input.charAt(i) == ' ') {
            i += 1;
        }

        int sign = 1;
        if (i < n && input.charAt(i) == '-') {
            sign = -1;
            i += 1;
        } else if (i < n && input.charAt(i) == '+') {
            sign = 1;
            i += 1;
        }

        long result = 0;
        while (i < n && Character.isDigit(input.charAt(i))) {
            result = result * 10 + (input.charAt(i) - '0');
            i += 1;

            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) result * sign;
    }
}
