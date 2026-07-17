package com.problemsolving.twopintersandslidingwindow.hard.MinimumWindowSubString.brute;

public class MinimumWindowSubString {
    /*
     * Function to find the minimum length substring in string s that contains all
     * characters from string t
     */
    public String minWindow(String s, String t) {
        /*
         * Variable to store minimum length of the substring found
         */
        int minLength = Integer.MAX_VALUE;

        /*
         * Variable to store the starting index of the minimum length substring
         */
        int sIndex = -1;

        for (int i = 0; i < s.length(); i += 1) {

            // Array to count frequencies of characters in t
            int hash[] = new int[256];

            for (char c : t.toCharArray()) {
                hash[c] += 1;
            }

            int count = 0;

            for (int j = i; j < s.length(); j += 1) {
                if (hash[s.charAt(j)] > 0) {
                    count += 1;
                }
                hash[s.charAt(j)] -= 1;

                /*
                 * If all the characters from t are found in the current window
                 */
                if (count == t.length()) {
                    if (j - i + 1 < minLength) {
                        sIndex = i;
                        minLength = j - i + 1;
                    }
                    break;
                }
            }
        }

        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLength);
    }
}

/*
 * Time complexity : O(N^2)
 * Space complexity : O(256)
 */