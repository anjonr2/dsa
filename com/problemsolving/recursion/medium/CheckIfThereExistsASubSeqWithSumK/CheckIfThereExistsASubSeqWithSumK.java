package medium.CheckIfThereExistsASubSeqWithSumK;

public class CheckIfThereExistsASubSeqWithSumK {
    private boolean checkIfThereExistsASubSeqWithSumK(int idx, int n, int[] arr, int sum) {
        /*
         * Base case : if sum is 0 , a subseq is found return true
         */
        if (sum == 0) {
            return true;
        }

        /* If sum is negative no valid subseq is found */
        if (sum < 0)
            return false;

        /*
         * Base case : if all elements are processed , check if sum is 0;
         */
        if (idx == n) {
            return sum == 0;
        }

        /*
         * Recursive call : include the current element in the subsequence or exclude
         * the current element from the subseq
         */
        return checkIfThereExistsASubSeqWithSumK(idx + 1, n, arr, sum - arr[idx])
                || checkIfThereExistsASubSeqWithSumK(idx + 1, n, arr, sum);
    }

    public boolean checkSubSeqSum(int[] nums, int target) {
        return checkIfThereExistsASubSeqWithSumK(0, nums.length, nums, target);
    }
}
