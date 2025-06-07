package com.dsa.strings.Anagrams.optimal;

public class AnagramString {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int count[] = new int[26];
        for (char ch : s.toCharArray())
            count[ch - 'a'] += 1;
        for (char ch : t.toCharArray())
            count[ch - 'a'] -= 1;
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
