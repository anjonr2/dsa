package RabinKarpAlgorithm.brute;

import java.util.ArrayList;
import java.util.List;

public class StartingIndexOfAllOccurencesOfPattern {
    /* Function to find the starting index of all occurrences of pattern in text */
    public List<Integer> search(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();

        /* List to store answer */
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= m - n; i += 1) {
            boolean flag = true;

            /* Check for every character in pattern */
            for (int j = 0; j < n; j += 1) {
                if (text.charAt(i) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                ans.add(i);
        }
        return ans;
    }
}

/*
 * text = ababcabcababc n =13
 * pattern = abc m =3 n-m = 10
 * 
 * Time complexity : O(M*n)
 * Outer loop iterates O(m-n+1)
 * For each position Inner loop (character by character comparison between
 * pattern and text)iterates O(n)
 */