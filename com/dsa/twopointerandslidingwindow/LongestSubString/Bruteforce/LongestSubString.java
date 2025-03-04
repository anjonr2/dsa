package com.dsa.twopointerandslidingwindow.LongestSubString.Bruteforce;

import java.util.HashSet;

public class LongestSubString {
    public static boolean isUniqueWithinRange(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isUniqueWithinRange(s, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}
