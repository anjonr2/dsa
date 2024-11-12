package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void findCombinationSum(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> ds) {
        if (idx == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombinationSum(idx, arr, target - arr[idx], res, ds);
            ds.remove(arr.length - 1);
        }
        findCombinationSum(idx + 1, arr, target, res, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidateArr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinationSum(0, candidateArr, target, res, new ArrayList<>());
        return res;
    }
}
