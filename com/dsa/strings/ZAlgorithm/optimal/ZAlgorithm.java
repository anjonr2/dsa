import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public int[] computeZarray(String s) {
        int n = s.length();
        int z[] = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i += 1) {
            if (i > right) {
                while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(i)) {
                    z[i] += 1;
                }
            } else {
                if (i + z[i - left] < n) {
                    z[i] = z[i - left];
                } else {
                    z[i] = right - i + 1;
                    while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) {
                        z[i] += 1;
                    }
                }
            }
            left = i;
            right = i + z[i] - 1;
        }
        return z;
    }

    // function to find all indices of occurrences of pattern in text
    public List<Integer> search(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        String concat = pattern + '$' + text;
        int z[] = computeZarray(concat);
        int n = text.length(), m = pattern.length();
        for (int i = m + 1; i < concat.length(); i += 1) {
            if (z[i] == m) {
                indices.add(i - (m + 1));
            }
        }
        return indices;
    }
}
