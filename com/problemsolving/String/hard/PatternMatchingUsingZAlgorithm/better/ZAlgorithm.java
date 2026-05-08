package PatternMatchingUsingZAlgorithm.better;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    private int[] computeZArray(String s) {
        int n = s.length();
        int z[] = new int[n];
        int left = 0, right = 0;

        for (int i = 1; i < n; i += 1) {
            if (i > right) {
                while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                    z[i] += 1;
                }
            } else {
                if (i + z[i - left] <= right) {
                    z[i] = z[i - left];
                } else {
                    z[i] = right - i + 1;

                    while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                        z[i] += 1;
                    }
                }

            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        return z;
    }

    public List<Integer> search(String text, String pattern) {
        String s = text + '$' + pattern;
        int n = s.length();
        int[] z = computeZArray(s);
        List<Integer> ans = new ArrayList<>();

        int m = pattern.length();
        for (int i = m + 1; i < n; i += 1) {
            if (z[i] == m)
                ans.add(i - (m + 1));
        }
        return ans;
    }
}
