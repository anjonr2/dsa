package com.dsa.strings.ReverseStringByWord.Bruteforce;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringByWord {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        // list to store words of the string
        List<String> words = new ArrayList<>();
        int start, end;
        int i = 0, n = s.length();
        while (i < n) {
            // skip the spaces
            while (i < n && s.charAt(i) == ' ')
                i += 1;
            if (i >= n)
                break;
            start = i;

            // find the end of the word
            while (i < n && s.charAt(i) != ' ')
                i += 1;
            end = i - 1;

            // add the word to the list
            words.add(s.substring(start, end + 1));
        }
        for (int j = words.size() - 1; j >= 0; j -= 1) {
            result.append(words.get(j));
            if (j != 0) {
                result.append(' '); // add space between words
            }
        }
        return result.toString();
    }
}
