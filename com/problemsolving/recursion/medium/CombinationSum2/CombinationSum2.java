package medium.CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private void findCombinations(int index, int sum, List<Integer> current, List<List<Integer>> result,
            int[] candidates) {

        int n = candidates.length;

        if (sum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (sum < 0 || index == n)
            return;

        /* Include the current candidate */
        current.add(candidates[index]);

        /*
         * If element at current index ins included then recursive call with updated sum
         */
        findCombinations(index + 1, sum - candidates[index], current, result, candidates);

        /* back track by removing the last added candidate */
        current.remove(current.size() - 1);

        /*
         * If not picking the current candidate ensure the next candidate is different
         * from current
         */
        for (int i = index + 1; i < n; i += 1) {
            if (candidates[i] != candidates[index]) {
                findCombinations(i, sum, current, result, candidates);
                break;
            }
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        /* Sort candidates to handle duplicates */
        Arrays.sort(candidates);

        findCombinations(0, target, current, result, candidates);
        return result;
    }
}

/*
 * Time complexity : O(2^n * N), where N is the number of coins
 * At each step, we explore two choices (include or exclude), leading to 2^n
 * possible subsets.
 * For each valid subset , copying the current combination into the result takes
 * up to O(N) giving the total complexity as O(2^n * N) in the worst case
 * 
 * Space complexity : O(n) , due to recursive stack depth and storage for
 * current combination
 */
