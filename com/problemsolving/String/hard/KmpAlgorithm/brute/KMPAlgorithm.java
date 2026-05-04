package KmpAlgorithm.brute;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    /* Compute the longest prefix suffix array for the combined string */
    private int[] computeLPS(String s) {
        int n = s.length();

        /*
         * this array stores the length of the longest seq in that particular index
         * which is both a prefix and a suffix as well
         */
        int[] LPS = new int[n];

        for (int i = 1; i < n; i += 1) {
            for (int len = 1; len < i; len += 1) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1)))
                    LPS[i] = len;
            }
        }
        return LPS;
    }

    /* Function to find all indices of pattern in text */
    public List<Integer> search(String pattern, String text) {
        /*
         * Form a new string S by combining the pattern and text with a delimiter ('$')
         */
        String s = pattern + '$' + text;
        int[] LPS = computeLPS(s);

        /* length of pattern and text */
        int n = text.length(), m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i += 1) {
            if (LPS[i] == m)
                ans.add(i - 2 * m);
        }
        return ans;
    }
}
