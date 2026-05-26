package medium.SubSetI;

import java.util.ArrayList;
import java.util.List;

public class SubSetI {
    private void calculateSubSetSum(int index, int sum, int[] nums, List<Integer> result) {
        int n = nums.length;

        /*
         * Base case : if index reaches end of the nums array
         */
        if (index == n) {
            /* Add the current sum to the result list */
            result.add(sum);
            return;
        }

        /*
         * Recursively include the current element in the sum by adding the current
         * element to the sum
         */
        calculateSubSetSum(index + 1, sum + nums[index], nums, result);

        /*
         * Recursively exclude current element from the sum
         */
        calculateSubSetSum(index + 1, sum, nums, result);
    }

    public List<Integer> subSetSum(int[] nums) {
        List<Integer> result = new ArrayList<>();

        /*
         * Start the recursion with index 0 and initial sum 0
         */
        calculateSubSetSum(0, 0, nums, result);
        return result;
    }
}

/*
 * Time complexity : O(2^n) where n is the size of the given array
 * Each element has two possibilities (include or exclude) resulting in 2^n
 * combinations
 * 
 * Space complexity : O(n) which is recursion stack space
 */