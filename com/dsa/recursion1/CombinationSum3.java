package com.dsa.recursion1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public void findCombinations(int start, int k, int sum, List<Integer> current, List<List<Integer>> result) {
        if (sum == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (start > 9 || start > sum || current.size() > k || sum < 0) {
            return;
        }

        current.add(start);
        findCombinations(start + 1, k, sum - start, current, result);
        current.remove(current.size() - 1);

        findCombinations(start + 1, k, sum, current, result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1, k, n, new ArrayList<>(), result);
        return result;
    }
}
