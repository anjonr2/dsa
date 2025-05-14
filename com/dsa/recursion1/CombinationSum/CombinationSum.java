import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void findCombinations(int currIndex, int[] candidates, int target, List<Integer> currentCombination,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (target < 0 || currIndex == candidates.length) {
            return;
        }
        // Include the current element
        currentCombination.add(candidates[currIndex]);
        findCombinations(currIndex, candidates, target - candidates[currIndex], currentCombination, result);
        // Backtrack to remove the last added element
        // and exclude it from the current combination
        currentCombination.remove(currentCombination.size() - 1);
        findCombinations(currIndex + 1, candidates, target, currentCombination, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        findCombinations(0, candidates, target, currentCombination, result);
        return result;
    }
}
