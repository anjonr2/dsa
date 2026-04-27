package com.problemsolving.String.medium.LongestPalindrome;

public class LongestPalindrome {
    int max = 0, start = 0, end = 0;

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i += 1) {
            for (int j = i; j < n; j += 1) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
