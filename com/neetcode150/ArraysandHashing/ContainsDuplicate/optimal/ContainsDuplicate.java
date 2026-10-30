import java.util.Set;

/**
 * 
 * ContainsDuplicate
 * 
 * Intuition : We can use a hashset to efficiently keep track of the values we
 * have
 * already encountered
 * As we iterate through the array, we check whether the current value is
 * already present
 * in the set. If it is that means, we have seen this value before, so a
 * duplicate exists
 * Using a hashset allows constant time lookups, making this approach much more
 * efficient than comparing every pair
 * 
 * Algorithm :
 * 
 * 1. Initialize an empty hash
 * 2. Iterate through each number in the array
 * 3. For each number
 * a. If it is already in the set, return true because a duplicate has been
 * found
 * b.Otherwise add it to the set
 */
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}

/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 */