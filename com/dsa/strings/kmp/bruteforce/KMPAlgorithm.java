package com.dsa.strings.kmp.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    private int[] computeLPSArray(String s) {
        int n = s.length();
        int lps[] = new int[n];
        for (int i = 1; i < n; i += 1) {
            for (int len = 1; len < i; len += 1) {
                if (s.substring(0, len).equals(s.substring(i - len + 1, i + 1))) {
                    lps[i] = len;
                }
            }
        }
        return lps;
    }

    public List<Integer> search(String pattern, String text) {
        String concat = pattern + '$' + text;
        int[] lps = computeLPSArray(concat);
        List<Integer> indices = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        for (int i = m + 1; i < concat.length(); i += 1) {
            if (lps[i] == m)
                indices.add(i - 2 * m);
        }
        return indices;
    }
}
