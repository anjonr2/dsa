package com.dsa.stack.ShortestPalindrome;

public class ShortestPalindrome {
    private int[] computeLPS(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int prefixPtr = 0, suffixPtr = 1;
        while (suffixPtr < n) {
            if (s.charAt(prefixPtr) == s.charAt(suffixPtr)) {
                lps[suffixPtr] = prefixPtr + 1;
                prefixPtr += 1;
                suffixPtr += 1;
            } else {
                while (prefixPtr > 0 && s.charAt(prefixPtr) != s.charAt(suffixPtr)) {
                    prefixPtr = lps[prefixPtr - 1];
                }
                if (s.charAt(prefixPtr) == s.charAt(suffixPtr)) {
                    lps[suffixPtr] = prefixPtr + 1;
                    prefixPtr += 1;
                }
                suffixPtr += 1;
            }
        }
        return lps;
    }

    /*
     * Function to find shortest palindrome
     * by inserting charaters at the front of the string
     */
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();

        String str = s + '$' + rev;
        int[] lps = computeLPS(str);
        int ans = s.length() - lps[str.length() - 1];
        String toAdd = str.subString(0, ans);
        return toAdd + s;
    }
}
