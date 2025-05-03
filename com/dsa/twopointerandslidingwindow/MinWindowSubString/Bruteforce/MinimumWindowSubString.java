package com.dsa.twopointerandslidingwindow.MinWindowSubString.Bruteforce;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int startingIndex = -1;
        int n = s.length(), m = t.length();
        for (int i = 0; i < n; i++) {
            int hash[] = new int[256];
            for (char c : t.toCharArray()) {
                hash[c] += 1;
            }
            int count = 0;
            for (int j = i; j < n; j += 1) {
                if (hash[s.charAt(j)] > 0) {
                    count += 1;
                }
                hash[s.charAt(j)] -= 1;
                if (count == m) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        startingIndex = i;
                        break;
                    }
                }
            }
        }
        return startingIndex == -1 ? "" : s.substring(startingIndex, minLength);
    }
}
