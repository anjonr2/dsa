package com.dsa.strings.longesthappyprefix;

public class LongestHappyPrefix {
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

    public String lps(String s) {
        int[] lps = computeLPS(s);
        return s.substring(0, lps[s.length() - 1]);
    }
}
