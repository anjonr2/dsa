package ShortestPalindrome.brute;

public class ShortestPalindrome {
    /*
     * Approach : Using subtring check for suffix and prefix of combined string made
     * of that string and reverse string
     * As we know a string is plaindrome if it is equal to revers of itself
     * So we will be comparing original string from the beginning and reverse string
     * from the end to check if those are equal or not
     */
    public String shortestPalindrome(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < length; i += 1) {
            if (s.substring(0, length - i).equals(reversedString.substring(i))) {
                return new StringBuilder(reversedString.substring(0, i)).append(s).toString();
            }
        }
        /* If none of the substrings are equal then return reverse + original string */
        return reversedString + s;
    }
}
