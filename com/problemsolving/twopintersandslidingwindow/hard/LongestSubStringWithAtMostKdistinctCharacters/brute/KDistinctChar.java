package com.problemsolving.twopintersandslidingwindow.hard.LongestSubStringWithAtMostKdistinctCharacters.brute;

import java.util.HashMap;

public class KDistinctChar {
    /*
     * Function to find the maximum length of substring with at most k distinct
     * characters
     */
    public int kDistinctChar(String s, int k) {

        /*
         * Variable to store maximum length of the substring
         */
        int maxLen = 0;

        /*
         * Map to track count of each character in the current window
         */
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();

        /*
         * Iterate through each starting point of the substring
         */
        for (int i = 0; i < n; i += 1) {
            /* Clear the map for a new starting point */
            map.clear();

            for (int j = i; j < n; j += 1) {

                // Add the current character to the map
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                /* Check if the number of distinct character is within limit */
                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(N^2)
 * Space complexity : O(K), as at most the map data structure is holding k
 * elements
 */