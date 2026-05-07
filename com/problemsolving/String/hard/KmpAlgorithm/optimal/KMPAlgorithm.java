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
                /*
                 * here we have added check of j>0 because if j==0 then j-1 will lead to -1
                 * which will give IndexOutOfBound error
                 */
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = LPS[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    /*
                     * if element matches till index j that means there are total element that has
                     * matched is j+1. since we follow 0 based indexing so no of elements will
                     * always be index + 1
                     */
                    LPS[i] = j + 1;
                    j += 1;
                }
                /*
                 * irrespective of whether s.charAt(j) matches with s.chartAt(i) or not j moves
                 * ahead by one point
                 */
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
 * LPS[j] means length longest prefix which is equal to suffix from idx 0 to j
 * for the string starting at 0th idx since there is only one character so only
 * prefix is there , but there is no suffix present
 * 
 * Time complexity is near about O(n)
 * and space complexity is O(n) for the lps array that we are using
 */
