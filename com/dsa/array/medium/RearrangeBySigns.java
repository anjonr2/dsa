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

    public int[] rearrangeArray1(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n / 2];
        int[] negative = new int[n / 2];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int j = 0;
                positive[j++] = nums[i];
            } else {
                int k = 0;
                negative[k++] = nums[i];
            }
        }
        if (positive.length > negative.length) {
            int index = negative.length;
            for (int i = 0; i < n / 2; i++) {
                nums[2 * i] = positive[i];
                nums[2 * i + 1] = negative[i];
            }
            for (int i = negative.length; i < positive.length; i++) {
                nums[index++] = positive[i];
            }
        } else {
            int index = positive.length;
            for (int i = 0; i < n / 2; i++) {
                nums[2 * i] = positive[i];
                nums[2 * i + 1] = negative[i];
            }
            for (int i = positive.length; i < negative.length; i++) {
                nums[index++] = negative[i];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, -2, -5, 2, -4, 6, 7 };
        RearrangeBySigns obj = new RearrangeBySigns();
        int[] ans = obj.rearrangeArray1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }
}
