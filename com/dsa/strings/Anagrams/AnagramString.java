package com.dsa.strings.Anagrams;

import java.util.Arrays;

public class AnagramString {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        return Arrays.equals(sArray, tArray);
    }
}
