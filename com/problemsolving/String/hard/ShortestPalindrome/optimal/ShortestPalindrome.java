package ShortestPalindrome.optimal;

public class ShortestPalindrome {
    /*
     * Using lps we are trying to find longest palindromic prefix already present in
     * the string . If we know the longest part of the string that is already a
     * palindrome starting from index 0 ,we only need to take the remaining
     * non-palindromic suffix reverse it and add it to the front
     * 
     * For the shortest palindrome we actually need the longest palindromic prefix
     * of s, then the suffix that is not mirrored gets reversed and added in the
     * front
     */
    private int[] computeLPS(String str) {
        int n = str.length();

        int lps[] = new int[n];

        int i = 1, j = 0;

        while (i < n) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[i] = j + 1;
                i += 1;
                j += 1;
            } else {
                while (j > 0 && str.charAt(i) != str.charAt(j)) {
                    j = lps[j - 1];
                }
                if (str.charAt(i) == str.charAt(j)) {
                    lps[i] = j + 1;
                }
                i += 1;
            }
        }
        return lps;
    }

    /*
     * Function to find the shortest palindrome by inserting characters at the
     * beggining of the string
     */
    public String shortestPalindrome(String s) {
        String reversedString = new StringBuilder(s).reverse().toString();

        String str = s + '$' + reversedString;

        int lps[] = computeLPS(str);

        /*
         * last element of lps array corresponds to the longest suffix of combined
         * string that matches a prefix capturing the maximum palindroming prefix length
         * so lps.length-1 is taken
         * Since lps.length-1 are already palindrome and no need to be mirrored we
         * subtract them from total no of character which is s.length()
         */
        int ans = s.length() - lps[lps.length - 1];

        return new StringBuilder(reversedString.substring(0, ans)).append(s).toString();
    }
}
