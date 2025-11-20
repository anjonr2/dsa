public class MaximumSum {
    public int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            for (int j = i; j < n; j += 1) {
                int sum = 0;
                for (int k = i; k <= j; k += 1) {
                    sum += nums[k];
                }
                maximum = Math.max(maximum, sum);
            }
        }
        return maximum;
    }
}
