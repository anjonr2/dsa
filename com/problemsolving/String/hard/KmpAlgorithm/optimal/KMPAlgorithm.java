package KmpAlgorithm.optimal;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    /* Computes the longest prefix suffix array for the combined string */
    private int[] computeLPS(String s) {
        int n = s.length();

        int[] LPS = new int[n];

        int i = 1, j = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j + 1;
                i += 1;
                j += 1;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = LPS[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    LPS[i] = j + 1;
                    j += 1;
                }
                i += 1;
            }
        }
        return LPS;
    }

    public List<Integer> search(String pattern, String text) {
        String s = pattern + '$' + text;
        int[] LPS = computeLPS(s);
        List<Integer> result = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        for (int i = m + 1; i < s.length(); i += 1) {
            if (LPS[i] == m)
                result.add(i - 2 * m);
        }
        return result;
    }
}

/*
 * Index in text = (Start in combined string s) - (Offset of text)
 * Index in text = i-m+1 - (m+1)
 */
