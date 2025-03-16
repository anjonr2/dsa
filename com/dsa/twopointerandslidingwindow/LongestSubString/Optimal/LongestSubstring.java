package com.dsa.twopointerandslidingwindow.LongestSubString.Optimal;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int first = 0;
        int second = 0;
        int result = 0;
        boolean[] count = new boolean[256];
        while (second < s.length()) {
            while (count[s.charAt(second)]) {
                count[s.charAt(first)] = false;
                first++;
            }
            count[s.charAt(second)] = true;
            result = Math.max(result, second - first + 1);
            second += 1;
        }
        return result;
    }
}
