
/**
 * ContainsDuplicate
 * 
 * Intuition : We can check every pair of different elements in the array and
 * return
 * true if any pair has equal values.
 * This is the most intuitive approach because it directly compares all possible
 * pairs
 * 
 * Algorithm
 * 
 * 1. Iterate through the array using two nested loops to check all possible
 * pairs of distinct
 * indices
 * 2. If any pair of the element has the same value, return true
 * 3. If all pairs are checked and no duplicates are found, return false
 */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = i + 1; j < nums.length; j += 1) {
                if (nums[i] == nums[j])
                    return false;
            }
        }
        return true;
    }
}

/**
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 */