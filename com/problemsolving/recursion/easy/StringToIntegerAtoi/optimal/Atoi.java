package easy.StringToIntegerAtoi.optimal;

public class Atoi {
    static int helper(String s, int i, long num, int sign) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return (int) (num * sign);

        num = num * 10 + (s.charAt(i) - '0');
        if (sign * num <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (sign * num >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        helper(s, i + 1, num, sign);
    }

    static int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i += 1;
        }

        int sign = 1;
        while (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(n) == '-') ? -1 : 1;
            i += 1;
        }

        return helper(s, i, 0, sign);
    }
}

/*
 * Time Complexity : O(n) since each character is processed once
 * Space Complexity : O(n) since the recursion stack grows up to n calls
 * 
 * result = result * 10 + (s.charAt(i)-'0') is the corelogic to build a number
 * digit by digit from string
 * 
 * Suppose the input string is '482'
 * A computer reads this string character by character
 * '4'
 * '8'
 * '2'
 * 
 * | Character | ASCII Value |
 * | --------- | ----------- |
 * | `'0'` | 48 |
 * | `'1'` | 49 |
 * | `'2'` | 50 |
 * | `'8'` | 56 |
 * 
 * input.charAt(i) = '8'
 * '8' - '0'
 * =56 - 48
 * = 8
 * 
 * char ch = '5';
 * 
 * int digit = ch - '0';
 * 53 - 48 = 5
 * digit = 5
 */