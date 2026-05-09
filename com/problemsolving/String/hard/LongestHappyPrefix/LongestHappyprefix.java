public class LongestHappyprefix {
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i += 1;
                j += 1;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = lps[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i] = j + 1;
                    j += 1;
                }
                i += 1;
            }
        }
        return lps;
    }

    /* Function to find the longest happy prefix of the given string */
    public String lps(String s) {
        int[] LPS = computeLPS(s);
        return s.substring(0, LPS[LPS.length - 1]);
    }
}
