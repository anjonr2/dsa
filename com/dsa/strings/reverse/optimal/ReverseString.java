package com.dsa.strings.reverse.optimal;

public class ReverseString {
    public static String reverse(String str) {

        String reverse = "";
        int start = 0;
        int end = str.length() - 1;
        char[] chars = str.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start += 1;
            end -= 1;

        }
        return reverse;
    }
}
