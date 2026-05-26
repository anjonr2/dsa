package medium.CombinationSumI;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public void findCombinations(int index, int target, int[] input, List<List<Integer>> result,
            List<Integer> current) {
        int n = input.length;

        /*
         * Base case : If all the elements in the array are processed
         */
        if (index == n) {
            /* if the target is 0 we have found a valid combination */
            if (target == 0) {
                result.add(new ArrayList<>(current)); // add the current combination to the result
            }
            return;
        }

        if (input[index] <= target) {
            /* Add the current element to the combination */
            current.add(input[index]);

            /* Continue with same index to allow repeated elements */
            findCombinations(index, target - input[index], input, result, current);

            /* back track by removing last added element */
            current.remove(current.size() - 1);
        }

        /*
         * Move to the next index by excluding current index element and passing the
         * same sum since element is not selected
         */
        findCombinations(index + 1, target, input, result, current);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // To store the result
        List<Integer> current = new ArrayList<>(); // To store a current combination
        findCombinations(0, target, nums, ans, current);
        return ans;
    }
}
