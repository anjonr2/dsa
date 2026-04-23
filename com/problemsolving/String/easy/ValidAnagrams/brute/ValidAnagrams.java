package com.problemsolving.String.easy.ValidAnagrams.brute;

import java.util.Arrays;

public class ValidAnagrams {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
