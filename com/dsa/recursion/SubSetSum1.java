package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum1 {
    public static void subSet(int idx, int sum, int[] candidate, int target, List<Integer> subSet) {
        if (idx == candidate.length) {
            subSet.add(sum);
            return;
        }

        subSet(idx + 1, sum + candidate[idx], candidate, target, subSet);
        subSet(idx + 1, sum, candidate, target, subSet);
    }

    public List<Integer> subsetSum(int[] arr, int target) {
        List<Integer> subSet = new ArrayList<>();
        subSet(0, 0, arr, target, subSet);
        Collections.sort(subSet);
        return subSet;
    }
}
