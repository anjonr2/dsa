package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSeqWithGivenSum {
    public static List<List<Integer>> printAllSubSeq(int idx, int[] input, int length, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int variableSum = 0;
        List<Integer> subSeqWithSum = new ArrayList<>();
        if (idx == length) {
            if (variableSum == sum) {
                res.add(subSeqWithSum);
            }
        }

        subSeqWithSum.add(input[idx]);
        variableSum += input[idx];
        printAllSubSeq(idx + 1, input, length, variableSum);

        subSeqWithSum.remove(input[idx]);
        variableSum -= input[idx];
        printAllSubSeq(idx + 1, input, length, variableSum);
        return res;
    }
}
