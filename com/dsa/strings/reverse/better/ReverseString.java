package com.dsa.strings.reverse.better;

public class ReverseString {
    public static String helper(String reverse, String original, int index) {
        if (index < 0) {
            return reverse;
        }
        reverse += original.charAt(index);
        return helper(reverse, original, index - 1);
    }

    public static String reverse(String str) {
        return helper("", str, str.length() - 1);
    }

    public static void main(String[] args) {
        String str = "Hello";
        String reversed = reverse(str);
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reversed);
    }
}
