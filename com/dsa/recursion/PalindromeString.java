package com.dsa.recursion;

public class PalindromeString {
    public static boolean check(int startIdx, int length, String str) {
        if (startIdx >= length / 2) {
            return true;
        }
        if (str.charAt(startIdx) != str.charAt(length - startIdx - 1)) {
            System.out.println(str.charAt(startIdx) + "------------" + str.charAt(length - startIdx - 1));
            return false;
        }
        return check(startIdx++, length, str);
    }
}
