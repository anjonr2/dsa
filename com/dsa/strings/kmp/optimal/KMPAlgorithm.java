package com.dsa.strings.kmp.optimal;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    private int[] computeLPS(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i++] = j + 1;
                j += 1;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = lps[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i++] = j + 1;
                    j += 1;
                }
            }
        }
        return lps;
    }

    public List<Integer> search(String pattern, String text) {
        List<Integer> indices = new ArrayList<>();
        String concat = pattern + '$' + text;
        int[] lps = computeLPS(concat);
        int m = pattern.length();
        for (int i = m + 1; i < concat.length(); i += 1) {
            if (lps[i] == m)
                indices.add(i - 2 * m);
        }
        return indices;
    }
}
