package com.problemsolving.String.easy.LongestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(str);

        int n = str.length;

        // Get the first and last string of str arrray
        char[] first = str[0].toCharArray();
        char[] last = str[n - 1].toCharArray();

        // start comparing
        for (int i = 0; i < first.length; i += 1) {
            if (first[i] != last[i])
                break;
            result.append(first[i]);
        }
        return result.toString();
    }
}

/*
 * Solution explanation : https://www.youtube.com/watch?v=wtOQaovlvhY
 * Time complexity : O(nlogn)
 * logn for sorting
 */