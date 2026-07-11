package com.problemsolving.twopintersandslidingwindow.medium.LongestRepeatingCharacterReplacement.brute;

public class LongestRepeatingCharacterReplacement {
    /*
     * Function to find the longest substring with at most k character replaced
     */
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int maxLen = 0;

        // Iterate through each starting point of the substring
        for (int i = 0; i < n; i += 1) {

            // Initialize hash array for character frequency
            int hash[] = new int[26];

            /*
             * Variable to track the maximum frequency of any single character in the
             * current window
             */
            int maxFreq = 0;

            for (int j = i; j < n; j += 1) {

                /* Update the frequency of the current character in the hash array */
                hash[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

                int change = (j - i + 1) - maxFreq;

                if (change <= k) {
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
 * 
 * Space complexity : O(26)
 */