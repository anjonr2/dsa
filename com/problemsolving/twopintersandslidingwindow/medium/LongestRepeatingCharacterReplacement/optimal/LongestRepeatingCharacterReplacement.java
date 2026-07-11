package com.problemsolving.twopintersandslidingwindow.medium.LongestRepeatingCharacterReplacement.optimal;

public class LongestRepeatingCharacterReplacement {
    /*
     * Function to find longest substring with at most k character replaced
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int maxLen = 0;

        int maxFreq = 0;

        int l = 0, r = 0;

        int hash[] = new int[26];

        while (r < n) {
            hash[s.charAt(r) - 'A'] += 1;

            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            if ((r - l + 1) - Math.max(maxFreq, hash[s.charAt(r) - 'A']) > k) {
                hash[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r += 1;
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(N)
 * 
 * Space complexity : O(26)
 */