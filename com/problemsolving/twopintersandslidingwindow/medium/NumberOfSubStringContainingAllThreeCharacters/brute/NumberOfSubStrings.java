package com.problemsolving.twopintersandslidingwindow.medium.NumberOfSubStringContainingAllThreeCharacters.brute;

public class NumberOfSubStrings {
    /*
     * Function to find the number of substrings containing all three characters
     * 'a', 'b' and 'c' in string s
     */
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int count = 0;

        /* Iterate through each starting point of the substring */
        for (int i = 0; i < n; i += 1) {
            /* Array to track presence of 'a', 'b', 'c' */
            int hash[] = new int[3];

            /* Iterate through each ending point of the subarray */
            for (int j = i; j < n; j += 1) {
                /* Mark the current character in the hash */
                hash[s.charAt(j) - 'a'] = 1;

                /* Check if all characters 'a', 'b', 'c' are present */
                if (hash[0] + hash[1] + hash[2] == 3) {
                    /* Increment count for valid substring */
                    count += 1;
                }
            }
        }
        return count;
    }
}

/*
 * Time complexity : O(N^2)
 */