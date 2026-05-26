package medium.SubSet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {
    private void findSubSets(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {

        int n = nums.length;

        /* If index reaches end of the nums */
        if (index == n) {

            /* Add the current subset to the result */
            result.add(current);
            return;
        }

        /* Include the current element in the subset */
        current.add(nums[index]);

        /* Recur for the next index */
        findSubSets(index + 1, current, nums, result);

        /* Backtrack : remove the last added element from the current list */
        current.remove(current.size() - 1);

        /* Skip duplicate */
        for (int i = index + 1; i < n; i += 1) {
            if (nums[i] != nums[index]) {
                findSubSets(i, current, nums, result);
                break;
            }
        }

        /*
         * Ensure the function finishes when no more unique element lefts
         * i.e when this if condition (nums[i] != nums[index]) is never true index
         * reaches n
         */
        findSubSets(n, current, nums, result);
    }

    public List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Current subset
        List<Integer> current = new ArrayList<>();

        // Sort the array to handle duplicates
        Arrays.sort(nums);

        findSubSets(0, current, nums, result)
        return result;
    }
}

/*
 * Time complexity : O(2^n * N) each element is either included or excluded
 * leading to exponential number of subsets
 * 
 * Space complexity : O(n) space complexity is for the recursion stack trace
 * which can go as deep as number of elements in the input list
 */