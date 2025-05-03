package com.dsa.twopointerandslidingwindow.MinWindowSubString.Optimal;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int startingIndex = -1;
        int right = 0, left = 0;
        int n = s.length(), m = t.length();
        int hash[] = new int[256];
        for (char c : t.toCharArray()) {
            hash[c] += 1;
        }
        int count = 0;
        while (right < n) {
            if (hash[s.charAt(right)] > 0) {
                count += 1;
            }
            hash[s.charAt(right)] -= 1;
            while (count == m) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startingIndex = left;
                }
                // shrink the window from left
                hash[s.charAt(left)] += 1;
                if (hash[s.charAt(left)] > 0) {
                    count -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        return startingIndex == -1 ? "" : s.substring(startingIndex, minLength);
    }
}
