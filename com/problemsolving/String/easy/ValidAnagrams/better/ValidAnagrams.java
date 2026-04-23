package com.problemsolving.String.easy.ValidAnagrams.better;

public class ValidAnagrams {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length())
            return false;

        /* Because we are dealing with lowercase english letters a to z so size is 26 */
        int count[] = new int[26];

        /*
         * Count occurences of each character in first string
         * why c-'a' . In java characters are internally stored as ASCII (or Unicode)
         * values. For lower case letters :
         * 'a' = 97
         * 'b' = 98
         * 'c' = 99
         * ...
         * 'z' = 122
         * 
         * so when we do c - 'a' , we are converting a character into a 0 based index
         * c = 'a'
         * c - 'a' = 'a' - 'a' = 0;
         * count[0]++
         * 
         */
        for (char c : s.toCharArray())
            count[c - 'a'] += 1;

        for (char c : t.toCharArray())
            count[c - 'a'] -= 1;

        for (int i : count)
            if (i != 0)
                return false;

        return true;
    }
}
