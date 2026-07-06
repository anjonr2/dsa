package com.problemsolving.twopintersandslidingwindow.medium.LongestSubStringWithoutRepeatingCharacters.optimal;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatingCharacters {
    /*
     * Function to find the longest substring without repeating characters
     */
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();

        // Assuming All ASCII characters
        final int HashLen = 256;

        /* Hash table to store last occurrence of each character */
        int hash[] = new int[HashLen];

        /*
         * Initialize hash table with -1 (indicating no occurrence)
         */
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;

        while (r < n) {
            /*
             * If the current character s.charAt(r)
             * is already in the substring
             */
            if (hash[s.charAt(r)] != -1) {
                /*
                 * Move left pointer to the right of the last occurrence of s.charAt(r)
                 */
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }

            // Calculate the current substring length
            int length = r - l + 1;

            // Update the maximum length found so far
            maxLen = Math.max(maxLen, length);

            /*
             * Store the index of the current character in the hash table
             */
            hash[s.charAt(r)] = r;

            r += 1;
        }

        return maxLen;
    }
}
