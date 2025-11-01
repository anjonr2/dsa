package com.dsa.RecursionBasics.PalindromeString.recursive;

public class CheckPalindromeString {
    public boolean palindrome(int i, String s) {

        if (i >= s.length() / 2)
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;
        return palindrome(+1, s);
    }
}
