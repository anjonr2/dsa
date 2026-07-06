package com.problemsolving.twopintersandslidingwindow.medium.LongestSubStringWithoutRepeatingCharacters.brute;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatingCharacters {
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();

        int maxLength = 0;

        /* Iterate through all possible starting points of the substring */
        for (int i = 0; i < n; i += 1) {
            /*
             * hash to track characters in the current substring window
             * Assuming extended ASCII characters
             */
            int hash[] = new int[256];
            Arrays.fill(hash, 0);

            for (int j = i; j < n; j += 1) {

                /*
                 * If s.charAt(j) is already in the current substring window
                 */
                if (hash[s.charAt(j)] == 1)
                    break;

                /*
                 * Update the hash to mark s.charAt(j) as present in the current window
                 */
                hash[s.charAt(i)] = 1;

                /*
                 * Calculate the length of the current substring
                 */
                int length = j - i + 1;

                maxLength = Math.max(maxLength, length);
            }

        }
        return maxLength;
    }
}

/*
 * Time complexity : O(n^2)
 * Spacec complexity : O(256) hash array to store all characters
 */