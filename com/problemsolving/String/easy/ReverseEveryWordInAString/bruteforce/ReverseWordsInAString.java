package com.problemsolving.String.easy.ReverseEveryWordInAString.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
    /* Function to reverse every words in a String */
    public String reverseWords(String s) {
        int n = s.length(); // length of the string

        /* List to store words present in a string */
        List<String> words = new ArrayList<>();

        int start, end; // Pointers to mark start and end of a word

        int i = 0;
        while (i < n) {
            // Find the first non-space character in the string
            while (i < n && i == ' ')
                i += 1;

            /* If no nonspace character is found break */
            if (i >= n)
                break;

            start = i; // starting the index of first character of word

            // finding the last character of the word
            while (i < n && s.charAt(i) != ' ') {
                i += 1;
            }

            end = i - 1;

            String wordFound = s.substring(start, end);
            words.add(wordFound);
        }

        StringBuilder ans = new StringBuilder();

        for (int j = words.size(); j >= 0; j -= 1) {
            ans.append(words.get(j));

            if (j != 0)
                ans.append(' ');
        }

        return ans.toString();
    }
}

/*
 * Time complecity : O(n) + O(n)
 * Space complexity : O(n)
 */