import java.util.Arrays;

/**
 * 
 * ContainsDuplicate
 * 
 * Intuition : This approach uses the same idea as hashset method : a set only
 * store
 * unique values, so duplicates are automatically removed. Instead of checking
 * each element manually, we simply compare the length of the set to the length
 * of the original array. If duplicate exists, the set will contain fewer
 * elements
 * 
 * Algorithm
 * 1. Convert the array into a hash set, which removes duplicates
 * 2. Compare the size of the set with the size of the original array
 * 3. If the set is smaller, return true because duplicates must have been
 * removed
 */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
