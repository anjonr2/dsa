import java.util.Arrays;

/**
 * ContainsDuplicate
 * 
 * Intuition : If we sort the array, then any duplicate values will appear next
 * to each
 * other. Sorting groups identical elements together, so we can simply check
 * adjacent positions
 * to detect duplicates. This reduces the problem to a single linear scan after
 * sorting,
 * making it easy to identify if any value repeats
 * 
 * Algorithm :
 * 
 * 1. Sort the array in non-decreasing order
 * 2. Iterate through the array starting from index 1
 * 3. Compare the current element with the previous element
 * 4. If both elements are equal, we have found a duplicate - return true
 * 5. If the loop finishes without detecting equal neighbors, return false
 */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 1) {
            if (nums[i - 1] == nums[i])
                return false;
        }

        return true;
    }
}

/**
 * Time complexity : O(nlogn)
 * Space complexity : O(1)
 */