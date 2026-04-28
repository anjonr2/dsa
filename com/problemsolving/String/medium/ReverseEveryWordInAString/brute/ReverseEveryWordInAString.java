package com.problemsolving.String.medium.ReverseEveryWordInAString.brute;

import java.util.ArrayList;
import java.util.List;

public class ReverseEveryWordInAString {
    /* Function to reverse every word in a String */
    public String reverseWords(String s) {
        int n = s.length();

        /* List to store words present in string */
        List<String> words = new ArrayList<>();

        /* Pointers to mark start and end of a word */
        int start, end;

        int i = 0;
        while (i < n) {
            /* Finding the first character of a word (if any) */
            while (i < n && s.charAt(i) == ' ')
                i += 1;

            /* If no word is found break */
            if (i >= n)
                break;

            /* Starting the index of first character of word */
            start = i;

            /* Finding the last character of the word */
            while (i < n && s.charAt(i) != ' ')
                i += 1;
            end = i - 1;

            String wordFound = s.substring(start, end);
            words.add(wordFound);
        }

        StringBuilder ans = new StringBuilder();

        /* Adding all the words to the final result in the reverse order */
        for (i = words.size() - 1; i >= 0; i -= 1) {
            ans.append(words.get(i));

            /* Adding spaces in between words */
            if (i != 0)
                ans.append(' ');
        }
        return ans.toString();
    }
}
