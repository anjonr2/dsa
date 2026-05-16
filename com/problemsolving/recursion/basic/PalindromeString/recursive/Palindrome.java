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

        /* If the start and end characters are not equal , it's not a palindrome */
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;

        return palindrome(i + 1, s);
    }
}
