package com.problemsolving.twopintersandslidingwindow.medium.LongestRepeatingCharacterReplacement.better;

public class LongestRepeatingCharacterReplacement {
    /*
     * Function to find longest substring with at most k character replaced
     */
    public int characterReplacement(String s, int k) {

        int n = s.length();

        /* variable to store maximum length of the substring found */
        int maxLen = 0;

        /*
         * Variable to track the maximum frequency of any single character in the
         * current window
         */
        int maxFreq = 0;

        /*
         * Pointers to maintain current window [l, r]
         */
        int l = 0, r = 0;

        /*
         * Hash array to count frequencies of characters
         */
        int hash[] = new int[26];

        while (r < n) {

            hash[s.charAt(r) - 'A'] += 1;

            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            /* check if the window is valid */
            while ((r - l + 1) - Math.max(maxFreq, hash[s.charAt(r) - 'A']) > k) {
                /* slide the left pointer to make the window valid again */
                hash[s.charAt(l) - 'A'] -= 1;

                maxFreq = 0;

                for (int i = 0; i < 26; i += 1) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }

                /* move the left pointer forward */
                l += 1;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r += 1;
        }
        return maxLen;
    }
}
