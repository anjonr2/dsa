package PatternMatchingUsingZAlgorithm.brute;

import java.util.ArrayList;
import java.util.List;

/* 
 * Given two string one is a text and other is a pattern. 
 * We need to print indexes of all occurences of the pattern in the string text
 */
public class ZAlgorithm {
    private int[] computeZArray(String s) {
        int n = s.length();

        /* Z- array */
        int z[] = new int[n];

        for (int i = 1; i < n; i += 1) {
            while (i + z[i] < n && s.charAt(i) == s.charAt(i + z[i])) {
                z[i] += 1;
            }
        }
        return z;
    }

    /* Function to find indices of all the patterns */
    public List<Integer> search(String text, String pattern) {
        String s = pattern + '$' + text;

        int[] z = computeZArray(s);

        int m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i += 1) {
            if (z[i] == m)
                ans.add(i - (m + 1));
        }
        return ans;
    }
}
