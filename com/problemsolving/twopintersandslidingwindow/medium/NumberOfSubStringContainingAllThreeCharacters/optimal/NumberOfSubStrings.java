package com.problemsolving.twopintersandslidingwindow.medium.NumberOfSubStringContainingAllThreeCharacters.optimal;

public class NumberOfSubStrings {
    /*
     * Function to find the number of substrings containing all three characters
     * 'a', 'b', 'c' in the string s
     */
    public int numberOfSubstrings(String s) {
        /*
         * Array to store last seen index of characters 'a', 'b', 'c'
         */
        int[] lastSeen = { -1, -1, -1 };

        int count = 0;

        int n = s.length();

        for (int i = 0; i < n; i += 1) {

            /* Update the last seen index */
            lastSeen[s.charAt(i) - 'a'] = i;

            /*
             * Check if all characters 'a', 'b', 'c' have been seen
             */
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }

        return count;
    }
}

/*
 * Time complexity : O(N)
 */