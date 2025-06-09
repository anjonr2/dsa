package com.dsa.strings.RabinKarpAlgorithm.Bruteforce;

import java.util.List;

public class StringIndexOfOccurrencesOfAPattern {
    /*
     * Function to find all occurrences of a pattern in a given text.
     * It returns a list of starting indices of the pattern in the text.
     */
    public List<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        List<Integer> ans = new ArrayList<>();

        // Traverse the text
        for (int i = 0; i < n - m; i += 1) {
            boolean found = true;
            for (int j = 0; j < m; j += 1) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    found = false;
                    break;
                }
            }
            if (found)
                ans.add(i);
        }
        return ans;
    }
}
