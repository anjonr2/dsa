public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i += 1) {
            for (int j = i; j < n; j += 1) {
                int sum = 0;
                for (int l = i; l < j; l += 1) {
                    sum += nums[l];
                }
                if (sum == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
