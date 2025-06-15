package com.dsa.strings.ZAlgorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public int[] computeZarray(String s) {
        int z[] = new int[s.length()];
        for (int i = 1; i < s.length(); i += 1) {
            while (i + z[i] < s.length() && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
        }
        return z;
    }

    public List<Integer> search(String text, String pattern) {
        String concat = pattern + '$' + text;
        List<Integer> ans = new ArrayList<>();
        int z[] = computeZarray(concat);
        int n = text.length();
        int m = pattern.length();
        for (int i = m + 1; i < concat.length(); i += 1) {
            if (z[i] == m) {
                // found a match
                ans.add(i - (m + 1));
            }
        }
        return ans;
    }
}
