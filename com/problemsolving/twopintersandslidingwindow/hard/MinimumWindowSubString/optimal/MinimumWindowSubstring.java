package com.problemsolving.twopintersandslidingwindow.hard.MinimumWindowSubString.optimal;

public class MinimumWindowSubstring {
    /*
     * Function to find the minimum length substring in string s that contains all
     * characters from string t
     */
    public String minWindow(String s, String t) {
        /*
         * Variable to store the minimum length of substring found
         */
        int minLength = Integer.MAX_VALUE;

        /*
         * Variable to store starting index of minimum length substring
         */
        int sIndex = -1;

        /* Arrays to count frequencies of characters in string t */
        int hash[] = new int[256];

        /* Count the frequencies of characters in string t */
        for (char c : t.toCharArray()) {
            hash[c] += 1;
        }

        /*
         * Count is the number of character that we figured out from string t in current
         * window
         */
        int count = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            /*
             * Positive number means this character was pre inserted from string t. So a
             * character from t is seen s so we can increment the count
             */
            if (hash[s.charAt(r)] > 0) {
                count += 1;
            }

            hash[s.charAt(r)] -= 1;

            /*
             * If all characters from t are found in current window
             */
            while (count == t.length()) {

                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    sIndex = l;
                }

                // remove left most character to find minimum length
                hash[s.charAt(l)] -= 1;
                if (hash[s.charAt(l)] > 0) {
                    count += 1;
                }
                l += 1;
            }
            r += 1;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
    }
}
