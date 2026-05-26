public class CountOfAllSubSequencesWithSumK {
    private int helper(int index, int sum, int[] nums) {
        int n = nums.length;

        /*
         * Base case : if sum = 0 one valid subseq with given target sum is found
         */
        if (sum == 0)
            return 1;

        /*
         * Base case : if sum is negative or index reaches size of array
         */
        if (sum < 0 || index == n)
            return 0;

        /*
         * recurseby including current number or excluding it from the sum
         */
        return helper(+1, sum - nums[index], nums) + helper(index + 1, sum, nums);
    }

    public int countSubSeqWithTargetSum(int[] nums, int target) {
        return helper(0, target, nums);
    }
}
