package com.dsa.recursion1.PalindromeString.Iterative;

public class PalindromeString {
    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
}
