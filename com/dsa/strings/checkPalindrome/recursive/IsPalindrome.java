package com.dsa.strings.checkPalindrome.recursive;

public class IsPalindrome {
    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}
