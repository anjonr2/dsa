package medium;

public class RearrangeBySigns {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int positiveIdx = 0;
        int negativeIdx = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[negativeIdx] = nums[i];
                negativeIdx += 2;
            } else {
                ans[positiveIdx] = nums[i];
                positiveIdx += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, -2, -5, 2, -4 };
        RearrangeBySigns obj = new RearrangeBySigns();
        int[] ans = obj.rearrangeArray(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + " ");
        }
    }
}
