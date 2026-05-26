package medium.combinationSum3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private void generateCombinationSum3(int sum, int last, List<Integer> current, List<List<Integer>> result, int k) {
        /* Base case : if the sum is 0 and number of elements is k */
        if (sum == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        /*
         * If sum is less than 0 and number of elements in current combination exceeds k
         */
        if (sum < 0 || current.size() > k)
            return;

        /* Iterate from the last number till 9 */
        for (int i = last; i <= 9; i += 1) {
            /* If the current number is less than or equal to the sum */
            if (i <= sum) {
                /* Add the number to the current combination */
                current.add(i);

                /* recursively call with updated sum and next element */
                generateCombinationSum3(sum - i, last + 1, current, result, k);

                /* remove the last added element to backtrack */
                current.remove(current.size() - 1);
            } else {
                /* If the current number is greater than sum then break the loop */
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        /* call the recursive function with initial parameters */
        generateCombinationSum3(n, 1, current, result, k);
        return result;
    }
}
