package basic.PalindromeString.recursive;

public class Palindrome {
    public boolean palindrome(int i, String s) {
        /*
         * Base condition: If i exceeds half of the string, all the elements have been
         * compared
         * and the string is a palindrome , return true
         */
        if (i >= s.length() / 2)
            return true;

        /* check if the characters at the current position are equal or not */
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;

        return palindrome(i + 1, s);
    }
}
