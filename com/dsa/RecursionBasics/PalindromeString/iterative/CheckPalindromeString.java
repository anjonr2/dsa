package com.dsa.RecursionBasics.PalindromeString.iterative;

public class CheckPalindromeString {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            else
                left += 1;
            right -= 1;
        }
        return true;
    }
}
